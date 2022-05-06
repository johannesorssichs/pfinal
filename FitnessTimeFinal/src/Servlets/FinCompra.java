package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import dominio.*;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.lang.*;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class FinCompra
 */
public class FinCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
            this.processRequest(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	
		}
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		HttpSession sesion = request.getSession();
		Carrito c = (Carrito)sesion.getAttribute("carrito");
		Usuario u = (Usuario)sesion.getAttribute("usuario");
			try
			{
				String usuario = u.getUsuario();
				ComprasDAO cdao = new ComprasDAO();
				cdao.nuevaCompra(c,usuario);
				sesion.setAttribute("carrito", null);
				RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
				rd.forward(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}

}
