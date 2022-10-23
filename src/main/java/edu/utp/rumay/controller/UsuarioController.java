package edu.utp.rumay.controller;

import edu.utp.rumay.enums.RolDeUsuario;
import edu.utp.rumay.model.Usuario;
import edu.utp.rumay.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //CRUD methods
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario( Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> buscarTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> buscarUsuariosPorRol(RolDeUsuario rol) {
        return usuarioRepository.findByRol(rol);
    }
}
