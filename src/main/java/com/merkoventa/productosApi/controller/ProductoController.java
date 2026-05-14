package com.merkoventa.productosApi.controller;

import com.merkoventa.productosApi.model.Producto;
import com.merkoventa.productosApi.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins="http://localhost:8081", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/{id}")
    public Optional<Producto> buscarPorId(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @GetMapping("/listarproductos")
    public List<Producto> listar() {
        return productoService.findAll();
    }

    @PostMapping()
    public Producto crear(@Valid @RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/actualizarproducto/{id}")
    public Producto actualizar(@Valid @PathVariable Long id,
                               @RequestBody Producto producto) {
        Producto productoExistente = productoService.findById(id).orElse(null);
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setCodigo(producto.getCodigo());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());
            productoExistente.setDisponible(producto.isDisponible());

            return productoService.save(productoExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        if (!productoService.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        productoService.deleteById(id);
    }
}

