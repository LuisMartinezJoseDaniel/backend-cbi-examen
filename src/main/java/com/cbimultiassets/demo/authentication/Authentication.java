package com.cbimultiassets.demo.authentication;

import com.cbimultiassets.demo.rol.Rol;
import com.cbimultiassets.demo.users.User;
import jakarta.persistence.*;

@Entity
@Table(name = "Autenticacion")
public class Authentication {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long idAutenticacion;


    @Column(unique = true)
    private String usuario;


    private String contrasena;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id")
    private Rol rol;



    public Authentication() {
    }

    public Authentication(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Authentication(String usuario, String contrasena, User user, Rol rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.user = user;
        this.rol = rol;
    }

    public Long getIdAutenticacion() {
        return idAutenticacion;
    }

    public void setIdAutenticacion(Long idAutenticacion) {
        this.idAutenticacion = idAutenticacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "idAutenticacion=" + idAutenticacion +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", user=" + user +
                ", rol=" + rol +
                '}';
    }
}
