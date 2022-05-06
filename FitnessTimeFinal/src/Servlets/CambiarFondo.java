package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import dominio.*;

public class CambiarFondo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CambiarFondo() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            this.processRequest(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            this.processRequest(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
       
	
		HttpSession sesion = request.getSession();
		Usuario u = (Usuario)sesion.getAttribute("usuario");
		if(u==null){
			RequestDispatcher rd = request.getRequestDispatcher("InicioSesion.jsp");
			rd.forward(request,response);
		}
		else
		{
		
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String fondo = request.getParameter("fondo");
	        Cookie c = new Cookie("colorFondo", fondo);
	        c.setMaxAge(Integer.MAX_VALUE);
	        c.setHttpOnly(true);
	        response.addCookie(c);
	        RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
	        rd.forward(request, response);
		}
	}

}
