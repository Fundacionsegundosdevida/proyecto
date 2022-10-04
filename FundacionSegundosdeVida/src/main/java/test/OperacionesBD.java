
package test;
import beans.equipo_medico;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
    
    public static void main(String[] args) {
        actualizarequipo_medico(1, "Superheroes/DC");
        listarequipo_medico();
    }
    
    public static void actualizarequipo_medico(int id, String tipo_equipo){
        DBConnection con = new DBConnection();
        String sql = "UPDATE equipo_medico SET tipo_equipo= '"+ tipo_equipo + "'WHERE id= "+id;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }
    
    public static void listarequipo_medico(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM equipo_medico";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre_equipo = rs.getString("nombre_equipo");
                String tipo_equipo = rs.getString("tipo_equipo");
                String marca_equipo = rs.getString("marca_equipo");
                int cantidad_equipo = rs.getInt("cantidad_equipo");
                boolean novedad = rs.getBoolean("novedad");
                equipo_medico equipo_medicos = new equipo_medico(id, nombre_equipo, tipo_equipo, marca_equipo, cantidad_equipo, novedad);
                System.out.println(equipo_medicos.toString());
            }
            st.executeQuery(sql);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }
    
}
