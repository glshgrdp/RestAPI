package com.example.libraryproject.dto;

import jakarta.validation.constraints.*;

public class PublisherDTO {

    private Long id;

    @NotBlank(message = "Yayınevi adı boş olamaz")
    private String name;

    @Min(value = 1400, message = "Kuruluş yılı geçerli bir yıl olmalıdır")
    @Max(value = 2100, message = "Kuruluş yılı geçerli bir yıl olmalıdır")
    private int establishmentYear;

    @NotBlank(message = "Adres boş olamaz")
    private String address;

    public PublisherDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getEstablishmentYear() { return establishmentYear; }
    public void setEstablishmentYear(int establishmentYear) { this.establishmentYear = establishmentYear; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
