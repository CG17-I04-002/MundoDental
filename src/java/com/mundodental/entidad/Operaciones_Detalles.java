
package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;

@Entity(table = "Operaciones_Detalles")
public class Operaciones_Detalles {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idOperaciones")
    private int idOperacion;
    @NotNull
    private int idProducto;
    @NotNull
    private double costoCompra;
    @NotNull
    private int cantidad;
    @NotNull
    private double precioVenta;
    
    public Operaciones_Detalles(){
    }
    public Operaciones_Detalles(int idOperacion,int idProducto,double costoCompra,int cantidad,double precioVenta){
        this.idOperacion=idOperacion;
        this.idProducto=idProducto;
        this.costoCompra=costoCompra;
        this.cantidad=cantidad;
        this.precioVenta=precioVenta;
    }
    public int getIdOperacion(){
        return idOperacion;
    }
    public void setIdOperacion(int idOperacion){
        this.idOperacion=idOperacion;
    }
    public int getIdProductos(){
        return idProducto;
    }
    public void setIdProducto(int idProducto){
        this.idProducto=idProducto;
    }
    public double getCostoCompra(){
        return costoCompra;
    }
    public void setCostoCompra(double costoCompra){
        this.costoCompra=costoCompra;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public double getPrecioVenta(){
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta){
        this.precioVenta=precioVenta;
    }
    
}
