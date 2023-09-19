package com.practica1.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria {

    private Long id;
    private String nombre;
    private Integer estado;

    public Categoria() {
    }

    public Categoria(Long id, String nombre, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

}
