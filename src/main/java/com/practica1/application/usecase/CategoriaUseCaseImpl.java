package com.practica1.application.usecase;

import com.practica1.domain.model.Categoria;
import com.practica1.domain.ports.in.CategoriaUseCase;
import com.practica1.domain.ports.out.CategoriaRepositoryPort;

import java.util.Optional;

public class CategoriaUseCaseImpl implements CategoriaUseCase {

    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public CategoriaUseCaseImpl(CategoriaRepositoryPort categoriaRepositoryPort) {
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepositoryPort.save(categoria);
    }

    @Override
    public Optional<Categoria> encontrarCategoriaPorId(Long id) {
        return categoriaRepositoryPort.findById(id);
    }

    @Override
    public Optional<Categoria> actualizarCategoria(Categoria categoria) {
        return categoriaRepositoryPort.update(categoria);
    }

    @Override
    public Boolean eliminarCategoriaPorId(Long id) {
        return categoriaRepositoryPort.deleteById(id);
    }
}
