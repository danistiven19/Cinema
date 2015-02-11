package co.com.edu.udea.micine.model;
// Generated 11/02/2015 01:29:45 PM by Hibernate Tools 3.6.0



/**
 * Boleta generated by hbm2java
 */
public class Boleta  implements java.io.Serializable {


     private Integer idBoleta;
     private Tipopago tipopago;
     private Asiento asiento;
     private Factura factura;
     private Funcion funcion;
     private boolean esReserva;

    public Boleta() {
    }

    public Boleta(Tipopago tipopago, Asiento asiento, Factura factura, Funcion funcion, boolean esReserva) {
       this.tipopago = tipopago;
       this.asiento = asiento;
       this.factura = factura;
       this.funcion = funcion;
       this.esReserva = esReserva;
    }
   
    public Integer getIdBoleta() {
        return this.idBoleta;
    }
    
    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }
    public Tipopago getTipopago() {
        return this.tipopago;
    }
    
    public void setTipopago(Tipopago tipopago) {
        this.tipopago = tipopago;
    }
    public Asiento getAsiento() {
        return this.asiento;
    }
    
    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Funcion getFuncion() {
        return this.funcion;
    }
    
    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
    public boolean isEsReserva() {
        return this.esReserva;
    }
    
    public void setEsReserva(boolean esReserva) {
        this.esReserva = esReserva;
    }




}

