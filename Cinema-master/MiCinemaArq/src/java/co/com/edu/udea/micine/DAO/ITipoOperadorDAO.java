/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Tipooperador;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface ITipoOperadorDAO {
    public void guardarTipooperador(Tipooperador p);
    public void editarTipooperador(Tipooperador p);
    public void eliminarTipooperador(int id);
    public Tipooperador obtenerTipooperador(int id);
    public List<Tipooperador> obtenerTipooperadores();    
}
