<%-- 
    Document   : factura
    Created on : 12/02/2015, 09:05:47 AM
    Author     : julianesten
--%>

<%@page import="java.util.Date"%>
<%@page import="co.com.edu.udea.micine.model.Operador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura</title>
         <%
           Operador fs = new Operador();
           Date fecha = new Date();
       %>
    </head>
    <body>
        <h1>Factura de Venta de Boleteria</h1>
        <table border="0">
            <tr>
                <td colspan="2"><form method="get" action="FuncionServlet" enctype="multipart/form-data"><input type="submit" value="Seleccionar Funcion"></form></td>
            </tr>
            <tr>
                <td colspan="2"><form method="get" action="BoletaServlet" enctype="multipart/form-data"><input type="submit" value="Nueva boleta"></form></td>
            </tr>                   
        </table>
    <center>

        <form method="get" action="FacturaServlet" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Fecha Venta: </td>
                    <td><%=fecha%></td>
                </tr>
                <tr>
                    <td>operador: </td>
                    <td><%= fs.getNombreUsuario() %></td>
                </tr>      
                <tr>
                    <td>Cliente: </td>
                    <td><input type="text" name="cliente" size="50"/></td>
                </tr>
                <tr>                
                <tr>
                    <td>Estado: </td>
                    <td><select name="estado">
                            <option value="pago">Pago</option>
                            <option value="reservar">Reservar</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Funcion a ver: </td>
                    <td><%=fecha%></td>
                </tr>                
                <tr>
                    <td>Tipo de pago: </td>
                    <td><select name="tipoPago">
                            <option value="puntos">Puntos</option>
                            <option value="efectivo">Efectivo</option>
                            <option value="tarjeta">Tarjeta</option>
                        </select></td>
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
