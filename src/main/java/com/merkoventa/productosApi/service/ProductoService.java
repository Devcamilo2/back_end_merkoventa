package com.merkoventa.productosApi.service;

import com.merkoventa.productosApi.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public Optional<Producto> findById(Long id);
    public List<Producto> findAll();

    List<Producto> findAll(Long id);

    public Producto save(Producto producto);
    public boolean existsById(Long id);
    public void deleteById(Long id);
}
