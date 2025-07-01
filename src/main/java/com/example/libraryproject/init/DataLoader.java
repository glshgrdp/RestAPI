package com.example.libraryproject.init;

import com.example.libraryproject.model.Author;
import com.example.libraryproject.model.Book;
import com.example.libraryproject.model.Publisher;
import com.example.libraryproject.repository.AuthorRepository;
import com.example.libraryproject.repository.BookRepository;
import com.example.libraryproject.repository.PublisherRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader {

    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public DataLoader(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void loadData() {
        // Authors
        Author a1 = authorRepository.save(new Author("Orhan Pamuk", LocalDate.of(1952, 6, 7), "Turkey"));
        Author a2 = authorRepository.save(new Author("Elif Shafak", LocalDate.of(1971, 10, 25), "Turkey"));
        Author a3 = authorRepository.save(new Author("Yaşar Kemal", LocalDate.of(1923, 10, 6), "Turkey"));
        Author a4 = authorRepository.save(new Author("Ahmet Hamdi Tanpınar", LocalDate.of(1901, 6, 23), "Turkey"));
        Author a5 = authorRepository.save(new Author("Sabahattin Ali", LocalDate.of(1907, 2, 25), "Turkey"));

        // Publishers
        Publisher p1 = publisherRepository.save(new Publisher("Yapı Kredi Publishing", 1945, "Istanbul, Turkey"));
        Publisher p2 = publisherRepository.save(new Publisher("Can Publishing", 1981, "Istanbul, Turkey"));
        Publisher p3 = publisherRepository.save(new Publisher("İletişim Publishing", 1982, "Istanbul, Turkey"));
        Publisher p4 = publisherRepository.save(new Publisher("Doğan Publishing", 1995, "Istanbul, Turkey"));
        Publisher p5 = publisherRepository.save(new Publisher("Everest Publishing", 1990, "Istanbul, Turkey"));

        // Books
        bookRepository.save(new Book("The Black Book", 1990, 5, a1, p1));
        bookRepository.save(new Book("Love", 2009, 3, a2, p2));
        bookRepository.save(new Book("İnce Memed", 1955, 4, a3, p3));
        bookRepository.save(new Book("Peace", 1949, 6, a4, p4));
        bookRepository.save(new Book("Madonna in a Fur Coat", 1943, 7, a5, p5));
    }
}
