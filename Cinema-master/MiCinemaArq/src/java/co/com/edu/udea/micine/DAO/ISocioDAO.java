/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Socio;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface ISocioDAO {
     public void guardarSocio(Socio c);
    public void editarSocio(Socio c);
    public void eliminarSocio(int id);
    public Socio obtenerSocio(int id);
    public List<Socio> obtenerSocios();
    public Socio obtenerSocioCedula(String cedula);
}
