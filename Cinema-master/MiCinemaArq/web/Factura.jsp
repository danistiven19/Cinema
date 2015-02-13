<%--
 Document : factura
 Created on : 12/02/2015, 09:05:47 AM
 Author : julianesten
--%>

<%@page import="co.com.edu.udea.micine.model.Funcion"%>
<%@page import="co.com.edu.udea.micine.model.Socio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="co.com.edu.udea.micine.model.Operador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Factura</title>
 <%
Funcion f = (Funcion) request.getSession().getAttribute("funcion");
 List<Operador> fs = (List<Operador>) request.getSession().getAttribute("operadores");
 List<Socio> clie = (List<Socio>) request.getSession().getAttribute("clientes");
 Date fecha = new Date();
 %>
 </head>
 <body>
 <center><h1>Factura de Venta de Boleteria</h1></center>
 
 <center>

 <form method="get" action="FacturaServlet" enctype="multipart/form-data">
     <input type="text" value="<%=f.getId().getFecha() %>" />
     <table border="0">
 <tr>
 <td>Fecha Venta: </td>
 <td><%=fecha%></td>
 
 <td>operador: </td>
 <td><select name ="operador"><%
 
        for(int i =0 ; i< fs.size(); i++){
            Operador op = fs.get(i);
            %>
            <option value="<%=op.getIdOperador() %>" ><%=op.getNombre() %></option>
            <%
        }
     %>
     </select>
 </td>
 </tr>
 <tr>
 <td>Cliente: </td>
  <td><select name ="cliente"><%
 
        for(int i =0 ; i< clie.size(); i++){
            Socio so = clie.get(i);
            %>
            <option value="<%=so.getIdSocio() %>" ><%=so.getNombre() %></option>
            <%
        }
     %>
     </select>
 </td>

 <td>Estado: </td>
<td><select name="estado">
 <option value="pago">Pago</option>
 <option value="reservar">Reservar</option>
 </select></td>
 </tr>
 <tr>
 <td>Fecha función: </td>
 <td><%=fecha%></td>
 
 <td>Tipo de pago: </td>
 <td><select name="tipoPago">
 <option value="puntos">Puntos</option>
 <option value="efectivo">Efectivo</option>
 <option value="tarjeta">Tarjeta</option>
 </select></td>
 </tr>
<tr>
    <td colspan="2"><a href="NuevaBoletaServlet">Nueva boleta</a></td>
 </tr>
 <tr>
 <td colspan="2">
 <input type="submit" value="Cobrar">
</td>
 </tr>
 </table>
 </form>
 </center>
</body>
</html>