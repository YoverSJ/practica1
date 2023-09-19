package com.practica1.application.service;

import com.practica1.domain.model.Producto;
import com.practica1.domain.ports.in.ProductoUseCase;

import java.util.List;
import java.util.Optional;

public class ProductoService implements ProductoUseCase {

    private final ProductoUseCase productoUseCase;

    public ProductoService(ProductoUseCase productoUseCase) {
        this.productoUseCase = productoUseCase;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoUseCase.crearProducto(producto);
    }

    @Override
    public Optional<List<Producto>> obtenerProductos() {
        return productoUseCase.obtenerProductos();
    }

    @Override
    public Optional<Producto> encontrarProductoPorId(Long id) {
        return productoUseCase.encontrarProductoPorId(id);
    }

    @Override
    public Optional<Producto> actualizarProducto(Producto producto) {
        return productoUseCase.actualizarProducto(producto);
    }

    @Override
    public Boolean eliminarProductoPorId(Long id) {
        return productoUseCase.eliminarProductoPorId(id);
    }
}
