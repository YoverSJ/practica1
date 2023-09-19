package com.practica1.domain.ports.out;

import com.practica1.domain.model.Proveedor;

import java.util.Optional;

public interface ProveedorRepositoryPort {

    Proveedor save(Proveedor proveedor);

    Optional<Proveedor> findById(Long id);

    Optional<Proveedor> update(Proveedor proveedor);

    Boolean deleteById(Long id);
}
