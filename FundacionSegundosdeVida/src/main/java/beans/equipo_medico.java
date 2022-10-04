
package beans;

public class equipo_medico {
    private int id;
    private String nombre_equipo;
    private String tipo_equipo;
    private String marca_equipo;
    private int cantidad_equipo;
    private boolean novedad;

    public equipo_medico(int id, String nombre_equipo, String tipo_equipo, String marca_equipo, int cantidad_equipo, boolean novedad) {
        this.id = id;
        this.nombre_equipo = nombre_equipo;
        this.tipo_equipo = tipo_equipo;
        this.marca_equipo = marca_equipo;
        this.cantidad_equipo = cantidad_equipo;
        this.novedad = novedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnombre_equipo() {
        return nombre_equipo;
    }

    public void setnombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String gettipo_equipo() {
        return tipo_equipo;
    }

    public void settipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }

    public String getmarca_equipo() {
        return marca_equipo;
    }

    public void setmarca_equipo(String marca_equipo) {
        this.marca_equipo = marca_equipo;
    }

    public int getcantidad_equipo() {
        return cantidad_equipo;
    }

    public void setcantidad_equipo(int cantidad_equipo) {
        this.cantidad_equipo = cantidad_equipo;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "equipo_medico{" + "id=" + id + ", nombre_equipo=" + nombre_equipo + ", tipo_equipo=" + tipo_equipo + ", marca_equipo=" + marca_equipo + ", cantidad_equipo=" + cantidad_equipo + ", novedad=" + novedad + '}';
    }
    
    
}
