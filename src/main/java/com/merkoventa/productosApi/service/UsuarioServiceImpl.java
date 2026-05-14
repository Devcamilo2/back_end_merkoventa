package com.merkoventa.productosApi.service;

import com.merkoventa.productosApi.model.Usuario;
import com.merkoventa.productosApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public String login(String usu, String ctr) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(usu).orElse(null);

        if (usuario == null) {
            return  "Usuario no encontrado";
        }

        if (!usuario.getUsuarioContrasena().equals(ctr)) {
            return "Contraseña incorrecta";
        }
        return "Inicio exitoso";
    }


    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
