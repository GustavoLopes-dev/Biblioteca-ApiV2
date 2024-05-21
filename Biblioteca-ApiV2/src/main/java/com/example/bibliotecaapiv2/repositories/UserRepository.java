package com.example.bibliotecaapiv2.repositories;

import com.example.bibliotecaapiv2.classes.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
