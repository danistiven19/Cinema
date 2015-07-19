/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ICOmbo_has_FacturaDAO;
import co.com.edu.udea.micine.model.ComboHasFactura;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class ComboHasFacturaDAOImpl implements ICOmbo_has_FacturaDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarComboHasFactura(ComboHasFactura c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    @Override
    public void editarComboHasFactura(ComboHasFactura c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarComboHasFactura(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerComboHasFactura(id));
        tx.commit();
        session.close();
    }

    @Override
    public ComboHasFactura obtenerComboHasFactura(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        ComboHasFactura c = (ComboHasFactura) session.get(ComboHasFactura.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<ComboHasFactura> obtenerComboHasFacturas() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<ComboHasFactura> result = (List<ComboHasFactura>) session.createQuery("from combo_has_Factura").list();
        tx.commit();
        session.close();
        return result;
    }            
}
