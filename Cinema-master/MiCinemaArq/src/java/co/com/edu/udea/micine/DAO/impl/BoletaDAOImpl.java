/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IBoletaDAO;
import co.com.edu.udea.micine.model.Asiento;
import co.com.edu.udea.micine.model.Boleta;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class BoletaDAOImpl implements IBoletaDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarBoleta(Boleta p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void editarBoleta(Boleta p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarBoleta(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerBoleta(id));
        tx.commit();
        session.close();
    }

    @Override
    public Boleta obtenerBoleta(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Boleta c = (Boleta) session.get(Boleta.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Boleta> obtenerBoletas() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Boleta> result = (List<Boleta>) session.createQuery("from Boleta").list();
        tx.commit();
        session.close();
        return result;
    }
    
}
