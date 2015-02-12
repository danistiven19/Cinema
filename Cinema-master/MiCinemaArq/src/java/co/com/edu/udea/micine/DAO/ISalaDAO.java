/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Sala;
import co.com.edu.udea.micine.model.SalaId;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface ISalaDAO {
    public void guardarSala(Sala p);
    public void editarSala(Sala p);
    public void eliminarSala(SalaId id);
    public Sala obtenerSala(SalaId id);
    public List<Sala> obtenerSalas();    
}
