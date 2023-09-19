package com.practica1.infraestructure.controller;

import com.practica1.application.service.ProductoService;
import com.practica1.domain.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping()
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Producto>> getProductos(){
        return productoService.obtenerProductos().map(productos -> new ResponseEntity<>(productos, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findProductoById(@PathVariable Long id){
        return productoService.encontrarProductoPorId(id).map(producto -> new ResponseEntity<>(producto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
        return productoService.actualizarProducto(producto).map(producto1 -> new ResponseEntity<>(producto1, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProductoById(@PathVariable Long id){
        if (productoService.eliminarProductoPorId(id)){
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
    }

}
