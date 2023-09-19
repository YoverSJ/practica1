package com.practica1.domain.ports.in;

import com.practica1.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoUseCase {

    Producto crearProducto(Producto producto);

    Optional<List<Producto>> obtenerProductos();

    Optional<Producto> encontrarProductoPorId(Long id);

    Optional<Producto>  actualizarProducto(Producto producto);

    Boolean eliminarProductoPorId(Long id);

}
