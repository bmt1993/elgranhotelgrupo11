
package Entidades;

import java.time.LocalDate;

public class mantenimiento {
    
    private habitacion idhabitacion;
    private LocalDate fechainiciom;
    private LocalDate fechafinm;

    public mantenimiento(habitacion idhabitacion, LocalDate fechainiciom, LocalDate fechafinm) {
        this.idhabitacion = idhabitacion;
        this.fechainiciom = fechainiciom;
        this.fechafinm = fechafinm;
    }

    public mantenimiento(habitacion idhabitacion, LocalDate fechainiciom) {
        this.idhabitacion = idhabitacion;
        this.fechainiciom = fechainiciom;
    }

    public habitacion getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(habitacion idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public LocalDate getFechainiciom() {
        return fechainiciom;
    }

    public void setFechainiciom(LocalDate fechainiciom) {
        this.fechainiciom = fechainiciom;
    }

    public LocalDate getFechafinm() {
        return fechafinm;
    }

    public void setFechafinm(LocalDate fechafinm) {
        this.fechafinm = fechafinm;
    }

   
}
