/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.controller;

import co.com.edu.udea.micine.model.Asiento;
import co.com.edu.udea.micine.model.AsientoId;
import co.com.edu.udea.micine.model.Boleta;
import co.com.edu.udea.micine.model.Funcion;
import co.com.edu.udea.micine.model.FuncionId;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class AnadirBoletaServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AnadirBoletaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AnadirBoletaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        String asiento = request.getParameter("asiento");
        String fecha= request.getParameter("fecha");
        String pelicula = request.getParameter("pelicula");
        String cine = request.getParameter("cine");
        String localidad = request.getParameter("localidad");
        String sala = request.getParameter("sala");
        
        Asiento as = new Asiento();
        
        AsientoId aid = new AsientoId();
        aid.setIdAsiento(Integer.parseInt(asiento));
        aid.setLocalidadIdLocalidad(Integer.parseInt(localidad));
        System.out.println(fecha);
        aid.setSalaCineIdCine(Integer.parseInt(cine));
        aid.setSalaIdSala(Integer.parseInt(sala));
        
        as.setId(aid);
        
        Funcion f = new Funcion();
        
        FuncionId fid = new FuncionId();
        Date d = new Date();
        fid.setFecha(d);
        fid.setPeliculaIdPelicula(Integer.parseInt(pelicula));
        
        Boleta b = new Boleta();
        b.setAsiento(as);
        b.setFuncion(f);
        
        List<Boleta> boletas = (List<Boleta>) request.getSession().getAttribute("boletas");
        boletas.add(b);
        request.getSession().setAttribute("boletas",boletas);
        response.sendRedirect("Factura.jsp");
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
