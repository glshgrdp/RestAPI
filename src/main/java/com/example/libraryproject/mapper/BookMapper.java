package com.example.libraryproject.mapper;

import com.example.libraryproject.dto.BookDTO;
import com.example.libraryproject.model.Book;
import java.util.stream.Collectors;

public class BookMapper {
    public static BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setPublicationYear(book.getPublicationYear());
        dto.setStock(book.getStock());

        if (book.getAuthor() != null)
            dto.setAuthorId(book.getAuthor().getId());

        if (book.getPublisher() != null)
            dto.setPublisherId(book.getPublisher().getId());

        if (book.getCategories() != null)
            dto.setCategoryIds(book.getCategories().stream()
                    .map(cat -> cat.getId())
                    .collect(Collectors.toList()));

        return dto;
    }
}
