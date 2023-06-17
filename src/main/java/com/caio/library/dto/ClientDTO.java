package com.caio.library.dto;

import com.caio.library.entities.Client;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private String cpf;
    private String name;

    public ClientDTO() {
    }

    public ClientDTO(Client obj) {
        cpf = obj.getCpf();
        name = obj.getName();
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

    public void setName(String title) {
        this.name = name;
    }

}
