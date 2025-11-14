package com.tpdteam3.demo_env.controller;

import com.tpdteam3.demo_env.entity.Usuario;
import com.tpdteam3.demo_env.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Integer id) {
        return usuarioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<Usuario> obtenerPorLogin(@PathVariable String login) {
        return usuarioService.obtenerPorLogin(login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}