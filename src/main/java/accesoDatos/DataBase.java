/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Crism
 */
public class DataBase {
       private static final String url = "jdbc:postgresql://localhost:5432/pawpetcare";
    private static final  String user = "postgres";
    private static final String password = "2911";  
    
     public Connection connection(){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa a la base de datos");
        }catch(Exception e){
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
        return conn;
        }
     
     public void desconectar(Connection conn){
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
                System.out.println("Conexion cerrada");
            }
        }catch(Exception e){
            System.out.println("Error al cerrar Conexion");
            e.printStackTrace();
        }
    
    }
}
