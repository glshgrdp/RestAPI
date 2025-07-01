package com.example.libraryproject.mapper;

import com.example.libraryproject.dto.BookDTO;
import com.example.libraryproject.model.Author;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Category;
import com.example.libraryproject.model.Publisher;

import java.util.List;
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
                    .map(Category::getId)
                    .collect(Collectors.toList()));

        return dto;
    }

    // Yeni: DTO'dan Entity'ye dönüşüm metodu
    public static Book toEntity(BookDTO dto, Author author, Publisher publisher, List<Category> categories) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setName(dto.getName());
        book.setPublicationYear(dto.getPublicationYear());
        book.setStock(dto.getStock());
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategories(categories);
        return book;
    }
}
