package com.caio.library.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection = "orders")
public class Order implements Serializable {
    @Id
    private String id;
    private LocalDateTime initialDate;
    private LocalDateTime dateOfReturn;
    @DocumentReference
    private Client client;
    private Integer amountOfBooks;
    @DocumentReference
    private Set<Book> books = new HashSet<>();

    public Order() {
    }

    public Order(String id, LocalDateTime dateOfReturn, Client client, Integer amountOfBooks, Set<Book> books) {
        this.id = id;
        this.initialDate = LocalDateTime.now();
        this.dateOfReturn = dateOfReturn;
        this.client = client;
        this.amountOfBooks = amountOfBooks;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDateTime getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDateTime dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getAmountOfBooks() {
        return amountOfBooks;
    }

    public void setAmountOfBooks(Integer amountOfBooks) {
        this.amountOfBooks = amountOfBooks;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
