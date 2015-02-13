<%--
    Document   : Boleta
    Created on : 12-feb-2015, 10:06:06
    Author     : sisaza92
--%>

<%@page import="co.com.edu.udea.micine.model.Boleta"%>
<%@page import="co.com.edu.udea.micine.model.Asiento"%>
<%@page import="co.com.edu.udea.micine.DAO.impl.LocalidadDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.ILocalidadDAO"%>
<%@page import="co.com.edu.udea.micine.DAO.IFormatoDAO"%>
<%@page import="co.com.edu.udea.micine.DAO.impl.FormatoDAOImpl"%>
<%@page import="co.com.edu.udea.micine.model.Tarifa"%>
<%@page import="co.com.edu.udea.micine.DAO.ITarifaDAO"%>
<%@page import="co.com.edu.udea.micine.DAO.impl.TarifaDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.impl.SalaDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.ISalaDAO"%>
<%@page import="co.com.edu.udea.micine.model.Sala"%>
<%@page import="co.com.edu.udea.micine.model.FuncionId"%>
<%@page import="co.com.edu.udea.micine.DAO.impl.CineDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.ICineDAO"%>
<%@page import="co.com.edu.udea.micine.DAO.impl.PeliculaDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.IPeliculaDAO"%>
<%@page import="java.util.List"%>
<%@page import="co.com.edu.udea.micine.DAO.impl.FuncionDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.IFuncionDAO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="co.com.edu.udea.micine.model.Funcion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boleteria</title>
        <%
            //request.getSession().setAttribute("AsientoEscogido", null);
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
            Funcion f = (Funcion) request.getSession().getAttribute("funcion");
            if(f == null){
               /* IFuncionDAO fDAO =context.getBean(FuncionDAOImpl.class);
                List<Funcion> listf = fDAO.obtenerFunciones();
                f = listf.get(0);
                request.getSession().setAttribute("funcion", f);*/
                
            }
            
            request.setAttribute("boletas", (List<Boleta>) request.getSession().getAttribute("boletas"));
            
            
            IPeliculaDAO ipDAO = context.getBean(PeliculaDAOImpl.class);
            f.setPelicula(ipDAO.obtenerPelicula(f.getPelicula().getIdPelicula()));
            
            ILocalidadDAO iloc = context.getBean(LocalidadDAOImpl.class);
            IFormatoDAO ifor = context.getBean(FormatoDAOImpl.class);
            ITarifaDAO it = context.getBean(TarifaDAOImpl.class);
            
            f.setTarifa(it.obtenerTarifa(f.getTarifa().getIdTarifa()));
            Tarifa t = f.getTarifa();
            t.setFormato(ifor.obtenerFormato(t.getIdTarifa()));
            t.setLocalidad(iloc.obtenerLocalidad(t.getLocalidad().getIdLocalidad()));
            f.setTarifa(t);
            ISalaDAO isala = context.getBean(SalaDAOImpl.class);
            f.setSala(isala.obtenerSala(f.getSala().getId()));
            request.getSession().setAttribute("localidad", Integer.toString(t.getLocalidad().getIdLocalidad()));
            ICineDAO icine = context.getBean(CineDAOImpl.class);
            Sala sal = f.getSala();
            sal.setCine(icine.obtenerCine(sal.getCine().getIdCine()));
            f.setSala(sal);
            
            
    
            %>
    </head>
    <body>
        <h1 align="center">Boleta</h1>
        <form method="post" action="AnadirBoletaServlet" class="form">
            <table align="center" class="table">
                <tr>
                    <td>Pelicula </td><td><input type="text" value="<%=f.getPelicula().getNombre() %>"</td>
                <input type="hidden" value="<%=f.getPelicula().getIdPelicula() %>" name="pelicula" />
                </tr>
                <tr>
                    <td>Función:</td>
                <tr><td>Sala:<input type="text" value = "<%=f.getSala().getId().getIdSala() %>" /></td><td>Cine</td><td><input type="text" value="<%=f.getSala().getCine().getNombre() %>"</td>
                <tr>
                    <td>Fecha:</td><td><input type="text" name="fecha" value="<%=f.getId().getFecha() %>" /></td><td>Formato</td><td><input type="text" value="<%=f.getTarifa().getFormato().getNombre() %>" /></td>
                </tr>
               <!-- <tr>
                     <td>Localidad:</td><td><input type="text" value="<%=f.getTarifa().getLocalidad().getNombre() %>" /></td>
                </tr>-->
                <tr>
                    <td>Valor:</td><td></td>
                </tr>
                <tr>
               
                </tr>
                <tr>
                   
                </tr>
            </table>
                 <% 
                    Asiento asiEsc = (Asiento) request.getSession().getAttribute("AsientoEscogido");
                    
                    if (asiEsc == null){ %>
                    
                    <td colspan="2" ><iframe style="height: 230px; width: 500px ; overflow-x: hidden;"  src="Asiento.jsp" width="300"/></td>
                    <% }else{ asiEsc.setSala(isala.obtenerSala(f.getSala().getId()));%>
                    
                    <td>Sala:</td><td><input name="sala" type="text" value="<%=asiEsc.getSala().getId().getIdSala() %>"/></td>
                    <td>Localidad:</td><td><input name="localidad" type="text" value="<%=asiEsc.getId().getLocalidadIdLocalidad() %>" /></td>
                    <td>Asiento :</td><td><input name="asiento" type="text" value="<%=asiEsc.getId().getIdAsiento() %>" /></td><td><input type="button" value="Cambiar" class="btn btn-info" onclick="<% request.getSession().setAttribute("AsientoEscogido", null);  %> window.location.reload();  " /></td>
                <input type="hidden" name="cine" value="<%=asiEsc.getSala().getCine().getIdCine() %>" />
                    <% } %>
                    <br/>
                    <br/>
                    <br/>
                    <center><input type="submit" class="btn btn-info" /></center>
        </form>
    </body>
</html>