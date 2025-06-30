package com.example.libraryproject.dto;

public class PublisherDTO {

    private Long id;
    private String name;
    private int establishmentYear;
    private String address;

    public PublisherDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) { this.establishmentYear = establishmentYear; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { this.address = address; }
}
