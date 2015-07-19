/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Tipopago;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface ITipoPagoDAO {
    public void guardarTipopago(Tipopago p);
    public void editarTipopago(Tipopago p);
    public void eliminarTipopago(int id);
    public Tipopago obtenerTipopago(int id);
    public List<Tipopago> obtenerTipopagos();    
}
