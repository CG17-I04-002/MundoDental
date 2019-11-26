package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;

@Entity(table = "Empleados")
public class Empleados {

    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idEmpleado")
    private int idEmpleado;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @NotNull
    private String estado;
    @NotNull
    private String usuario;
    @NotNull
    private int idLocal;
    private String telefono;

    public Empleados() {
    }

    public Empleados(int idEmpleado, String nombres, String apellidos, String estado, String usuario, int idLocal, String telefono) {
        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estado = estado;
        this.usuario = usuario;
        this.idLocal = idLocal;
        this.telefono = telefono;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
