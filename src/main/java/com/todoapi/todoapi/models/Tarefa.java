package com.todoapi.todoapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.todoapi.todoapi.state.ConcluidaState;
import com.todoapi.todoapi.state.EmProgressoState;
import com.todoapi.todoapi.state.PendenteState;
import com.todoapi.todoapi.state.TarefaState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String estado = "PENDENTE";


    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference 
    private Usuario usuario;

    @Transient
    private TarefaState estadoObj;

    public Tarefa() {}

    public Tarefa(String descricao, Usuario usuario) {
        this.descricao = descricao;
        this.usuario = usuario;
        this.estado = "PENDENTE";
    }

    public void avancarEstado() {
        TarefaState estadoAtual = getEstadoObj();
        this.estadoObj = estadoAtual.avancar();
        this.estado = this.estadoObj.getNome();
    }

    private TarefaState getEstadoObj() {
        if (estadoObj == null) {
            estadoObj = switch (this.estado) {
                case "EM_PROGRESSO" -> new EmProgressoState();
                case "CONCLUIDA"    -> new ConcluidaState();
                default             -> new PendenteState();
            };
        }
        return estadoObj;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}