/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.controller;

import co.com.edu.udea.micine.DAO.IAsientoDAO;
import co.com.edu.udea.micine.DAO.ICineDAO;
import co.com.edu.udea.micine.DAO.ISalaDAO;
import co.com.edu.udea.micine.DAO.impl.AsientoDAOImpl;
import co.com.edu.udea.micine.DAO.impl.CineDAOImpl;
import co.com.edu.udea.micine.DAO.impl.SalaDAOImpl;
import co.com.edu.udea.micine.model.Asiento;
import co.com.edu.udea.micine.model.AsientoId;
import co.com.edu.udea.micine.model.Sala;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Daniel
 */
public class AnadirAsientoServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
        
        String a = request.getParameter("asiEscogido");
        String loca = request.getParameter("loca");
        String sala = request.getParameter("sala");
        String cine = request.getParameter("cine");
        AsientoId asid = new AsientoId();
        asid.setIdAsiento(Integer.parseInt(a));
        asid.setLocalidadIdLocalidad(Integer.parseInt(loca));
        asid.setSalaIdSala(Integer.parseInt(sala));
        asid.setSalaCineIdCine(Integer.parseInt(cine));
        IAsientoDAO iasi = context.getBean(AsientoDAOImpl.class);        
        request.getSession().setAttribute("AsientoEscogido", (Asiento) iasi.obtenerAsiento(asid));
        request.getSession().setAttribute("Recargar","SI" );
        response.sendRedirect("Asiento.jsp");
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
