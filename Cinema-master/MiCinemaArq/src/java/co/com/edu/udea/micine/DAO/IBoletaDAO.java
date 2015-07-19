/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Boleta;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface IBoletaDAO {
    public void guardarBoleta(Boleta p);
    public void editarBoleta(Boleta p);
    public void eliminarBoleta(int id);
    public Boleta obtenerBoleta(int id);
    public List<Boleta> obtenerBoletas();    
}
