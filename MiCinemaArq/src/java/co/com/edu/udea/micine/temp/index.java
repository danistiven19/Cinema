/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.temp;

import co.com.edu.udea.micine.DAO.ICineDAO;
import co.com.edu.udea.micine.DAO.IOperadorDAO;
import co.com.edu.udea.micine.DAO.impl.CineDAOImpl;
import co.com.edu.udea.micine.DAO.impl.OperadorDAOImpl;
import co.com.edu.udea.micine.model.Cine;
import co.com.edu.udea.micine.model.Operador;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Daniel
 */
public class index {
    
    public static void main (String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
        Cine c = new Cine();
        c.setNombre("monterey");
        c.setCiudad("medellin");
        c.setTelefono("387383");
        ICineDAO cineDAO = context.getBean(CineDAOImpl.class);
        cineDAO.guardarCine(c);
        
        /*Operador o = new Operador();
        o.setCine(c);
        o.setContrasena("1234");
        o.setNombre("DANIEL");
        o.setNombreUsuario("daniel");
        IOperadorDAO personDAO = context.getBean(OperadorDAOImpl.class);
        personDAO.guardarOperador(o);*/
        context.close();
        
    }
}
