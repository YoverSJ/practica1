package com.practica1.infraestructure.entity;

import com.practica1.domain.model.Categoria;
import com.practica1.domain.model.Producto;
import com.practica1.domain.model.Proveedor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer estado;

    @ManyToOne
    private CategoriaEntity categoria;

    @ManyToOne
    private ProveedorEntity proveedor;

    public ProductoEntity() {
    }

    public ProductoEntity(Long id, String nombre, String descripcion, Double precio, Integer estado, CategoriaEntity categoria, ProveedorEntity proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public static ProductoEntity fromDomainModel(Producto producto){
        return new ProductoEntity(producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getEstado(), CategoriaEntity.fromDomainModel(producto.getCategoria()), ProveedorEntity.fromDomainModel(producto.getProveedor()));
    }

    public Producto toDomainModel(){
        return new Producto(id, nombre, descripcion, precio, estado, categoria.toDomainModel(), proveedor.toDomainModel());
    }
}
