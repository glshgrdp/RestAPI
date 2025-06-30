package com.example.libraryproject.controller;

import com.example.libraryproject.dto.BookBorrowingDTO;
import com.example.libraryproject.service.BookBorrowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookborrowings")
public class BookBorrowingController {

    private final BookBorrowingService bookBorrowingService;

    public BookBorrowingController(BookBorrowingService bookBorrowingService) {
        this.bookBorrowingService = bookBorrowingService;
    }

    @GetMapping
    public List<BookBorrowingDTO> getAllBorrowings() {
        return bookBorrowingService.getAllBorrowings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookBorrowingDTO> getBorrowingById(@PathVariable Long id) {
        return bookBorrowingService.getBorrowingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookBorrowingDTO> createBorrowing(@RequestBody BookBorrowingDTO dto) {
        return bookBorrowingService.saveBorrowing(dto)
                .map(saved -> ResponseEntity.status(HttpStatus.CREATED).body(saved))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookBorrowingDTO> updateBorrowing(@PathVariable Long id, @RequestBody BookBorrowingDTO dto) {
        return bookBorrowingService.updateBorrowing(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable Long id) {
        boolean deleted = bookBorrowingService.deleteBorrowing(id);
        if (deleted) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }
}
