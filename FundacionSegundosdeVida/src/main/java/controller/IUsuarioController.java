package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String nombre, String apellidos, String email, double cuota_mantenimiento, boolean prioritario);

    public String pedir(String username);

    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos, String nuevoEmail,
            double nuevocuota_mantenimiento, boolean nuevoprioritario);

    public String vercantidad_equipo(String username);

    public String devolverequipo_medicos(String username, Map<Integer, Integer> cantidad_equipo);

    public String eliminar(String username);

    public String restarDinero(String username, double nuevocuota_mantenimiento);

}
