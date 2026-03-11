package com.todoapi.todoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoapi.todoapi.models.Tarefa;
import com.todoapi.todoapi.services.TarefaService;

@RestController
@RequestMapping("/usuarios/{usuarioId}/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listarTarefas(@PathVariable int usuarioId) {
        return tarefaService.listarTarefasDoUsuario(usuarioId);
    }

    @PostMapping("/criar")
    public Tarefa criarTarefa(@PathVariable int usuarioId, @RequestParam String descricao) {
        return tarefaService.criarTarefa(usuarioId, descricao);
    }

    @PatchMapping("/{tarefaId}/avancar")
    public Tarefa avancarEstado(@PathVariable int usuarioId, @PathVariable int tarefaId) {
        return tarefaService.avancarEstado(usuarioId, tarefaId);
    }

    @PutMapping("/{tarefaId}/atualizar")
    public Tarefa atualizarTarefa(
            @PathVariable int usuarioId,
            @PathVariable int tarefaId,
            @RequestParam String descricao) {
        return tarefaService.atualizarTarefa(usuarioId, tarefaId, descricao);
    }

    @DeleteMapping("/{tarefaId}/deletar")
    public void deletarTarefa(@PathVariable int usuarioId, @PathVariable int tarefaId) {
        tarefaService.deletarTarefa(usuarioId, tarefaId);
    }

}