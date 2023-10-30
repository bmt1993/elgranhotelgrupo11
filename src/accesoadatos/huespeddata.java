
package accesoadatos;

import Entidades.huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class huespeddata {
    
    private Connection con=null;
    
    public huespeddata(){
        con=conexion.getconexion();
    }
   
    public boolean comprobarexistencia(int dni){
        
        // Este método recibe un nro. de DNI por parámetro y retorna TRUE si existe en la base de datos, y FALSE
        // de lo contrario.
        
        String sql="SELECT dni FROM huesped WHERE dni=?";
        boolean resultado=false;
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            resultado= rs.next();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
        return resultado;
    }
    
    public void nuevohuesped(huesped nuevohuesped){
        
        // Recibe un huésped por parámetro y lo sube a la base de datos.
        
        String sql = "INSERT INTO huesped (dni,nombre,apellido,email,telefono,domicilio,pais) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, nuevohuesped.getDni());
            ps.setString(2,nuevohuesped.getNombre());
            ps.setString(3,nuevohuesped.getApellido());
            ps.setString(4,nuevohuesped.getEmail());
            ps.setString(5,nuevohuesped.getTelefono());
            ps.setString(6,nuevohuesped.getDomicilio());
            ps.setString(7,nuevohuesped.getPais());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
    }
    
    
    public huesped buscarhuespedpordni(int dni){
        
        
        String sql = "SELECT* FROM huesped WHERE dni=?";
        huesped hues =new huesped();
        
    
        try{
            
            PreparedStatement ps=con.prepareStatement(sql);
            
            
            ps.setInt(1, dni);
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                
                
                
                hues.setNombre(rs.getString("nombre"));
                hues.setApellido(rs.getString("apellido"));
                hues.setPais(rs.getString("pais"));
                hues.setDomicilio(rs.getString("domicilio"));
                hues.setTelefono(rs.getString("telefono"));
                hues.setEmail(rs.getString("email"));
                
            }
            
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
        
        
        return hues;
        
        
        
        
        
        
        
    }
    
    
    
    
    public void actualizarhuesped(huesped huespedactualizado){
        String sql = "UPDATE huesped SET nombre=?,apellido=?,email=?,telefono=?,domicilio=?,pais=? WHERE dni=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
     
            ps.setString(1,huespedactualizado.getNombre());
            ps.setString(2,huespedactualizado.getApellido());
            ps.setString(3,huespedactualizado.getEmail());
            ps.setString(4,huespedactualizado.getTelefono());
            ps.setString(5,huespedactualizado.getDomicilio());
            ps.setString(6,huespedactualizado.getPais());
            ps.setInt(7,huespedactualizado.getDni());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos1");
        }
    }
    
    
    
    
    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    public void nuevocliente(int dni){
//    
//        // Este método se ejecuta cuando se realiza una reservación con el DNI de un huesped no registrado
//        // en la base de datos.
//        
//        String sql = "SELECT dni,nombre,apellido,email,telefono,domicilio,pais FROM huesped WHERE dni=?";
//        
//        try{
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, dni);
//            ResulSet rs=ps.executeQuery();
//            if(rs.next){
//                JOptionPane.showMessageDialog(null,"El DNI ingresado ya existe en la base de datos. A continuación podrá actualizar sus datos");
//                
//            }else{
//                
//                
//                
//                
//                
//                
//                
//                
//                
//                
//            }
//        }
//        
//        
//        
//        
//    }
//    
//    public huesped buscarhuesped(int dni,int accion){
//        
//        // Este método se ejecuta cuando:
//        // a)_ Un cliente desea hacer una nueva reserva. Si el programa encuentra el cliente en cuestión,
//        // le pedirá al personal que controle si los datos están actualizados. De lo contrario, se ejecutará el
//        // método nuevocliente.
//        // b)_ Se desea buscar un huesped (pasado o presente) por DNI en la base de datos. En tal caso, el programa
//        // indica la existencia o inexistencia del mismo.
//        
//        String sql = "SELECT dni, nombre, apellido, email, telefono, domicilio, pais";
//        huesped huesped=null;
//      
//        try{
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, dni);
//            ResultSet rs=ps.executeQuery();
//            if(rs.next()){
//                if(accion!=1){
//                    huesped = new huesped();
//                    huesped.setDni(dni);
//                    huesped.setNombre("nombre");
//                    huesped.setEmail("email");
//                    huesped.setTelefono("telefono");
//                    huesped.setDomicilio("domicilio");
//                    huesped.setPais("pais");
//                }else{
//                    huesped = new huesped();
//                    huesped.setDni(dni);
//                    huesped.setNombre("nombre");
//                    huesped.setEmail("email");
//                    huesped.setTelefono("telefono");
//                    huesped.setDomicilio("domicilio");
//                    huesped.setPais("pais");
//                    JOptionPane.showMessageDialog(null,"El huésped con el DNI ingresado ya existe en la base de datos. A continuación, verifique que los datos estén actualizados");
//                }
//                
//                
//            }else{
//                if(accion!=1){
//                    JOptionPane.showMessageDialog(null,"No existe en la base de datos un huésped con el DNI ingresado");
//                }else{
//                    JOptionPane.showMessageDialog(null,"No existe en la base de datos un huésped con el DNI ingresado. A continuación deberá crear un nuevo huésped con ingresando todos sus datos");
//                }
//                
//            }
//            ps.close();
//            
//            
//        } catch (SQLException ex){
//            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
//        }
//        return huesped;
//    }
//    
    
}
