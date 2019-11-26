
package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


@Entity(table = "Especialidades")
public class Especialidades {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idEspecialidad")
    private int idEspecialidad;
    @NotNull
    private String especialidad;
    
    public Especialidades(){
    }

    public Especialidades(int idEspecialidad, String especialidad) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
