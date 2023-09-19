package com.practica1.domain.ports.in;

import com.practica1.domain.model.Proveedor;
import com.practica1.domain.model.Proveedor;

import java.util.Optional;

public interface ProveedorUseCase {

    Proveedor crearProveedor(Proveedor proveedor);

    Optional<Proveedor> encontrarProveedorPorId(Long id);

    Optional<Proveedor> actualizarProveedor(Proveedor proveedor);

    Boolean eliminarProveedorPorId(Long id);
    
}
