/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
  ****************PROYECTO ***************************
 */
public class Usuario {
     //Atributos de la tabla en la BD USUARIO
    private String username;
    private String contrasena;
    private String nombre;
    private String apellido;
    private int edad;
    private String diagnostico;
    private String correo;
    private boolean prioritario; // es relativo a premiun, revisar la bd el tipo de dato
    private String telefono;
    private String direccion;
    private Double cuota_mantenimiento;
//--------constructor --
    public Usuario(String username, String contrasena, String nombre, String apellido, int edad, String diagnostico, String correo, boolean prioritario, String telefono, String direccion, Double cuota_mantenimiento) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.diagnostico = diagnostico;
        this.correo = correo;
        this.prioritario = prioritario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuota_mantenimiento = cuota_mantenimiento;
    }
//---------------getters y setters 
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getCuota_mantenimiento() {
        return cuota_mantenimiento;
    }

    public void setCuota_mantenimiento(Double cuota_mantenimiento) {
        this.cuota_mantenimiento = cuota_mantenimiento;
    }
// tostrings()
    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", diagnostico=" + diagnostico + ", correo=" + correo + ", prioritario=" + prioritario + ", telefono=" + telefono + ", direccion=" + direccion + ", cuota_mantenimiento=" + cuota_mantenimiento + '}';
    }
    
    

    
    
    
}
