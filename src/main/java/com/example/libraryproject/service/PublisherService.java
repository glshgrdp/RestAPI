package com.example.libraryproject.service;

import com.example.libraryproject.dto.PublisherDTO;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<PublisherDTO> getAllPublishers();
    Optional<PublisherDTO> getPublisherById(Long id);
    PublisherDTO savePublisher(PublisherDTO dto);
    Optional<PublisherDTO> updatePublisher(Long id, PublisherDTO dto);
    boolean deletePublisher(Long id);
}
