package co.com.edu.udea.micine.model;
// Generated 11/02/2015 01:29:45 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Localidad generated by hbm2java
 */
public class Localidad  implements java.io.Serializable {


     private Integer idLocalidad;
     private String nombre;
     private Set<Asiento> asientos = new HashSet<Asiento>(0);
     private Set<Tarifa> tarifas = new HashSet<Tarifa>(0);

    public Localidad() {
    }

	
    public Localidad(String nombre) {
        this.nombre = nombre;
    }
    public Localidad(String nombre, Set<Asiento> asientos, Set<Tarifa> tarifas) {
       this.nombre = nombre;
       this.asientos = asientos;
       this.tarifas = tarifas;
    }
   
    public Integer getIdLocalidad() {
        return this.idLocalidad;
    }
    
    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Asiento> getAsientos() {
        return this.asientos;
    }
    
    public void setAsientos(Set<Asiento> asientos) {
        this.asientos = asientos;
    }
    public Set<Tarifa> getTarifas() {
        return this.tarifas;
    }
    
    public void setTarifas(Set<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }




}


