
package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;

import java.sql.Date;
import java.sql.Time;
import java.math.BigDecimal;

@Entity(table = "Consultas")
public class Consultas{
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idConsulta")
    private int idConsulta;
    @NotNull
    private Date fecha;
    @NotNull
    private Time horaIngreso;
    @NotNull
    private Time horaFinalizacionConsulta;
    @NotNull
    private String tipoConsulta;
    @NotNull
    private BigDecimal costo;
    @NotNull
    private int expediente;
    @NotNull
    private int idLocal;
    @NotNull
    private BigDecimal descuento;
    @NotNull
    private BigDecimal total;
    @NotNull
    private int idEmpleadoDoctor;

    public Consultas(){
    }

    public Consultas(int idConsulta, Date fecha, Time horaIngreso, Time horaFinalizacionConsulta, String tipoConsulta, BigDecimal costo, int expediente, int idLocal, BigDecimal descuento, BigDecimal total, int idEmpleadoDoctor){
        this.idConsulta = idConsulta;
        this.fecha = fecha;
        this.horaIngreso = horaIngreso;
        this.horaFinalizacionConsulta = horaFinalizacionConsulta;
        this.tipoConsulta = tipoConsulta;
        this.costo = costo;
        this.expediente = expediente;
        this.idLocal = idLocal;
        this.descuento = descuento;
        this.total = total;
        this.idEmpleadoDoctor = idEmpleadoDoctor;
        
    }

    public int getIdConsulta(){
        return this.idConsulta;
    }

    public void setIdConsulta(int idConsulta){
        this.idConsulta = idConsulta;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public Time getHoraIngreso(){
        return this.horaIngreso;
    }

    public void setHoraIngreso(Time horaIngreso){
        this.horaIngreso = horaIngreso;
    }
    
    public Time getHoraFinalizacionConsulta(){
        return this.horaFinalizacionConsulta;
    }

    public void setHoraFinalizacionConsulta(Time horaFinalizacionConsulta){
        this.horaFinalizacionConsulta = horaFinalizacionConsulta;
    }
    
    public String getTipoConsulta(){
        return this.tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta){
        this.tipoConsulta = tipoConsulta;
    }
    
    public BigDecimal getCosto(){
        return this.costo;
    }

    public void setCosto(BigDecimal costo){
        this.costo = costo;
    }
     
    
    public int getExpediente(){
        return this.expediente;
    }

    public void setExpediente(int expediente){
        this.expediente = expediente;
    }

    public int getIdLocal(){
        return this.idLocal;
    }

    public void setIdLocal(int idLocal){
        this.idLocal = idLocal;
    }

    public BigDecimal getDescuento(){
        return this.descuento;
    }

    public void setDescuento(BigDecimal descuento){
        this.descuento = descuento;
    }
    
    public BigDecimal getTotal(){
        return this.total;
    }

    public void setTotal(BigDecimal total){
        this.total = total;
    }
    
    public int getIdEmpleadoDoctor(){
        return this.idEmpleadoDoctor;
    }

    public void setIdEmpleadoDoctor(int idEmpleadoDoctor){
        this.idEmpleadoDoctor = idEmpleadoDoctor;
    }
}