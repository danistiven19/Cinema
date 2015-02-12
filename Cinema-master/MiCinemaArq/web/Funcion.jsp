<%-- 
    Document   : Funcion
    Created on : 11/02/2015, 11:41:41 PM
    Author     : julianesten
--%>

<%@page import="co.com.edu.udea.micine.DAO.impl.PeliculaDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.IPeliculaDAO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="java.util.List"%>
<%@page import="co.com.edu.udea.micine.model.Funcion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcion</title>
        <%
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
           
            %>
    </head>
    <body style="width:1024px; margin: auto">
       
        <h1>Seleccione una ciudad para consular funciones:</h1>
            <form action="FuncionServlet" method="post">
                <select name="ciudad" id="ciudad">
                    <option value="Medellin">Medellín</option>
                    <option value="Cali">Cali</option>
                    <option value="Bogota">Bógota</option>
                    <option value="Barranquilla">Barranquilla</option>
                    <option value="Cartagena">Cartagena</option>
                    <option value="Cucuta">Cucuta</option>
                    <option value="Bucaramanga">Bucaramanga</option>
                    <option value="Valledupar">Valledupar</option>
                    <option value="Manizales">Manizales</option>
                    <option value="Neiva">Neiva</option>
                </select>
                <input type="submit" name="consultar" value="Cargar" />
            </form>
     
    </body>
</html>
