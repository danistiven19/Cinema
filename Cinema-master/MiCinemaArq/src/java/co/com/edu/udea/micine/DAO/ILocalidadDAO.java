/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO;
import co.com.edu.udea.micine.model.Localidad;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface ILocalidadDAO {
    public void guardarLocalidad(Localidad c);
    public void editarLocalidad(Localidad c);
    public void eliminarLocalidad(int id);
    public Localidad obtenerLocalidad(int id);
    public List<Localidad> obtenerLocalidades();
}
