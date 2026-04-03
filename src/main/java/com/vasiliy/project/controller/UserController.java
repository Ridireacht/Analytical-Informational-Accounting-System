package com.vasiliy.project.controller;

import com.vasiliy.project.dto.UserDto;
import com.vasiliy.project.dto.info.SupplierDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.entity.User;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.exception.CustomValidationException;
import com.vasiliy.project.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid UserDto userDto) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            return ResponseEntity.badRequest().body(" такой email уже существует");
        }

        userService.saveUser(userDto);
        return ResponseEntity.ok().body("{}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long userId, @RequestBody UpdateRequest updateRequest) {
        if (updateRequest.getType() == null || !updateRequest.typeMatchesAny(new String[] {"name", "email"})) {
            throw new CustomBadRequestException();
        }

        if (updateRequest.getValue() == null || updateRequest.getValue().isBlank()) {
            throw new CustomValidationException("поле не должно быть пустым");
        }

        userService.updateUser(userId, updateRequest);
        return ResponseEntity.ok().body("{}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        Boolean success = userService.deleteUser(userId);

        if (success) {
            return ResponseEntity.ok().body("{}");
        }

        else {
            return ResponseEntity.badRequest().body("");
        }
    }
}
