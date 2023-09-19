package com.practica1.infraestructure.entity;

import com.practica1.domain.model.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer estado;

    public CategoriaEntity() {
    }

    public CategoriaEntity(Long id, String nombre, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public static CategoriaEntity fromDomainModel(Categoria categoria){
        return new CategoriaEntity(categoria.getId(), categoria.getNombre(), categoria.getEstado());
    }

    public Categoria toDomainModel(){
        return new Categoria(id, nombre, estado);
    }

}
