package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;

@Entity(table = "Locales")
public class Locales {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idLocal")
    private int idLocal;
    @NotNull
    private String local;
    
    public Locales(){
    }
    public Locales(int idLocal, String local){
        this.idLocal=idLocal;
        this.local=local;
    }
    public int getIdLocal(){
        return idLocal;
    }
    public void setIdLocal(int idLocal){
        this.idLocal=idLocal;
    }
    public String getLocal(){
        return local;
    }
    public void setLocal(String local){
        this.local=local;
    }
}
