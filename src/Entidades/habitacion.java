
package Entidades;

import java.time.LocalDate;


public class habitacion {
    
    private int idhabitacion;
    private int piso;
    private String estadohabitacion;
    private tipohabitacion tipohabitacion;

    public habitacion(int idhabitacion, int piso, tipohabitacion tipohabitacion) {
        this.idhabitacion = idhabitacion;
        this.piso = piso;
        this.tipohabitacion = tipohabitacion;
    }
    
    
    

    public habitacion(int idhabitacion, int piso, String estadohabitacion, tipohabitacion tipohabitacion) {
        this.idhabitacion = idhabitacion;
        this.piso = piso;
        this.estadohabitacion = estadohabitacion;
        this.tipohabitacion = tipohabitacion;
    }

    public habitacion() {
        
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getEstadohabitacion() {
        return estadohabitacion;
    }

    public void setEstadohabitacion(String estadohabitacion) {
        this.estadohabitacion = estadohabitacion;
    }

    public tipohabitacion getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(tipohabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }
    
    
    
    
    
    
    
    
}


