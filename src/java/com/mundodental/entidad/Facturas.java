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
    private String tipoPago ;
    @NotNull
    private String estado ;
    @NotNull
    private BigDecimal total;
    @NotNull
    private int expediente;
    private int idOperacion;
    private int idConsulta;

    public Facturas(){}

    public Facturas(int idFactura, String tipoPago, String estado, BigDecimal total, int expediente, int idOperacion, int idConsulta){
        this.idFactura = idFactura;
        this.tipoPago = tipoPago;
        this.estado = estado;
        this.total = total;
        this.expediente = expediente;
        this.idOperacion = idOperacion;
        this.idConsulta = idConsulta;        
    }
     
    public int getIdFactura(){
        return this.idFactura;
    }

    public void setIdFactura(int idFactura){
        this.idFactura = idFactura;
    }

    public String getTipoPago(){
        return this.tipoPago;
    }

    public void setTipoPago(String tipoPago){
        this.tipoPago = tipoPago;
    }

    public String getEstado(){
        return this.estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public BigDecimal getTotal(){
        return this.total;
    }

    public void setTotal(BigDecimal total){
        this.total = total;
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
    public int getIdConsulta(){
        return this.idConsulta;
    }

    public void setIdConsulta(int idConsulta){
        this.idConsulta = idConsulta;
    }
}