package com.practica1.infraestructure.repository;

import com.practica1.domain.model.Categoria;
import com.practica1.domain.model.Producto;
import com.practica1.domain.model.Proveedor;
import com.practica1.infraestructure.entity.CategoriaEntity;
import com.practica1.infraestructure.entity.ProductoEntity;
import com.practica1.infraestructure.entity.ProveedorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductoJpaRepositoryAdapterTest {

    @Mock
    ProductoJpaRepository productoJpaRepository;

    @InjectMocks
    ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);
        productoJpaRepositoryAdapter = new ProductoJpaRepositoryAdapter(productoJpaRepository);
    }

    @Test
    void save() {

        CategoriaEntity categoria = new CategoriaEntity(1L, "Bebida", 1);

        ProveedorEntity proveedor = new ProveedorEntity(1L, "Empresa 1", "Av. Lima", "1234567", 1);

        Producto producto = new Producto(1L, "Inca Kola", "Gaseosa", 2.8, 1, categoria.toDomainModel(), proveedor.toDomainModel());

        ProductoEntity productoEntity = new ProductoEntity(1L, "Inca Kola", "Gaseosa", 2.8, 1, categoria, proveedor);

        Mockito.when(productoJpaRepository.save(Mockito.any(ProductoEntity.class))).thenReturn(productoEntity);

        Producto responseProducto = productoJpaRepositoryAdapter.save(producto);

        assertNotNull(responseProducto);
        assertEquals(producto.getId(), responseProducto.getId());
        assertEquals(producto.getCategoria().getId(), responseProducto.getCategoria().getId());
        assertEquals(producto.getProveedor().getId(), responseProducto.getProveedor().getId());

    }

    @Test
    void findByIdExitoso() {

        Long id = 1L;

        CategoriaEntity categoria = new CategoriaEntity(1L, "Bebida", 1);

        ProveedorEntity proveedor = new ProveedorEntity(1L, "Empresa 1", "Av. Lima", "1234567", 1);

        Producto producto = new Producto(1L, "Inca Kola", "Gaseosa", 2.8, 1, categoria.toDomainModel(), proveedor.toDomainModel());

        ProductoEntity productoEntity = new ProductoEntity(1L, "Inca Kola", "Gaseosa", 2.8, 1, categoria, proveedor);

        Mockito.when(productoJpaRepository.existsById(id)).thenReturn(true);
        Mockito.when(productoJpaRepository.findById(id)).thenReturn(Optional.of(productoEntity));

        Optional<Producto> responseProducto = productoJpaRepositoryAdapter.findById(id);

        assertNotNull(responseProducto);

        responseProducto.map(rproducto -> {
           assertEquals(productoEntity.getId(), rproducto.getId());
           assertEquals(productoEntity.getCategoria().getId(), rproducto.getCategoria().getId());
           assertEquals(productoEntity.getProveedor().getId(), rproducto.getProveedor().getId());
           return true;
        });

    }

    @Test
    void findByIdNull(){

        Long id = 1L;

        Mockito.when(productoJpaRepository.existsById(id)).thenReturn(false);

        Optional<Producto> producto = productoJpaRepositoryAdapter.findById(id);

        assertTrue(producto.isEmpty());
    }

    @Test
    void updateExitoso() {

        CategoriaEntity categoria = new CategoriaEntity(1L, "Bebida", 1);

        ProveedorEntity proveedor = new ProveedorEntity(1L, "Empresa 1", "Av. Lima", "1234567", 1);

        Producto producto = new Producto(1L, "Inca Kola", "Gaseosa", 2.8, 1, categoria.toDomainModel(), proveedor.toDomainModel());

        ProductoEntity productoEntity = new ProductoEntity(1L, "Inca Kola", "Gaseosa", 2.8, 1, categoria, proveedor);

        Mockito.when(productoJpaRepository.existsById(producto.getId())).thenReturn(true);
        Mockito.when(productoJpaRepository.save(Mockito.any(ProductoEntity.class))).thenReturn(productoEntity);

        Optional<Producto> responseProducto = productoJpaRepositoryAdapter.update(producto);

        assertNotNull(responseProducto);

        responseProducto.map(rproducto -> {
            assertEquals(producto.getId(), rproducto.getId());
            assertEquals(producto.getCategoria().getId(), rproducto.getCategoria().getId());
            assertEquals(producto.getProveedor().getId(), rproducto.getProveedor().getId());
            return true;
        });

    }

    @Test
    void updateNull() {

        Producto producto = new Producto();

        Mockito.when(productoJpaRepository.existsById(producto.getId())).thenReturn(false);

        Optional<Producto> responseProducto = productoJpaRepositoryAdapter.update(producto);

        assertTrue(responseProducto.isEmpty());

    }

    @Test
    void deletebyIdExitoso() {

        Long id = 1L;

        Mockito.when(productoJpaRepository.existsById(id)).thenReturn(true);

        Boolean producto = productoJpaRepositoryAdapter.deletebyId(id);

        assertTrue(producto);
    }

    @Test
    void deletebyIdFalse() {

        Long id = 1L;

        Mockito.when(productoJpaRepository.existsById(id)).thenReturn(false);

        Boolean producto = productoJpaRepositoryAdapter.deletebyId(id);

        assertFalse(producto);
    }
}