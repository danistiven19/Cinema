/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Tarifa;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface ITarifaDAO {
    public void guardarTarifa(Tarifa f);
    public void editarTarifa(Tarifa f);
    public void eliminarTarifa(int id);
    public Tarifa obtenerTarifa(int id);
    public List<Tarifa> obtenerTarifas();    
}
