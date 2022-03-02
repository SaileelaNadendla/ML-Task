package com.bhavna.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavna.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
