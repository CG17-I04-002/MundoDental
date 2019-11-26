package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;

@Entity(table = "Membresias_Beneficiarios")
public class Membresias_Beneficiarios {
    @PrimaryKey
    @NotNull
    private int idMembresia;
    @PrimaryKey
    @NotNull
    private int expediente;

    public Membresias_Beneficiarios() {
        
    }

    public Membresias_Beneficiarios(int idMembresia, int expediente) {
        this.idMembresia = idMembresia;
        this.expediente = expediente;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }
    
    
    
    
}
