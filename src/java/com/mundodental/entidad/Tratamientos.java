package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


@Entity(table = "Tratamientos")
public class Tratamientos {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idTratamiento")
    private int idTratamiento;
    @NotNull
    private String descripcion;

    public Tratamientos(){
    }
    public Tratamientos(int idTratamiento, String descripcion){
        this.idTratamiento = idTratamiento;
        this.descripcion = descripcion;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}