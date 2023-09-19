package com.practica1.infraestructure.entity;

import com.practica1.domain.model.Proveedor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    private String telefono;

    private Integer estado;

    public ProveedorEntity() {
    }

    public ProveedorEntity(Long id, String nombre, String direccion, String telefono, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public static ProveedorEntity fromDomainModel(Proveedor proveedor){
        return new ProveedorEntity(proveedor.getId(), proveedor.getNombre(), proveedor.getDireccion(), proveedor.getTelefono(), proveedor.getEstado());
    }

    public Proveedor toDomainModel(){
        return new Proveedor(id, nombre, direccion, telefono, estado);
    }

}
