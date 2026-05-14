package com.merkoventa.productosApi.service;

import com.merkoventa.productosApi.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Usuario save(Usuario usuario);

    public String login(String usu, String ctr);

    public Optional<Usuario> findById(Long id);

    public List<Usuario> findAll();

    public boolean existsById(Long id);

    public void deleteById(Long id);
}
