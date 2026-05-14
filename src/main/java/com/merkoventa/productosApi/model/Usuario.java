package com.merkoventa.productosApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long id;

    @Column(name = "nombreUsuario")
    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String nombreUsuario;

    @Column(name = "apellidoUsuario")
    @NotBlank(message = "El apellido de usuario es obligatorio")
    private String apellidoUsuario;

    @Column(name = "contrasenaUsuario")
    @NotBlank(message = "La contraseña de usuario es obligatoria")
    private String usuarioContrasena;

    @Column(name = "edadUsuario")
    @NotNull(message = "La edad es obligatoria")
    @Min(value = 1, message = "La edad debe ser mayor a 0")
    private Integer edadUsuario;

    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String apellidoUsuario, String usuarioContrasena, Integer edadUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.usuarioContrasena = usuarioContrasena;
        this.edadUsuario = edadUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getUsuarioContrasena() {
        return usuarioContrasena;
    }

    public void setUsuarioContrasena(String usuarioContrasena) {
        this.usuarioContrasena = usuarioContrasena;
    }

    public Integer getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(Integer edadUsuario) {
        this.edadUsuario = edadUsuario;
    }
}




