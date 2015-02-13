<%-- 
    Document   : Asiento
    Created on : 12/02/2015, 10:16:23 AM
    Author     : Daniel
--%>

<%@page import="co.com.edu.udea.micine.DAO.impl.LocalidadDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.ILocalidadDAO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="co.com.edu.udea.micine.model.Asiento"%>
<%@page import="co.com.edu.udea.micine.model.Localidad"%>
<%@page import="java.util.List"%>

<%@page import="co.com.edu.udea.micine.model.Funcion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
            if(request.getSession().getAttribute("Recargar") != null && request.getSession().getAttribute("Recargar").equals("SI")){
                %>
                <script>parent.location.reload();</script>
                <%
                request.getSession().setAttribute("Recargar", "NO");
            }
            Funcion f = (Funcion) request.getSession().getAttribute("funcion");
           
            List<Localidad> loc = (List<Localidad>) request.getSession().getAttribute("localidades");
            List<Asiento> lisAs = (List<Asiento>)  request.getSession().getAttribute("asientos");
            Asiento asi =(Asiento) request.getSession().getAttribute("asiento");
            int l= asi.getLocalidad().getIdLocalidad();
            ILocalidadDAO iloca = context.getBean(LocalidadDAOImpl.class);
            Localidad lo = iloca.obtenerLocalidad(l);
            //System.out.print(lisAs.get(0).getId());
            %>
    </head>
    <body >
        <form id="forma" name="forma" action="AsientoServlet" class="form" ></form>
        <form method="get" id="form2" name="form2" action="AnadirAsientoServlet" style="width: 500px; margin: auto">
             
            <% if(f != null && loc != null && lisAs != null){ %>
            <table class="table">
                <tr><td><input type="hidden" name="sala" value="<%=f.getSala().getId().getIdSala() %>" /></td></tr>
                <tr><td><input type="hidden" name="cine" value="<%=f.getSala().getCine().getIdCine() %>" /></td></tr>
                <tr><td>localidad:</td><td>
                        <select name="loca" class="form-control" onchange="document.form2.action = 'AsientoServlet'; document.form2.submit();">
                            <% for(int i=0; i< loc.size(); i++){%>
                            <option value="<%=loc.get(i).getIdLocalidad() %>" <% if(l != 0 && loc.get(i).getIdLocalidad() == l){ %> selected="true"<%} %>><%=loc.get(i).getNombre() %> </option>
                            <% } %>
                        </select>
                            
                    </td></tr>
                <tr><td>Asiento:</td><td>
                        <select name="asiEscogido" >
                            <% for(int i=0; i< lisAs.size(); i++){%>
                            <option value="<%=lisAs.get(i).getId().getIdAsiento() %>" ><%=lisAs.get(i).getId().getIdAsiento() %> </option>
                            <% } %>
                        </select>
                        
                    </td></tr>
            </table>
                        <input type="submit" value="Añadir Asiento" class="btn btn-info"  />
            <%    }else{
                
            }    
            %>
            <input type="button" onclick="document.forma.submit();" />
            </form>
        </form>
    </body>
</html>
