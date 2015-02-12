/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IFormatoDAO;
import co.com.edu.udea.micine.model.Formato;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class FormatoDAOImpl implements IFormatoDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarFormato(Formato c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    @Override
    public void editarFormato(Formato c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarFormato(int id) {
               Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerFormato(id));
        tx.commit();
        session.close();
    }

    @Override
    public Formato obtenerFormato(int id) {
                Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Formato c = (Formato) session.get(Formato.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Formato> obtenerFormatos() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Formato> result = (List<Formato>) session.createQuery("from localidad").list();
        tx.commit();
        session.close();
        return result;
    }

}
