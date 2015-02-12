/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.controller;

import co.com.edu.udea.micine.DAO.ICineDAO;
import co.com.edu.udea.micine.DAO.IFuncionDAO;
import co.com.edu.udea.micine.DAO.ISalaDAO;
import co.com.edu.udea.micine.DAO.impl.CineDAOImpl;
import co.com.edu.udea.micine.DAO.impl.SalaDAOImpl;
import co.com.edu.udea.micine.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author julianesten
 */
public class FuncionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
        response.setContentType("text/html;charset=UTF-8");
        String ciudad = (String) request.getParameter("ciudad");
        IFuncionDAO funcionDAO = context.getBean(IFuncionDAO.class);
        List<Funcion> funciones = funcionDAO.obtenerFunciones();
        List<Funcion> def = new ArrayList<Funcion>();
        ISalaDAO ic = context.getBean(SalaDAOImpl.class);
        ICineDAO icine = context.getBean(CineDAOImpl.class);
        Iterator it = funciones.iterator();
        while (it.hasNext()) {
            Funcion ff = (Funcion) it.next();
            ff.setSala((ic.obtenerSala(ff.getSala().getId())));
            ff.getSala().setCine(icine.obtenerCine(ff.getSala().getCine().getIdCine()));
            
            if (ff.getSala().getCine().getCiudad().equalsIgnoreCase(ciudad)) {
                def.add(ff);
                
            }
        }
        request.getSession().setAttribute("funciones", def);
        //System.out.println(def.get(0).getId().getPeliculaIdPelicula());
        response.sendRedirect("MostrarFunciones.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
