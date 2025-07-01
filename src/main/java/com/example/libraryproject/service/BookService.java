package com.example.libraryproject.service;

import com.example.libraryproject.dto.BookDTO;
import com.example.libraryproject.mapper.BookMapper;
import com.example.libraryproject.model.Author;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Category;
import com.example.libraryproject.model.Publisher;
import com.example.libraryproject.repository.AuthorRepository;
import com.example.libraryproject.repository.BookRepository;
import com.example.libraryproject.repository.CategoryRepository;
import com.example.libraryproject.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       PublisherRepository publisherRepository,
                       CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.categoryRepository = categoryRepository;
    }

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

    public BookDTO saveBook(BookDTO dto) {
        Author author = null;
        if (dto.getAuthorId() != null) {
            author = authorRepository.findById(dto.getAuthorId()).orElse(null);
        }

        Publisher publisher = null;
        if (dto.getPublisherId() != null) {
            publisher = publisherRepository.findById(dto.getPublisherId()).orElse(null);
        }

        List<Category> categories = null;
        if (dto.getCategoryIds() != null) {
            categories = categoryRepository.findAllById(dto.getCategoryIds());
        }

        Book book = BookMapper.toEntity(dto, author, publisher, categories);

        Book savedBook = bookRepository.save(book);
        return BookMapper.toDTO(savedBook);
    }
}
