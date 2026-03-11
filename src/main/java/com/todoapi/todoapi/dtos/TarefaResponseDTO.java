package com.todoapi.todoapi.dtos;

public class TarefaResponseDTO {

    private Long id;
    private String descricao;
    private String estado;
    private Long usuarioId;

    public TarefaResponseDTO() {}

    public TarefaResponseDTO(Long id, String descricao, String estado, Long usuarioId) {
        this.id = id;
        this.descricao = descricao;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEstado() {
        return estado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

}