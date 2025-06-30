package com.example.libraryproject.mapper;

import com.example.libraryproject.dto.AuthorDTO;
import com.example.libraryproject.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorDTO toDTO(Author author) {
        if (author == null) return null;

        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setBirthDate(author.getBirthDate());
        dto.setCountry(author.getCountry());

        return dto;
    }

    public Author toEntity(AuthorDTO dto) {
        if (dto == null) return null;

        Author author = new Author();
        // Eğer DTO içinde id varsa ve update işleminde kullanılıyorsa aşağıyı açabilirsin:
        // author.setId(dto.getId());
        author.setName(dto.getName());
        author.setBirthDate(dto.getBirthDate());
        author.setCountry(dto.getCountry());

        return author;
    }
}
