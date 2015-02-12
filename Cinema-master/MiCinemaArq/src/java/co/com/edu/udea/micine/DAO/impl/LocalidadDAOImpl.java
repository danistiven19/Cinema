/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ILocalidadDAO;
import co.com.edu.udea.micine.model.Localidad;
import co.com.edu.udea.micine.model.Socio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class LocalidadDAOImpl implements ILocalidadDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarLocalidad(Localidad c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    @Override
    public void editarLocalidad(Localidad c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarLocalidad(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerLocalidad(id));
        tx.commit();
        session.close();
    }

    @Override
    public Localidad obtenerLocalidad(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Localidad c = (Localidad) session.get(Localidad.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Localidad> obtenerLocalidades() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Localidad> result = (List<Localidad>) session.createQuery("from Localidad").list();
        tx.commit();
        session.close();
        return result;
    }

}
