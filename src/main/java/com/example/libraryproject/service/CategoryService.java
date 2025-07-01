package com.example.libraryproject.service;

import com.example.libraryproject.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    Optional<CategoryDTO> getCategoryById(Long id);

    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    Optional<CategoryDTO> updateCategory(Long id, CategoryDTO categoryDTO);

    boolean deleteCategory(Long id);

}
