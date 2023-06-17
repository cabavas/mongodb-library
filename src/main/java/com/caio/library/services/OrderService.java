package com.caio.library.services;

import com.caio.library.entities.Order;
import com.caio.library.repositories.OrderRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(String id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectCollectedException("Order not found"));
    }
}
