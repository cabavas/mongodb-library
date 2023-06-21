package com.caio.library.services;

import com.caio.library.dto.OrderDTO;
import com.caio.library.entities.Order;
import com.caio.library.repositories.OrderRepository;
import com.mongodb.client.MongoCollection;
import com.sun.jdi.ObjectCollectedException;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public OrderService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(String id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectCollectedException("Order not found"));
    }

    public Order insert(Order obj) {
        return repository.insert(obj);
    }

    public Order fromDTO(OrderDTO obj) {
        return new Order(obj.getId(), obj.getDateOfReturn(), obj.getClient(), obj.getAmountOfBooks(), obj.getBooks());
    }
}
