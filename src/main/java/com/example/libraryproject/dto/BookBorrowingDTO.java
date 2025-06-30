package com.example.libraryproject.dto;

import java.time.LocalDate;

public class BookBorrowingDTO {

    private Long id;

    private String borrowerName;

    private LocalDate borrowingDate;

    private LocalDate returnDate;

    private Long bookId;  // Kitap ID olarak tutulacak

    public BookBorrowingDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) { this.borrowerName = borrowerName; }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) { this.borrowingDate = borrowingDate; }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) { this.bookId = bookId; }
}
