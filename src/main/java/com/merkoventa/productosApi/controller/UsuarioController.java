package com.merkoventa.productosApi.controller;

import com.merkoventa.productosApi.model.Usuario;
import com.merkoventa.productosApi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario guardarUsuario (@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody Usuario usuario){
        String mensaje = usuarioService.login(usuario.getNombreUsuario(),usuario.getUsuarioContrasena());
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId (@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @GetMapping("/listarusuarios")
    public List<Usuario> listar (){
        return usuarioService.findAll();
    }

    @PutMapping("/actualizarusuario/{id}")
    public Usuario actualizar (@Valid @PathVariable Long id,
                               @RequestBody Usuario usuario){
        Usuario usuarioExistente = usuarioService.findById(id).orElse(null);
        if (usuarioExistente != null){
            usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExistente.setApellidoUsuario(usuario.getApellidoUsuario());
            usuarioExistente.setUsuarioContrasena(usuario.getUsuarioContrasena());
            usuarioExistente.setEdadUsuario(usuario.getEdadUsuario());

            return usuarioService.save (usuarioExistente);
        }
        return  null;
    }
    @DeleteMapping ("/{id}")
    public void eliminar (@PathVariable Long id){
        if(!usuarioService.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioService.deleteById(id);
    }
}