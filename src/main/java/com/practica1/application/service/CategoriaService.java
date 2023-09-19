package com.practica1.application.service;

import com.practica1.domain.model.Categoria;
import com.practica1.domain.ports.in.CategoriaUseCase;

import java.util.Optional;

public class CategoriaService implements CategoriaUseCase {

    private final CategoriaUseCase categoriaUseCase;

    public CategoriaService(CategoriaUseCase categoriaUseCase) {
        this.categoriaUseCase = categoriaUseCase;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaUseCase.crearCategoria(categoria);
    }

    @Override
    public Optional<Categoria> encontrarCategoriaPorId(Long id) {
        return categoriaUseCase.encontrarCategoriaPorId(id);
    }

    @Override
    public Optional<Categoria> actualizarCategoria(Categoria categoria) {
        return categoriaUseCase.actualizarCategoria(categoria);
    }

    @Override
    public Boolean eliminarCategoriaPorId(Long id) {
        return categoriaUseCase.eliminarCategoriaPorId(id);
    }
}
