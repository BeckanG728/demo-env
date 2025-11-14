package com.tpdteam3.demo_env.service;

import com.tpdteam3.demo_env.entity.Usuario;
import com.tpdteam3.demo_env.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerPorLogin(String login) {
        return usuarioRepository.findByLogiUsua(login);
    }
}