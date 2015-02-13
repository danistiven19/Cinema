/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.controller;

import co.com.edu.udea.micine.DAO.IOperadorDAO;
import co.com.edu.udea.micine.DAO.ISocioDAO;
import co.com.edu.udea.micine.DAO.impl.OperadorDAOImpl;
import co.com.edu.udea.micine.DAO.impl.SocioDAOImpl;
import co.com.edu.udea.micine.model.Funcion;
import co.com.edu.udea.micine.model.FuncionId;
import co.com.edu.udea.micine.model.Operador;
import co.com.edu.udea.micine.model.Socio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Daniel
 */
public class SeleccionarFuncionServlet extends HttpServlet {

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
        List<Funcion> fs =(List<Funcion>) request.getSession().getAttribute("funciones");
        String selec = request.getParameter("funcion");
        Funcion f = fs.get(Integer.parseInt(selec));
        request.getSession().setAttribute("funcion",  f);
        IOperadorDAO iDAO = context.getBean(OperadorDAOImpl.class);
        ISocioDAO isoc= context.getBean(SocioDAOImpl.class);
        request.getSession().setAttribute("operadores",(List<Operador>) iDAO.listarOperadores());
        request.getSession().setAttribute("clientes",(List<Socio>) isoc.obtenerSocios());
        response.sendRedirect("Factura.jsp");
        
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
