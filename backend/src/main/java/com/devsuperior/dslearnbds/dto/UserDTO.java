package com.devsuperior.dslearnbds.dto;

import com.devsuperior.dslearnbds.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long SerialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;

    public UserDTO(){

    }

    // construtor com os dados que quero trafegar
    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Copia os atributos da entidade para o DTO
    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
