package dao;
import java.sql.*;
import dominio.Producto;
import java.util.*;
public class ProductosDAO {
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1/pat_11?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "pat";
    private static final String PASS = "Patpatpat123-";
    private static final String QUERY_BUSCAR = "SELECT * FROM producto WHERE ref = ?";
    private static final String QUERY_TODOS = "SELECT * FROM producto";
    private static final String QUERY_SELECT_ALL = "SELECT * FROM producto WHERE categoria = ?";
    private static final String QUERY_INSERTAR = "INSERT INTO producto (ref,nombre,descripcion,categoria,precio) VALUES (?,?,?,?,?)";
    private static final String QUERY_CUENTA_FILAS = "SELECT count(*) FROM producto";
    private static final String QUERY_ELIMINAR = "DELETE from producto WHERE ref = ?";
    private static final String QUERY_OFERTA = "UPDATE producto SET descripcion = ?, precio = ? WHERE ref = ?";
    private static final String QUERY_MODIFICAR = "UPDATE producto SET descripcion = ?, nombre = ? WHERE ref = ?";
    
    private Connection con;
    
    public ProductosDAO() throws SQLException, ClassNotFoundException
    {
    	Class.forName(DRIVER);
        con=DriverManager.getConnection(URL,USER,PASS);
    }
    public ArrayList<Producto> getTodos() throws SQLException
    {
    	ArrayList<Producto> ps = new ArrayList();
    	PreparedStatement pstmt = con.prepareStatement(QUERY_TODOS);
    	ResultSet rs = pstmt.executeQuery();
    	while(rs.next())
        {
       	 int id = rs.getInt(1);
       	 String nombre = rs.getString(2);
       	 String desc = rs.getString(3);
       	 String categoria = rs.getString(4);
       	 double precio = rs.getDouble(5);
       	 Producto p = new Producto(nombre,id,desc,precio,categoria);
       	 ps.add(p);
        }
    	return ps;
    }
    public Producto buscarProd(int ref) throws SQLException
    {
    	 Producto p = null;
    	 PreparedStatement pstmt = con.prepareStatement(QUERY_BUSCAR);
         pstmt.setInt(1,ref);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
        	 int id = rs.getInt(1);
        	 String nombre = rs.getString(2);
        	 String desc = rs.getString(3);
        	 String categoria = rs.getString(4);
        	 double precio = rs.getDouble(5);
        	 p = new Producto(nombre,ref,desc,precio,categoria);
         }
         return p;         
         
    }
    public Collection<Producto> getProductos(String categoria) throws SQLException
    {
    	Collection<Producto>ps=new ArrayList();
    	PreparedStatement pstmt = con.prepareStatement(QUERY_SELECT_ALL);
    	pstmt.setString(1,categoria);
    	ResultSet rs = pstmt.executeQuery();
    	while(rs.next())
    	{
    		int ref = rs.getInt(1);
    		String nombre = rs.getString(2);
    		String desc = rs.getString(3);
    		double precio = rs.getDouble(5);
    		Producto p = new Producto(nombre,ref,desc,precio,categoria);
    		ps.add(p);
    	}
    	return ps;
    }
    public int contarFilas() throws SQLException
    {
    	PreparedStatement pstmt = con.prepareStatement(QUERY_CUENTA_FILAS);
    	ResultSet rs = pstmt.executeQuery();
    	int n = 1;
    	if(rs.next()) {
    	  //Si hay resultados obtengo el valor. 
    	  n= rs.getInt(1);
    	  }
    	n=n+2;
    	return n;
    	
    }
    public void addProducto(String nombre, String descripcion, double precio, String categoria) throws SQLException
    {
    	int n = this.contarFilas();
    	PreparedStatement pstmt = con.prepareStatement(QUERY_INSERTAR);
    	pstmt.setInt(1,n);
    	pstmt.setString(2,nombre);
    	pstmt.setString(3,descripcion);
    	pstmt.setString(4,categoria);
    	pstmt.setDouble(5,precio);
    	pstmt.executeUpdate();
    }
    public void eliminarProducto(int ref) throws SQLException
    {
    	PreparedStatement pstmt = con.prepareStatement(QUERY_ELIMINAR);
    	pstmt.setInt(1, ref);
    	pstmt.executeUpdate();
    }
    public void ofertaProducto(int ref, double precio, String d) throws SQLException
    {
    	PreparedStatement pstmt = con.prepareStatement(QUERY_OFERTA);
    	pstmt.setString(1, d);
    	pstmt.setDouble(2,precio);
    	pstmt.setInt(3, ref);
    	pstmt.executeUpdate();
    	
    }
    public void modificarProducto(int ref, String nombre, String d) throws SQLException
    {
    	PreparedStatement pstmt = con.prepareStatement(QUERY_MODIFICAR);
    	pstmt.setString(1, d);
    	pstmt.setString(2,nombre);
    	pstmt.setInt(3, ref);
    	pstmt.executeUpdate();
    	
    }
    

    
   

}
