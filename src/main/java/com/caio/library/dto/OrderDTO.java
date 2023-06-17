package com.caio.library.dto;

import com.caio.library.entities.Book;
import com.caio.library.entities.Client;
import com.caio.library.entities.Order;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class OrderDTO implements Serializable {
    private Integer id;
    private Date initialDate;
    private Date dateOfReturn;
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
}
