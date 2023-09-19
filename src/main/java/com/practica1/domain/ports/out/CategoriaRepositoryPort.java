package com.practica1.domain.ports.out;

import com.practica1.domain.model.Categoria;

import java.util.Optional;

public interface CategoriaRepositoryPort {

    Categoria save(Categoria categoria);

    Optional<Categoria> findById(Long id);

    Optional<Categoria> update(Categoria categoria);

    Boolean deleteById(Long id);

}
