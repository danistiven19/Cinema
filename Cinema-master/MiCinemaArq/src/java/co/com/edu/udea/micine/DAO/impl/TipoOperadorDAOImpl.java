/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ITipoOperadorDAO;
import co.com.edu.udea.micine.model.Tipooperador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class TipoOperadorDAOImpl implements ITipoOperadorDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarTipooperador(Tipooperador p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void editarTipooperador(Tipooperador p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarTipooperador(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerTipooperador(id));
        tx.commit();
        session.close();
    }

    @Override
    public Tipooperador obtenerTipooperador(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Tipooperador c = (Tipooperador) session.get(Tipooperador.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Tipooperador> obtenerTipooperadores() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Tipooperador> result = (List<Tipooperador>) session.createQuery("from TipoOperador").list();
        tx.commit();
        session.close();
        return result;
    }        
}
