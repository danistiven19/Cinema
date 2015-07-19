/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.edu.udea.micine.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julianesten
 */
public class FacturaServlet extends HttpServlet {

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
        String cliente = (String) request.getAttribute("cliente");
        String accionEstado = (String) request.getAttribute("estado");
        String accionTipoPago = (String) request.getAttribute("tipoPago");
        int idFuncion = (int) request.getAttribute("pelicula");
        if("pago".equalsIgnoreCase(accionEstado) && "puntos".equalsIgnoreCase(accionTipoPago)){
            //El cliente es socio y va a pagar con puntos
        }else if("pago".equalsIgnoreCase(accionEstado) && "efectivo".equalsIgnoreCase(accionTipoPago)){
        //El cliente va a pagar con efectivo
        }else if("pago".equalsIgnoreCase(accionEstado) && "tarjeta".equalsIgnoreCase(accionTipoPago)){
            //El cliente va a pagar con tarjeta
        }else if ("reservar".equalsIgnoreCase(accionEstado)){
            
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
