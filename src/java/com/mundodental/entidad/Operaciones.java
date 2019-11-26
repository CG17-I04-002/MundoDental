
package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;

import java.sql.Date;

@Entity(table = "Operaciones")
public class Operaciones {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idOperaciones")
    private int idOperacion;
    @NotNull
    private String transaccion;
    @NotNull
    private Date fecha;
    @NotNull
    private int idLocal;
    @NotNull
    private double monto;
    public Operaciones(){}
    
    public Operaciones(int idOperacion, String transaccion,Date fecha,int idLocal,double monto){
        this.idOperacion=idOperacion;
        this.transaccion=transaccion;
        this.fecha=fecha;
        this.idLocal=idLocal;
        this.monto=monto;
    }
    
    public int getIdOperacion(){
        return idOperacion;
    }
    public void setIdOperacion(int idOperacion){
        this.idOperacion=idOperacion;
    }
    public String getTransaccion(){
        return transaccion;
    }
    public void setTransaccion(String transaccion){
        this.transaccion=transaccion;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    public int getIdLocal(){
        return idLocal;
    }
    public void setIdLocal(int idLocal){
        this.idLocal=idLocal;
    }
    public double getMonto(){
        return monto;
    }
    public void setMonto(double monto){
        this.monto=monto;
    }
}
