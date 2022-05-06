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
import dao.UsuarioDAO;
import dominio.Usuario;

/**
 * Servlet implementation class ModificarDatos
 */
public class ModificarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatos() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		String accion =(String)request.getParameter("accion");
		HttpSession sesion = request.getSession();
		String u = ((Usuario)sesion.getAttribute("usuario")).getUsuario();
		if(accion!=null)
		{
			if(accion.equals("eliminar"))
			{
				try {
					UsuarioDAO udao = new UsuarioDAO();
					udao.eliminarUsuario(u);
					sesion.setAttribute("usuario", null);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
			    rd.forward(request,response);
					
				
			}
		}
		else
		{
			String pwd = request.getParameter("pwd");
			try {
			UsuarioDAO udao = new UsuarioDAO();
			udao.cambioPwd(u, pwd);	
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
	    	rd.forward(request,response);
		}
		
    	
    	
	}

}
