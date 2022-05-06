package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductosDAO;
import dominio.Producto;

public class ControlCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControlCategoria() {
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
       
		
			try {
				ProductosDAO pdao = new ProductosDAO();
				Collection<Producto> productos =(ArrayList<Producto>)pdao.getProductos(request.getParameter("categoria"));
				HttpSession sesion = request.getSession();
				sesion.setAttribute("categoria", request.getParameter("categoria"));
				sesion.setAttribute("productos", productos);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}		
			RequestDispatcher rd = request.getRequestDispatcher("Productos.jsp");
			rd.forward(request, response);
		
		
	}

}
