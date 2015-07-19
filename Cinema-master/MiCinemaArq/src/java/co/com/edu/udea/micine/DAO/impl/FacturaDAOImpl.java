/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IFacturaDAO;
import co.com.edu.udea.micine.model.Factura;
import co.com.edu.udea.micine.model.Tipooperador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class FacturaDAOImpl implements IFacturaDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarFactura(Factura f) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(f);
        tx.commit();
        session.close();
    }

    @Override
    public void editarFactura(Factura p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarFactura(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerFactura(id));
        tx.commit();
        session.close();
    }

    @Override
    public Factura obtenerFactura(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Factura c = (Factura) session.get(Factura.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Factura> obtenerFacturas() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Factura> result = (List<Factura>) session.createQuery("from Factura").list();
        tx.commit();
        session.close();
        return result;
    }            
}
