package com.todoapi.todoapi.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoapi.todoapi.models.Usuario;
import com.todoapi.todoapi.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ArrayList<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/criar")
    public Usuario criarUsuario(@RequestParam String nome, @RequestParam String email) {
        return usuarioService.criarUsuario(nome, email);
    }

    @PutMapping("/{id}/atualizar")
    public Usuario atualizarUsuario(
            @PathVariable int id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email) {
        return usuarioService.atualizarUsuario(id, nome, email);
    }

    @DeleteMapping("/{id}/deletar")
    public void deletarUsuario(@PathVariable int id) {
        usuarioService.deletarUsuario(id);
    }

}