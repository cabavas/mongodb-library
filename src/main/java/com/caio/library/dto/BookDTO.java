package com.caio.library.dto;

import com.caio.library.entities.Book;
import com.caio.library.entities.Category;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BookDTO implements Serializable {

    private String id;
    private String title;
    private String author;
    private Boolean rented = false;
    private Set<Category> categories = new HashSet<>();

    public BookDTO() {
    }

    public BookDTO(Book obj) {
        id = obj.getId();
        title = obj.getTitle();
        author = obj.getAuthor();
        rented = obj.isRented();
        categories = obj.getCategories();
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
}
