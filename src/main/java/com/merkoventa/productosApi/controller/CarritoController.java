package com.merkoventa.productosApi.controller;

import com.merkoventa.productosApi.model.Carrito;
import com.merkoventa.productosApi.service.CarritoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carritos")
@CrossOrigin(origins = "http://localhost:8081" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CarritoController {

    @Autowired
    CarritoService carritoService;

    @GetMapping("/{id}")
    public Optional <Carrito> buscarPorId (@PathVariable Long id){
        return carritoService.findById(id);
    }

    @GetMapping("/listarcarrito")
    public List<Carrito> listar (){
        return carritoService.findAll();
    }

    @PostMapping("/agregarcarrito")
    public Carrito crear (@Valid @RequestBody Carrito carrito){
        return carritoService.save(carrito);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Long id){
        if (!carritoService.existsById(id)){
            throw new RuntimeException("Item del carrito no encontrado");
        }
        carritoService.deleteById(id);
    }
}
