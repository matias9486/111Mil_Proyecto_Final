/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Cliente;
import Modelo.Repositorios.RepositorioClientes;
import Modelo.Telefono;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hatake
 */
public class ControladoraClientes {
    private RepositorioClientes clientes= new RepositorioClientes();

    public ControladoraClientes() {
    }
    
    public int proximoClienteId()throws Exception
    {
        return clientes.maxClientes()+1;
    }
    
    public List<Cliente> DevolverClientes() throws Exception
    {                
        return clientes.DevolverClientes();        
    }
    
    public List<Cliente> BuscarClientePorApellido(String apellido) throws Exception
    {                
        return clientes.BuscarClientePorApellido(apellido);
    }
    
    public boolean AgregarCliente(int nroCliente, String nombre, String apellido, String direccion, boolean activo, List<Telefono> telefonos) throws Exception
    {
        boolean estado=false;
        Cliente nuevo= new Cliente(nroCliente,nombre,apellido,direccion,activo,telefonos);
        
        if(clientes.BuscarCliente(nuevo)==null)
        {
            clientes.agregarCliente(nuevo);
            estado=true;
        }
        return estado;    
    }
    
    public boolean ModificarCliente(int nroCliente, String nombre, String apellido, String direccion, boolean activo, List<Telefono> telefonos) throws Exception
    {
        boolean estado=false;
        Cliente aux= new Cliente(nroCliente,nombre,apellido,direccion,activo,telefonos);
        
        if(clientes.BuscarCliente(aux)==null)
        {
            
            clientes.modificarCliente(aux);
            estado=true;
        }
        return estado;    
    }
    
    
    public boolean EliminarCliente(int id) throws Exception
    {
        boolean estado=false;        
        
        //if(clientes.buscarClientePorId(id)!=null)
        if(clientes.BuscarFacturasDelCliente(id)==false)
        {
            clientes.eliminarCliente(id);
            estado=true;
        }
        return estado;    
    }
    
    public Cliente buscarClienteId(int id) throws Exception
    {   
        Cliente buscado= clientes.buscarClientePorId(id);        
        return buscado;    
    }
    
    public boolean modificarTelefono(Telefono modificado,Telefono original) throws Exception
    {
        boolean estado=false;        
                                    
        clientes.modificarTelefono(modificado,original);
            
        estado=true;
        
        return estado;    
    }
                
    public boolean elimininarTelefono(Telefono original) throws Exception
    {
        boolean estado=false;        
                                    
        clientes.eliminarTelefono(original);
            
        estado=true;
        
        return estado;    
    }
    
}
