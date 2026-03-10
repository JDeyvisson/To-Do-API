package com.todoapi.todoapi.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todoapi.todoapi.models.Tarefa;
import com.todoapi.todoapi.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ArrayList<Tarefa> listarTarefas(){

        return tarefaService.verTarefas();

    }

    @PostMapping("/tarefas/criar")
    public void criarTarefa(String descricao){
        tarefaService.criarTarefa(descricao);
    }

    @PostMapping("/tarefas/marcar")
    public void marcarTarefa(Tarefa tarefa){
        tarefaService.marcarTarefa(tarefa);
    }

    @PutMapping("/tarefas/atualizar")
    public void atualizarTarefa(Tarefa tarefa, String descricao){

        tarefaService.atualizarTarefa(tarefa, descricao);
    }

    @DeleteMapping("/tarefas/deletar")
    public void deletarTarefa(Tarefa tarefa){
        tarefaService.deletarTarefa(tarefa);
    }
}
