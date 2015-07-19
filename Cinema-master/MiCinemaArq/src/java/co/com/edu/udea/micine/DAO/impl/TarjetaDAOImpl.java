/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ITarjetaDAO;
import co.com.edu.udea.micine.model.Tarjeta;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class TarjetaDAOImpl implements ITarjetaDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarTarjeta(Tarjeta t) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
        session.close();
    }

    @Override
    public void editarTarjeta(Tarjeta p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarTarjeta(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerTarjeta(id));
        tx.commit();
        session.close();
    }

    @Override
    public Tarjeta obtenerTarjeta(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Tarjeta c = (Tarjeta) session.get(Tarjeta.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Tarjeta> obtenerTarjetas() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Tarjeta> result = (List<Tarjeta>) session.createQuery("from Tarjeta").list();
        tx.commit();
        session.close();
        return result;
    }                
}
