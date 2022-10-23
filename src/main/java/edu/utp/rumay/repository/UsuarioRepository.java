package edu.utp.rumay.repository;

import edu.utp.rumay.enums.RolDeUsuario;
import edu.utp.rumay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByRol(RolDeUsuario rol);

}
