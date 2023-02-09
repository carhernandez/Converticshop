package com.Converticshop.Converticshop.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @ManyToOne
    @JoinColumn(name = "tipo_documento" )
    TipoDocumento tipoDocumento;
    @Transient
    private int numeroTipoDocumento;
    @Column(name = "n_documento")
    private Integer nDocumento;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "contrasena")
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String correoElectronico, TipoDocumento tipoDocumento, Integer nDocumento,
                    String nombres, String apellidos, String contrasena, List<Productos> productos) {
        this.correoElectronico = correoElectronico;
        this.tipoDocumento = tipoDocumento;
        this.nDocumento = nDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrasena = contrasena;

    }

    public int getNumeroTipoDocumento() {
        return numeroTipoDocumento;
    }

    public void setNumeroTipoDocumento(int numeroTipoDocumento) {
        this.numeroTipoDocumento = numeroTipoDocumento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getnDocumento() {
        return nDocumento;
    }

    public void setnDocumento(Integer nDocumento) {
        this.nDocumento = nDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "idUsuario=" + idUsuario +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", nDocumento=" + nDocumento +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }




}
