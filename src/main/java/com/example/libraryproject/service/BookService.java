package com.example.libraryproject.service;

import com.example.libraryproject.dto.BookDTO;
import com.example.libraryproject.mapper.BookMapper;
import com.example.libraryproject.model.*;
import com.example.libraryproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookMapper::toDTO)
                .orElse(null);
    }

    public Book saveBook(BookDTO dto) {
        Book book = new Book();
        book.setName(dto.getName());
        book.setPublicationYear(dto.getPublicationYear());
        book.setStock(dto.getStock());

        if (dto.getAuthorId() != null) {
            Optional<Author> author = authorRepository.findById(dto.getAuthorId());
            author.ifPresent(book::setAuthor);
        }

        if (dto.getPublisherId() != null) {
            Optional<Publisher> publisher = publisherRepository.findById(dto.getPublisherId());
            publisher.ifPresent(book::setPublisher);
        }

        if (dto.getCategoryIds() != null) {
            List<Category> categories = categoryRepository.findAllById(dto.getCategoryIds());
            book.setCategories(categories);
        }

        return bookRepository.save(book);
    }
}