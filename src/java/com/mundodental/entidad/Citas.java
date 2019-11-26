
package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


import java.sql.Date;

@Entity(table = "Citas")
public class Citas {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idCita")
    private int idCita;
    @NotNull
    private Date fecha;
    @NotNull
    private int expediente;
    @NotNull
    private int idLocal;
    @NotNull
    private String estado;
    @NotNull
    private int idEmpleadoDoctor;

    public Citas() {
    }

    public Citas(int idCita, Date fecha, int expediente, int idLocal, String estado, int idEmpleadoDoctor) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.expediente = expediente;
        this.idLocal = idLocal;
        this.estado = estado;
        this.idEmpleadoDoctor = idEmpleadoDoctor;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEmpleadoDoctor() {
        return idEmpleadoDoctor;
    }

    public void setIdEmpleadoDoctor(int idEmpleadoDoctor) {
        this.idEmpleadoDoctor = idEmpleadoDoctor;
    }    
}