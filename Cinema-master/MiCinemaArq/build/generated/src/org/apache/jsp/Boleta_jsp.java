package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.com.edu.udea.micine.model.Asiento;
import co.com.edu.udea.micine.DAO.impl.LocalidadDAOImpl;
import co.com.edu.udea.micine.DAO.ILocalidadDAO;
import co.com.edu.udea.micine.DAO.IFormatoDAO;
import co.com.edu.udea.micine.DAO.impl.FormatoDAOImpl;
import co.com.edu.udea.micine.model.Tarifa;
import co.com.edu.udea.micine.DAO.ITarifaDAO;
import co.com.edu.udea.micine.DAO.impl.TarifaDAOImpl;
import co.com.edu.udea.micine.DAO.impl.SalaDAOImpl;
import co.com.edu.udea.micine.DAO.ISalaDAO;
import co.com.edu.udea.micine.model.Sala;
import co.com.edu.udea.micine.model.FuncionId;
import co.com.edu.udea.micine.DAO.impl.CineDAOImpl;
import co.com.edu.udea.micine.DAO.ICineDAO;
import co.com.edu.udea.micine.DAO.impl.PeliculaDAOImpl;
import co.com.edu.udea.micine.DAO.IPeliculaDAO;
import java.util.List;
import co.com.edu.udea.micine.DAO.impl.FuncionDAOImpl;
import co.com.edu.udea.micine.DAO.IFuncionDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import co.com.edu.udea.micine.model.Funcion;

public final class Boleta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Boleteria</title>\r\n");
      out.write("        ");

            //request.getSession().setAttribute("AsientoEscogido", null);
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
            Funcion f = (Funcion) request.getSession().getAttribute("funcion");
            if(f == null){
               /* IFuncionDAO fDAO =context.getBean(FuncionDAOImpl.class);
                List<Funcion> listf = fDAO.obtenerFunciones();
                f = listf.get(0);
                request.getSession().setAttribute("funcion", f);*/
                
            }
            
            
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
            
            
    
            
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1 align=\"center\">Boleta</h1>\r\n");
      out.write("        <form method=\"post\" action=\"AnadirBoletaServlet\">\r\n");
      out.write("        <table align=\"center\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Pelicula </td><td><input type=\"text\" value=\"");
      out.print(f.getPelicula().getNombre() );
      out.write("\"</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Función:</td><td>Sala:<input type=\"text\" value = \"");
      out.print(f.getSala().getId().getIdSala() );
      out.write("\" /></td><td>Cine</td><td><input type=\"text\" value=\"");
      out.print(f.getSala().getCine().getNombre() );
      out.write("\"</td>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Fecha:</td><td><input type=\"text\" value=\"");
      out.print(f.getId().getFecha() );
      out.write("\" /></td><td>Formato</td><td><input type=\"text\" value=\"");
      out.print(f.getTarifa().getFormato().getNombre() );
      out.write("\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("               <!-- <tr>\r\n");
      out.write("                     <td>Localidad:</td><td><input type=\"text\" value=\"");
      out.print(f.getTarifa().getLocalidad().getNombre() );
      out.write("\" /></td>\r\n");
      out.write("                </tr>-->\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Valor:</td><td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                ");
 
                    Asiento asiEsc = (Asiento) request.getSession().getAttribute("AsientoEscogido");
                    if (asiEsc == null){ 
      out.write("\r\n");
      out.write("                    <td colspan=\"2\" ><iframe style=\"overflow-x: hidden;\"  src=\"Asiento.jsp\" width=\"300\"/></td>\r\n");
      out.write("                    ");
 }else{ 
      out.write("\r\n");
      out.write("                    <td>Sala:</td><td><input type=\"text\" value=\"");
      out.print(asiEsc.getSala().getId().getIdSala() );
      out.write("\"/></td>\r\n");
      out.write("                    <td>Localidad:</td><td><input type=\"text\" value=\"");
      out.print(asiEsc.getId().getLocalidadIdLocalidad() );
      out.write("\" /></td>\r\n");
      out.write("                    <td>Asiento :</td><td><input type=\"text\" value=\"");
      out.print(asiEsc.getId().getIdAsiento() );
      out.write("\" /></td><td><input type=\"button\" value=\"Cambiar\" onclick=\"");
 request.getSession().setAttribute("AsientoEscogido", null);  
      out.write(" window.location.reload();  \" /></td>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><input type=\"submit\"  value=\"Guardar\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
