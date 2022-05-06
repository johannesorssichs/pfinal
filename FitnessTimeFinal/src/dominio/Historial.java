package dominio;

public class Historial {
	
	private java.sql.Date fecha;
	private Producto producto;
	private int uds;
	
	public Historial(java.sql.Date fecha,Producto producto,int uds)
	{
		this.fecha=fecha;
		this.producto=producto;
		this.uds=uds;
	}
	public java.sql.Date getFecha()
	{return fecha;}
	public Producto getProducto()
	{return producto;}
	public int getUds()
	{return uds;}
	public void setFecha(java.sql.Date fecha)
	{this.fecha=fecha;}
	public void setUds(int uds)
	{this.uds=uds;}
	public void setProducto(Producto producto)
	{this.producto=producto;}
}
