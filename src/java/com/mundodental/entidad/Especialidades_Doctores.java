
package com.mundodental.entidad;

import com.mundodental.anotaciones.AutoIncrement;
import com.mundodental.anotaciones.Entity;
import com.mundodental.anotaciones.FieldName;
import com.mundodental.anotaciones.NotNull;
import com.mundodental.anotaciones.PrimaryKey;


@Entity(table = "Especialidades_Doctores")
public class Especialidades_Doctores {
    @PrimaryKey
    @NotNull
    private int idEspecialidad;
    @PrimaryKey
    @NotNull
    private int idEmpleadoDoctor;
    
    public Especialidades_Doctores(){
    }

    public Especialidades_Doctores(int idEspecialidad, int idEmpleadoDoctor) {
        this.idEspecialidad = idEspecialidad;
        this.idEmpleadoDoctor = idEmpleadoDoctor;
    }
    

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdEmpleadoDoctor() {
        return idEmpleadoDoctor;
    }

    public void setIdEmpleadoDoctor(int idEmpleadoDoctor) {
        this.idEmpleadoDoctor = idEmpleadoDoctor;
    }
}
