package co.com.edu.udea.micine.model;
// Generated 11/02/2015 07:39:26 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Tipopago generated by hbm2java
 */
public class Tipopago  implements java.io.Serializable {


     private Integer idTipoPago;
     private String nombreTipo;
     private Set<Boleta> boletas = new HashSet<Boleta>(0);

    public Tipopago() {
    }

	
    public Tipopago(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    public Tipopago(String nombreTipo, Set<Boleta> boletas) {
       this.nombreTipo = nombreTipo;
       this.boletas = boletas;
    }
   
    public Integer getIdTipoPago() {
        return this.idTipoPago;
    }
    
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    public String getNombreTipo() {
        return this.nombreTipo;
    }
    
    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    public Set<Boleta> getBoletas() {
        return this.boletas;
    }
    
    public void setBoletas(Set<Boleta> boletas) {
        this.boletas = boletas;
    }




}


