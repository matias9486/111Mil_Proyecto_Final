/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

/**
 *
 * @author Patria
 */
public class Principal {
  
    private static SessionFactory SESSION_FACTORY;
    public static SessionFactory getSessionFactory(){
        if(SESSION_FACTORY == null) {    
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // obtiene los valores de hibernate.cfg.xml
                .build();
            SESSION_FACTORY = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        return SESSION_FACTORY;
    }
 
    public static void main(String[] args){
        try{
            Session session = getSessionFactory().openSession();
              
            
                /*--------------------- Clientes------------------------- */       
                 //buscarClientePorId(session, 51);
                addCliente(session,101);
                buscarClientePorId(session, 101);                                
                modificarCliente2punto0(session);
                buscarClientePorId(session, 101);
                //ListarClientes(session);
                //modificarCliente(session,101,"mi direccion");
                //buscarClientePorId(session,101);
                //eliminarCliente(session,101);
                //ListarClientes(session);
                // ListarClientesConParametros(session);
  
                //---------------------Productos----------------------------
                                
                // ListarProductos(session);
                //ListarProductosConParametros(session);
                //addProducto(session,101);
                //buscarProductoPorId(session,  101);
                //modificarProducto(session,101, "nombre modificado");
                //eliminarProducto(session,101);
                
                //--------------------Facturas-------------------------------
                //addFactura(session,401);  
                
                /*
                ListarFacturaPorNro(session,401);
                modificarFactura(session,401,10);
                */
                
                /*
                ListarFacturaPorNro(session,401);
                eliminarFactura(session,401);  
                */
                
                //ListarFacturaPorNro(session,401);
                //ListarFacturas(session);  
                
            getSessionFactory().close();
        }
        catch (HibernateException e) {
             System.out.println(e.getCause());
             System.out.println(e.getClass());
             System.out.println(e.getMessage());
        }
    }

    private static void buscarClientePorId(Session session, int i) {
        session.beginTransaction();
        
            System.out.println("---------------Buscando el Cliente "+i +" ------------------");
            // espero con un solo registro  session.get()
            Cliente c = session.get(Cliente.class, i);
            System.out.println(c);
      
        session.getTransaction().commit();        
    }
    private static void ListarClientes(Session session) {
        session.beginTransaction();
            
            // espero  una coleccion   session.createQuery()   con un filtro creado por mi 
            Query q = session.createQuery("from Cliente", Cliente.class);

            List<Cliente> l = q.list();
            System.out.println("Lista de clientes  ");
            l.forEach((cl) -> {
                System.out.println(cl);
            });
            
        session.getTransaction().commit();
    }
    private static void ListarClientesConParametros(Session session) {
        session.beginTransaction();
            // espero  una coleccion   session.createQuery() con un filtro creado por mi 
            Query q = session.createQuery("from Cliente where activo =:act", Cliente.class);
            q.setParameter("act", false);    

            List<Cliente> l = q.list();
            System.out.println("Lista de clientes no activos");
            l.forEach((cl) -> {
                System.out.println(cl);
            });
   
        session.getTransaction().commit();
    }
    
    private static void buscarProductoPorId(Session session, int i) {
        session.beginTransaction();
        // espero con un solo registro  session.get()
        System.out.println(" ");
        System.out.println("Buscando el Producto "+i);
        Producto p = session.get(Producto.class, i);
        System.out.println(p);
        System.out.println(" ");
        session.getTransaction().commit();
    } 
    private static void ListarProductos(Session session) {
        session.beginTransaction();
        // espero  una coleccion   session.createQuery()   con un filtro creado por mi 
        Query p = session.createQuery("from Producto", Producto.class);        
        List<Producto> l = p.list();
        System.out.println(" ");
        System.out.println("Lista de Producto");
        l.forEach((prod) -> {
            System.out.println(prod);
        });
        System.out.println(" ");
        session.getTransaction().commit();
    }
    private static void ListarProductosConParametros(Session session) {
        session.beginTransaction();
        // espero  una coleccion   session.createQuery() con un filtro creado por mi 
        Query p = session.createQuery("from Producto where stock< :cant", Producto.class);
        p.setParameter("cant", 130);
        
        List<Producto> l = p.list();
        System.out.println(" ");
        System.out.println("Lista de Productos Sin Stock");
        l.forEach((prod) -> {
            System.out.println(prod);
        });
        System.out.println(" ");
        
        session.getTransaction().commit();
        
    }


    //--------------------ABM CLIENTES-----------------------------------
    public static void  addCliente(Session s, int id)
    {
        s.beginTransaction();
        System.out.println("Agregando cliente: "+id);
        
        List<Telefono> l= new ArrayList<>();
        

        Telefono.Numero num= new Telefono.Numero(223,4455022);
        Telefono oTelefono= new Telefono(num,"F");
        l.add(oTelefono);
  
        Telefono.Numero num2= new Telefono.Numero(223,155907722);
        Telefono oTelefono2= new Telefono(num2,"M");
        l.add(oTelefono2);
        
        Cliente c= new Cliente(id,"Patricia","Caballero","Santa Cruz 4454",true,l);
        
        s.save(c);
        
        s.getTransaction().commit();
    }
    
    public static void  modificarCliente(Session s, int id,String direccion)
    {
        s.beginTransaction();
        System.out.println("Modificando cliente: "+id);
        
        Cliente c= s.get(Cliente.class, id);                
        c.setDireccion(direccion);                        
        s.save(c);        
        s.getTransaction().commit();                
    }
    
    public static void  modificarCliente2punto0(Session s)
    {                               
        s.beginTransaction();
        System.out.println("-------- Modificando cliente Patricia("+101+") por el mejor alumno :p  ----------------");
        
        Cliente c= s.get(Cliente.class, 101);                                    
        
        c.setApellido("Alancay");
        c.setNombre("Matias \"ALDO\"");
        c.setDireccion("Luis Agote 3037");                        
        
        //tiene que empezar con la lista de telefonos propias del cliente .. no funciona con una lista nueva
        List<Telefono> misTelefonos= c.getTelefonos();
        
        //desde la vista...
        //si agregara, agrego el telefono nuevo a la lista original
        //si modificara, eliminaria telefono original y agregaria el telefono modificado...o modifico el telefono en la posicion que se encuentra en la lista 
        //si elimina, eliminaria de la lista directamente el telefono
        //como es por consola, para simular que elimine todos y agrego uno nuevo, remuevo todo de la lista original
        misTelefonos.removeAll(misTelefonos);
                
        //genera objeto telefono y agrega a lista limpia        
        Telefono.Numero num= new Telefono.Numero(223,5943972);        
        Telefono oTelefono= new Telefono(num,"M");        
        misTelefonos.add(oTelefono);        
        
        //al cliente le asigna la lista modificada de los telefonos 
        c.setTelefonos(misTelefonos);        
        s.save(c);                        
        s.getTransaction().commit();                
    }
    
    public static void  eliminarCliente(Session s, int id)
    {
        s.beginTransaction();
        
        Cliente c= s.get(Cliente.class, id);                            
        s.delete(c);        
        s.getTransaction().commit();                
    }
    
    /*
    ALTA(armo objeto OBJ, session.save(OBJ))
    MODIFICACION(obtengo el OBJ de la BD, modifico atributo con el setter del objeto, session.save(OBJ))
    ELIMINACION(obtengo el OBJ de la BD, session.delete(OBJ)))
    */
    
    //------------------ABM PRODUCTOS--------------------------
    public static void  addProducto(Session s, int id)
    {
        s.beginTransaction();
        System.out.println("Agregando producto: "+id);
        
        Producto p= new Producto(id,"mi marca","mi nombre","mi descripcion",100,10);
        
        s.save(p);
        
        s.getTransaction().commit();
    }
    
    public static void  modificarProducto(Session s, int id,String nombre)
    {
        s.beginTransaction();
        System.out.println("Modificando producto: "+id);
        
        Producto p= s.get(Producto.class, id);
        p.setNombre(nombre);
        s.save(p);        
        s.getTransaction().commit();                
    }
    
    public static void  eliminarProducto(Session s, int id)
    {
        s.beginTransaction();
        
        Producto p= s.get(Producto.class, id);                            
        s.delete(p);        
        s.getTransaction().commit();                
    }
    
    
    //------------------ABM FACTURAS---------------------------
    public static void  addFactura(Session s, int id)
    {
        s.beginTransaction();
        System.out.println("Agregando factura: "+id);
        
        Producto p= s.get(Producto.class, 1);
        Cliente c=s.get(Cliente.class,100);
                
        List<DetalleFactura> listaDetalles=new ArrayList<>();                
                                
        double totalSinIva=0, totalConIva=0;
        Date miFecha= new Date(); //funciona        
        /*Factura( nroFactura,fecha, totalSinIva, iva,totalConIva,cliente,detalleFactura) */
        Factura f= new Factura(id,miFecha, 0,  21, 0,  c, listaDetalles);
                
        
        //DetalleFactura(factura,producto, nroItem, cantidad) 
        int cantidad=2;
        DetalleFactura d= new DetalleFactura(f,p,1,cantidad) ;
        listaDetalles.add(d);      
        totalSinIva=totalSinIva+p.getPrecio()*cantidad;
        totalConIva= totalSinIva * 1.21;
        
        /*
        listaDetalles.forEach((det) -> {
            System.out.println(det);           
        });
        */
        
        f.setDetalleFactura(listaDetalles);
        f.setTotalConIva(totalConIva);
        f.setTotalSinIva(totalSinIva);
                
        s.save(f);                
        s.getTransaction().commit();       
        System.out.println("----------------Se agrego factura---------------");
    }
    
    public static void  modificarFactura(Session s, int nroFactura,int nroCliente)
    {
        s.beginTransaction();
        System.out.println("Modificando Factura: "+nroFactura);
        
        Cliente c= s.get(Cliente.class, nroCliente);
        Factura f= s.get(Factura.class,nroFactura);
        
        f.setCliente(c);                        
        s.save(f);        
        s.getTransaction().commit();                
        System.out.println("Se modificó Factura: "+nroFactura);
    }
    
    public static void  eliminarFactura(Session s, int nroFactura)
    {
        s.beginTransaction();
        
        Factura f= s.get(Factura.class, nroFactura);                            
        s.delete(f);        
        s.getTransaction().commit();                
        System.out.println("Se eliminó Factura: "+nroFactura);
    }
    
    //-----------------metodos FACTURAS -----------------
    private static void ListarFacturaPorNro(Session session,int nro) {
        session.beginTransaction();                        
        Factura f = session.get(Factura.class,nro );                
        System.out.println(f);        
        session.getTransaction().commit();        
    }
    
    private static void ListarFacturas(Session session) {
        session.beginTransaction();
        // espero  una coleccion   session.createQuery()   con un filtro creado por mi 
        Query p = session.createQuery("from Factura", Factura.class);
        
        List<Factura> l = p.list();
        
        System.out.println("\nLista de Facturas:");
        l.forEach((fac) -> {
            System.out.println(fac);
        });
        System.out.println(" ");
        session.getTransaction().commit();
    }
}
 