/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Tarjeta;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface ITarjetaDAO {
    public void guardarTarjeta(Tarjeta t);
    public void editarTarjeta(Tarjeta t);
    public void eliminarTarjeta(int id);
    public Tarjeta obtenerTarjeta(int id);
    public List<Tarjeta> obtenerTarjetas();    
}
