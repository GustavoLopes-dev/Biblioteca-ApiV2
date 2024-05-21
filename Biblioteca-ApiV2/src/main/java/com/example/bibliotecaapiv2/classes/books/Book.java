package com.example.bibliotecaapiv2.classes.books;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String isbn;
    private String title;
    private String subtitle;
    private String[] authors;
    private String publisher;
    private String synopsis;
    private Dimensions dimensions;
    private int year;
    private String format;
    private int page_count;
    private String[] subjects;
    private String location;
    private double retail_price;
    private String cover_url;
    private String provider;
}
