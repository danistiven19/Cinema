/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.ComboHasFactura;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface ICOmbo_has_FacturaDAO {
    public void guardarComboHasFactura(ComboHasFactura c);
    public void editarComboHasFactura(ComboHasFactura c);
    public void eliminarComboHasFactura(int id);
    public ComboHasFactura obtenerComboHasFactura(int id);
    public List<ComboHasFactura> obtenerComboHasFacturas();    
}
