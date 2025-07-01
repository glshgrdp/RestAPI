package com.example.libraryproject.service;

import com.example.libraryproject.dto.BookDTO;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository, null, null, null);
    }

    @Test
    public void testGetAllBooksReturnsEmptyList() {
        when(bookRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(bookService.getAllBooks().isEmpty());
    }
}
