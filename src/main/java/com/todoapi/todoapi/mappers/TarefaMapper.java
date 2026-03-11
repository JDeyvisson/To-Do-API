package com.todoapi.todoapi.mappers;

import com.todoapi.todoapi.dtos.TarefaResponseDTO;
import com.todoapi.todoapi.models.Tarefa;

public class TarefaMapper {

    public static TarefaResponseDTO toDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getDescricao(),
                tarefa.getEstado(),
                tarefa.getUsuario().getId()
        );
    }

}