package co.edu.uniquindio.poo.logistica2.model;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    private String id;
    private String nombre;
    private int habitantes;


    public Ciudad(String id, String nombre, int habitantes) {
        this.id = id;
        this.nombre = nombre;
        this.habitantes = habitantes;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
}


