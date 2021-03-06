package co.com.edu.udea.micine.model;
// Generated 11/02/2015 05:36:49 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Reserva generated by hbm2java
 */
public class Reserva  implements java.io.Serializable {


     private ReservaId id;
     private Socio socio;
     private Factura factura;
     private Date fechaReserva;

    public Reserva() {
    }

	
    public Reserva(ReservaId id, Socio socio, Factura factura) {
        this.id = id;
        this.socio = socio;
        this.factura = factura;
    }
    public Reserva(ReservaId id, Socio socio, Factura factura, Date fechaReserva) {
       this.id = id;
       this.socio = socio;
       this.factura = factura;
       this.fechaReserva = fechaReserva;
    }
   
    public ReservaId getId() {
        return this.id;
    }
    
    public void setId(ReservaId id) {
        this.id = id;
    }
    public Socio getSocio() {
        return this.socio;
    }
    
    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Date getFechaReserva() {
        return this.fechaReserva;
    }
    
    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }




}


