package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;
import java.math.BigDecimal;
import java.sql.Date;

@Entity(table = "Membresias")
public class Membresias {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idMembresia")
    private int idMembresia;
    @NotNull
    private Date fechaRegistro;
    @NotNull
    private Date fechaVencimiento;
    @NotNull
    private BigDecimal monto;
    @NotNull
    private int expediente;
    
    private BigDecimal porcentaje;

    public Membresias() {
    }

    public Membresias(Date fechaRegistro, Date fechaVencimiento, BigDecimal monto, int expediente, BigDecimal porcentaje) {
        this.fechaRegistro = fechaRegistro;
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.expediente = expediente;
        this.porcentaje = porcentaje;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    /*public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }*/

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }
    
    
    
    
}
