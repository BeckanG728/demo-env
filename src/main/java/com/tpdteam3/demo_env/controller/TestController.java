package com.tpdteam3.demo_env.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @GetMapping("/conexion")
    public Map<String, String> verificarConexion() {
        Map<String, String> info = new HashMap<>();
        info.put("status", "OK");
        info.put("datasource_url", datasourceUrl);
        info.put("datasource_username", datasourceUsername);
        info.put("mensaje", "Variables de entorno cargadas correctamente");
        return info;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("aplicacion", "demo-env");
        return status;
    }
}