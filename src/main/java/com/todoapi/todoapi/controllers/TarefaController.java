package com.todoapi.todoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapi.todoapi.dtos.TarefaRequestDTO;
import com.todoapi.todoapi.dtos.TarefaResponseDTO;
import com.todoapi.todoapi.services.TarefaService;

@RestController
@RequestMapping("/usuarios/{usuarioId}/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<TarefaResponseDTO> listarTarefas(@PathVariable Long usuarioId) {
        return tarefaService.listarTarefasDoUsuario(usuarioId);
    }

    @PostMapping("/criar")
    public TarefaResponseDTO criarTarefa(@PathVariable Long usuarioId, @RequestBody TarefaRequestDTO dto) {
        return tarefaService.criarTarefa(usuarioId, dto);
    }
    
    @PatchMapping("/{tarefaId}/avancar")
    public TarefaResponseDTO avancarEstado(@PathVariable Long usuarioId, @PathVariable Long tarefaId) {
        return tarefaService.avancarEstado(usuarioId, tarefaId);
    }

    @PutMapping("/{tarefaId}/atualizar")
    public TarefaResponseDTO atualizarTarefa(
            @PathVariable Long usuarioId,
            @PathVariable Long tarefaId,
            @RequestBody TarefaRequestDTO dto) {
        return tarefaService.atualizarTarefa(usuarioId, tarefaId, dto);
    }

    @DeleteMapping("/{tarefaId}/deletar")
    public void deletarTarefa(@PathVariable Long usuarioId, @PathVariable Long tarefaId) {
        tarefaService.deletarTarefa(usuarioId, tarefaId);
    }

}