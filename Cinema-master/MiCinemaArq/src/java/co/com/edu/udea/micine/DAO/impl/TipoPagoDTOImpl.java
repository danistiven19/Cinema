/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ITipoPagoDAO;
import co.com.edu.udea.micine.model.Tipopago;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class TipoPagoDTOImpl implements ITipoPagoDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarTipopago(Tipopago p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void editarTipopago(Tipopago p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarTipopago(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerTipopago(id));
        tx.commit();
        session.close();
    }

    @Override
    public Tipopago obtenerTipopago(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Tipopago c = (Tipopago) session.get(Tipopago.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Tipopago> obtenerTipopagos() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Tipopago> result = (List<Tipopago>) session.createQuery("from Tipopago").list();
        tx.commit();
        session.close();
        return result;
    }    
}
