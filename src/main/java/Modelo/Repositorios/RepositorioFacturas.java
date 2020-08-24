/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repositorios;

import Modelo.DetalleFactura;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.MiSesion;
import Modelo.Producto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Hatake
 */
public class RepositorioFacturas {    
    private Session s= MiSesion.AbrirSesion();
    public RepositorioFacturas() 
    {        
    }
     
    public List<Factura> DevolverFacturas() throws Exception
    {   
        //throws TipoException, permite arrojar una excepcion(sin tener que capturarla donde se produce) 
        //al siguiente bloque donde se usara este metodo, pero debe estar entre try y catch , o volver a usar throw hstsa que la excepcion sea capturada        
        
        s.beginTransaction();                           
        Query q = s.createQuery("from Factura", Factura.class);       
        List<Factura> l = q.list();                        
        
        s.getTransaction().commit();        
        
        return l;
                
    }
    
    public void modificarDetallesFacturas() throws Exception,HibernateException
    {   
        //throws TipoException, permite arrojar una excepcion(sin tener que capturarla donde se produce) 
        //al siguiente bloque donde se usara este metodo, pero debe estar entre try y catch , o volver a usar throw hstsa que la excepcion sea capturada        
        
        s.beginTransaction();    
                            
        
        Query q = s.createQuery("from Factura", Factura.class);       
        List<Factura> l = q.list();                        
                        
        for(Factura f :l)
        {
            int i=0;        
            for(DetalleFactura df :f.getDetalleFactura())
            {
                i++;
                df.setNroItem(i);                            
            }
            s.update(f);
        }                
        s.getTransaction().commit();       
        
    }
    
    public Factura buscarFacturaPorId(int id) throws Exception
    {
        //s = MiSesion.getSessionFactory().openSession();        
        s.beginTransaction();                        
        Factura f = s.get(Factura.class, id);              
        s.getTransaction().commit();        
        //s.close();
        return f;
    }
        
    
   
    public void  agregarFactura(Factura f) throws Exception
    {        
        s.beginTransaction();                                
                        
        s.save(f);       
        for(DetalleFactura df: f.getDetalleFactura())
        {
            Producto p= s.get(Producto.class, df.getProducto().getCodigoProducto());              
            int stock= (int)(p.getStock() - df.getCantidad());
            p.setStock(stock);
            s.save(p);
        }
        
        s.getTransaction().commit();
        
    }        
    
    public int cantidadProductosVendidos() throws Exception
    {
        s.beginTransaction();
        Query q = s.createQuery("from DetalleFactura", DetalleFactura.class);       
        List<DetalleFactura> l = q.list();                        
        
        s.getTransaction().commit();        
        
        if(l.isEmpty())
            return 0;
        else 
            return l.size();
    }
    
    public int maxFactura()
    {
        s.beginTransaction();               
        Query q = s.createQuery("select max(nroFactura) from Factura");        
                        
        int id=q.uniqueResult().hashCode();
        
        s.getTransaction().commit();        
        return id;        
    }
}
