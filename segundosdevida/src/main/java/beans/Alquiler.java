/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Date; //libreria para usar fechas

/**
 *
 * @author Usuario
 */
public class Alquiler {
     //atributos de la tabla alquiler en la BD 
    private int id_equipo;
    private String username;
    private Date fecha;
    //datos dicionales no estan en la tabla pero la necesitamos para mostrar esos datos
    private boolean novedad;
    private String genero;
    
//----------Constrcutor
    public Alquiler(int id_equipo, String username, Date fecha, boolean novedad, String genero) {
        this.id_equipo = id_equipo;
        this.username = username;
        this.fecha = fecha;
        this.novedad = novedad;
        this.genero = genero;
    }
//-------------getters y setters 
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

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
// -----------toStrings()
    @Override
    public String toString() {
        return "Alquiler{" + "id_equipo=" + id_equipo + ", username=" + username + ", fecha=" + fecha + ", novedad=" + novedad + ", genero=" + genero + '}';
    }   
    
}
