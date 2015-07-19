/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.ISocioDAO;
import co.com.edu.udea.micine.model.Cine;
import co.com.edu.udea.micine.model.Socio;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class SocioDAOImpl implements ISocioDAO{
 private SessionFactory sessionFactory ;
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void guardarSocio(Socio c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }

    @Override
    public void editarSocio(Socio c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarSocio(int id) {
          Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerSocio(id));
        tx.commit();
        session.close();
    }

    @Override
    public Socio obtenerSocio(int id) {
            Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Socio c = (Socio) session.get(Socio.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Socio> obtenerSocios() {
         Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
         List<Socio> result = (List<Socio>)session.createQuery("from socio").list();
        tx.commit();
        session.close();
        return result;
    }

    @Override
    public Socio obtenerSocioCedula(String cedula) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Socio where Cedula = :ced");
        query.setParameter("ced", cedula);
        List<Socio> lsocio = query.list();
        return lsocio.get(0);
    }
    
    
}
