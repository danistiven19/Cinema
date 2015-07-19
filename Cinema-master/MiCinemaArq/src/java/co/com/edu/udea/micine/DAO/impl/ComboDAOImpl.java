/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IComboDAO;
import co.com.edu.udea.micine.model.Combo;
import co.com.edu.udea.micine.model.Reserva;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class ComboDAOImpl implements IComboDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarCombo(Combo c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    @Override
    public void editarCombo(Combo c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarCombo(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerCombo(id));
        tx.commit();
        session.close();
    }

    @Override
    public Combo obtenerCombo(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Combo c = (Combo) session.get(Combo.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Combo> obtenerCombos() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Combo> result = (List<Combo>) session.createQuery("from Combo").list();
        tx.commit();
        session.close();
        return result;
    }        
}
