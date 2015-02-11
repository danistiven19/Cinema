package co.com.edu.udea.micine.model;
// Generated 11/02/2015 05:36:49 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Pelicula generated by hbm2java
 */
public class Pelicula  implements java.io.Serializable {


     private Integer idPelicula;
     private String nombre;
     private Set<Funcion> funcions = new HashSet<Funcion>(0);
     private Set<Formato> formatos = new HashSet<Formato>(0);

    public Pelicula() {
    }

	
    public Pelicula(String nombre) {
        this.nombre = nombre;
    }
    public Pelicula(String nombre, Set<Funcion> funcions, Set<Formato> formatos) {
       this.nombre = nombre;
       this.funcions = funcions;
       this.formatos = formatos;
    }
   
    public Integer getIdPelicula() {
        return this.idPelicula;
    }
    
    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Funcion> getFuncions() {
        return this.funcions;
    }
    
    public void setFuncions(Set<Funcion> funcions) {
        this.funcions = funcions;
    }
    public Set<Formato> getFormatos() {
        return this.formatos;
    }
    
    public void setFormatos(Set<Formato> formatos) {
        this.formatos = formatos;
    }




}


