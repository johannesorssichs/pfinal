package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.Usuario;

public class UsuarioDAO {
	
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1/pat_11?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "pat";
    private static final String PASS = "Patpatpat123-";
    private static final String QUERY_INSERTAR = "INSERT INTO usuarios (usuario,password,nombre,direccion,telf,ciudad,cp,provincia) VALUES (?,?,?,?,?,?,?,?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM usuarios WHERE usuario = ?";
    private static final String QUERY_CAMBIOPWD = "UPDATE usuarios SET password = ? WHERE usuario = ?";
    private static final String QUERY_ELIMINAR = "DELETE from usuarios WHERE usuario = ?";
    
    Connection conexion;
    
    public UsuarioDAO() throws SQLException, ClassNotFoundException
    {
    	Class.forName(DRIVER);
        conexion=DriverManager.getConnection(URL,USER,PASS);
    }
	
	public Usuario getUsuario(String u, String pwd) throws SQLException {
	        PreparedStatement pstmt = conexion.prepareStatement(QUERY_BUSCAR);
	        pstmt.setString(1,u);
	        ResultSet rs = pstmt.executeQuery();
	        Usuario user=null;
	        while(rs.next())
	        {
	        	if(rs.getString(1).equals(u))
	        	{
	        		if(rs.getString(2).contentEquals(pwd))
	        		{
	        			String usuario=rs.getString(1);
	        			String pass=rs.getString(2);
	        			String nombre=rs.getString(3);
	        			String dir=rs.getString(4);
	        			String t=rs.getString(5);
	        			String ciudad=rs.getString(6);
	        			String cp=rs.getString(7);
	        			String prov=rs.getString(8);
	        			
	        			user=new Usuario(nombre,usuario,dir,t,ciudad,cp,prov,pass,0);
	        			
	        			return user; 
	        		}else
	        		{
	        			return user;
	        		}
	        	}
	        }
	        return user;       
	    }
    public void desconectar() throws SQLException {
        conexion.close();
    }
    public void addUsuario(Usuario u) throws SQLException
    {
    	PreparedStatement pstmt = conexion.prepareStatement(QUERY_INSERTAR);
        pstmt.setString(1,u.getUsuario());
        pstmt.setString(2,u.getPassword());
        pstmt.setString(3, u.getNombre());
        pstmt.setString(4,u.getDireccion());
        pstmt.setString(5,u.getTelf());
        pstmt.setString(6, u.getCiudad());
        pstmt.setString(7,u.getCP());
        pstmt.setString(8, u.getProvincia());
        pstmt.executeUpdate();
    }
    public void cambioPwd(String u,String pwd) throws SQLException
    {
    	PreparedStatement pstmt = conexion.prepareStatement(QUERY_CAMBIOPWD);
    	pstmt.setString(1, pwd);
    	pstmt.setString(2,u);
    	pstmt.executeUpdate();   	
    }
    public void eliminarUsuario(String user) throws SQLException
    {
    	PreparedStatement pstmt = conexion.prepareStatement(QUERY_ELIMINAR);
    	pstmt.setString(1, user);
    	pstmt.executeUpdate();
    }

}
