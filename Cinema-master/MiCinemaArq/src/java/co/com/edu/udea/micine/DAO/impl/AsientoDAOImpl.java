/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IAsientoDAO;
import co.com.edu.udea.micine.model.Asiento;
import co.com.edu.udea.micine.model.SalaId;
import co.com.edu.udea.micine.model.Socio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author julianesten
 */
public class AsientoDAOImpl implements IAsientoDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarAsiento(Asiento p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void editarAsiento(Asiento p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
        session.close();
    }

    @Override
    public void eliminarAsiento(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.obtenerAsiento(id));
        tx.commit();
        session.close();
    }

    @Override
    public Asiento obtenerAsiento(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Asiento c = (Asiento) session.get(Asiento.class, id);
        tx.commit();
        session.close();
        return c;
    }

    @Override
    public List<Asiento> obtenerAsiento() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Asiento> result = (List<Asiento>) session.createQuery("from Asiento").list();
        tx.commit();
        session.close();
        return result;
    }

    @Override
    public List<Asiento> obtenerAsientoPorSala(SalaId s) {
         Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Asiento where Sala_idSala = :sala");
        query.setParameter("sala", s.getIdSala());
        List<Asiento> lAs = query.list();
        return lAs;
    }

}
