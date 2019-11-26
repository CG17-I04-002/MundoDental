package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


@Entity(table = "Usuario")
public class Usuario {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "usuario")
    private String usuario;
    @NotNull
    private String contrasena;
    @NotNull
    private int idRol;

    

    public Usuario() {
    }

    public Usuario(String usuario, String contrasena, int idRol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.idRol = idRol;
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

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    
}
