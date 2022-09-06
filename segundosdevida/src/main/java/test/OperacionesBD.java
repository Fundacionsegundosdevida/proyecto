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
import beans.Equipo_medico; //objeto de la clase Equipo medico dentro de beans
import connection.DBConnection; //coneccion con la bd
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {
    
    //metodo principal de ejecucion 
    public static void main(String[] args){
        actualizar_equipo_medico(6, "Cambiado");//testeo de actualizacion
        listarequipo_medico(); //testeo de listado
    
    }
    
    
     //========================UPDATE==============================================
    public static void actualizar_equipo_medico(int id_equipo, String tipo_equipo){
    
        DBConnection con = new DBConnection();
        // creando variable llamada sql = Nombre de la BD -----------------columna -----------donde ------ id_equipo = Pk
        String sql="UPDATE equipo_medico SET tipo_equipo ='"+tipo_equipo+"'WHERE id_equipo="+id_equipo;
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
    
    //======================VIEW===============================================
      public static void listarequipo_medico(){
    
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM equipo_medico"; //sentencia SQL
        // control errores
        try {
            //validano la sentencia 
            Statement st = con.getConnection().createStatement();//Conexion
            ResultSet rs = st.executeQuery(sql);
            //-----
           while (rs.next()) {
                int id_equipo = rs.getInt("id_equipo");
                String nombre_equipo = rs.getString("nombre_equipo");
                String tipo_equipo = rs.getString("tipo_equipo");
                String marca_equipo = rs.getString("marca_equipo");
                int cantidad_equipo = rs.getInt("cantidad_equipo");
                boolean observacion_equipo = rs.getBoolean("observacion_equipo");
                
                //Equipo_medico es el que importamos desde beans = nuevo equipo_medico con las variables de la bd
                Equipo_medico equipo_medico = new Equipo_medico(id_equipo, nombre_equipo, tipo_equipo, marca_equipo, cantidad_equipo, observacion_equipo);
                //mostrando por consola los qeuipos medicos 
                System.out.println(equipo_medico.toString());
                    
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        finally{
            con.desconectar();
        }//despues de conectarse poder desconectarse
    }
    
    
    
}
    
