package com.caio.library.resources;

import com.caio.library.dto.OrderDTO;
import com.caio.library.entities.Order;
import com.caio.library.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;
    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<Order> books = service.findAll();
        List<OrderDTO> booksDTO = books.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(booksDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable String id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(new OrderDTO(obj));
    }
}
