/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import Entidades.habitacion;
import Entidades.huesped;
import Entidades.reserva;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bmt
 */
public class reservadata {
    
    private Connection con=null;
    
    public reservadata(){   
        this.con=conexion.getconexion();
    }
    
    
    public void nuevareserva(reserva res){
        
        // Genera una nueva reserva y la sube a la base de datos, recibiendo como parámetro el id de la habitación,
        // el huesped, así como las fechas de checkin y checkout.
      
        String sql = "INSERT INTO reserva (idhabitacion,dni,checkin,checkout,estadoreserva) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,res.getHabitacion().getIdhabitacion());
            ps.setInt(2,res.getHuesped().getDni());
            ps.setDate(3,Date.valueOf(res.getCheckin()));
            ps.setDate(4,Date.valueOf(res.getCheckout()));
            ps.setString(5,res.getEstadoreserva());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
    }
    
    
    public ArrayList<reserva> buscarreservadni(int dni){
        
        int i=0;
        String sql = "SELECT dni,idhabitacion,checkin,checkout,montobase,montofinal,estadoreserva FROM reserva WHERE dni=?";
        
        ArrayList<reserva> res =new ArrayList();
        
        ArrayList<habitacion> hab =new ArrayList();
        
        ArrayList<huesped> hues =new ArrayList();
        
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            
            
            while(rs.next()){
                reserva res1 = new reserva();
                habitacion hab1 = new habitacion();
                huesped hues1=new huesped();
                res.add(res1);
                hab.add(hab1);
                hues.add(hues1);
                res.get(i).setCheckin(rs.getDate("checkin").toLocalDate());
                res.get(i).setCheckout(rs.getDate("checkout").toLocalDate());
                res.get(i).setEstadoreserva(rs.getString("estadoreserva"));
                res.get(i).setMontobase(rs.getDouble("montobase"));
                res.get(i).setMontofinal(rs.getDouble("montofinal"));
                res.get(i).setHabitacion(hab.get(i));
                res.get(i).getHabitacion().setIdhabitacion(rs.getInt("idhabitacion"));
                res.get(i).setHuesped(hues.get(i));
                res.get(i).getHuesped().setDni(dni);
                
                
                i++;
               
            }
            
            if(i==0){
                JOptionPane.showMessageDialog(null,"No se ha encontrado una reserva a nombre del cliente con DNI "+dni+" en la base de datos.");
            }
            
           
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
        }
        return res;
    }
    
    
    
    public ArrayList<reserva> buscarreservafecha(LocalDate f1, LocalDate f2){
        
        // Conversión de f1 y f2 a número entero:
        
        String sql = "SELECT dni,idhabitacion,checkin,checkout,montobase,montofinal,estadoreserva FROM reserva";
        
        ArrayList<reserva> res =new ArrayList();
        
        ArrayList<habitacion> hab =new ArrayList();
        
        ArrayList<huesped> hues=new ArrayList();
        
        LocalDate f1b;
        LocalDate f2b;
        int i=0;        
                
            try{
                PreparedStatement ps = con.prepareStatement(sql);;
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    f1b=rs.getDate("checkin").toLocalDate();
                    f2b=rs.getDate("checkout").toLocalDate();
                        if(f1.compareTo(f1b)<0){
                            if(f2.compareTo(f1b)>=0){
                                reserva res1 = new reserva();
                                habitacion hab1= new habitacion();
                                huesped hues1=new huesped();
                                res.add(res1);
                                hab.add(hab1);
                                hues.add(hues1);
                                res.get(i).setHabitacion(hab.get(i));
                                res.get(i).setHuesped(hues.get(i));
                                hab.get(i).setIdhabitacion(rs.getInt("idhabitacion"));
                                hues.get(i).setDni(rs.getInt("dni"));
                                res.get(i).setEstadoreserva(rs.getString("estadoreserva"));
                                res.get(i).setCheckin(rs.getDate("checkin").toLocalDate());
                                res.get(i).setCheckout(rs.getDate("checkout").toLocalDate());
                                
                                i++;
                            }
                        }else{
                            if(f1.compareTo(f2b)<0){
                                reserva res1 = new reserva();
                                habitacion hab1= new habitacion();
                                huesped hues1=new huesped();
                                res.add(res1);
                                hab.add(hab1);
                                hues.add(hues1);
                                res.get(i).setHabitacion(hab.get(i));
                                res.get(i).setHuesped(hues.get(i));
                                hab.get(i).setIdhabitacion(rs.getInt("idhabitacion"));
                                hues.get(i).setDni(rs.getInt("dni"));
                                res.get(i).setEstadoreserva(rs.getString("estadoreserva"));
                                res.get(i).setCheckin(rs.getDate("checkin").toLocalDate());
                                res.get(i).setCheckout(rs.getDate("checkout").toLocalDate());
                               
                                i++;
                            }
                        }
                    }
                if(i==0){
                JOptionPane.showMessageDialog(null,"No se han encontrado reservas.");
            }
            
                    
                ps.close();
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
        }
        return res;
    }
    
    
    public void abortarreserva(reserva res){
        String sql;
        if(res.getEstadoreserva().equals("En curso")){
            sql="UPDATE reserva SET estadoreserva='Parcialmente abortadada' WHERE dni=?";
            try{
                
                PreparedStatement ps=con.prepareStatement(sql);
                
                ps.setInt(1,res.getHuesped().getDni());
                ps.executeUpdate();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }               
        }else{
            if(res.getEstadoreserva().equals("Futura")){
               sql="UPDATE reserva SET estadoreserva='Abortadada' WHERE dni=?";
            try{
               PreparedStatement ps=con.prepareStatement(sql);
               
               ps.setInt(1,res.getHuesped().getDni());
               ps.executeUpdate();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }
        }
    }
        

        
       
        
        
    }
    
    
    public void setearestadoreserva(){
        
        
        int cantidad=0;
        
        
        String sql="SELECT* FROM reserva";
        
        
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
        
       
        
        
        String sql2="SELECT checkin FROM reserva";
        
        try{
            
            PreparedStatement ps2=con.prepareStatement(sql2);
            ResultSet rs2=ps2.executeQuery();
            
            while(rs2.next()){
                fechas1.add(rs2.getDate("checkin").toLocalDate());
            }
            
            ps2.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }
        
        String sql3="SELECT checkout FROM reserva";
        
        try{
            
            PreparedStatement ps3=con.prepareStatement(sql3);
            ResultSet rs3=ps3.executeQuery();
            
            while(rs3.next()){
                fechas2.add(rs3.getDate("checkout").toLocalDate());
            }
            
            ps3.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }
        
        
        
        ArrayList<Integer> reservas = new ArrayList();
        
        
        String sql4="SELECT idreserva FROM reserva";
        
        try{
            
            PreparedStatement ps4=con.prepareStatement(sql4);
            ResultSet rs4=ps4.executeQuery();
            
            while(rs4.next()){
                reservas.add(rs4.getInt("idreserva"));
            }
            
            ps4.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }
        
        ArrayList<String> estados=new ArrayList();
        
        String sql5="SELECT estadoreserva FROM reserva";
        
        try{
            
            PreparedStatement ps5=con.prepareStatement(sql5);
            ResultSet rs5=ps5.executeQuery();
            
            while(rs5.next()){
                estados.add(rs5.getString("estadoreserva"));
            }
            ps5.close();
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }

        
        for(int p=0;p<=cantidad-1;p++){
            
            
            String sql6="UPDATE estadoreserva=? FROM reserva WHERE idreserva=?";
            
            
            try{
                
                
                PreparedStatement ps6=con.prepareStatement(sql6);
                switch(estados.get(p)){
                    
                    case "Abortada":
                        ps6.setString(1,"Abortada");
                        break;
                    case "Parcialemente abortada":
                        ps6.setString(1,"Parcialemte abortada");
                        break;
                    case "Pasada":
                        ps6.setString(1,"Pasada");
                        break;
                        
                    case "Futura":
                        
                        if(fechas1.get(p)==LocalDate.now()){
                            ps6.setString(1,"En curso");
                        }
                        
                        
                        break;
                        
                    default:
                        
                        if(fechas2.get(p).compareTo(LocalDate.now())<0){
                            ps6.setString(1,"Pasada");
                        }
                        
                        break;
                        
                        
                        
                    
                    
                }
                ps6.setInt(2,reservas.get(p));
                
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
            }

            
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
   
    
    
    
    
        public void setearprecioabortada(){
            
            
//            LocalDate f1;
//            LocalDate f2;
//            double precio;
//            int id;
//            
//            String sql2="SELECT checkin FROM reserva WHERE estadoreserva='Abortada' and montobase='NULL'";
//        
//        
//            
//        try{
//            
//            PreparedStatement ps2=con.prepareStatement(sql2);
//            ResultSet rs2=ps2.executeQuery();
//            
//            
//                f1=rs2.getDate("checkin").toLocalDate();
//            
//            
//            ps2.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos6");
//            }
//       
//        String sql3="SELECT checkot FROM reserva WHERE estadoreserva='Abortada' and montobase='NULL'";
//        
//        try{
//            
//            PreparedStatement ps3=con.prepareStatement(sql2);
//            ResultSet rs3=ps3.executeQuery();
//            
//            
//                f2=rs3.getDate("checkout").toLocalDate();
//            
//            
//            ps3.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos6");
//            }
//            
//            
//        String sql4="SELECT idhabitacion FROM reserva WHERE estadoreserva='Abortada' and montobase is NULL";
//        
//        try{
//            
//            PreparedStatement ps4=con.prepareStatement(sql4);
//            ResultSet rs4=ps4.executeQuery();
//            
//            
//                id=rs4.getInt("idhabitacion");
//            
//            
//            ps4.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos6");
//            }    
//            
//            
//        String sql5="SELECT preciopornoche FROM habitacion WHERE idhabitacion=?";
//        
//        try{
//            
//            PreparedStatement ps5=con.prepareStatement(sql5);
//            ps5.setInt(1,id);
//            ResultSet rs5=ps5.executeQuery();
//            
//            
//                precio=rs5.getDouble("preciopornoche");
//            
//            
//            ps5.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos6");
//            }        
//            
//            
//            String sql6="UPDATE reserva SET montobase=?,montofinal=0 FROM habitacion WHERE idhabitacion=?";
//        
//        try{
//            
//            PreparedStatement ps6=con.prepareStatement(sql6);
//            ps6.setDouble(1, precio);
//            ResultSet rs6=ps6.executeQuery();
//            
//            
//                precio=rs6.getDouble("preciopornoche");
//            
//            
//            ps6.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos6");
//            }        
//            
//            
//            
            
            
            
            
            
            
//            
//            ArrayList<LocalDate> fechas1=new ArrayList();
//        ArrayList<LocalDate> fechas2= new ArrayList();
//        
//       
//        
//        
//        String sql2="SELECT checkin FROM reserva WHERE estadoreserva='Abortada' and montobase='NULL'";
//        
//        try{
//            
//            PreparedStatement ps2=con.prepareStatement(sql2);
//            ResultSet rs2=ps2.executeQuery();
//            
//            while(rs2.next()){
//                fechas1.add(rs2.getDate("checkin").toLocalDate());
//            }
//            
//            ps2.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos6");
//            }
//        
//        String sql3="SELECT checkout FROM reserva WHERE estadoreserva='Abortada' and montobase='NULL'";
//        
//        try{
//            
//            PreparedStatement ps3=con.prepareStatement(sql3);
//            ResultSet rs3=ps3.executeQuery();
//            
//            while(rs3.next()){
//                fechas2.add(rs3.getDate("checkout").toLocalDate());
//            }
//            
//            ps3.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos5");
//            }
//        
//        
//        
//        ArrayList<Integer> reservas = new ArrayList();
//        
//        
//        String sql4="SELECT idreserva FROM reserva WHERE estadoreserva='Abortada' and montobase='NULL'";
//        
//        try{
//            
//            PreparedStatement ps4=con.prepareStatement(sql4);
//            ResultSet rs4=ps4.executeQuery();
//            
//            while(rs4.next()){
//                reservas.add(rs4.getInt("idreserva"));
//            }
//            
//            ps4.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos4");
//            }
//            
//            
//            ArrayList<Integer> habitaciones = new ArrayList();
//            String sql5="SELECT idhabitacion FROM reserva WHERE estadoreserva='Abortada' and montobase='NULL'";
//        
//        try{
//            
//            PreparedStatement ps5=con.prepareStatement(sql5);
//            ResultSet rs5=ps5.executeQuery();
//            
//            while(rs5.next()){
//                habitaciones.add(rs5.getInt("idreserva"));
//            }
//            
//            ps5.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos3");
//            }
//            
//        ArrayList<Integer> precios = new ArrayList();
//        
//        
//        
//        for(int q=0;q<=habitaciones.size()-1;q++){
//            
//        
//            
//            String sql6="SELECT preciopornoche FROM habitacion WHERE idhabitacion=? and montobase='NULL'";
//        
//        try{
//            
//            PreparedStatement ps6=con.prepareStatement(sql6);
//            ps6.setInt(1,habitaciones.get(q));
//            ResultSet rs6=ps6.executeQuery();
//            
//            while(rs6.next()){
//                precios.add(rs6.getInt("preciopornoche"));
//            }
//            
//            ps6.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos2");
//            }
//        }
//        
//        
//        
//        
//        for(int z=0;z<=habitaciones.size()-1;z++){
//            
//            
//            String sql7="UPDATE reserva SET montobase=?,montofinal='0' WHERE idreserva=? and montobase='NULL'";
//            
//            try{
//            
//            PreparedStatement ps7=con.prepareStatement(sql7);
//            ps7.setDouble(1,precios.get(z)*fechas1.get(z).until(fechas2.get(z)).getDays()*0.3);
//            ps7.setInt(2,reservas.get(z));
//            ResultSet rs7=ps7.executeQuery();
//            
//           
//            ps7.close();
//        }catch(SQLException ex){
//                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos1");
//            }
//            
//            
//            
//            
//            
//            
//        }
//        
//        
//        
        
        
        
            
        }






}





