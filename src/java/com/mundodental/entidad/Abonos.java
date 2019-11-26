package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


import java.sql.Date;

@Entity(table = "Abonos")
public class Abonos {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idAbono")
    private int idAbono;
    @NotNull
    private Date fecha;
    @NotNull
    private double monto;
    @NotNull
    private int idFactura;

    public Abonos(){
    }

    public Abonos(int idAbono, Date fecha, double monto){
        this.idAbono = idAbono;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getIdAbono() {
        return idAbono;
    }

    public void setIdAbono(int idAbono) {
        this.idAbono = idAbono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    
}
    
    

    
