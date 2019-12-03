package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


import java.math.BigDecimal;

@Entity(table = "Facturas")
public class Facturas{
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idFactura")
    private int idFactura;
    @NotNull
    private int expediente;
    private int idOperacion;

    public Facturas(){}

    public Facturas(int idFactura,int expediente, int idOperacion){
        this.idFactura = idFactura;
        
        this.expediente = expediente;
        this.idOperacion = idOperacion;      
    }
     
    public int getIdFactura(){
        return this.idFactura;
    }

    public void setIdFactura(int idFactura){
        this.idFactura = idFactura;
    }

    
    public int getExpediente(){
        return this.expediente;
    }

    public void setExpediente(int expediente){
        this.expediente = expediente;
    }
    
    public int getIdOperacion(){
        return this.idOperacion;
    }

    public void setIdOperacion(int idOperacion){
        this.idOperacion = idOperacion;
    }
    
}