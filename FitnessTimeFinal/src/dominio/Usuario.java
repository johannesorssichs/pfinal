package dominio;

public class Usuario {
	
	private String nombre;
	private String usuario;
	private String pwd;
	private String direccion;
	private String telf;
	private String ciudad;
	private String cp;
	private String provincia;
	private int admin;
	public Usuario(String n,String u,String d,String tlf, String c, String cp, String p,String pwd, int admin)
	{
		this.setNombre(n);
		this.setUsuario(u);
		this.setDireccion(d);
		this.setTelf(tlf);
		this.setCiudad(c);
		this.setCP(cp);
		this.setProvincia(p);
		this.setPassword(pwd);
		this.setAdmin(admin);
		
	}
	public Usuario()
	{;}
	public void setNombre(String nombre)
	{this.nombre=nombre;}
	public void setUsuario(String usuario)
	{this.usuario=usuario;}
	public void setDireccion(String direccion)
	{this.direccion=direccion;}
	public void setTelf(String telf)
	{this.telf=telf;}
	public void setCiudad(String ciudad)
	{this.ciudad=ciudad;}
	public void setCP(String cp)
	{this.cp=cp;}
	public void setProvincia(String provincia)
	{this.provincia=provincia;}
	public void setPassword(String pwd)
	{this.pwd=pwd;}
	public void setAdmin(int admin)
	{this.admin=admin;}
	public String getNombre()
	{return nombre;}
	public String getUsuario()
	{return usuario;}
	public String getDireccion()
	{return direccion;}
	public String getTelf()
	{return telf;}
	public String getCiudad()
	{return ciudad;}
	public String getCP()
	{return cp;}
	public String getProvincia()
	{return provincia;}
	public String getPassword()
	{return pwd;}
	public int getAdmin()
	{return admin;}

}
