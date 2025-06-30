package com.example.libraryproject.mapper;

import com.example.libraryproject.dto.BookBorrowingDTO;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.BookBorrowing;

public class BookBorrowingMapper {

    public static BookBorrowingDTO toDTO(BookBorrowing bookBorrowing) {
        if (bookBorrowing == null) return null;

        BookBorrowingDTO dto = new BookBorrowingDTO();
        dto.setId(bookBorrowing.getId());
        dto.setBorrowerName(bookBorrowing.getBorrowerName());
        dto.setBorrowingDate(bookBorrowing.getBorrowingDate());
        dto.setReturnDate(bookBorrowing.getReturnDate());

        if (bookBorrowing.getBook() != null) {
            dto.setBookId(bookBorrowing.getBook().getId());
        }

        return dto;
    }

    public static BookBorrowing toEntity(BookBorrowingDTO dto, Book book) {
        if (dto == null) return null;

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setId(dto.getId());
        bookBorrowing.setBorrowerName(dto.getBorrowerName());
        bookBorrowing.setBorrowingDate(dto.getBorrowingDate());
        bookBorrowing.setReturnDate(dto.getReturnDate());

        // Kitap entity'si servis veya controller katmanında bulunup parametre olarak verilmelidir
        bookBorrowing.setBook(book);

        return bookBorrowing;
    }
}
