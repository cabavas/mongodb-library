package com.caio.library.dto;

import com.caio.library.entities.Client;

import java.io.Serializable;

public class ClientDTO implements Serializable {
    private String id;

    private String cpf;
    private String name;

    public ClientDTO() {
    }

    public ClientDTO(Client obj) {
        id = obj.getId();
        cpf = obj.getCpf();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
