package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


@Entity(table = "Consultas_Tratamientos")
public class Consultas_Tratamientos {
    @PrimaryKey
    @NotNull
    private int idConsulta;
    @PrimaryKey
    @NotNull
    private int idTratamiento;

    public Consultas_Tratamientos(){
    }

    public Consultas_Tratamientos(int idConsulta, int idTratamiento){
        this.idConsulta = idConsulta;
        this.idTratamiento = idTratamiento;
    }
    
    public int getIdConsulta(){
        return this.idConsulta;
    }

    public void setIdConsulta(int idConsulta){
        this.idConsulta = idConsulta;
    }
    
    public int getIdTratamiemto(){
        return this.idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento){
        this.idTratamiento = idTratamiento;
    }
    
}