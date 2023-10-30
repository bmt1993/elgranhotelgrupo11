
package elgranhotel;

import Entidades.habitacion;
import Entidades.huesped;
import Entidades.reserva;
import java.time.LocalDate;
import accesoadatos.conexion;
import accesoadatos.habitaciondata;
import accesoadatos.huespeddata;
import accesoadatos.mantenimientodata;
import accesoadatos.reservadata;
import java.sql.Connection;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;


public class Elgranhotel {

  
    public static void main(String[] args) {
        
        
    // CREANDO HABITACIONES AL PRINCIPIO:
    
    // habitaciondata nuevashab = new habitaciondata();
    // nuevashab.crearhabitaciones(28,2);
   
//   int[] types = new int[14];
//   
//   types[0]=1;
//   types[1]=1;
//   types[2]=1;
//   types[3]=1;
//   types[4]=1;
//   types[5]=1;
//   types[6]=1;
//   types[7]=2;
//   types[8]=2;
//   types[9]=2;
//   types[10]=3;
//   types[11]=3;
//   types[12]=3;
//   types[13]=3;
   
   habitaciondata nuevashab = new habitaciondata();
//   nuevashab.crearhabitaciones(types, 8);
////    
        System.out.println(""+nuevashab.vecthabitacionesid(3).size());
   System.out.println(""+nuevashab.vecthabitacionesid(3));
   

   
        System.out.println("");
   
   System.out.println(""+nuevashab.matrizfcheckin2(nuevashab.vecthabitacionesid(3)));
   
   System.out.println(""+nuevashab.matrizfcheckout2(nuevashab.vecthabitacionesid(3)));
   
   LocalDate fecha1 = LocalDate.of(2023, Month.JANUARY,8);
   LocalDate fecha2 = LocalDate.of(2023, Month.JANUARY,10);
   
   
        ArrayList<habitacion> listahab = nuevashab.habitacionesdisponiblesparareservar(fecha1,fecha2,nuevashab.vecthabitacionesid(3),nuevashab.matrizfcheckin2(nuevashab.vecthabitacionesid(3)),nuevashab.matrizfcheckout2(nuevashab.vecthabitacionesid(3)),3);

        System.out.println(""+listahab);
        
        for(int i=0;i<=listahab.size()-1;i++){
            System.out.println("");
            System.out.println("Id habitación: "+listahab.get(i).getIdhabitacion());
            System.out.println("Categoría: "+listahab.get(i).getTipohabitacion().getCategoria());
            System.out.println("Camas dobles: "+listahab.get(i).getTipohabitacion().getCamasdobles());
            System.out.println("Camas simples: "+listahab.get(i).getTipohabitacion().getCamassimples());
            System.out.println("Piso: "+listahab.get(i).getPiso());
            System.out.println("Tipo: "+listahab.get(i).getTipohabitacion().getTipo());
            System.out.println("");
        }
        
        nuevashab.setearestadohabitaciones();
        nuevashab.setearlibrehasta();
        
        reservadata res=new reservadata();
        
        
        mantenimientodata mtto=new mantenimientodata();
        
        
        mtto.setearestadomantenimiento();
        
        res.setearprecioabortada();
        
        huespeddata hues=new huespeddata();
        
    
        String a=hues.buscarhuespedpordni(37283650).getApellido();
        
        
        System.out.println(a);
        
//        System.out.println(""+res.setearestadoreserva());
        
//     
//        
//        boolean[] x=new boolean[14];
//        
//        
//        x=nuevashab.tiposdisponibles(listahab);
//        
//        for(int i=0;i<=13;i++){
//            System.out.println(""+x[i]);
//        }
        
//        reservadata resd = new reservadata();
//        resd.buscarreservafecha(fecha1, fecha2);
        
//        System.out.println(""+resd.buscarreservadni(28626975).get(0).getHabitacion().getIdhabitacion());
//        System.out.println(""+resd.buscarreservadni(28626975).get(1).getHabitacion().getIdhabitacion());
//        
//        
//        for(int i=0;i<=resd.buscarreservafecha(fecha1, fecha2).size()-1;i++){
//             System.out.println(""+resd.buscarreservafecha(fecha1, fecha2).get(i));
//        }
//        
//        System.out.println(""+resd.buscarreservadni(482265843).get(0).getEstadoreserva());
//        
//        System.out.println(""+resd.buscarreservadni(482265843).get(0).getHuesped().getDni());
//        
//        resd.abortarreserva(resd.buscarreservadni(482265843).get(0));
        
        
//
//
//        
//
//
//   huespeddata nuevohues = new huespeddata();
//   
//        System.out.println(""+nuevohues.comprobarexistencia(69783141));
//
//
//    huesped nuevohuesped = new huesped(37283650,"Blas Manuel","Trejo","bmt@outlook.com.ar","543425787491","Pasaje Alsina 2833","Argentina");
//    
//    nuevohues.nuevohuesped(nuevohuesped);

        
        

       
    }
    
    
    
}
