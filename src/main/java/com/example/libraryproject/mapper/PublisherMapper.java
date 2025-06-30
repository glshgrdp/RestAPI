package com.example.libraryproject.mapper;

import com.example.libraryproject.dto.PublisherDTO;
import com.example.libraryproject.model.Publisher;

public class PublisherMapper {

    public static PublisherDTO toDTO(Publisher publisher) {
        if (publisher == null) return null;

        PublisherDTO dto = new PublisherDTO();
        dto.setId(publisher.getId());
        dto.setName(publisher.getName());
        dto.setEstablishmentYear(publisher.getEstablishmentYear());
        dto.setAddress(publisher.getAddress());
        return dto;
    }

    public static Publisher toEntity(PublisherDTO dto) {
        if (dto == null) return null;

        Publisher publisher = new Publisher();
        publisher.setId(dto.getId());
        publisher.setName(dto.getName());
        publisher.setEstablishmentYear(dto.getEstablishmentYear());
        publisher.setAddress(dto.getAddress());
        return publisher;
    }
}
