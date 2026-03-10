package com.todoapi.todoapi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.todoapi.todoapi.models.Tarefa;

@Service
public class TarefaService {

   
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public Tarefa criarTarefa(String descricao) {
   
        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
        return tarefa;
    }

    public void deletarTarefa(int id) {
        tarefas.removeIf(t -> t.getId() == id);
    }


    public Tarefa avancarEstado(int id) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.avancarEstado();
        return tarefa;
    }

    public ArrayList<Tarefa> verTarefas() {
        return this.tarefas;
    }

    public Tarefa atualizarTarefa(int id, String descricao) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setDescricao(descricao);
        return tarefa;
    }

    private Tarefa buscarPorId(int id) {
        return tarefas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
    }

}