package com.Converticshop.Converticshop.Services;

import com.Converticshop.Converticshop.Model.Usuario;
import com.Converticshop.Converticshop.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    /*public List<Usuarios> getUsuario() {
        return usuarioRepository.findAll();
    }

    public void delete(Usuarios usuario) {
        usuarioRepository.delete(usuario);
    }

    public Optional<Usuarios> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }*/

        /*String correoElectronico;
        Integer tipoDocumento;
        Integer nDocumento;
        String nombres;
        String apellidos;
        String contrasena;*/


    // obtener todos los usuarios
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    // crear usuario rest api

    public ResponseEntity<Usuario> createUsuario(Usuario usuarios) {
        return new ResponseEntity<>(usuarioRepository.save(usuarios), HttpStatus.OK);
    }

    // obtener usuario por id rest api
    public ResponseEntity<Usuario> getUsuariosById(Integer idUsuarios) {
        Usuario usuarios = usuarioRepository.findByIdUsuario(idUsuarios)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios no existe con esa id :" +
                        idUsuarios));
        return ResponseEntity.ok(usuarios);
    }

    // actualizar usuarios rest api
    public ResponseEntity<Usuario> updateUsuarios(int idUsuarios, Usuario usuarios1) {
        Usuario usuarios = usuarioRepository.findByIdUsuario(idUsuarios)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios no existe con esa id :" + idUsuarios));


        usuarios.setCorreoElectronico(usuarios1.getCorreoElectronico());
        usuarios.setTipoDocumento(usuarios1.getTipoDocumento());
        usuarios.setnDocumento(usuarios1.getnDocumento());
        usuarios.setNombres(usuarios1.getNombres());
        usuarios.setApellidos(usuarios1.getApellidos());
        usuarios.setContrasena(usuarios1.getContrasena());

        Usuario updateUsuarios = usuarioRepository.save(usuarios);
        return ResponseEntity.ok(updateUsuarios);
    }

    // borrar usuario rest api
    public ResponseEntity<Map<String, Boolean>> deleteUsuario(int idUsuarios) {
        Usuario usuarios = usuarioRepository.findByIdUsuario(idUsuarios)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios no existe con esa id :" + idUsuarios));

        usuarioRepository.delete(usuarios);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<Usuario>> getIdUsuarioAndPassword(int idUsuarios, String contrasena) {
        List<Usuario> usuarios = usuarioRepository.findByIdUsuarioAndContrasena(idUsuarios, contrasena)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios no existe con esa id :" +
                        idUsuarios));
        return ResponseEntity.ok(usuarios);
    }

    public ResponseEntity<List<Usuario>> getUsuarioOrNombres(int idUsuarios, String nombres) {
        List<Usuario> usuarios = usuarioRepository.findByIdUsuarioOrNombres(idUsuarios, nombres)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios no existe con esa id :" +
                        idUsuarios));
        return ResponseEntity.ok(usuarios);
    }

    /*public ResponseEntity<List<Usuarios>> getCorreoElectronicoAndContrasena(String correoElectronico,
                                                                            String contrasena) {
        List<Usuarios> usuarios = (List<Usuarios>) usuarioRepository.findByCorreoElectronicoAndContrasena(correoElectronico,
                        contrasena)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con ese  :" +
                        correoElectronico));
        return ResponseEntity.ok(usuarios);

    }*/

   /* public ResponseEntity<List<Usuarios>> getCorreoElectronicoAndContrasena(String correoElectronico, String contrasena) {
        List<Usuarios> usuarios = (List<Usuarios>) usuarioRepository.findByCorreoElectronicoAndContrasena(correoElectronico,
                        contrasena)
                .orElseThrow(() -> new ResourceNotFoundException("Usuarios no existe con ese  :" +
                        correoElectronico));
        return ResponseEntity.ok(usuarios);
    }*/



}
