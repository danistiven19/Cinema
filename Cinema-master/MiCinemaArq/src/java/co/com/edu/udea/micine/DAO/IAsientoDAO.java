/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Asiento;
import co.com.edu.udea.micine.model.AsientoId;
import co.com.edu.udea.micine.model.SalaId;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface IAsientoDAO {
    public void guardarAsiento(Asiento p);
    public void editarAsiento(Asiento p);
    public void eliminarAsiento(AsientoId id);
    public Asiento obtenerAsiento(AsientoId id);
    public List<Asiento> obtenerAsiento();    
    public List<Asiento> obtenerAsientoPorSala(SalaId s);    
}
