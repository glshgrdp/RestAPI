package com.example.libraryproject.service;

import com.example.libraryproject.dto.PublisherDTO;
import com.example.libraryproject.mapper.PublisherMapper;
import com.example.libraryproject.model.Publisher;
import com.example.libraryproject.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherDTO> getAllPublishers() {
        return publisherRepository.findAll().stream()
                .map(PublisherMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PublisherDTO> getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .map(PublisherMapper::toDTO);
    }

    public PublisherDTO savePublisher(PublisherDTO dto) {
        Publisher publisher = PublisherMapper.toEntity(dto);
        publisher = publisherRepository.save(publisher);
        return PublisherMapper.toDTO(publisher);
    }

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

    public boolean deletePublisher(Long id) {
        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
