
package beans;

public class Usuario {
    private String username;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String email;
    private Double cuota_mantenimiento;
    private boolean prioritario;

    public Usuario(String username, String contrasena, String nombre, String apellidos, String email, Double cuota_mantenimiento, boolean prioritario) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.cuota_mantenimiento = cuota_mantenimiento;
        this.prioritario = prioritario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getcuota_mantenimiento() {
        return cuota_mantenimiento;
    }

    public void setcuota_mantenimiento(Double cuota_mantenimiento) {
        this.cuota_mantenimiento = cuota_mantenimiento;
    }

    public boolean isprioritario() {
        return prioritario;
    }

    public void setprioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", cuota_mantenimiento=" + cuota_mantenimiento + ", prioritario=" + prioritario + '}';
    }
    
    
}
