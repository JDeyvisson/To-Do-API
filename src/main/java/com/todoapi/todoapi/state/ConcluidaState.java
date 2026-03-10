package com.todoapi.todoapi.state;

public class ConcluidaState implements TarefaState {

    @Override
    public String getNome() {
        return "CONCLUIDA";
    }

    @Override
    public TarefaState avancar() {
   
        return this;
    }

}