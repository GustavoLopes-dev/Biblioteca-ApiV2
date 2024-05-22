package com.example.bibliotecaapiv2.repositories;

import com.example.bibliotecaapiv2.classes.books.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
