/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Funcion;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface IFuncionDAO {
    public void guardarFuncion(Funcion p);
    public void editarFuncion(Funcion p);
    public void eliminarFuncion(int id);
    public Funcion obtenerFuncion(int id);
    public List<Funcion> obtenerFunciones();    
    public List<Funcion> obtenerFuncionPorCiudad(String ciudad);
}
