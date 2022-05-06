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
import servicios.ServicioCarrito;
import dominio.*;
import dao.*;
import java.util.*;

/**
 * Servlet implementation class ControlVistas
 */
public class ControlVistas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlVistas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		// TODO Auto-generated method stub
		try {
            this.processRequest(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		if(opcion.equals("home"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("FotosInicio.jsp");
			rd.forward(request, response);
		}
		else if(opcion.equals("login"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("InicioSesion.jsp");
			rd.forward(request, response);
		}
		else if(opcion.equals("registro"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Registro.jsp");
			rd.forward(request, response);
		}
		else if(opcion.equals("pagar"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Cesta.jsp");
			rd.forward(request, response);
		}
		else if(opcion.equals("perfil"))
		{
			HttpSession sesion = request.getSession();
			Usuario u = (Usuario)sesion.getAttribute("usuario");
			//String user = u.getUsuario();
			if(u.getAdmin()==0)
			{
				try {
					String user = u.getUsuario();
					ComprasDAO cdao = new ComprasDAO();
					ArrayList<Historial> historial = cdao.historialCompras(user);
					sesion.setAttribute("historial", historial);	
					RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
					rd.forward(request, response);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				try {
					ComprasDAO cdao = new ComprasDAO();
					ProductosDAO pdao = new ProductosDAO();
					HashMap mapaP = cdao.productosCompras();
					sesion.setAttribute("productosPopulares", mapaP);
					HashMap mapaC = cdao.diasCompras();
					sesion.setAttribute("diasPopulares", mapaC);
					ArrayList<Producto> todos = pdao.getTodos();
					sesion.setAttribute("todosProductos", todos);
					RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
					rd.forward(request, response);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
			
		}
	}

}
