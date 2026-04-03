package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.UserDto;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.entity.User;
import com.vasiliy.project.entity.info.Supplier;
import com.vasiliy.project.repository.RoleRepository;
import com.vasiliy.project.repository.UserRepository;
import com.vasiliy.project.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName(userDto.getRoleName())));

        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        if (userRepository.existsById(userId) & !userRepository.getById(userId).getRoles().get(0).getName().equals("Администратор")) {
            userRepository.deleteById(userId);
            return true;
        }

        return false;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRoleName(user.getRoles().get(0).getName());
        return userDto;
    }


    @Override
    @Transactional
    public Boolean updateUser(Long userId, UpdateRequest updateRequest) {
        if (userRepository.existsById(userId)) {
            User user = userRepository.findById(userId).get();

            switch (updateRequest.getType()) {
                case "name" -> user.setName(updateRequest.getValue());
                case "email" -> user.setEmail(updateRequest.getValue());
            }

            userRepository.save(user);

            return true;
        }

        return false;
    }
}
