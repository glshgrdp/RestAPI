package com.example.libraryproject.repository;

import com.example.libraryproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Belirli bir kategoriye ait kitap var mı diye kontrol eden metot
    boolean existsByBooks_Categories_Id(Long categoryId);
}
