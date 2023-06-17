package com.caio.library.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caio.library.entities.Book;
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
