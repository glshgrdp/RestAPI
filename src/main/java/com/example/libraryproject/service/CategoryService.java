package com.example.libraryproject.service;

import com.example.libraryproject.dto.CategoryDTO;
import com.example.libraryproject.mapper.CategoryMapper;
import com.example.libraryproject.model.Category;
import com.example.libraryproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDTO);
    }

    public CategoryDTO saveCategory(CategoryDTO dto) {
        Category category = CategoryMapper.toEntity(dto);
        category = categoryRepository.save(category);
        return CategoryMapper.toDTO(category);
    }

    public Optional<CategoryDTO> updateCategory(Long id, CategoryDTO dto) {
        return categoryRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setDescription(dto.getDescription());
                    Category updated = categoryRepository.save(existing);
                    return CategoryMapper.toDTO(updated);
                });
    }

    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
