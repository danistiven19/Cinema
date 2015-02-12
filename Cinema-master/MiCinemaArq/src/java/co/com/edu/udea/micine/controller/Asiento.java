/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.edu.udea.micine.controller;

import co.com.edu.udea.micine.DAO.IAsientoDAO;
import co.com.edu.udea.micine.DAO.IFuncionDAO;
import co.com.edu.udea.micine.DAO.ILocalidadDAO;
import co.com.edu.udea.micine.DAO.impl.AsientoDAOImpl;
import co.com.edu.udea.micine.DAO.impl.FuncionDAOImpl;
import co.com.edu.udea.micine.DAO.impl.LocalidadDAOImpl;
import co.com.edu.udea.micine.model.Funcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
public class Asiento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       /* String localidad = request.getParameter("loca");
        
        Funcion f = (Funcion) request.getSession().getAttribute("funcion");
        if(f == null){
            IFuncionDAO fDAO = context.getBean(FuncionDAOImpl.class);
            List<Funcion> listf = fDAO.obtenerFunciones();
            f = fDAO.obtenerFuncion(listf.get(0).getId());
            request.getSession().setAttribute("funcion",f);
        }
        
        ILocalidadDAO ilocal = context.getBean(LocalidadDAOImpl.class);
        if(ilocal != null){
            request.getSession().setAttribute("localidades", ilocal.obtenerLocalidades());
        }
        IAsientoDAO iAsiento = context.getBean(AsientoDAOImpl.class);
        List<Asiento> listAs = iAsiento.obtenerAsientoPorSala(f.getSala().getId());
        //System.out.println(listAs.get(0).getId().getIdAsiento());
        if(localidad != null && !localidad.equals("")){
            request.getSession().setAttribute("localidad", localidad);
            List<Asiento> def = new ArrayList<Asiento>();
            Iterator it = listAs.iterator();
            while(it.hasNext()){
                Asiento as = (Asiento) it.next();
                if(as.getLocalidad().getIdLocalidad() == Integer.parseInt(localidad)){
                    def.add(as);
                }
            }
            request.getSession().setAttribute("asientos", def);
        }else{
            request.getSession().setAttribute("asientos", listAs);
        }
        
       response.sendRedirect("Asiento.jsp");*/
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
