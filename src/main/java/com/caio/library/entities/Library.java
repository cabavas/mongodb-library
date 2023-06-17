package com.caio.library.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Library {

    private List<Book> books = new ArrayList<>();
    private Set<Order> orders = new HashSet<>();

    public Library() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
