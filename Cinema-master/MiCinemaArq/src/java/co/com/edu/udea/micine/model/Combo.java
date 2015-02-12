package co.com.edu.udea.micine.model;
// Generated 11/02/2015 05:36:49 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Combo generated by hbm2java
 */
public class Combo  implements java.io.Serializable {


     private int idcombo;
     private int puntosAcumular;
     private Double precio;
     private Set<ComboHasFactura> comboHasFacturas = new HashSet<ComboHasFactura>(0);

    public Combo() {
    }

	
    public Combo(int idcombo, int puntosAcumular) {
        this.idcombo = idcombo;
        this.puntosAcumular = puntosAcumular;
    }
    public Combo(int idcombo, int puntosAcumular, Double precio, Set<ComboHasFactura> comboHasFacturas) {
       this.idcombo = idcombo;
       this.puntosAcumular = puntosAcumular;
       this.precio = precio;
       this.comboHasFacturas = comboHasFacturas;
    }
   
    public int getIdcombo() {
        return this.idcombo;
    }
    
    public void setIdcombo(int idcombo) {
        this.idcombo = idcombo;
    }
    public int getPuntosAcumular() {
        return this.puntosAcumular;
    }
    
    public void setPuntosAcumular(int puntosAcumular) {
        this.puntosAcumular = puntosAcumular;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Set<ComboHasFactura> getComboHasFacturas() {
        return this.comboHasFacturas;
    }
    
    public void setComboHasFacturas(Set<ComboHasFactura> comboHasFacturas) {
        this.comboHasFacturas = comboHasFacturas;
    }




}


