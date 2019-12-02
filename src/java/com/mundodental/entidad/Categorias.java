
package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


@Entity(table = "Categorias")
public class Categorias {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idCategoria")
    private int idCategoria;
    @NotNull
    private String categoria;
    
    public Categorias(){
    }
    public Categorias(String categoria){
       /// this.idCategoria=idCategoria;
        this.categoria=categoria;
    }
     public int getIdCategoria(){
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria){
        this.idCategoria=idCategoria;
    }
     public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria=categoria;
    }
    
}
