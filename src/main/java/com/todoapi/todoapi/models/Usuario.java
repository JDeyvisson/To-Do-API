package com.todoapi.todoapi.models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String email;
    private List<Tarefa> tarefas;

    public Usuario(String nome, String email) {
        this.id = contadorId++;
        this.nome = nome;
        this.email = email;
        this.tarefas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
    }

}