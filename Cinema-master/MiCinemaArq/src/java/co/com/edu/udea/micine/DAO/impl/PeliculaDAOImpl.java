/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IPeliculaDAO;
import co.com.edu.udea.micine.model.Pelicula;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class PeliculaDAOImpl implements IPeliculaDAO{
     private SessionFactory sessionFactory ;
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void guardarPelicula(Pelicula p) {
         Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void editarPelicula(Pelicula p) {
       Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarPelicula(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerPelicula(id));
        tx.commit();
        session.close();
    }

    @Override
    public Pelicula obtenerPelicula(int id) {
          Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Pelicula c = (Pelicula) session.get(Pelicula.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Pelicula>  obtenerPeliculas() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
         List<Pelicula> result = (List<Pelicula>)session.createQuery("from Pelicula").list();
        tx.commit();
        session.close();
        return result;
    }    
}
