package com.caio.library.resources;

import com.caio.library.dto.ClientDTO;
import com.caio.library.entities.Client;
import com.caio.library.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<ClientDTO> findById(@PathVariable String id) {
        Client obj = service.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClientDTO clientDTO) {
        Client obj = service.fromDTO(clientDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
