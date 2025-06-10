package com.example.models.responses;

import com.example.models.entities.User;
import com.example.models.external.Perfume;

import java.util.List;

public class UsuarioConPerfumesDTO {

    private User usuario;
    private List<Perfume> perfumes;

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public List<Perfume> getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(List<Perfume> perfumes) {
        this.perfumes = perfumes;
    }
}
