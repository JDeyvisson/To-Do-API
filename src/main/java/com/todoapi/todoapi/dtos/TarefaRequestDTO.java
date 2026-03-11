package com.todoapi.todoapi.dtos;

public class TarefaRequestDTO {

    private String descricao;

    public TarefaRequestDTO() {}

    public TarefaRequestDTO(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}