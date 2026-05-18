package com.merkoventa.productosApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrito")
    private Long id;

    @Column(name = "nombreProducto")
    @NotBlank(message = "El producto debe tener nombre")
    private String nombreProducto;

    @Column(name = "precioProducto")
    @Positive(message = "El precio debe ser mayor a 0")
    private double precioProducto;

    @Column(name = "cantidadProducto")
    @Min(value = 0 , message = "La cantidad del producto debe ser mayor a 0")
    private int cantidadProducto;

    @Column(name = "subtotalCarrito")
    private double subtotalCarrito;

    public Carrito() {
    }

    public Carrito(Long id, String nombreProducto, double precioProducto, int cantidadProducto, double subtotalCarrito) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
        this.subtotalCarrito = subtotalCarrito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getSubtotalCarrito() {
        return subtotalCarrito;
    }

    public void setSubtotalCarrito(double subtotalCarrito) {
        this.subtotalCarrito = subtotalCarrito;
    }
}
