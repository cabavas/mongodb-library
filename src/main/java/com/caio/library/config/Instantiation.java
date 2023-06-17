package com.caio.library.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.caio.library.repositories.BookRepository;
import com.caio.library.entities.Book;
import com.caio.library.entities.Category;

public class Instantiation implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book b1 = new Book(null, "Physics for dummies", "Caio");
        Book b2 = new Book(null, "Knight in an armor", "Tom");
        Book b3 = new Book(null, "The pillars of Earth", "Ken Follet");

        b1.addCategories(Category.PHYSICS);
        b2.addCategories(Category.DRAMA);
        b3.addCategories(Category.ROMANCE);
        b3.addCategories(Category.HISTORICAL);

        bookRepository.saveAll(Arrays.asList(b1, b2, b3));
    }
}
