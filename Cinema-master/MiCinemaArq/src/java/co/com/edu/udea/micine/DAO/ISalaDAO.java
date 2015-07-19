/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Sala;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface ISalaDAO {
    public void guardarSala(Sala p);
    public void editarSala(Sala p);
    public void eliminarSala(int id);
    public Sala obtenerSala(int id);
    public List<Sala> obtenerSalas();    
}
