/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Combo;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface IComboDAO {
    public void guardarCombo(Combo c);
    public void editarCombo(Combo c);
    public void eliminarCombo(int id);
    public Combo obtenerCombo(int id);
    public List<Combo> obtenerCombos();    
}
