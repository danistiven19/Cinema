package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import co.com.edu.udea.micine.DAO.impl.PeliculaDAOImpl;
import co.com.edu.udea.micine.DAO.IPeliculaDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import co.com.edu.udea.micine.model.Funcion;

public final class Funcion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Funcion</title>\r\n");
      out.write("        ");

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("co/com/edu/udea/micine/util/springConf.xml");
           
            
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body style=\"width:1024px; margin: auto\">\r\n");
      out.write("       \r\n");
      out.write("        <h1>Seleccione una ciudad para consular funciones:</h1>\r\n");
      out.write("            <form action=\"FuncionServlet\" method=\"post\">\r\n");
      out.write("                <select name=\"ciudad\" id=\"ciudad\">\r\n");
      out.write("                    <option value=\"Medellin\">Medellín</option>\r\n");
      out.write("                    <option value=\"Cali\">Cali</option>\r\n");
      out.write("                    <option value=\"Bogota\">Bógota</option>\r\n");
      out.write("                    <option value=\"Barranquilla\">Barranquilla</option>\r\n");
      out.write("                    <option value=\"Cartagena\">Cartagena</option>\r\n");
      out.write("                    <option value=\"Cucuta\">Cucuta</option>\r\n");
      out.write("                    <option value=\"Bucaramanga\">Bucaramanga</option>\r\n");
      out.write("                    <option value=\"Valledupar\">Valledupar</option>\r\n");
      out.write("                    <option value=\"Manizales\">Manizales</option>\r\n");
      out.write("                    <option value=\"Neiva\">Neiva</option>\r\n");
      out.write("                </select>\r\n");
      out.write("                <input type=\"submit\" name=\"consultar\" value=\"Cargar\" />\r\n");
      out.write("            </form>\r\n");
      out.write("     \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
