package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    List<Category> findByCodeStartingWith(String code);

    @Query("""
        select p.category
        from Product p
        where p.id = :productId
    """)
    Category findCategoryByProductId(@Param("productId") Long productId);
}
