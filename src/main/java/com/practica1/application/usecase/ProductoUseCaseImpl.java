package com.practica1.application.usecase;

import com.practica1.domain.model.Producto;
import com.practica1.domain.ports.in.ProductoUseCase;
import com.practica1.domain.ports.out.ProductoRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ProductoUseCaseImpl implements ProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public ProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepositoryPort.save(producto);
    }

    @Override
    public Optional<List<Producto>> obtenerProductos() {
        return productoRepositoryPort.getProductos();
    }

    @Override
    public Optional<Producto> encontrarProductoPorId(Long id) {
        return productoRepositoryPort.findById(id);
    }

    @Override
    public Optional<Producto> actualizarProducto(Producto producto) {
        return productoRepositoryPort.update(producto);
    }

    @Override
    public Boolean eliminarProductoPorId(Long id) {
        return productoRepositoryPort.deletebyId(id);
    }
}
