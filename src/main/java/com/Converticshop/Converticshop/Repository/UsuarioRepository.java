package com.Converticshop.Converticshop.Repository;

import com.Converticshop.Converticshop.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByIdUsuario(int idUsuario);

    Optional <List<Usuario>> findByIdUsuarioAndContrasena(int idUsuario, String contrasena );

    Optional <List<Usuario>> findByIdUsuarioOrNombres(int idUsuario,String nombres );


    /*Optional<Usuarios>  findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena);*/

}
