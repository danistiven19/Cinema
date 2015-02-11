package co.com.edu.udea.micine.model;
// Generated 11/02/2015 07:39:26 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Tarifa generated by hbm2java
 */
public class Tarifa  implements java.io.Serializable {


     private Integer idTarifa;
     private Localidad localidad;
     private Formato formato;
     private double valor;
     private Integer puntosAcumular;
     private double valorTarjeta;
     private Set<Funcion> funcions = new HashSet<Funcion>(0);

    public Tarifa() {
    }

	
    public Tarifa(Localidad localidad, Formato formato, double valor, double valorTarjeta) {
        this.localidad = localidad;
        this.formato = formato;
        this.valor = valor;
        this.valorTarjeta = valorTarjeta;
    }
    public Tarifa(Localidad localidad, Formato formato, double valor, Integer puntosAcumular, double valorTarjeta, Set<Funcion> funcions) {
       this.localidad = localidad;
       this.formato = formato;
       this.valor = valor;
       this.puntosAcumular = puntosAcumular;
       this.valorTarjeta = valorTarjeta;
       this.funcions = funcions;
    }
   
    public Integer getIdTarifa() {
        return this.idTarifa;
    }
    
    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }
    public Localidad getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    public Formato getFormato() {
        return this.formato;
    }
    
    public void setFormato(Formato formato) {
        this.formato = formato;
    }
    public double getValor() {
        return this.valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Integer getPuntosAcumular() {
        return this.puntosAcumular;
    }
    
    public void setPuntosAcumular(Integer puntosAcumular) {
        this.puntosAcumular = puntosAcumular;
    }
    public double getValorTarjeta() {
        return this.valorTarjeta;
    }
    
    public void setValorTarjeta(double valorTarjeta) {
        this.valorTarjeta = valorTarjeta;
    }
    public Set<Funcion> getFuncions() {
        return this.funcions;
    }
    
    public void setFuncions(Set<Funcion> funcions) {
        this.funcions = funcions;
    }




}


