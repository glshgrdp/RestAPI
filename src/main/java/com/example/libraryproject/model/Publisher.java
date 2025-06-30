package com.example.libraryproject.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int establishmentYear;

    private String address;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Book> books;

    public Publisher() {}

    public Publisher(String name, int establishmentYear, String address) {
        this.name = name;
        this.establishmentYear = establishmentYear;
        this.address = address;
    }

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) { this.books = books; }
}
