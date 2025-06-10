package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.models.entities.User;
import com.example.models.requests.UserCreate;
import com.example.models.requests.UserUpdate;
import com.example.models.external.Perfume;
import com.example.models.responses.UsuarioConPerfumesDTO;
import com.example.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WebClient webClient;

    // aqui obenetemos a todos los usuarios
    @GetMapping
    public List<User> obtenerTodos() {
        return userService.obtenerTodos();
    }

    // aqui obtenemos a un usuario por su ID
    @GetMapping("/{id}")
    public User obtenerUno(@PathVariable int id) {
        return userService.obtenerPorId(id);
    }

    // desde aqui registramos un nuevo usuario
    @PostMapping
    public User registrar(@Valid @RequestBody UserCreate body) {
        return userService.registrar(body);
    }

    // aqui actualizamos a usuarios existentes
    @PutMapping
    public User actualizar(@Valid @RequestBody UserUpdate body) {
        return userService.actualizar(body);
    }

    // eliminamos a usuarios
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        userService.eliminar(id);
        return "usuario eliminado";
    }

    // aqui obtendremos a usuario + perfumes asociados
    @GetMapping("/{id}/perfumes")
    public UsuarioConPerfumesDTO obtenerUsuarioConPerfumes(@PathVariable int id) {
        User usuario = userService.obtenerPorId(id);

        List<Perfume> perfumes = webClient.get()
            .uri("/api/perfumes/usuario/" + id)
            .retrieve()
            .bodyToFlux(Perfume.class)
            .collectList()
            .block();

        UsuarioConPerfumesDTO dto = new UsuarioConPerfumesDTO();
        dto.setUsuario(usuario);
        dto.setPerfumes(perfumes);
        return dto;
    }
}
