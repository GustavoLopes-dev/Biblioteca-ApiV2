package com.example.bibliotecaapiv2.services;

import com.example.bibliotecaapiv2.classes.books.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
public class BookServices {
    private Book bookReg;

    private final RestTemplate restTemplate = new RestTemplate();


    public void BookRegister(String isbn) {
        String url = "https://brasilapi.com.br/api/isbn/v1/" + isbn;
        bookReg = restTemplate.getForObject(url, Book.class);
    }
}
