package com.todoapi.todoapi.state;

public class PendenteState implements TarefaState {

    @Override
    public String getNome() {
        return "PENDENTE";
    }

    @Override
    public TarefaState avancar() {
        return new EmProgressoState();
    }

}