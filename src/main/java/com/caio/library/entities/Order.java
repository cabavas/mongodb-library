package com.caio.library.entities;

import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Order implements Serializable {
    @MongoId(FieldType.INT64)
    private Integer id;
    private Date initialDate;
    private Date dateOfReturn;
    private Client client;
    private Integer amountOfBooks;
    private Set<Book> books = new HashSet<>();

    public Order() {
    }

    public Order(int id, Date date, Date dateOfReturn, Client client, Integer amountOfBooks) {
        this.id = id;
        this.initialDate = new Date(String.valueOf(Instant.now()));
        this.dateOfReturn = dateOfReturn;
        this.client = client;
        this.amountOfBooks = amountOfBooks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
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
