package com.caio.library.resources;

import com.caio.library.dto.OrderDTO;
import com.caio.library.entities.Order;
import com.caio.library.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;
    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<Order> orders = service.findAll();
        List<OrderDTO> ordersDTO = orders.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(ordersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable String id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(new OrderDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody OrderDTO orderDTO) {
        Order obj = service.fromDTO(orderDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
