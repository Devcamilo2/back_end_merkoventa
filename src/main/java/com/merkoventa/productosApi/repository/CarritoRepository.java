package com.merkoventa.productosApi.repository;

import com.merkoventa.productosApi.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository  extends JpaRepository<Carrito, Long> {
}
