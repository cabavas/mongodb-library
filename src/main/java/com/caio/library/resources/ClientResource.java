package com.caio.library.resources;

import com.caio.library.dto.ClientDTO;
import com.caio.library.entities.Client;
import com.caio.library.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> clients = service.findAll();
        List<ClientDTO> clientsDTO = clients.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clientsDTO);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<ClientDTO> findByCpf(@PathVariable String cpf) {
        Client obj = service.findByCpf(cpf);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }
}
