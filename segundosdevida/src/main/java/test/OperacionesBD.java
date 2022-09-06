/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Usuario
 */
//Importacion de controlador de tabla equipo_medico
import beans.Equipo_medico;
import connection.DBConnection; //coneccion con la bd
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {
    
    
     //========================UPDATE==============================================
    public static void actualizarPelicula(int id_equipo, String tipo_equipo){
    
        DBConnection con = new DBConnection();
        // creando variable llamada sql = Nombre de la BD -----------------columna -----------donde ------ id = Pk
        String sql="UPDATE equipo_medico SET tipo_equipo ='"+tipo_equipo+"'WHERE id="+id_equipo;
        // control errores
        try {
            //validano la sentencia 
            Statement st = con.getConnection().createStatement();//Conexion
            st.executeUpdate(sql);
            
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        finally{
            con.desconectar();
        }//despues de conectarse poder desconectarse
    }
    
    
    
    
}
    
