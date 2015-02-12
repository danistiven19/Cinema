/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ISalaDAO;
import co.com.edu.udea.micine.model.Sala;
import co.com.edu.udea.micine.model.SalaId;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class SalaDAOImpl implements ISalaDAO{
     private SessionFactory sessionFactory ;
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void guardarSala(Sala p) {
         Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void editarSala(Sala p) {
       Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarSala(SalaId id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerSala(id));
        tx.commit();
        session.close();
    }

    @Override
    public Sala obtenerSala(SalaId id) {
          Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Sala c = (Sala) session.get(Sala.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Sala> obtenerSalas() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
         List<Sala> result = (List<Sala>)session.createQuery("from Sala").list();
        tx.commit();
        session.close();
        return result;
    }        
}
