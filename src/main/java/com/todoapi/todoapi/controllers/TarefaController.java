package com.todoapi.todoapi.controllers;

import java.util.ArrayList;

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
@RequestMapping("/tarefas") 
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ArrayList<Tarefa> listarTarefas() {
        return tarefaService.verTarefas();
    }

    @PostMapping("/criar")
    public Tarefa criarTarefa(@RequestParam String descricao) {
        return tarefaService.criarTarefa(descricao);
    }

    @PatchMapping("/{id}/avancar")
    public Tarefa avancarEstado(@PathVariable int id) {
        return tarefaService.avancarEstado(id);
    }

    @PutMapping("/{id}/atualizar")
    public Tarefa atualizarTarefa(@PathVariable int id, @RequestParam String descricao) {
        return tarefaService.atualizarTarefa(id, descricao);
    }

    @DeleteMapping("/{id}/deletar")
    public void deletarTarefa(@PathVariable int id) {
        tarefaService.deletarTarefa(id);
    }

}