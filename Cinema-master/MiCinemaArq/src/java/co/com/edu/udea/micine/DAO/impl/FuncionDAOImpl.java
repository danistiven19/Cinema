/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IFuncionDAO;
import co.com.edu.udea.micine.model.Funcion;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class FuncionDAOImpl implements IFuncionDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarFuncion(Funcion p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void editarFuncion(Funcion p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarFuncion(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerFuncion(id));
        tx.commit();
        session.close();
    }

    @Override
    public Funcion obtenerFuncion(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Funcion c = (Funcion) session.get(Funcion.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Funcion> obtenerFunciones() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Funcion> result = (List<Funcion>) session.createQuery("from Funcion").list();
        tx.commit();
        session.close();
        return result;
    }
        
}
