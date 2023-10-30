/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author bmt
 */
public class mantenimientodata {
    
    
    private Connection con=null;
    
    public mantenimientodata(){
        con=conexion.getconexion();
    }
    
    
    
    
     public void setearestadomantenimiento(){
        
        
        int cantidad=0;
        
        
        String sql="SELECT* FROM mantenimiento";
        
        
        try{
            
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                cantidad++;
            }
            
            ps.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }
        
        
        ArrayList<LocalDate> fechas1=new ArrayList();
        ArrayList<LocalDate> fechas2= new ArrayList();
        
       
        
        
        String sql2="SELECT fechainiciom FROM mantenimiento";
        
        try{
            
            PreparedStatement ps2=con.prepareStatement(sql2);
            ResultSet rs2=ps2.executeQuery();
            
            while(rs2.next()){
                fechas1.add(rs2.getDate("fechainiciom").toLocalDate());
            }
            
            ps2.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }
        
        String sql3="SELECT fechafinm FROM mantenimiento";
        
        try{
            
            PreparedStatement ps3=con.prepareStatement(sql3);
            ResultSet rs3=ps3.executeQuery();
            
            while(rs3.next()){
                fechas2.add(rs3.getDate("fechafinm").toLocalDate());
            }
            
            ps3.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }
        
        
        
        ArrayList<Integer> mantenimientos = new ArrayList();
        
        
        String sql4="SELECT idmantenimiento FROM mantenimiento";
        
        try{
            
            PreparedStatement ps4=con.prepareStatement(sql4);
            ResultSet rs4=ps4.executeQuery();
            
            while(rs4.next()){
                mantenimientos.add(rs4.getInt("idmantenimiento"));
            }
            
            ps4.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }
        
        ArrayList<String> estados=new ArrayList();
        
        String sql5="SELECT estadomantenimiento FROM mantenimiento";
        
        try{
            
            PreparedStatement ps5=con.prepareStatement(sql5);
            ResultSet rs5=ps5.executeQuery();
            
            while(rs5.next()){
                estados.add(rs5.getString("estadomantenimiento"));
            }
            ps5.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }

        
        for(int p=0;p<=cantidad-1;p++){
            
            
            String sql6="UPDATE estadomantenimientos=? FROM mantenimiento WHERE estadomantenimiento=?";
            
            
            try{
                
                
                PreparedStatement ps6=con.prepareStatement(sql6);
                switch(estados.get(p)){
                    
                    case "Pasado":
                        ps6.setString(1,"Pasado");
                        break;
                    
                        
                    case "Futuro":
                        
                        if(fechas1.get(p)==LocalDate.now()){
                            ps6.setString(1,"En curso");
                        }
                        
                        
                        break;
                        
                    default:
                        
                        if(fechas2.get(p).compareTo(LocalDate.now())<0){
                            ps6.setString(1,"Pasado");
                        }
                        
                        break;
                        
                        
                        
                    
                    
                }
                ps6.setInt(2,mantenimientos.get(p));
                
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }

            
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
   
    
}
