/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO;

import co.com.edu.udea.micine.model.Reserva;
import java.util.List;

/**
 *
 * @author julianesten
 */
public interface IReservaDAO {
    public void guardarReserva(Reserva r);
    public void editarReserva(Reserva r);
    public void eliminarReserva(int id);
    public Reserva obtenerReserva(int id);
    public List<Reserva> obtenerReservas();    
}
