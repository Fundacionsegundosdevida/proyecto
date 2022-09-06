/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

/**
 *====================================================================
 * ===================================PROYECTO========================
 * ===================================================================
 */
import java.sql.Connection; //importando la dependica para la coneccion
import java.sql.DriverManager;// importando controlador de sql

public class DBConnection {
    //proseso de conexion entre el bac y la BD
    Connection connection; //creando objeto conexion
    static String bd = "alquiler_equipos"; //colocamos el nombre de la bd
    static String port = "3306"; //puerto de la bd, toca revisar en el gertor de bd
    static String login = "root";
    static String password = "admin"; //contraseña de la base de datos 
    
    //se genera uns constructor bacio 
    public DBConnection() {
        //tratamiento de errores
        try {
            Class.forName("com.mysql.jdbc.Driver"); //llamado ala base de datos      
            String url = "jdbc:mysql://localhost:"+ this.port+ "/"+this.bd; // url de la base de dtaos 
            connection = DriverManager.getConnection(url,this.login, this.password); // controlado de la conexion
            System.out.println("Conexion establecida");
        } catch (Exception ex) {
            System.out.println("Error de la conexion");
        }
        
    }
    //-------Retorno de la base de datos ----------------
    public Connection getConnection(){
    return connection; // si encuentra el usuario y password retorne base de datos
    }
    public void desconectar(){
        connection = null;
    }
}
