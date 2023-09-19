package com.practica1.domain.ports.out;

import com.practica1.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {

    Producto save(Producto producto);

    Optional<List<Producto>> getProductos();

    Optional<Producto> findById(Long id);

    Optional<Producto> update(Producto producto);

    Boolean deletebyId(Long id);

}
