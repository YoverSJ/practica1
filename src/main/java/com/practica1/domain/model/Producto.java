package com.practica1.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer estado;
    private Categoria categoria;
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, Double precio, Integer estado, Categoria categoria, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }
}
