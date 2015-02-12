/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Formato;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IFormatoDAO {
   public void guardarFormato(Formato c);
    public void editarFormato(Formato c);
    public void eliminarFormato(int id);
    public Formato obtenerFormato(int id);
    public List<Formato> obtenerFormatos();
}
