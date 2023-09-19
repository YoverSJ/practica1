package com.practica1.application.usecase;

import com.practica1.domain.model.Proveedor;
import com.practica1.domain.ports.in.ProveedorUseCase;
import com.practica1.domain.ports.out.ProveedorRepositoryPort;

import java.util.Optional;

public class ProveedorUseCaseImpl implements ProveedorUseCase {

    private final ProveedorRepositoryPort proveedorRepositoryPort;

    public ProveedorUseCaseImpl(ProveedorRepositoryPort proveedorRepositoryPort) {
        this.proveedorRepositoryPort = proveedorRepositoryPort;
    }

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepositoryPort.save(proveedor);
    }

    @Override
    public Optional<Proveedor> encontrarProveedorPorId(Long id) {
        return proveedorRepositoryPort.findById(id);
    }

    @Override
    public Optional<Proveedor> actualizarProveedor(Proveedor proveedor) {
        return proveedorRepositoryPort.update(proveedor);
    }

    @Override
    public Boolean eliminarProveedorPorId(Long id) {
        return proveedorRepositoryPort.deleteById(id);
    }
}
