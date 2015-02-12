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
            String l= (String) request.getSession().getAttribute("localidad");
            ILocalidadDAO iloca = context.getBean(LocalidadDAOImpl.class);
            Localidad lo = iloca.obtenerLocalidad(Integer.parseInt(l));
            //System.out.print(lisAs.get(0).getId());
            %>
    </head>
    <body >
<form id="forma" name="forma" action="AsientoServlet" ></form>
        <form method="get" id="form2" name="form2" action="AnadirAsientoServlet" style="width: 500px; margin: auto">
             
            <% if(f != null && loc != null && lisAs != null){ %>
            <table>
                <tr><td>Sala:</td><td><%=f.getSala().getId().getIdSala() %></td></tr>
                <tr><td>localidad:</td><td>
                        <!--<select name="loca" onchange="document.form2.action = 'AsientoServlet'; document.form2.submit();">
                            <% for(int i=0; i< loc.size(); i++){%>
                            <option value="<%=loc.get(i).getIdLocalidad() %>" <% if(request.getSession().getAttribute("localidad") != null && loc.get(i).getIdLocalidad() == Integer.parseInt((String)request.getSession().getAttribute("localidad"))){ %> selected="true"<%} %>><%=loc.get(i).getNombre() %> </option>
                            <% } %>
                        </select>-->
                            <input type="text" value="<%=lo.getNombre() %>" />
                    </td></tr>
                <tr><td>Asiento:</td><td>
                        <select name="asiEscogido" >
                            <% for(int i=0; i< lisAs.size(); i++){%>
                            <option value="<%=lisAs.get(i).getId().getIdAsiento() %>" ><%=lisAs.get(i).getId().getIdAsiento() %> </option>
                            <% } %>
                        </select>
                        
                    </td></tr>
            </table>
                        <input type="submit" value="Añadir Asiento"  />
            <%    }else{
                
            }    
            %>
            <input type="button" onclick="document.forma.submit();" />
            </form>
        </form>
    </body>
</html>
