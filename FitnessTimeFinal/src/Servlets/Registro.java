package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
 * Servlet implementation class Registro
 */
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
    	String user = request.getParameter("user");
    	String nombre = request.getParameter("nombre");
    	String pwd = request.getParameter("pwd");
    	String movil = request.getParameter("movil");
    	String dir = request.getParameter("dir");
    	String cp = request.getParameter("cp");
    	String ciudad = request.getParameter("ciudad");
    	String provincia=request.getParameter("provincia");
    	String mensajeError = "";
    	
    	Usuario u = new Usuario(nombre,user,dir,movil,ciudad,cp,provincia,pwd,0);
    	try {
	    	UsuarioDAO udao = new UsuarioDAO();
	    	udao.addUsuario(u);
	    	sesion.setAttribute("usuario", u);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("Portada.jsp");
	    	dispatcher.forward(request, response);
    	}
    	catch(SQLIntegrityConstraintViolationException e)
		{
			mensajeError = "Ese usuario ya existe";
			request.setAttribute("mensajeError",mensajeError);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Registro.jsp");
	    	dispatcher.forward(request, response); 
						
		}
    	
    	//sesion.setAttribute("usuario", u);
    	//RequestDispatcher dispatcher = request.getRequestDispatcher("Portada.jsp");
    	//dispatcher.forward(request, response);   	
    }
}