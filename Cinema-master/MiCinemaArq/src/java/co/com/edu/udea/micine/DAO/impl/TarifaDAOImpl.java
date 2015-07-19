/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ITarifaDAO;
import co.com.edu.udea.micine.model.Tarifa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class TarifaDAOImpl implements ITarifaDAO{
     private SessionFactory sessionFactory ;
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void guardarTarifa(Tarifa c) {
         Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    @Override
    public void editarTarifa(Tarifa f) {
       Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(f);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarTarifa(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerTarifa(id));
        tx.commit();
        session.close();
    }

    @Override
    public Tarifa obtenerTarifa(int id) {
          Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Tarifa c = (Tarifa) session.get(Tarifa.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Tarifa>  obtenerTarifas() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
         List<Tarifa> result = (List<Tarifa>)session.createQuery("from Tarifa").list();
        tx.commit();
        session.close();
        return result;
    }
}
