package com.example.libraryproject.service.impl;

import com.example.libraryproject.dto.PublisherDTO;
import com.example.libraryproject.mapper.PublisherMapper;
import com.example.libraryproject.model.Publisher;
import com.example.libraryproject.repository.BookRepository;
import com.example.libraryproject.repository.PublisherRepository;
import com.example.libraryproject.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<PublisherDTO> getAllPublishers() {
        return publisherRepository.findAll()
                .stream()
                .map(PublisherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PublisherDTO> getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .map(PublisherMapper::toDTO);
    }

    @Override
    public PublisherDTO savePublisher(PublisherDTO dto) {
        Publisher publisher = PublisherMapper.toEntity(dto);
        Publisher saved = publisherRepository.save(publisher);
        return PublisherMapper.toDTO(saved);
    }

    @Override
    public Optional<PublisherDTO> updatePublisher(Long id, PublisherDTO dto) {
        return publisherRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setEstablishmentYear(dto.getEstablishmentYear());
                    existing.setAddress(dto.getAddress());
                    Publisher updated = publisherRepository.save(existing);
                    return PublisherMapper.toDTO(updated);
                });
    }

    @Override
    public boolean deletePublisher(Long id) {
        boolean hasBooks = bookRepository.existsByPublisher_Id(id);
        if (hasBooks) {
            return false; // kitapları varsa silme
        }

        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
