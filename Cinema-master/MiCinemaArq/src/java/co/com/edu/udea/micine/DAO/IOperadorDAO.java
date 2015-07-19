/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Operador;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface IOperadorDAO {
    public void guardarOperador(Operador o);
    public void editarOperador(Operador o);
    public Operador buscarOperador(String cedula);
    public void eliminarOperador(String cedula);
    public List<Operador> listarOperadores();
}
