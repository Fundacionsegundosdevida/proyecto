/***********************************
*************PROYECTO***************
 ************************************/
package controller;

import java.util.Map;
//controlador de la interfax de usuario
public interface IUsuarioController {

    public String login(String username, String contrasena);
    //registro de usuario
     public String register(String username, String contrasena, 
            String nombre, String apellido, int edad, String diagnostico ,String correo, boolean prioritario,String telefono,String direccion, double saldo);

}
