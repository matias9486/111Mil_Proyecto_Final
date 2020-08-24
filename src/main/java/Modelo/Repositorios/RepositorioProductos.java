/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repositorios;

import Modelo.Cliente;
import Modelo.DetalleFactura;
import Modelo.Factura;
import Modelo.MiSesion;
import Modelo.Producto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Hatake
 */
public class RepositorioProductos {    
    private Session s= MiSesion.AbrirSesion();
    
    public RepositorioProductos() 
    {        
    }
     
    public List<Producto> DevolverProductos() throws Exception
    {   
        //throws TipoException, permite arrojar una excepcion(sin tener que capturarla donde se produce) 
        //al siguiente bloque donde se usara este metodo, pero debe estar entre try y catch , o volver a usar throw hstsa que la excepcion sea capturada
        List<Producto> l=null;
        try
        {
            s.beginTransaction();                           
            Query q = s.createQuery("from Producto", Producto.class);       
            l = q.list();                                    
            s.getTransaction().commit();       
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
        return l;
                
    }
    
    
    public Producto buscarProductoPorId(int id) throws Exception
    {    
        Producto p=null;
        try
        {
            s.beginTransaction();                        
            p = s.get(Producto.class, id);              
            s.getTransaction().commit();                
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
        return p;
    }
        
    public List<Producto> BuscarProductosPorMarca(String marca) throws Exception
    {    
        List<Producto> l=null;
        try
        {
            s.beginTransaction();                        
            Query q = s.createQuery("from Producto where marca =:mar", Producto.class);        
            q.setParameter("mar", marca);           
            l = q.list();               
            s.getTransaction().commit();
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
        return l;
    }
    
    public List<Producto> BuscarProductosPorNombre(String nombre) throws Exception
    {   
        List<Producto> l =null;
        try
        {
            s.beginTransaction();                        
            Query q = s.createQuery("from Producto where nombre =:nom", Producto.class);        
            q.setParameter("nom", nombre);           
            l = q.list();               
            s.getTransaction().commit();
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }
        return l;
    }
    
    public Producto  BuscarProducto(Producto p) throws Exception 
    {
        Producto aux=null;        
        try
        {
        s.beginTransaction();       
        
        Query q = s.createQuery("from Producto where nombre=:nom and marca=:mar", Producto.class);        
        q.setParameter("nom", p.getNombre());            
        q.setParameter("mar", p.getMarca());          
        
        //ver si el resultado es null.. sino es convertirlo a cliente sino es devolver null
        if(q.getResultList().size()>0)
            aux= (Producto)q.getResultList().get(0);
        
        s.getTransaction().commit();
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }
        return aux;
    }
    
    public void  agregarProducto(Producto p) throws Exception
    {
        try
        {
            s.beginTransaction();                                
            s.save(p);       
            s.getTransaction().commit();
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }
    }
    
    public void  modificarProducto(Producto p) throws Exception
    {
        try
        {

            s.beginTransaction();                
            Producto aux= s.get(Producto.class, p.getCodigoProducto());

           //atributos modificar.....
            aux.setNombre(p.getNombre());
            aux.setDescripcion(p.getDescripcion());
            aux.setMarca(p.getMarca());
            aux.setPrecio(p.getPrecio());
            aux.setStock(p.getStock());

            s.save(aux);        
            s.getTransaction().commit();                
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }
    }
    
    public void  eliminarProducto(int id) throws Exception
    {
        try
        {
            s.beginTransaction();

            Producto p= s.get(Producto.class, id);                            
            s.delete(p);        
            s.getTransaction().commit();                
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }
    }
    
    public  boolean BuscarFacturasDelProducto(int cod) throws Exception
    {
        boolean tieneDetalleFactura=true;
        try
        {                        
            s.beginTransaction();            
            Query q = s.createQuery("from DetalleFactura where codigo_producto =:codigo", DetalleFactura.class);
            q.setParameter("codigo", cod);    

            List<DetalleFactura> l = q.list();                           
        
            s.getTransaction().commit();
            
            if(l.isEmpty())
                tieneDetalleFactura=false;
            }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }
            return tieneDetalleFactura;
    }
    
    public int maxProductos()throws Exception
    {
        int id=0;    
        try
        {
            s.beginTransaction();               
            Query q = s.createQuery("select max(codigoProducto) from Producto");        

            id=q.uniqueResult().hashCode();

            s.getTransaction().commit();        
        }
         catch(Exception e)
        {
            s.getTransaction().rollback();
        }
            
        return id;        
    }
}
