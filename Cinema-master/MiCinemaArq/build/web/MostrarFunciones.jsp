
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="co.com.edu.udea.micine.DAO.impl.PeliculaDAOImpl"%>
<%@page import="co.com.edu.udea.micine.DAO.IPeliculaDAO"%>
<%@page import="co.com.edu.udea.micine.model.Funcion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funciones Por Ciudad</title>
        <%
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
           List<Funcion> fs =(List<Funcion>) request.getSession().getAttribute("funciones");
       %>
    </head>
    <body>
        <h1>Funciones Por Ciudad</h1>
        <form method="post" action="SeleccionarFuncionServlet" class="form">
            <table class="table " >
            <th>Cine</th>
            <th>Pelicula</th>
            <th>Estado</th>
            <th>Fecha</th>
            <%
           if(fs.isEmpty()){
               %>
            <h1>Vacio</h1>
            <%
           }
            IPeliculaDAO ipeli = context.getBean(PeliculaDAOImpl.class);
            
                for(int i = 0; i< fs.size() ; i++){
                    Funcion f = fs.get(i);
                    f.setPelicula(ipeli.obtenerPelicula(f.getPelicula().getIdPelicula()));
                    %>
            <tr>
                <td><%=f.getSala().getCine().getNombre() %></td>
                <td><%=f.getPelicula().getNombre() %></td>
                <td><% if(f.getEstado().equals("true")){ %> Disponible  <% }else{ %> No disponible <% } %></td>
                <td><%=f.getId().getFecha() %></td>
                <td><input type="radio" name="funcion" value="<%=i   %>" /></td>
            </tr>
                    <%
                }
                %>
        </table>
        <input type="submit"  value="Seleccionar" class="btn btn-info" />
        </form>
    </body>
</html>


