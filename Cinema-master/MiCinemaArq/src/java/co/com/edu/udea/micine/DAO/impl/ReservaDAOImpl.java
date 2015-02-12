/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IReservaDAO;
import co.com.edu.udea.micine.model.Reserva;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class ReservaDAOImpl implements IReservaDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarReserva(Reserva r) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(r);
        tx.commit();
        session.close();
    }

    @Override
    public void editarReserva(Reserva p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarReserva(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerReserva(id));
        tx.commit();
        session.close();
    }

    @Override
    public Reserva obtenerReserva(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Reserva c = (Reserva) session.get(Reserva.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Reserva> obtenerReservas() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Reserva> result = (List<Reserva>) session.createQuery("from Reserva").list();
        tx.commit();
        session.close();
        return result;
    }    
}
