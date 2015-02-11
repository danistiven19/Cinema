/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IOperadorDAO;
import co.com.edu.udea.micine.model.Cine;
import co.com.edu.udea.micine.model.Operador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author Daniel
 */
public class OperadorDAOImpl  implements IOperadorDAO {
    private SessionFactory sessionFactory ;
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void guardarOperador(Operador o) {
       Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(o);
        tx.commit();
        session.close();
    }

    @Override
    public void editarOperador(Operador o) {
         Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(o);
        tx.commit();
        session.close();
    }

    @Override
    public Operador buscarOperador(String cedula) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Operador o = (Operador) session.get(Operador.class, cedula);
        tx.commit();
        session.close();
        return o;
    }

    @Override
    public void eliminarOperador(String cedula) {
       Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(this.buscarOperador(cedula));
        tx.commit();
        session.close();
    }

    @Override
    public List<Operador> listarOperadores() {
      Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
         List<Operador> result = (List<Operador>)session.createQuery("from Operador").list();
        tx.commit();
        session.close();
        return result;
    }
    
}
