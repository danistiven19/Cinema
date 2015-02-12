<%-- 
    Document   : Funcion
    Created on : 11/02/2015, 11:41:41 PM
    Author     : julianesten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcion</title>
    </head>
    <body>
        <h1>Seleccione una ciudad para consular funciones:</h1>
        
            <form action="cliente" method="post">
                <select name="seleccion">
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
                <input type="submit" name="consultar" value="Consultar Funcion" />
            </form>
    </body>
</html>
