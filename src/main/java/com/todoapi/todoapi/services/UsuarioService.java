package com.todoapi.todoapi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.todoapi.todoapi.models.Usuario;

@Service
public class UsuarioService {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario criarUsuario(String nome, String email) {
       
        boolean emailJaExiste = usuarios.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));

        if (emailJaExiste) {
            throw new RuntimeException("Já existe um usuário com o e-mail: " + email);
        }

        Usuario usuario = new Usuario(nome, email);
        usuarios.add(usuario);
        return usuario;
    }

    public ArrayList<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Usuario buscarPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }

    public Usuario atualizarUsuario(int id, String nome, String email) {
        Usuario usuario = buscarPorId(id);
        if (nome != null && !nome.isBlank()) usuario.setNome(nome);
        if (email != null && !email.isBlank()) usuario.setEmail(email);
        return usuario;
    }

    public void deletarUsuario(int id) {
        Usuario usuario = buscarPorId(id);
        usuarios.remove(usuario);
    }

}