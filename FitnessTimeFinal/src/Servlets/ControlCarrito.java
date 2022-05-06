package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductosDAO;
import dominio.Carrito;
import dominio.Producto;
import dominio.Usuario;
import servicios.ServicioCarrito;

public class ControlCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControlCarrito() {
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
			 int id = 0;
	         if(request.getParameter("ref")!=null)
	             id = Integer.parseInt(request.getParameter("ref"));
	        ServicioCarrito sc = new ServicioCarrito(request);
	        request.setAttribute("id", id);
	        try {
			sc.comprar(id);
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
			RequestDispatcher rd = request.getRequestDispatcher("Cesta.jsp");
			rd.forward(request, response);
		}
		
	}

}
