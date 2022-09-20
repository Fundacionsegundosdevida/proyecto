/********************************************
 ******************PROYECTO*******************
 *******************************************/

package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuario where username = '" + username
                + "' and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String diagnostico = rs.getString("diagnostico");
                String correo = rs.getString("correo");
                boolean prioritario = rs.getBoolean("prioritario");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                double cuota_mantenimiento= rs.getDouble("cuota_mantenimiento");
                

                Usuario usuario
                        = new Usuario(username, contrasena, nombre, apellido,edad, diagnostico, correo,prioritario ,telefono,direccion,cuota_mantenimiento);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    // --------------controlador de registro 
        @Override
    public String register(String username, String contrasena,String nombre, String apellido, int edad, String diagnostico ,String correo, boolean prioritario,String telefono,String direccion, double cuota_mantenimiento) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + username + "', '" + contrasena + "', '" + nombre
                + "', '" + apellido + "', '" + edad + "', " + diagnostico + ", " + correo + "," + prioritario+ "," + telefono + "," + direccion + "," + cuota_mantenimiento+ " )";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, contrasena, nombre, apellido, edad, diagnostico,correo,prioritario,telefono,direccion ,cuota_mantenimiento);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

   
}
