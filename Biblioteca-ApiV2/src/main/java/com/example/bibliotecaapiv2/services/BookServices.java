package com.example.bibliotecaapiv2.services;

import com.example.bibliotecaapiv2.classes.books.Book;
import com.example.bibliotecaapiv2.repositories.BookRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
@Service
public class BookServices {
    private Book bookReg;
    private final RestTemplate restTemplate;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public BookServices(RestTemplate restTemplate, BookRepository bookRepository) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository;
    }

    public boolean BookRegister(String isbn) {
        String url = "https://brasilapi.com.br/api/isbn/v1/" + isbn;
        bookReg = restTemplate.getForObject(url, Book.class);
        if (bookReg != null) {
            saveBookToDatabase(bookReg);
            return true;
        } else {
            return false;
        }
    }

    public void saveBookToDatabase(Book bookReg) {
        if (bookReg != null) {
            bookRepository.save(bookReg);
        } else {
            throw new IllegalStateException("BookReg is null. Make sure to register the book before saving.");
        }
    }

    public boolean BookUpload(String isbn) {
        return BookRegister(isbn);
    }
}
