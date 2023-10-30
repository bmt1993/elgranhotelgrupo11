
package accesoadatos;

import Entidades.habitacion;
import Entidades.reserva;
import Entidades.tipohabitacion;
import java.time.LocalDate;
import java.sql.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bmt
 */
public class habitaciondata {
    
    private Connection con=null;

    public habitaciondata() {
        
        con=conexion.getconexion();
        
    }
    
    
//    public String estadohab(int idhabitacion){
//        
//        // Devuelve el estado de una habitación.
//        
//        String estado=null;
//        String sql = "SELECT idhabitacion,estadohabitacion FROM habitacion WHERE idhabitacion = ?";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1,idhabitacion);
//            ResultSet rs= ps.executeQuery();
//            estado = rs.getString("estadohabitacion");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
//        }
//    return estado;
//    }
//    
//    
//    public void cambiarestadohabitaciones(int[] habitaciones){
//        
//        // Se ejecuta cuando cambia el estado de una habitación:
//        // Cuando un cliente la reserva (pasa de LIBRE a RESERVADA, o bien cambia la fecha librahasta).
//        // Cuando estando reservada, se cumple la fecha del checkin (pasa de RESERVADA a OCUPADA).
//        // Cuando estando ocuapada, se cumple la fecha del checkout (pasa de OCUPADA a LIBRE).
//        // Cuando el personal de mantenimiento debe hacer tareas de reparación o refacción (pasa a EN MANTENIMIENTO).
//    }
//    
//    
//    public void agregarpisos(int nuevospisos){
//        
//        // Agrega nuevos pisos, y por ende habitaciones.
//        
//    }
    
    
    public boolean[] tiposdisponibles(ArrayList<habitacion> hab){
        boolean[] valor = new boolean[14];
        
        for(int j=0;j<=13;j++){
            valor[j]=false;
        }
        
        
        for(int i=0;i<=hab.size()-1;i++){
            switch (hab.get(i).getTipohabitacion().getTipo()) {
                    case 1:
                        valor[0]=true;
                        break;
                    case 2:
                        valor[1]=true;
                        break;
                    case 3:
                        valor[2]=true;
                        break;
                    case 4:
                        valor[3]=true;
                        break;
                    case 5:
                        valor[4]=true;
                        break;
                    case 6:
                        valor[5]=true;
                        break;
                    case 7:
                        valor[6]=true;
                        break;
                    case 8:
                        valor[7]=true;
                        break;
                    case 9:
                        valor[8]=true;
                        break;
                    case 10:
                        valor[9]=true;
                        break;
                    case 11:
                        valor[10]=true;
                        break;
                    case 12:
                        valor[11]=true;
                        break;
                    case 13:
                        valor[12]=true;
                        break;
                    default:
                        valor[13]=true;
                        break;
                    }   
        }
        return valor;
    }
    
    public ArrayList<habitacion> habitacionesdisponiblesparareservar(LocalDate f1,LocalDate f2,ArrayList<Integer> habitaciones,ArrayList<ArrayList<Integer>> fechas1,ArrayList<ArrayList<Integer>> fechas2,int personas){
        
        // Lista todas las habitaciones libres durante el período de tiempo que va desde fecheckin hasta
        // fcheckout.
        
        ArrayList<habitacion> hab = new ArrayList();
        int año1 = f1.getYear();
        int dia1;
        int fech1;
        if(año1>=2024){
            fech1=96;
            if(año1==2024){
                dia1= f1.getDayOfYear();
                fech1=fech1+dia1;
            }else{
                for(int x=2024;x<=año1-1;x++){
                if(x%4==0){
                    fech1=fech1+366;
                }else{
                    fech1=fech1+365;
                    }    
                }
                dia1=f1.getDayOfYear();
                fech1=fech1+dia1;
            }
        }else{
        dia1= f1.getDayOfYear()-269;
        fech1=dia1;
        }
        int año2 = f2.getYear();
        int dia2;
        int fech2;
        if(año2>=2024){
            fech2=96;
            if(año2==2024){
                dia2= f2.getDayOfYear();
                fech2=fech2+dia2;
            }else{
                for(int x=2024;x<=año2-1;x++){
                if(x%4==0){
                    fech2=fech2+366;
                }else{
                    fech2=fech2+365;
                    }    
                }
                dia2=f2.getDayOfYear();
                fech2=fech2+dia2;
            }
        }else{
        dia2= f2.getDayOfYear()-269;
        fech2=dia2;
        }
        int inferior=0;
        int posicion=0;
        ArrayList<Integer> habdisp = new ArrayList();
        for(int i=0;i<=habitaciones.size()-1;i++){
            for(int j=0;j<=fechas1.get(i).size()-1;j++){
                if(fech1>fechas1.get(i).get(j)){
                    inferior=fechas1.get(i).get(j);
                    posicion = j;
                    break;
                }
            }
            if(inferior==0){
                if(fech2<fechas2.get(i).get(0)){
                    habdisp.add(habitaciones.get(i));
                }
            }else{
                    if(posicion==fechas1.get(i).size()-1){
                        if(fech2>fechas2.get(i).get(fechas1.get(i).size()-1)){
                            habdisp.add(habitaciones.get(i));
                        }
                    }else{
                        if(fech1>fechas2.get(i).get(posicion) & fech2<fechas1.get(i).get(posicion+1)){
                    habdisp.add(habitaciones.get(i));
                    }
                
                    }
                
//                if(fech1>fechas2.get(i).get(posicion) & fech2<fechas1.get(i).get(posicion+1)){
//                    habdisp.add(habitaciones.get(i));
//                }
            }
        }
        String sql2 = "SELECT idhabitacion FROM habitacion WHERE camassimples+2*camasdobles=? and librehasta='0'";
//        HashSet<Integer> conjuntoUnico = new HashSet<>(vect);
//        vect.clear();
//        vect.addAll(conjuntoUnico);
        
//        HashSet<Integer> habsnull = new HashSet<>();
        
        try{
            PreparedStatement ps2=con.prepareStatement(sql2);
            ps2.setInt(1,personas);
            ResultSet rs2=ps2.executeQuery();
            while(rs2.next()){
                habdisp.add(rs2.getInt("idhabitacion"));
                        }  
            ps2.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
            }
        
        HashSet<Integer> conjuntoUnico = new HashSet<>(habdisp);
        habdisp.clear();
        habdisp.addAll(conjuntoUnico);
        
        
        Collections.sort(habdisp);
        
        
        
        
        
//      habdisp.addAll(habsnull);

        
        
        habitacion vecthabitaciones[]=new habitacion[habdisp.size()];
        tipohabitacion vecttipohabitaciones[]=new tipohabitacion[habdisp.size()];
        for(int k=0;k<=habdisp.size()-1;k++){
            String sql="SELECT categoria,camassimples,camasdobles,piso,tipo,preciopornoche FROM habitacion WHERE idhabitacion=?";
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1, habdisp.get(k));
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    vecttipohabitaciones[k]=new tipohabitacion();
                    vecttipohabitaciones[k].setCategoria(rs.getString("categoria"));
                    vecttipohabitaciones[k].setCamassimples(rs.getInt("camassimples"));
                    vecttipohabitaciones[k].setCamasdobles(rs.getInt("camasdobles"));
                    vecttipohabitaciones[k].setTipo(rs.getInt("tipo"));
                    vecttipohabitaciones[k].setPreciopornoche(rs.getDouble("preciopornoche"));
                    vecthabitaciones[k]=new habitacion(habdisp.get(k),rs.getInt("piso"),vecttipohabitaciones[k]);
                    hab.add(vecthabitaciones[k]);
                }else{
                    JOptionPane.showMessageDialog(null,"No existen habitaciones disponibles para la el período de tiempo y capacidad indicadas");
                }
                ps.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
            }
        }
        return hab;
    }
    
    public void crearhabitaciones(int[] tipos,int pisos){
        
        // Este método crea las habitaciones al principio. Permite crear cientos de habitaciones al ejecutarse
        // (y subir la información a la base de datos).
        
       String sql="INSERT INTO habitacion (idhabitacion,piso,estadohabitacion,categoria,camassimples,camasdobles,tipo,preciopornoche) VALUES(?,?,?,?,?,?,?,?)";
       int suma=0; 
       for(int z=0;z<=13;z++){
           suma=tipos[z]+suma;
       }
       int canttotal=suma*pisos;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            habitacion habitaciones[]=new habitacion[canttotal];
            tipohabitacion vecttipohabitacion[]=new tipohabitacion[canttotal];
            int piso;
            int sumak=0;
            for(int j=1;j<=pisos;j++){
                String cat;
                int simples;
                int dobles;
                int tipo;
                double preciopornoche;
                for(int h=1;h<=14;h++){
                    for(int k=0;k<=tipos[h-1];k++){
                        switch (h) {
                    case 1:
                        cat="Comfort";
                        simples=2;
                        dobles=0;
                        tipo=1;
                        preciopornoche=30000;
                        break;
                    case 2:
                        cat="Comfort";
                        simples=0;
                        dobles=1;
                        tipo=2;
                        preciopornoche=30000;
                        break;
                    case 3:
                        cat="Privilege";
                        simples=2;
                        dobles=0;
                        tipo=3;
                        preciopornoche=45000;
                        break;
                    case 4:
                        cat="Privilege";
                        simples=0;
                        dobles=1;
                        tipo=4;
                        preciopornoche=45000;
                        break;
                    case 5:
                        cat="Luxury";
                        simples=2;
                        dobles=0;
                        tipo=5;
                        preciopornoche=70000;
                        break;
                    case 6:
                        cat="Luxury";
                        simples=0;
                        dobles=1;
                        tipo=6;
                        preciopornoche=70000;
                        break;
                    case 7:
                        cat="Privilege";
                        simples=3;
                        dobles=0;
                        tipo=7;
                        preciopornoche=54000;
                        break;
                    case 8:
                        cat="Privilege";
                        simples=1;
                        dobles=1;
                        tipo=8;
                        preciopornoche=54000;
                        break;
                    case 9:
                        cat="Luxury";
                        simples=3;
                        dobles=0;
                        tipo=9;
                        preciopornoche=84000;
                        break;
                    case 10:
                        cat="Luxury";
                        simples=1;
                        dobles=1;
                        tipo=10;
                        preciopornoche=84000;
                        break;
                    case 11:
                        cat="Privilege";
                        simples=4;
                        dobles=0;
                        tipo=11;
                        preciopornoche=64800;
                        break;
                    case 12:
                        cat="Privilege";
                        simples=2;
                        dobles=1;
                        tipo=12;
                        preciopornoche=64800;
                        break;
                    case 13:
                        cat="Luxury";
                        simples=4;
                        dobles=0;
                        tipo=13;
                        preciopornoche=100800;
                        break;
                    default:
                        cat="Luxury";
                        simples=2;
                        dobles=1;
                        tipo=14;
                        preciopornoche=100800;
                        break;
                    }
                    if(k!=0){
                    sumak=1+sumak;}
                    
                        if(k!=0){
                           vecttipohabitacion[k]=new tipohabitacion(cat,simples,dobles,tipo,preciopornoche);
                           habitaciones[k]=new habitacion(sumak,j,"Libre",vecttipohabitacion[k]);
                           ps.setInt(1,habitaciones[k].getIdhabitacion());
                           ps.setInt(2,habitaciones[k].getPiso());
                           ps.setString(3,habitaciones[k].getEstadohabitacion());
                           ps.setString(4,vecttipohabitacion[k].getCategoria());
                           ps.setInt(5, vecttipohabitacion[k].getCamassimples());
                           ps.setInt(6, vecttipohabitacion[k].getCamasdobles());
                           ps.setInt(7,vecttipohabitacion[k].getTipo());
                           ps.setDouble(8,vecttipohabitacion[k].getPreciopornoche());
                           ps.executeUpdate();  
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null,"Se han cargado exitosamente las "+canttotal+" habitaciones");
            ps.close();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos");
        }            
    }
    
    public ArrayList<Integer> vecthabitacionesid(int capacidad){
        
        // Retorna una arraylist con el id de las habitaciones de una determinada capacidad y cuyo
        // estado de reserva o mantenimiento es en curso o futuro.
        
        String sql = "SELECT r.* FROM Reserva AS r JOIN Habitacion AS h ON r.idhabitacion = h.idhabitacion WHERE h.camassimples + 2 * h.camasdobles = ? and r.estadoreserva<>'Pasada' and r.estadoreserva<>'Abortada' and r.estadoreserva<>'Parcialmente abortada'";
        ArrayList<Integer> vect=new ArrayList();
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,capacidad);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vect.add(rs.getInt("idhabitacion"));
                        }  
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
            }
        String sql2 = "SELECT m.* FROM mantenimiento AS m JOIN habitacion AS h ON m.idhabitacion = h.idhabitacion WHERE h.camassimples + 2 * h.camasdobles = ? and m.estadomantenimiento<>'Pasado'";
        try{
            PreparedStatement ps2=con.prepareStatement(sql2);
            ps2.setInt(1,capacidad);
            ResultSet rs2=ps2.executeQuery();
            while(rs2.next()){
                vect.add(rs2.getInt("idhabitacion"));
                        }  
            ps2.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
            }
        HashSet<Integer> conjuntoUnico = new HashSet<>(vect);
        vect.clear();
        vect.addAll(conjuntoUnico);
        Collections.sort(vect);
        return vect;
        
        }
    

     
    
    
    public ArrayList<ArrayList<Integer>> matrizfcheckin2(ArrayList<Integer> habitaciones){
        
        // Devuelve una arraylist con las fechas de checkin de las reservas de las habitaciones que se pasan
        // como parámetro.
        
        ArrayList<ArrayList<Integer>> matriz = new ArrayList();
            try{
                for(int j=1;j<=habitaciones.size();j++){
                    ArrayList<Integer> filas = new ArrayList();
                    ArrayList<Integer> filas2 = new ArrayList();
                    String sql = "SELECT checkin FROM reserva WHERE idhabitacion=? and estadoreserva<>'Pasada' and estadoreserva<>'Abortada' and estadoreserva<>'Parcialmente abortada'";
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.setInt(1,habitaciones.get(j-1));
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        int año = rs.getDate("checkin").toLocalDate().getYear();
                        int dia;
                        int fech;
                        if(año>=2024){
                            fech=96;
                            if(año==2024){
                                dia= rs.getDate("checkin").toLocalDate().getDayOfYear();
                                fech=fech+dia;
                            }else{
                                for(int x=2024;x<=año-1;x++){
                                    if(x%4==0){
                                        fech=fech+366;
                                    }else{
                                        fech=fech+365;
                                    }
                                }
                                dia= rs.getDate("checkin").toLocalDate().getDayOfYear();
                                fech=fech+dia;
                            }
                        }else{
                            dia= rs.getDate("checkin").toLocalDate().getDayOfYear()-269;
                            fech=dia;
                        }
                        filas.add(fech);
                    }
                    ps.close();
                    String sql2 = "SELECT fechainiciom FROM mantenimiento WHERE idhabitacion=? and estadomantenimiento<>'Pasado'";
                    PreparedStatement ps2=con.prepareStatement(sql2);
                    ps2.setInt(1,habitaciones.get(j-1));
                    ResultSet rs2=ps2.executeQuery();
                    while(rs2.next()){
                        int año = rs2.getDate("fechainiciom").toLocalDate().getYear();
                        int dia;
                        int fech;
                        if(año>=2024){
                            fech=96;
                            if(año==2024){
                                dia= rs2.getDate("fechainiciom").toLocalDate().getDayOfYear();
                                fech=fech+dia;
                            }else{
                                for(int x=2024;x<=año-1;x++){
                                    if(x%4==0){
                                        fech=fech+366;
                                    }else{
                                        fech=fech+365;
                                    }
                                }
                                dia= rs2.getDate("fechainiciom").toLocalDate().getDayOfYear();
                                fech=fech+dia;
                            }
                        }else{
                            dia= rs2.getDate("fechainiciom").toLocalDate().getDayOfYear()-269;
                            fech=dia;
                        }
                        filas.add(fech);
                    }
                    ps2.close();
//                int posicion;
//                int minimo;
//                int maximo;
//                maximo=filas.get(0);
//                for(int i=0;i<=filas.size()-1;i++){
//                    if(filas.get(i)>maximo){
//                        maximo=filas.get(i);
//                    }
//                }
//                for(int i=0;i<=filas.size()-1;i++){
//            minimo=filas.get(i);
//            posicion=i;
//            for(int k=0;k<=filas.size()-1;k++){
//                if(filas.get(k)<minimo){
//                    minimo=filas.get(k);
//                    posicion=k;
//                }
//            }
//            filas.set(posicion,maximo);
//            filas2.add(minimo);
                    Collections.sort(filas);
                    matriz.add(filas);
                }  
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
            }
        return matriz;   
    }
    
    public ArrayList<ArrayList<Integer>> matrizfcheckout2(ArrayList<Integer> habitaciones){
        
        // Devuelve una arraylist con las fechas de checkin de las reservas de las habitaciones que se pasan
        // como parámetro.
        
        ArrayList<ArrayList<Integer>> matriz = new ArrayList();
        
            try{
                for(int j=1;j<=habitaciones.size();j++){
                ArrayList<Integer> filas = new ArrayList();
//                ArrayList<Integer> filas2 = new ArrayList();
                String sql = "SELECT checkout FROM reserva WHERE idhabitacion=? and estadoreserva<>'Pasada' and estadoreserva<>'Abortada' and estadoreserva<>'Parcialmente abortada'";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,habitaciones.get(j-1));
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    int año = rs.getDate("checkout").toLocalDate().getYear();
                    int dia;
                    int fech;
                    if(año>=2024){
                        fech=96;
                        if(año==2024){
                            dia= rs.getDate("checkout").toLocalDate().getDayOfYear();
                            fech=fech+dia;
                        }else{
                            for(int x=2024;x<=año-1;x++){
                                if(x%4==0){
                                    fech=fech+366;
                                }else{
                                    fech=fech+365;
                                }
                            }
                            dia= rs.getDate("checkout").toLocalDate().getDayOfYear();
                            fech=fech+dia;
                        }
                    }else{
                        dia= rs.getDate("checkout").toLocalDate().getDayOfYear()-269;
                        fech=dia;
                    }
                    filas.add(fech);
                }
                ps.close();
                String sql2 = "SELECT fechafinm FROM mantenimiento WHERE idhabitacion=?  and estadomantenimiento<>'Pasado'";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,habitaciones.get(j-1));
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next()){
                    int año2 = rs2.getDate("fechafinm").toLocalDate().getYear();
                    int dia2;
                    int fech2;
                    if(año2>=2024){
                        fech2=96;
                        if(año2==2024){
                            dia2= rs2.getDate("fechafinm").toLocalDate().getDayOfYear();
                            fech2=fech2+dia2;
                        }else{
                            for(int x=2024;x<=año2-1;x++){
                                if(x%4==0){
                                    fech2=fech2+366;
                                }else{
                                    fech2=fech2+365;
                                }
                            }
                            dia2= rs2.getDate("fechafinm").toLocalDate().getDayOfYear();
                            fech2=fech2+dia2;
                        }
                    }else{
                        dia2= rs2.getDate("fechafinm").toLocalDate().getDayOfYear()-269;
                        fech2=dia2;
                    }
                    filas.add(fech2);
                }
                ps2.close();
//                int posicion;
//                int minimo;
//                int maximo;
//                maximo=filas.get(0);
//                for(int i=0;i<=filas.size()-1;i++){
//                    if(filas.get(i)>maximo){
//                        maximo=filas.get(i);
//                    }
//                }
//                for(int i=0;i<=filas.size()-1;i++){
//            minimo=filas.get(i);
//            posicion=i;
//            for(int k=0;k<=filas.size()-1;k++){
//                if(filas.get(k)<minimo){
//                    minimo=filas.get(k);
//                    posicion=k;
//                }
//            }
//            filas.set(posicion,maximo);
//            filas2.add(minimo);
//        }
//                matriz.add(filas);
                  Collections.sort(filas);
                  matriz.add(filas);
                }
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
            }
        return matriz;   
    }    
    
    
    public void actualizacionporinflacion(double indice){
        String sql="UPDATE habitacion SET preciopornoche=(preciopornoche)*(1+?/100)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,indice);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Actualización de precios por inflación realizada");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
            }
    }
    
    
    public void actualizaciondepreciosrelativos(ArrayList<Double> precios){
        
        boolean error=false;
        for(int i=0;i<=precios.size();i++){
            String sql="UPDATE habitacion SET preciopornoche=? WHERE tipo=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,precios.get(i));
            ps.setInt(2,i+1);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Actualización de precios por inflación realizada");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
            error=true;
            }
            
        if(error==false){
            JOptionPane.showMessageDialog(null,"Actualización de precios relativos correctamente realizada!");
        }    
            
            
            
            
        }
        
        
        
      
            
        }
        
      public void setearestadohabitaciones(){
            
            boolean[] estados = new boolean[200];
            
            for(int k=0;k<=199;k++){
                estados[k]=false;
            }
          
            for(int i=0;i<=199;i++){
                
            String sql="SELECT estadoreserva FROM reserva WHERE idhabitacion=?";
            
            
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,i+1);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(rs.getString("estadoreserva").equals("En curso")){
                        estados[i]=true;
                    }
                
                    
                
                }
                
                ps.close();
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
           
            }
                
            String sql2="SELECT estadomantenimiento FROM mantenimiento WHERE idhabitacion=?";
            
            
            try{
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,i+1);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next()){
                    if(rs2.getString("estadomantenimiento").equals("En curso")){
                        estados[i]=true;
                    }
                
                    
                
                }
                
                ps2.close();
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
           
            }
                
                
                
            }
            
            
            for(int h=0;h<=199;h++){
                
                
                String sql3="UPDATE habitacion SET estadohabitacion=? WHERE idhabitacion=?";
                
                try{
             
                    PreparedStatement ps=con.prepareStatement(sql3);
                    
                    
                    if(estados[h]==true){
                        ps.setString(1,"Ocupada");
                        ps.setInt(2, h+1);
                    }else{
                        ps.setString(1,"Libre");
                        ps.setInt(2, h+1);
                    }
                    
                    ps.executeUpdate();
                }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
           
            }
                
                
                
                
            }
            
            
              
        
      }
      
      
      
      public void setearlibrehasta(){
          
          int[] librehasta=new int[200];
          
          for(int k=0;k<=199;k++){
              
              
              librehasta[k]=0;
              
              
          }
          
          
          for(int i=0;i<=199;i++){
              
              
              String sql="SELECT* FROM reserva WHERE idhabitacion=? and estadoreserva='Futura'";
              
              try{
                  
                  PreparedStatement ps=con.prepareStatement(sql);
                  ps.setInt(1, i+1);
                  ResultSet rs=ps.executeQuery();
                  
                  
                  if(rs.next()){
                      librehasta[i]=1;
                  }
                  ps.close();
                  
                  
              }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
           
            }
              
              String sql2="SELECT* FROM mantenimiento WHERE idhabitacion=? and estadomantenimiento='Futuro'";
              
              try{
                  
                  PreparedStatement ps2=con.prepareStatement(sql2);
                  ps2.setInt(1, i+1);
                  ResultSet rs2=ps2.executeQuery();
                  
                  
                  if(rs2.next()){
                      librehasta[i]=1;
                  }
                  ps2.close();
                  
                  
              }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
           
            }
              
              
              
              
              
          }
          
          
          
          for(int h=1;h<=200;h++){
              
              
                String sql3="UPDATE habitacion SET librehasta=? WHERE idhabitacion=?";
                
                try{
             
                    PreparedStatement ps3=con.prepareStatement(sql3);
                    
                    
                    
                        ps3.setInt(1,librehasta[h-1]);
                        ps3.setInt(2, h);
                    
                        
                    ps3.executeUpdate();
                }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos 3");
           
            }
                
              
              
              
          }
          
          
          
          
      }
    
    

    
    
    
    
}
        
        
        
        
        
        
        
        
       
        
 
    
    



    
