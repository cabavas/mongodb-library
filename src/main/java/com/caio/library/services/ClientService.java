package com.caio.library.services;

import com.caio.library.entities.Client;
import com.caio.library.repositories.ClientRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findByCpf(String cpf) {
        Optional<Client> obj = repository.findById(cpf);
        return obj.orElseThrow(() -> new ObjectCollectedException("Client not found"));
    }
}
