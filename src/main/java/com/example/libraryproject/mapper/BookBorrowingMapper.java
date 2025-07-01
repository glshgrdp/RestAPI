package com.example.libraryproject.mapper;

import com.example.libraryproject.dto.BookBorrowingDTO;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.BookBorrowing;

public class BookBorrowingMapper {

    public static BookBorrowingDTO toDTO(BookBorrowing entity) {
        if (entity == null) return null;

        BookBorrowingDTO dto = new BookBorrowingDTO();
        dto.setId(entity.getId());
        dto.setBorrowerName(entity.getBorrowerName());
        dto.setBorrowingDate(entity.getBorrowingDate());
        dto.setReturnDate(entity.getReturnDate());
        dto.setBookId(entity.getBook() != null ? entity.getBook().getId() : null);
        return dto;
    }

    public static BookBorrowing toEntity(BookBorrowingDTO dto, Book book) {
        if (dto == null) return null;

        BookBorrowing entity = new BookBorrowing();
        entity.setBorrowerName(dto.getBorrowerName());
        entity.setBorrowingDate(dto.getBorrowingDate());
        entity.setReturnDate(dto.getReturnDate());
        entity.setBook(book);
        return entity;
    }
}
