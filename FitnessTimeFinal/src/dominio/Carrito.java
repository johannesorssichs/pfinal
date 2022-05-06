package dominio;

import java.util.*;
import dominio.Producto;

public class Carrito{

    public HashMap <Producto,Integer> productos;
    //Clave = referencia del producto
    //El integer será un contador para contabilizar las unidades de ese libro que se han añadido al carrito.

    public Carrito() //Constructor
    {
        productos = new HashMap();
    }

    public void addProducto(Producto p) 
    {
    	//int ref=p.getReferencia();
        Integer uds = productos.get(p); 
        if(uds!=null) 
            productos.put(p,uds+1); 
        else
            productos.put(p,1); 
    }
    public void removeProducto(Producto p) 
    {
    	//int ref=p.getReferencia();
        Integer uds = productos.get(p); 
        if(uds==1)
            productos.remove(p); 
        else
            productos.put(p,uds-1); 
    }
    public HashMap getProductos()
    {return productos;}

}
