<%--
 Document : factura
 Created on : 12/02/2015, 09:05:47 AM
 Author : julianesten
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="co.com.edu.udea.micine.model.Boleta"%>
<%@page import="co.com.edu.udea.micine.model.Funcion"%>
<%@page import="co.com.edu.udea.micine.model.Socio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="co.com.edu.udea.micine.model.Operador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
             <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Factura</title>
 <%
Funcion f = (Funcion) request.getSession().getAttribute("funcion");
 List<Operador> fs = (List<Operador>) request.getSession().getAttribute("operadores");
 List<Boleta> b = (List<Boleta>) request.getSession().getAttribute("boletas");
 boolean temp = false;
 if(b == null || b.isEmpty()){
     temp = true;
     b= new ArrayList<Boleta>();
     request.getSession().setAttribute("boletas", b);
 }
 List<Socio> clie = (List<Socio>) request.getSession().getAttribute("clientes");
 Date fecha = new Date();
 %>
 </head>
 <body>
 <center><h1>Factura de Venta de Boleteria</h1></center>
 
 <center>

     <form method="get" action="FacturaServlet" enctype="multipart/form-data" class="form">
     <table border="0" class="table">
 <tr>
 <td>Fecha Venta: </td>
 <td><%=fecha%></td>
 
 <td>Operador: </td>
 <td><select name ="operador" class="form-control"><%
 
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
  <td><select name ="cliente" class="form-control" style="width: 300px"><%
 
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
<td><select name="estado" class="form-control">
 <option value="pago">Pago</option>
 <option value="reservar">Reservar</option>
 </select></td>
 </tr>
 <tr>
 <td>Fecha función: </td>
 <td><%=fecha%></td>
 
 <td>Tipo de pago: </td>
 <td><select name="tipoPago" class="form-control" style="width: 100px">
 <option value="puntos">Puntos</option>
 <option value="efectivo">Efectivo</option>
 <option value="tarjeta">Tarjeta</option>
 </select></td>
 </tr>
  <%
 
   if(!temp){ %>
   <table class="table" >
            <th>Asientos:</th>
       
<%
 
        for(int i =0 ; i< b.size(); i++){
            %>
            
                <td> <%= b.get(i).getAsiento().getId().getIdAsiento() %></td>
                
            <%
        }
   }
     %>      
                <td colspan="2"><a href="NuevaBoletaServlet">Nueva boleta</a></td>

        </table>
 <tr>
 <td colspan="2">
     <input type="submit" value="Cobrar" class="btn btn-info">
</td>
 </tr>
 </table>

    
 </form>
 
 
 
 
 </center>
</body>
</html>