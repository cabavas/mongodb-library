package com.caio.library.services;

import com.caio.library.dto.ClientDTO;
import com.caio.library.entities.Client;
import com.caio.library.repositories.ClientRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(String id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectCollectedException("Client not found"));
    }

    public Client insert(Client obj) {
        return repository.insert(obj);
    }

    public Client fromDTO(ClientDTO clientDTO) {
        return new Client(clientDTO.getCpf(), clientDTO.getName());
    }
}
