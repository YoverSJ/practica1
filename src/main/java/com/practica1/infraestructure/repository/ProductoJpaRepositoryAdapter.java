package com.practica1.infraestructure.repository;

import com.practica1.domain.model.Producto;
import com.practica1.domain.ports.out.ProductoRepositoryPort;
import com.practica1.infraestructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoJpaRepositoryAdapter implements ProductoRepositoryPort {

    private final ProductoJpaRepository productoJpaRepository;

    public ProductoJpaRepositoryAdapter(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public Producto save(Producto producto) {
        ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        ProductoEntity createProductoEntity = productoJpaRepository.save(productoEntity);
        return createProductoEntity.toDomainModel();
    }

    @Override
    public Optional<List<Producto>> getProductos() {
        List<ProductoEntity> productosEntity = productoJpaRepository.findAll();

        if (!productosEntity.isEmpty()){

            List<Producto> productos = new ArrayList<>();

            for (ProductoEntity productoEntity : productosEntity) {

                Producto producto = new Producto();

                producto.setId(productoEntity.getId());
                producto.setNombre(productoEntity.getNombre());
                producto.setDescripcion(productoEntity.getDescripcion());
                producto.setPrecio(productoEntity.getPrecio());
                producto.setEstado(productoEntity.getEstado());
                producto.setCategoria(productoEntity.getCategoria().toDomainModel());
                producto.setProveedor(productoEntity.getProveedor().toDomainModel());

                productos.add(producto);
            }
            return Optional.of(productos);
        }

        return null;

    }

    @Override
    public Optional<Producto> findById(Long id) {
        if (productoJpaRepository.existsById(id)){
            return productoJpaRepository.findById(id).map(ProductoEntity::toDomainModel);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Producto> update(Producto producto) {
        if (productoJpaRepository.existsById(producto.getId())){
            ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
            ProductoEntity updateProductoEntity = productoJpaRepository.save(productoEntity);
            return Optional.of(updateProductoEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deletebyId(Long id) {
        if (productoJpaRepository.existsById(id)){
            productoJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
