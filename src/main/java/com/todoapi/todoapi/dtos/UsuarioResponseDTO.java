package com.todoapi.todoapi.dtos;

import java.util.List;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private List<TarefaResponseDTO> tarefas;

    public UsuarioResponseDTO() {}

    public UsuarioResponseDTO(Long id, String nome, String email, List<TarefaResponseDTO> tarefas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tarefas = tarefas;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<TarefaResponseDTO> getTarefas() {
        return tarefas;
    }

}