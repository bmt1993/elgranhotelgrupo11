
package Entidades;


public class tipohabitacion {
    
    private String categoria;
    private int camassimples;
    private int camasdobles;
    private int tipo;
    private double preciopornoche;

    public tipohabitacion() {
    }

    public tipohabitacion(String categoria, int camassimples, int camasdobles, int tipo, double preciopornoche) {
        this.categoria = categoria;
        this.camassimples = camassimples;
        this.camasdobles = camasdobles;
        this.tipo = tipo;
        this.preciopornoche = preciopornoche;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCamassimples() {
        return camassimples;
    }

    public void setCamassimples(int camassimples) {
        this.camassimples = camassimples;
    }

    public int getCamasdobles() {
        return camasdobles;
    }

    public void setCamasdobles(int camasdobles) {
        this.camasdobles = camasdobles;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getPreciopornoche() {
        return preciopornoche;
    }

    public void setPreciopornoche(double preciopornoche) {
        this.preciopornoche = preciopornoche;
    }
    
    
    
    public void determinartipo(int cat,int camassimples,int camasdobles) {
    
    
    
    
    
    }
    
    
    
    
    
}
