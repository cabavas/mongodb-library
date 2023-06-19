package com.caio.library.services;

import com.caio.library.dto.ClientDTO;
import com.caio.library.entities.Client;
import com.caio.library.repositories.ClientRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }


    public Client update(Client obj) {
        Client newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void updateData(Client newObj, Client obj) {
        newObj.setCpf(obj.getCpf());
        newObj.setName(obj.getName());
    }

    public Client fromDTO(ClientDTO obj) {
        return new Client(obj.getId(), obj.getCpf(), obj.getName());
    }
}
