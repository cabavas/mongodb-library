package com.caio.library.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.*;

@Document(collection = "books")
public class Book implements Serializable {

    @Id
    private String id;
    private String title;
    private String author;
    private Boolean rented = false;
    private Set<Category> categories = new HashSet<>();

    public Book() {
    }

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void addCategories(Category category) {
        this.categories.add(category);
    }

    public Boolean isRented() {
        return this.rented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
