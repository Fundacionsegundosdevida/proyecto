
package beans;

import java.sql.Date;

public class Alquiler {
    private int id;
    private String username;
    private Date fecha;
    private boolean novedad;
    private String tipo_equipo;

    public Alquiler(int id, String username, Date fecha, boolean novedad, String tipo_equipo) {
        this.id = id;
        this.username = username;
        this.fecha = fecha;
        this.novedad = novedad;
        this.tipo_equipo = tipo_equipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String gettipo_equipo() {
        return tipo_equipo;
    }

    public void settipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", username=" + username + ", fecha=" + fecha + ", novedad=" + novedad + ", tipo_equipo=" + tipo_equipo + '}';
    }
    
}
