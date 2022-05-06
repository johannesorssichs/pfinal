package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import dominio.*;
import java.util.*;
import java.sql.Date;

public class ComprasDAO {
	
		private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	    private static final String URL="jdbc:mysql://127.0.0.1/pat_11?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    private static final String USER = "pat";
	    private static final String PASS = "Patpatpat123-";
	    private static final String QUERY_NUEVACOMPRA = "INSERT INTO compras (unidades,usuario,producto) VALUES (?,?,?)";
	    private static final String QUERY_FECHA = "SELECT fecha, sum(unidades) FROM compras GROUP BY fecha ORDER BY sum(unidades) desc";
	    private static final String QUERY_PRODUCTOS ="SELECT producto, sum(unidades) FROM compras GROUP BY producto ORDER BY sum(unidades) desc";
	    private static final String QUERY_PEDIDOS = "SELECT fecha, producto, unidades FROM compras WHERE usuario = ?";
	    
	    private Connection con;
	    
	    public ComprasDAO() throws SQLException, ClassNotFoundException
	    {
	    	Class.forName(DRIVER);
	        con=DriverManager.getConnection(URL,USER,PASS);
	    }
	    
	    public void nuevaCompra(Carrito c, String usuario) throws SQLException
	    { 
	    	HashMap<Producto,Integer> productos = c.getProductos();

	    	for(Map.Entry<Producto, Integer> mapa : productos.entrySet())
	    	{
	    		Producto p = mapa.getKey();
	    		int ref = p.getReferencia();
	    		int uds = mapa.getValue();
	    		PreparedStatement pstm = con.prepareStatement(QUERY_NUEVACOMPRA);
	    		pstm.setInt(1, uds);
	    		pstm.setString(2,usuario);
	    		pstm.setInt(3, ref);
	    		pstm.executeUpdate();	    		
	    	}
	    }
	    public HashMap diasCompras() throws SQLException
	    {
	    	HashMap<java.sql.Date,Integer> mapa = new HashMap();
	    	PreparedStatement pstm = con.prepareStatement(QUERY_FECHA);
	    	ResultSet rs = pstm.executeQuery();
	    	while(rs.next())
	    	{
	    		mapa.put(rs.getDate(1), rs.getInt(2));
	    	}
	    	return mapa;	    	
	    }
	    public HashMap<Producto,Integer> productosCompras() throws SQLException, ClassNotFoundException
	    {
	    	HashMap<Producto,Integer> mapa = new HashMap();
	    	ProductosDAO pdao = new ProductosDAO();
	    	PreparedStatement pstm = con.prepareStatement(QUERY_PRODUCTOS);
	      	ResultSet rs = pstm.executeQuery();
	    	while(rs.next())
	    	{
	    		Producto p=pdao.buscarProd(rs.getInt(1));
	    		mapa.put(p, rs.getInt(2));
	    	}
	    	return mapa;
	    }
	   public ArrayList<Historial> historialCompras(String usuario) throws SQLException, ClassNotFoundException
	   {
	    	PreparedStatement pstm = con.prepareStatement(QUERY_PEDIDOS);
	    	pstm.setString(1, usuario);
	    	ResultSet rs = pstm.executeQuery();
	    	ProductosDAO pdao = new ProductosDAO();
	    	ArrayList<Historial> compras = new ArrayList();
	    	while(rs.next())
	    	{
	    		java.sql.Date fecha = rs.getDate(1);
	    		int ref = rs.getInt(2);
	    		Producto p = pdao.buscarProd(ref);
	    		int uds = rs.getInt(3);
	    		Historial h = new Historial(fecha,p,uds);
	    		compras.add(h);
	    	}
	    	return compras;
	    }
 
}
