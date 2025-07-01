package com.example.libraryproject.repository;

import com.example.libraryproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByPublisher_Id(Long publisherId);

    boolean existsByCategories_Id(Long categoryId);
}
