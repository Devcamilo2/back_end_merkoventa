package com.merkoventa.productosApi.service;

import com.merkoventa.productosApi.model.Carrito;

import java.util.List;
import java.util.Optional;

public interface CarritoService {

    public Optional<Carrito> findById(Long id);
    public List<Carrito> findAll();
    public Carrito save(Carrito carrito);
    public boolean existsById(Long id);
    public void deleteById(Long id);
}
