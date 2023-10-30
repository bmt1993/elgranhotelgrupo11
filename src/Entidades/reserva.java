
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;


public class reserva {
    
    private habitacion habitacion;
    private huesped huesped;
    private LocalDate checkin;
    private LocalDate checkout;
    private String estadoreserva;
    private double montobase;
    private double montofinal;

    public reserva(habitacion habitacion, huesped huesped, LocalDate checkin, LocalDate checkout, String estadoreserva) {
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.checkin = checkin;
        this.checkout = checkout;
        this.estadoreserva = estadoreserva;
    }

    public reserva() {
    }
    
    
    

    public reserva(habitacion habitacion, huesped huesped, LocalDate checkin, LocalDate checkout, String estadoreserva, double montobase, double montofinal) {
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.checkin = checkin;
        this.checkout = checkout;
        this.estadoreserva = estadoreserva;
        this.montobase = montobase;
        this.montofinal = montofinal;
    }

    public habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(huesped huesped) {
        this.huesped = huesped;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public String getEstadoreserva() {
        return estadoreserva;
    }

    public void setEstadoreserva(String estadoreserva) {
        this.estadoreserva = estadoreserva;
    }

    public double getMontobase() {
        return montobase;
    }

    public void setMontobase(double montobase) {
        this.montobase = montobase;
    }

    public double getMontofinal() {
        return montofinal;
    }

    public void setMontofinal(double montofinal) {
        this.montofinal = montofinal;
    }

    
    
    
}