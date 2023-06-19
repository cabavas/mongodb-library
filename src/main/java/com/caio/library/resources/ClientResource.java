package com.caio.library.resources;

import com.caio.library.dto.ClientDTO;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.caio.library.entities.Client;
import com.caio.library.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> clients = service.findAll();
        List<ClientDTO> clientsDTO = clients.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clientsDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable String id) {
        Client obj = service.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClientDTO clientDTO) {
        Client obj = service.fromDTO(clientDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ClientDTO objDTO, @PathVariable String id) {
        Client obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
