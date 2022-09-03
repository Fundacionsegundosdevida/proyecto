/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Date; //libreria para usar fechas

/**
 *
 * **********************PROYECTO*****************************************
 */
public class Alquiler {
     //atributos de la tabla alquiler en la BD 
    private int id_equipo;
    private String username;
    private Date fecha;
    //datos dicionales no estan en la tabla pero la necesitamos para mostrar esos datos
    private boolean observacion_equipo;
    private String tipo_equipo; // ES EL QUIVALENTE A GENERO 
    
    
// -------CONSTRUCTOR ---
    public Alquiler(int id_equipo, String username, Date fecha, boolean observacion_equipo, String tipo_equipo) {
        this.id_equipo = id_equipo;
        this.username = username;
        this.fecha = fecha;
        this.observacion_equipo = observacion_equipo;
        this.tipo_equipo = tipo_equipo;
    }
//---GETTER Y SEETERS
    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isObservacion_equipo() {
        return observacion_equipo;
    }

    public void setObservacion_equipo(boolean observacion_equipo) {
        this.observacion_equipo = observacion_equipo;
    }

    public String getTipo_equipo() {
        return tipo_equipo;
    }

    public void setTipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }
 // ----------tStrings---------------
    @Override
    public String toString() {
        return "Alquiler{" + "id_equipo=" + id_equipo + ", username=" + username + ", fecha=" + fecha + ", observacion_equipo=" + observacion_equipo + ", tipo_equipo=" + tipo_equipo + '}';
    }   
    
    
}
