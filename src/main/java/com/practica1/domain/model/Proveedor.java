package com.practica1.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proveedor {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Integer estado;

    public Proveedor() {
    }

    public Proveedor(Long id, String nombre, String direccion, String telefono, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

}
