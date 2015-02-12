/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ICineDAO;
import co.com.edu.udea.micine.model.Cine;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class CineDAOImpl implements ICineDAO{
 private SessionFactory sessionFactory ;
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void guardarCine(Cine c) {
         Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    @Override
    public void editarCine(Cine c) {
       Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarCine(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerCine(id));
        tx.commit();
        session.close();
    }

    @Override
    public Cine obtenerCine(int id) {
          Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Cine c = (Cine) session.get(Cine.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Cine> obtenerCines() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
         List<Cine> result = (List<Cine>)session.createQuery("from Cine").list();
        tx.commit();
        session.close();
        return result;
    }
    
}
