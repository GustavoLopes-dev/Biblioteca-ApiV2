package com.example.bibliotecaapiv2.repositories;

import com.example.bibliotecaapiv2.classes.locations.Locations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Locations, String> {
}
