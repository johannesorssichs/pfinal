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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
    	String pwd = request.getParameter("pwd");
    	String mensajeError="";

    	if((request.getParameter("admin")!=null))
    	{
    		if((user.equals("admin"))&&(pwd.equals("admin")))
    		{
    			Usuario usuario = new Usuario("Administrador","admin","admin","","","","","",1);
    			sesion.setAttribute("usuario", usuario);
            	RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
            	rd.forward(request,response);
    		}
    		else
    		{
    			mensajeError="Usuario o Contraseña Incorrectos";
            	request.setAttribute("mensajeError", mensajeError);
                RequestDispatcher dispatcher = request.getRequestDispatcher("InicioSesion.jsp");
                dispatcher.forward(request, response);    			
    		}
    	}
    	else
    	{
        	UsuarioDAO udao = new UsuarioDAO();
        	request.setAttribute("mensajeError", mensajeError);
        	Usuario usuario =(Usuario)udao.getUsuario(user,pwd);
            udao.desconectar();
            if(usuario==null)
            {
            	mensajeError="Usuario o Contraseña Incorrectos";
            	request.setAttribute("mensajeError", mensajeError);
                RequestDispatcher dispatcher = request.getRequestDispatcher("InicioSesion.jsp");
                dispatcher.forward(request, response);
            }
            else {
       
            	sesion.setAttribute("usuario", usuario);
            	RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
            	rd.forward(request,response);
            }
        	
    	}
    		
    	}

    }
