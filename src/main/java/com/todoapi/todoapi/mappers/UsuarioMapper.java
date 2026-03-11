package com.todoapi.todoapi.mappers;

import java.util.List;

import com.todoapi.todoapi.dtos.TarefaResponseDTO;
import com.todoapi.todoapi.dtos.UsuarioResponseDTO;
import com.todoapi.todoapi.models.Usuario;

public class UsuarioMapper {

    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        List<TarefaResponseDTO> tarefasDTO = usuario.getTarefas()
                .stream()
                .map(TarefaMapper::toDTO)
                .toList();

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                tarefasDTO
        );
    }

}