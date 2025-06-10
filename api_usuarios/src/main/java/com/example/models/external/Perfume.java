package com.example.models.external;

import lombok.Data;

@Data
public class Perfume {
    private Long id;
    private String nombre;
    private String marca;
    private Double precio;
    private Long idUsuario;
}
