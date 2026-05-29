package com.merkoventa.productosApi.dto;

public class CarritoDto {

    private Long idProducto;
    private int cantidadProducto;

    public CarritoDto() {
    }

    public CarritoDto(Long idProducto, int cantidadProducto) {
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
}
