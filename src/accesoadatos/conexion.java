
package accesoadatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class conexion {
    
    
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="elgranhotelg11";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection;
    
    private conexion(){    
    }
    
    public static Connection getconexion(){
        
        if(connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
//                JOptionPane.showMessageDialog(null, "Conectado existosamente a la base de datos");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error al cargar los drivers de conexión a la base de datos");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
            } 
            
        }
        
        return connection;
        
    }
    
    
    
}
