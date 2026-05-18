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
@CrossOrigin(origins = "http://localhost:8081" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario guardarUsuario (@Valid @RequestBody Usuario usuario){
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

    @GetMapping
    public List<Usuario> listar (){
        return usuarioService.findAll();
    }

    @PutMapping("/{id}")
    public Usuario actualizar (@PathVariable Long id,
                               @Valid @RequestBody Usuario usuario){
        Usuario usuarioExistente = usuarioService.findById(id).orElse(null);
        if (usuarioExistente != null){
            usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExistente.setApellidoUsuario(usuario.getApellidoUsuario());
            usuarioExistente.setUsuarioContrasena(usuario.getUsuarioContrasena());
            usuarioExistente.setEdadUsuario(usuario.getEdadUsuario());

            return usuarioService.save (usuarioExistente);
        }
        throw new RuntimeException("Usuario no encontrado");
    }
    @DeleteMapping ("/{id}")
    public void eliminar (@PathVariable Long id){
        if(!usuarioService.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioService.deleteById(id);
    }
}