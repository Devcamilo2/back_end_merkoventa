package com.merkoventa.productosApi.service;

import com.merkoventa.productosApi.model.Carrito;
import com.merkoventa.productosApi.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    CarritoRepository carritoRepository;

    @Override
    public Optional<Carrito> findById(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    private double calcularSubTotal (double precioProducto , int cantidadProducto){
        double subtotalCarrito = cantidadProducto * precioProducto;
        return subtotalCarrito;
    }

    @Override
    public Carrito save(Carrito carrito) {
        carrito.setSubtotalCarrito(calcularSubTotal(carrito.getPrecioProducto(), carrito.getCantidadProducto()));
        return carritoRepository.save(carrito);
    }

    @Override
    public boolean existsById(Long id) {
        return carritoRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        carritoRepository.deleteById(id);
    }
}
