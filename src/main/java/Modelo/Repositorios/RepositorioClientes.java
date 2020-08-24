/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repositorios;

import java.util.List;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.MiSesion;
import Modelo.Telefono;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Hatake
 */
public class RepositorioClientes 
{
    
    private Session s= MiSesion.AbrirSesion();
    
    public RepositorioClientes() 
    {        
    }
     
    public List<Cliente> DevolverClientes() throws Exception
    {   
        List<Cliente> l=null;        
        try
        {
            s.beginTransaction();                           
            Query q = s.createQuery("from Cliente", Cliente.class);       
            l = q.list();        

            s.getTransaction().commit();                             
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }
        return l;   
    }
    
    public Cliente buscarClientePorId(int id) throws Exception
    {    
        Cliente c=null;
        try
        {
            s.beginTransaction();                        
            c = s.get(Cliente.class, id);              
            s.getTransaction().commit();        
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
        return c;
    }
        
    public  List<Cliente> BuscarClientePorApellido( String ape) throws Exception
    {
        List<Cliente> l=null;
        try
        {
            s.beginTransaction();            
            Query q = s.createQuery("from Cliente where apellido =:ape", Cliente.class);
            q.setParameter("ape", ape);    

            l = q.list();                           
        
            s.getTransaction().commit();
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
        return l;
    }
    
    public Cliente  BuscarCliente(Cliente c) throws Exception 
    {   
        Cliente aux=null;        
        try
        {
            s.beginTransaction();       
            
            Query q = s.createQuery("from Cliente where nombre=:nom and apellido=:ape and direccion=:dir", Cliente.class);                                            
            
            q.setParameter("nom", c.getNombre());            
            q.setParameter("ape", c.getApellido());          
            q.setParameter("dir", c.getDireccion());                                          
            
            
            /* original
            if(q.getResultList().size()>0)                           
                aux=(Cliente)q.getResultList().get(0);
              */
            
            List<Cliente> l = q.getResultList();
            if(l.size()>0)
            {                
                aux=(Cliente) l.get(0);
                if(aux.equals(c)==false)
                {
                   aux=null;
                }                
            }
            
            s.getTransaction().commit();
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
        return aux;
    }
    
    public void  agregarCliente(Cliente c) throws Exception
    {        
        try
        {
            s.beginTransaction();                                
            s.save(c);       
            s.getTransaction().commit();       
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
    }
    
    
    
    public void  modificarCliente(Cliente c) throws Exception
    {        
        try
        {
            s.beginTransaction();                
            Cliente aux= s.get(Cliente.class, c.getNroCliente());

            aux.setNombre(c.getNombre());
            aux.setApellido(c.getApellido());
            aux.setDireccion(c.getDireccion());
            aux.setActivo(c.isActivo());

            aux.setTelefonos(c.getTelefonos());   

            s.save(aux);        
            s.getTransaction().commit();     
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
        
    }
    
    public void  eliminarCliente(int id) throws Exception
    {        
        try
        {
            s.beginTransaction();

            Cliente c= s.get(Cliente.class, id);                            
            s.delete(c);        
            s.getTransaction().commit();                
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
    }
    
    public void modificarTelefono(Telefono modificado,Telefono original) throws Exception
    {
        try
        {
            s.beginTransaction();                
            Telefono aux= s.get(Telefono.class, original.getNumero());

            aux.setNumero(modificado.getNumero());
            aux.setTipo(modificado.getTipo());

            //s.save(aux);        
            s.update(aux);        
            s.getTransaction().commit();                
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
    }
    
    public void  eliminarTelefono(Telefono t) throws Exception
    {
        try{
            s.beginTransaction();

            Telefono tel= s.get(Telefono.class,t.getNumero());                            
            s.delete(tel);        
            s.getTransaction().commit();                
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
    }
    
    //metodo utilizado para ver si el cliente posee facturas e impedir borrarlo luego
    public  boolean BuscarFacturasDelCliente(int id) 
    {
        boolean tieneFacturas=true;
        try
            {
            s.beginTransaction();            
            Query q = s.createQuery("from Factura where nro_cliente =:nro", Factura.class);
            q.setParameter("nro", id);    

            List<Cliente> l = q.list();                           
        
            s.getTransaction().commit();
            
            if(l.isEmpty())
                tieneFacturas=false;
            
        }
        catch(Exception e)
        {
            s.getTransaction().rollback();
        }        
        return tieneFacturas;
    }
    
    public int maxClientes()
    {
        int id=0;
        try
        {
            s.beginTransaction();               
            Query q = s.createQuery("select max(nroCliente) from Cliente");        

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
