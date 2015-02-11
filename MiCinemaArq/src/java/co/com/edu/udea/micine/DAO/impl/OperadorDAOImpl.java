/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.DAO.impl;

import co.com.edu.udea.micine.DAO.IOperadorDAO;
import co.com.edu.udea.micine.model.Operador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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
        session.close();
    }

    @Override
    public void editarOperador(Operador o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operador buscarOperador(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarOperador(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
