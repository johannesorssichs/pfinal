package servicios;

import dominio.Carrito;
import dominio.Producto;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ProductosDAO;

public class ServicioCarrito {
	
	private HttpServletRequest request;
    private Carrito carrito;
    
    public ServicioCarrito (HttpServletRequest request)
    {
        this.request = request;
        carrito = this.getCarrito();
    }
	
    private Carrito getCarrito()
    {
        HttpSession sesion = request.getSession();
        carrito = (Carrito) sesion.getAttribute("carrito");

        if (carrito==null)
        {
            carrito = new Carrito(); 
            sesion.setAttribute("carrito", carrito);
        }
        
        return carrito;
    }
    
    public void comprar(int id) throws ClassNotFoundException, SQLException
    {
        ProductosDAO dao = new ProductosDAO();

        Producto p = null;
        p = dao.buscarProd(id);
        
        if(p!=null)
            getCarrito().addProducto(p);
    }

}
