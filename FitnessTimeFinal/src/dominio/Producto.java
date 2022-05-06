package dominio;

public class Producto {
	
	private String nombre;
	private int referencia;
	private String descripcion;
	private double precio;
	private String categoria;
	
	public Producto(String nombre, int referencia, String descripcion, double precio , String categoria)
	{
		this.nombre=nombre;
		this.referencia=referencia;
		this.descripcion=descripcion;
		this.precio=precio;
		this.categoria=categoria;
	}
	public String getNombre()
	{return nombre;}
	public int getReferencia()
	{return referencia;}
	public String getDescripcion()
	{return descripcion;}
	public double getPrecio()
	{return precio;}
	public String getCategoria()
	{return categoria;}
	public void setNombre(String nombre)
	{this.nombre=nombre;}
	public void setDescripcion(String descripcion)
	{this.descripcion=descripcion;}
	public void setReferencia(int referencia)
	{this.referencia=referencia;}
	public void setPrecio(double precio)
	{this.precio=precio;}
	public void setCategoria(String categoria)
	{this.categoria=categoria;}
    @Override
    public boolean equals(Object o) 
    {
        Producto p = (Producto) o;
        if (referencia == p.getReferencia())
            return true;
        else
            return false;
    }  
    @Override
    public int hashCode() 
    {
        return referencia;
    }   

}
