package com.caio.library.dto;

import com.caio.library.entities.Book;
import com.caio.library.entities.Client;
import com.caio.library.entities.Order;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO implements Serializable {
    private String id;
    private LocalDateTime initialDate;
    private LocalDateTime dateOfReturn;
    private Client client;
    private Integer amountOfBooks;
    private Set<Book> books = new HashSet<>();

    public OrderDTO() {
    }

    public OrderDTO(Order obj) {
        this.id = obj.getId();
        this.initialDate = obj.getInitialDate();
        this.dateOfReturn = obj.getDateOfReturn();
        this.client = obj.getClient();
        this.amountOfBooks = obj.getAmountOfBooks();
        this.books = obj.getBooks();
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
}
