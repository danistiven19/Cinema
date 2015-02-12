/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.temp;

import co.com.edu.udea.micine.DAO.IOperadorDAO;
import co.com.edu.udea.micine.DAO.ISocioDAO;
import co.com.edu.udea.micine.DAO.impl.OperadorDAOImpl;
import co.com.edu.udea.micine.model.Cine;
import co.com.edu.udea.micine.model.Operador;
import co.com.edu.udea.micine.model.Socio;
import co.com.edu.udea.micine.model.Tipooperador;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Daniel
 */
public class index {
    
    public static void main (String[] args){
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
        Tipooperador to = new Tipooperador();
        to.setIdTipoOperador(1);
        
      Cine c = new Cine();
        c.setIdCine(1);
        /*  c.setNombre("monterey");
        c.setCiudad("medellin");
        c.setTelefono("387383");
        ICineDAO cineDAO = context.getBean(CineDAOImpl.class);
        cineDAO.guardarCine(c);
        
        Operador o = new Operador();
        o.setCine(c);
        o.setContrasena("1234");
        o.setNombre("DANIEL");
        o.setNombreUsuario("daniel");*/
        IOperadorDAO personDAO = context.getBean(OperadorDAOImpl.class);
        /*
        personDAO.guardarOperador(o);
        context.close();
        
        Operador o = new Operador();
        o.setNombre("Camilo");
        o.setNombreUsuario("jdsj");
        o.setContrasena("sfso");
        o.setCine(c);
        o.setTipooperador(to);
        personDAO.guardarOperador(o);*/
        ISocioDAO socioDAO = context.getBean(ISocioDAO.class);
        /*
        Socio s = new Socio();
        s.setCedula("1040");
        s.setDireccion("calle 123");
        s.setNombre("Jaimito");
        s.setTelefono("83838");
        s.setEstado(true);
        socioDAO.guardarSocio(s);*/
        
        Socio s1 = socioDAO.obtenerSocioCedula("1040");
        System.out.println(s1.getNombre());
                
    }
}
