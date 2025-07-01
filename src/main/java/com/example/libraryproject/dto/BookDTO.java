package com.example.libraryproject.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class BookDTO {

    private Long id;

    @NotBlank(message = "Kitap adı boş olamaz")
    private String name;

    @Min(value = 1400, message = "Yayın yılı 1400'den büyük olmalıdır")
    @Max(value = 2100, message = "Yayın yılı 2100'den küçük olmalıdır")
    private int publicationYear;

    @Min(value = 0, message = "Stok sayısı negatif olamaz")
    private int stock;

    @NotNull(message = "Yazar ID boş olamaz")
    private Long authorId;

    @NotNull(message = "Yayınevi ID boş olamaz")
    private Long publisherId;

    @NotEmpty(message = "En az bir kategori seçilmelidir")
    private List<@NotNull(message = "Kategori ID null olamaz") Long> categoryIds;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public Long getPublisherId() { return publisherId; }
    public void setPublisherId(Long publisherId) { this.publisherId = publisherId; }

    public List<Long> getCategoryIds() { return categoryIds; }
    public void setCategoryIds(List<Long> categoryIds) { this.categoryIds = categoryIds; }
}
