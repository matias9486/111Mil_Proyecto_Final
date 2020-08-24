/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Hatake
 */
public class MiSesion 
{
    private static SessionFactory SESSION_FACTORY;    
    private static Session sesionAbierta;
    
    public MiSesion() { }
                    
    //METODO ORIGINAL QUE USAMOS POR CONSOLA (crea la sesion)
    public static SessionFactory getSessionFactory(){
        if(SESSION_FACTORY == null) {    
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // obtiene los valores de hibernate.cfg.xml
                .build();
            SESSION_FACTORY = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        return SESSION_FACTORY;
    }
                   
    public static Session AbrirSesion() 
    {                
        if(sesionAbierta==null)
        {
            sesionAbierta=getSessionFactory().openSession();
        }
        return sesionAbierta;
    }
 
    public static void CerrarSesion()
    {
        sesionAbierta.close();
        SESSION_FACTORY.close();
    }
      
}
