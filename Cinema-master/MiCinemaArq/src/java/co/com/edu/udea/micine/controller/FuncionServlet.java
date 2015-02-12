/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.controller;

import co.com.edu.udea.micine.DAO.IFuncionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.com.edu.udea.micine.DAO.IFuncionDAO;
import co.com.edu.udea.micine.model.*;
import java.util.List;
import javax.naming.Context;
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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
        response.setContentType("text/html;charset=UTF-8");
        String ciudad = (String) request.getAttribute("seleccion");
        IFuncionDAO funcionDAO = context.getBean(IFuncionDAO.class);
        /*List listaFunciones=null;
        List<Funcion> funciones = funcionDAO.obtenerFuncionPorCiudad(ciudad);
        for (int i = 0; funciones.size() < 10; i++) {//FuncionId, Tarifa, Pelicula,Sala, Estado
            Pelicula pelicula = funciones.get(i).getPelicula();
            //Funcion id = funciones.get(i).getId().getPeliculaIdPelicula();
            Tarifa tarifa = funciones.get(i).getTarifa();
            Sala sala = funciones.get(i).getSala();
            String estado = funciones.get(i).getEstado();
            Funcion obj = new Funcion(null, pelicula, tarifa, sala, estado);
            listaFunciones.add(obj);
            
        }
        
        request.getSession().setAttribute("pelicula", obj); */
        response.sendRedirect("MostrarFunciones.jsp"); 
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
        processRequest(request, response);
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

