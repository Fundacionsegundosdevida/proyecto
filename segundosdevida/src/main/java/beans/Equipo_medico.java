/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Usuario
 */
public class Equipo_medico {
    //atributos de la tabla Equipos medico en la bd
    private int id_equipo;
    private String nombre_equipo;
    private String tipo_equipo; //los nombres deben ser tal cual los atributos de la base de datos
    private String marca_equipo;
    private int cantidad_equipo;
    private boolean observacion_equipo;
    
    //------CONSTRUCTOR--------------------------------------
    
    

    public Equipo_medico(int id_equipo, String nombre_equipo, String tipo_equipo, String marca_equipo, int cantidad_equipo, boolean observacion_equipo) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
        this.tipo_equipo = tipo_equipo;
        this.marca_equipo = marca_equipo;
        this.cantidad_equipo = cantidad_equipo;
        this.observacion_equipo = observacion_equipo;
    }
        
    
    //--------GET Y SET-----------------------------------

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getTipo_equipo() {
        return tipo_equipo;
    }

    public void setTipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }

    public String getMarca_equipo() {
        return marca_equipo;
    }

    public void setMarca_equipo(String marca_equipo) {
        this.marca_equipo = marca_equipo;
    }

    public int getCantidad_equipo() {
        return cantidad_equipo;
    }

    public void setCantidad_equipo(int cantidad_equipo) {
        this.cantidad_equipo = cantidad_equipo;
    }

    public boolean isObservacion_equipo() {
        return observacion_equipo;
    }

    public void setObservacion_equipo(boolean observacion_equipo) {
        this.observacion_equipo = observacion_equipo;
    }
    //------------TO STRING()--------------------------------

    @Override
    public String toString() {
        return "Equipo_medico{" + "id_equipo=" + id_equipo + ", nombre_equipo=" + nombre_equipo + ", tipo_equipo=" + tipo_equipo + ", marca_equipo=" + marca_equipo + ", cantidad_equipo=" + cantidad_equipo + ", observacion_equipo=" + observacion_equipo + '}';
    }
    
    
}
