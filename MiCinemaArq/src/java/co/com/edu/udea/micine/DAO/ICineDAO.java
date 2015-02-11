/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Cine;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface ICineDAO {
    public void guardarCine(Cine c);
    public void editarCine(Cine c);
    public void eliminarCine(int id);
    public Cine obtenerCine(int id);
    public List<Cine> obtenerCines();
}
