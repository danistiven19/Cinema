/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Pelicula;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface IPeliculaDAO {
    public void guardarPelicula(Pelicula p);
    public void editarPelicula(Pelicula p);
    public void eliminarPelicula(int id);
    public Pelicula obtenerPelicula(int id);
    public List<Pelicula> obtenerPeliculas();    
}
