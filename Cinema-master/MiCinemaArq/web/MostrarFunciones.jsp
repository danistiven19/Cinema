
<%@page import="co.com.edu.udea.micine.model.Funcion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funciones Por Ciudad</title>
        <%
           List<Funcion> fs =(List<Funcion>) request.getSession().getAttribute("funciones");
       %>
    </head>
    <body>
        <h1>Funciones Por Ciudad</h1>
        <form method="get" action="Factura.jsp" enctype="multipart/form-data">
           <table style="width:100%" border="1">
              <tr>
                <td>Id Funcion</td>
                <td>Pelicula</td>
                <td>Hora</td>		
                <td>Tarifa</td>
                <td>Estado</td>
              </tr>
              <% for (int i = 0; i < fs.size(); i++) {%>
              <td><input type="checkbox" name="pelicula" value="pelicula"><%= fs.get(i).getId() %></td>
              <td><%= fs.get(i).getPelicula().getNombre() %></td>
              <td><%= fs.get(i).getId().getFecha() %></td>
              <td><%= fs.get(i).getTarifa().getValor() %></td>
              <td><%= fs.get(i).getEstado() %></td>
              <% }%>  

            </table>
               <input type="submit" value="Confirmar funcion">
              </form>
    </body>
</html>


