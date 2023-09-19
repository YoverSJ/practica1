package com.practica1.application.service;

import com.practica1.domain.model.Proveedor;
import com.practica1.domain.ports.in.ProveedorUseCase;

import java.util.Optional;

public class ProveedorService implements ProveedorUseCase {

    private final ProveedorUseCase proveedorUseCase;

    public ProveedorService(ProveedorUseCase proveedorUseCase) {
        this.proveedorUseCase = proveedorUseCase;
    }

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorUseCase.crearProveedor(proveedor);
    }

    @Override
    public Optional<Proveedor> encontrarProveedorPorId(Long id) {
        return proveedorUseCase.encontrarProveedorPorId(id);
    }

    @Override
    public Optional<Proveedor> actualizarProveedor(Proveedor proveedor) {
        return proveedorUseCase.actualizarProveedor(proveedor);
    }

    @Override
    public Boolean eliminarProveedorPorId(Long id) {
        return proveedorUseCase.eliminarProveedorPorId(id);
    }
}
