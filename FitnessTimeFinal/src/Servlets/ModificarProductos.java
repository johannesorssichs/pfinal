package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import dao.ProductosDAO;
import dominio.*;

/**
 * Servlet implementation class ModificarProductos
 */
public class ModificarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductos() {
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
       
		String accion = request.getParameter("action");
		if (accion.equals("Añadir"))
		{
			String nombre = request.getParameter("nombreProd");
			double precio = Double.parseDouble(request.getParameter("precio"));
			String descripcion=request.getParameter("descripcion");
			String categoria=request.getParameter("categoria");
			try
			{
				ProductosDAO pdao=new ProductosDAO();
				pdao.addProducto(nombre, descripcion, precio, categoria);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if (accion.equals("Eliminar Producto"))
		{
			String referencia=request.getParameter("removeProducto");
			int ref=Integer.parseInt(referencia);
			try
			{
				ProductosDAO pdao=new ProductosDAO();
				pdao.eliminarProducto(ref);
				RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
				rd.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		}
		else if (accion.equals("Lanzar Oferta"))
		{
			String precio = request.getParameter("nuevoPrecio");
			double pNuevo = Double.parseDouble(precio);
			String referencia=request.getParameter("ofertaProducto");
			int ref=Integer.parseInt(referencia);
			try
			{
				ProductosDAO pdao=new ProductosDAO();
				String descripcion = "¡OFERTA!";
				pdao.ofertaProducto(ref,pNuevo,descripcion);
				RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
				rd.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(accion.equals("Modificar Producto"))
		{
			String referencia=request.getParameter("modificarProducto");
			int ref=Integer.parseInt(referencia);
			String nombre = request.getParameter("nombreProd");
			String descripcion=request.getParameter("descripcion");
			try
			{
				ProductosDAO pdao=new ProductosDAO();
				pdao.modificarProducto(ref,nombre,descripcion);
				RequestDispatcher rd = request.getRequestDispatcher("Portada.jsp");
				rd.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}

}
