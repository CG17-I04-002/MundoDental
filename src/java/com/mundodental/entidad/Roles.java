
package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


@Entity(table = "Roles")
public class Roles {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idRol")
    private int idRol;
    @NotNull
    private String rol;

    public Roles( String rol) {
        ///this.idRol = idRol;
        this.rol = rol;
    }

    public Roles() {
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
