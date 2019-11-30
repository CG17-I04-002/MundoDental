package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;
import java.math.BigDecimal;

import java.sql.Date;

@Entity(table = "Operaciones")
public class operaciones {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idOperacion")
    private int idOperacion;
    @NotNull
    private String transaccion;
    @NotNull
    private Date fecha;
    @NotNull
    private int idLocal;
    @NotNull
    private BigDecimal monto;
    private String flujo;
    public operaciones(){}
    
    public operaciones(int idOperacion, String transaccion,Date fecha,int idLocal,String flujo,BigDecimal monto){
        this.idOperacion=idOperacion;
        this.transaccion=transaccion;
        this.fecha=fecha;
        this.idLocal=idLocal;
        this.flujo=flujo;
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
    public String getFlujo() {
        return flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }
    public BigDecimal getMonto(){
        return monto;
    }
    public void setMonto(BigDecimal monto){
        this.monto=monto;
    }
}