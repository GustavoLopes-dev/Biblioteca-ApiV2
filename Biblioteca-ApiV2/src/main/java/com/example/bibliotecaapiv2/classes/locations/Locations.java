package com.example.bibliotecaapiv2.classes.locations;

import com.example.bibliotecaapiv2.classes.books.Book;
import com.example.bibliotecaapiv2.classes.users.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Locations {
    private final String id;
    private User user;
    private Book book;

    public Locations(User user, Book book) {
        this.user = user;
        this.book = book;
        this.id = generateId(user, book);
    }

    public String generateId(User user, Book book) {
        String userPrefix = user.getUser_name().substring(0, Math.min(user.getUser_name().length(), 5)).toUpperCase();
        String bookTitlePrefix = book.getTitle().substring(0, Math.min(book.getTitle().length(), 5)).toUpperCase();
        String bookIsbnSuffix = book.getIsbn().substring(Math.max(book.getIsbn().length() - 3, 0)).toUpperCase();
        return userPrefix + bookTitlePrefix + bookIsbnSuffix;
    }
}
