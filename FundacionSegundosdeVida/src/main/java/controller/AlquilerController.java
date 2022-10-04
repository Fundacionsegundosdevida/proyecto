package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Alquiler;
import connection.DBConnection;

public class AlquilerController implements IAlquilerController {

    @Override
    public String listarAlquileres(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id, l.nombre_equipo, l.tipo_equipo, l.novedad, a.fecha from equipo_medicos l "
                + "inner join alquiler a on l.id = a.id inner join usuarios u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> alquileres = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre_equipo = rs.getString("nombre_equipo");
                String tipo_equipo = rs.getString("tipo_equipo");
                boolean novedad = rs.getBoolean("novedad");
                Date fechaAlquiler = rs.getDate("fecha");

                Alquiler alquiler = new Alquiler(id, nombre_equipo, fechaAlquiler, novedad, tipo_equipo);

                alquileres.add(gson.toJson(alquiler));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(alquileres);
    }
}