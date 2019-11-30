package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;

@Entity(table = "Productos")
public class Productos {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idProducto")
    private int idProducto;
    @NotNull
    private String nombre;
    @NotNull
    private String detalleProducto;
    @NotNull
    private int idCategoria;
    
    public Productos(){
    }
    public Productos(String nombre,String detalleProducto,int idCategoria){
        ///this.idProducto=idProducto;
        this.nombre=nombre;
        this.detalleProducto=detalleProducto;
        this.idCategoria=idCategoria;
    }
    public int getIdProducto(){
        return idProducto;
    }
    public void setIdProducto(int idProducto){
        this.idProducto=idProducto;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getDetalleProducto(){
        return detalleProducto;
    }
    public void setDetalleProducto(String detalleProducto){
        this.detalleProducto=detalleProducto;
    }
    public int getIdCategoria(){
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria){
        this.idCategoria=idCategoria;
    }
    
    
}
