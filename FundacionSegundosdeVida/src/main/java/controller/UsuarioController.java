package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuario;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;

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
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                double cuota_mantenimiento = rs.getDouble("cuota_mantenimiento");
                boolean prioritario = rs.getBoolean("prioritario");
                Usuario usuario = new Usuario(username, contrasena, nombre, apellidos, email, cuota_mantenimiento, prioritario);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String register(String username, String contrasena, String nombre, String apellidos, String email,
            double cuota_mantenimiento, boolean prioritario) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + username + "', '" + contrasena + "', '" + nombre
                + "', '" + apellidos + "', '" + email + "', " + cuota_mantenimiento + ", " + prioritario + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, contrasena, nombre, apellidos, email, cuota_mantenimiento, prioritario);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                double cuota_mantenimiento = rs.getDouble("cuota_mantenimiento");
                boolean prioritario = rs.getBoolean("prioritario");

                Usuario usuario = new Usuario(username, contrasena,
                        nombre, apellidos, email, cuota_mantenimiento, prioritario);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos,
            String nuevoEmail, double nuevocuota_mantenimiento, boolean nuevoprioritario) {

        DBConnection con = new DBConnection();

        String sql = "Update usuario set contrasena = '" + nuevaContrasena
                + "', nombre = '" + nuevoNombre + "', "
                + "apellidos = '" + nuevosApellidos + "', email = '"
                + nuevoEmail + "', cuota_mantenimiento = " + nuevocuota_mantenimiento + ", prioritario = ";

        if (nuevoprioritario == true) {
            sql += " 1 ";
        } else {
            sql += " 0 ";
        }

        sql += " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String vercantidad_equipo(String username) {

        DBConnection con = new DBConnection();
        String sql = "Select id,count(*) as num_cantidad_equipo from alquiler where username = '"
                + username + "' group by id;";

        Map<Integer, Integer> cantidad_equipo = new HashMap<Integer, Integer>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int num_cantidad_equipo = rs.getInt("num_cantidad_equipo");

                cantidad_equipo.put(id, num_cantidad_equipo);
            }

            devolverequipo_medicos(username, cantidad_equipo);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String devolverequipo_medicos(String username, Map<Integer, Integer> cantidad_equipo) {

        DBConnection con = new DBConnection();

        try {
            for (Map.Entry<Integer, Integer> equipo_medico : cantidad_equipo.entrySet()) {
                int id = equipo_medico.getKey();
                int num_cantidad_equipo = equipo_medico.getValue();

                String sql = "Update equipo_medico set cantidad_equipo = (Select cantidad_equipo + " + num_cantidad_equipo
                        + " from equipo_medico where id = " + id + ") where id = " + id;

                Statement st = con.getConnection().createStatement();
                st.executeUpdate(sql);

            }

            this.eliminar(username);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql1 = "Delete from alquiler where username = '" + username + "'";
        String sql2 = "Delete from usuario where username = '" + username + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
     @Override
    public String restarDinero(String username, double nuevocuota_mantenimiento) {

        DBConnection con = new DBConnection();
        String sql = "Update usuario set cuota_mantenimiento = " + nuevocuota_mantenimiento + " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
}
