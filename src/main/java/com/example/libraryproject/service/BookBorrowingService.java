package com.example.libraryproject.service;

import com.example.libraryproject.dto.BookBorrowingDTO;
import com.example.libraryproject.mapper.BookBorrowingMapper;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.BookBorrowing;
import com.example.libraryproject.repository.BookBorrowingRepository;
import com.example.libraryproject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookBorrowingService {

    private final BookBorrowingRepository bookBorrowingRepository;
    private final BookRepository bookRepository;

    public BookBorrowingService(BookBorrowingRepository bookBorrowingRepository, BookRepository bookRepository) {
        this.bookBorrowingRepository = bookBorrowingRepository;
        this.bookRepository = bookRepository;
    }

    public List<BookBorrowingDTO> getAllBorrowings() {
        return bookBorrowingRepository.findAll().stream()
                .map(BookBorrowingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookBorrowingDTO> getBorrowingById(Long id) {
        return bookBorrowingRepository.findById(id)
                .map(BookBorrowingMapper::toDTO);
    }

    public Optional<BookBorrowingDTO> saveBorrowing(BookBorrowingDTO dto) {
        if (dto.getId() != null) {
            // POST için id null olmalı
            return Optional.empty();
        }

        Optional<Book> bookOpt = bookRepository.findById(dto.getBookId());
        if (bookOpt.isEmpty()) return Optional.empty();

        Book book = bookOpt.get();
        if (book.getStock() <= 0) return Optional.empty();

        book.setStock(book.getStock() - 1);
        bookRepository.save(book);

        BookBorrowing borrowing = BookBorrowingMapper.toEntity(dto, book);
        borrowing = bookBorrowingRepository.save(borrowing);

        return Optional.of(BookBorrowingMapper.toDTO(borrowing));
    }

    public Optional<BookBorrowingDTO> updateBorrowing(Long id, BookBorrowingDTO dto) {
        Optional<Book> bookOpt = bookRepository.findById(dto.getBookId());
        if (bookOpt.isEmpty()) return Optional.empty();

        return bookBorrowingRepository.findById(id)
                .map(existing -> {
                    existing.setBorrowerName(dto.getBorrowerName());
                    existing.setBorrowingDate(dto.getBorrowingDate());
                    existing.setReturnDate(dto.getReturnDate());
                    existing.setBook(bookOpt.get());

                    BookBorrowing updated = bookBorrowingRepository.save(existing);
                    return BookBorrowingMapper.toDTO(updated);
                });
    }

    public boolean deleteBorrowing(Long id) {
        if (bookBorrowingRepository.existsById(id)) {
            bookBorrowingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
