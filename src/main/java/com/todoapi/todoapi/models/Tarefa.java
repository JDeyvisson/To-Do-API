package com.todoapi.todoapi.models;

import com.todoapi.todoapi.state.PendenteState;
import com.todoapi.todoapi.state.TarefaState;

public class Tarefa {

    private static int contadorId = 1;

    private int id;
    private String descricao;
    private TarefaState estado;

    public Tarefa(String descricao) {
        this.id = contadorId++;
        this.descricao = descricao;
        this.estado = new PendenteState(); 
    }

   
    public void avancarEstado() {
        this.estado = this.estado.avancar();
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado.getNome();
    }

}