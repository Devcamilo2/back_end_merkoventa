package com.merkoventa.productosApi.service;

import com.merkoventa.productosApi.model.Producto;
import com.merkoventa.productosApi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> findAll(Long id) {
        return productoRepository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public boolean existsById(Long id) {
        return productoRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
