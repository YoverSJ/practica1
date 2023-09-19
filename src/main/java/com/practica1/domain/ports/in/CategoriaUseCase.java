package com.practica1.domain.ports.in;

import com.practica1.domain.model.Categoria;

import java.util.Optional;

public interface CategoriaUseCase {

    Categoria crearCategoria(Categoria categoria);

    Optional<Categoria> encontrarCategoriaPorId(Long id);

    Optional<Categoria> actualizarCategoria(Categoria categoria);

    Boolean eliminarCategoriaPorId(Long id);

}
