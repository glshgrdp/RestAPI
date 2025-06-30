package com.example.libraryproject.service;

import com.example.libraryproject.dto.AuthorDTO;
import com.example.libraryproject.mapper.AuthorMapper;
import com.example.libraryproject.model.Author;
import com.example.libraryproject.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorDTO createAuthor(AuthorDTO dto) {
        Author author = authorMapper.toEntity(dto);
        Author saved = authorRepository.save(author);
        return authorMapper.toDTO(saved);
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return authorMapper.toDTO(author);
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setName(dto.getName());
        author.setBirthDate(dto.getBirthDate());
        author.setCountry(dto.getCountry());

        Author updated = authorRepository.save(author);
        return authorMapper.toDTO(updated);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
