package co.com.edu.udea.micine.model;
// Generated 11/02/2015 01:29:45 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Operador generated by hbm2java
 */
public class Operador  implements java.io.Serializable {


     private Integer idOperador;
     private Cine cine;
     private Tipooperador tipooperador;
     private String nombre;
     private String nombreUsuario;
     private String contrasena;
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Operador() {
    }

	
    public Operador(Cine cine, Tipooperador tipooperador, String nombreUsuario, String contrasena) {
        this.cine = cine;
        this.tipooperador = tipooperador;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    public Operador(Cine cine, Tipooperador tipooperador, String nombre, String nombreUsuario, String contrasena, Set<Factura> facturas) {
       this.cine = cine;
       this.tipooperador = tipooperador;
       this.nombre = nombre;
       this.nombreUsuario = nombreUsuario;
       this.contrasena = contrasena;
       this.facturas = facturas;
    }
   
    public Integer getIdOperador() {
        return this.idOperador;
    }
    
    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }
    public Cine getCine() {
        return this.cine;
    }
    
    public void setCine(Cine cine) {
        this.cine = cine;
    }
    public Tipooperador getTipooperador() {
        return this.tipooperador;
    }
    
    public void setTipooperador(Tipooperador tipooperador) {
        this.tipooperador = tipooperador;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }




}


