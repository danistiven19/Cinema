/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Factura;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface IFacturaDAO {
    public void guardarFactura(Factura f);
    public void editarFactura(Factura f);
    public void eliminarFactura(int id);
    public Factura obtenerFactura(int id);
    public List<Factura> obtenerFacturas();    
}
