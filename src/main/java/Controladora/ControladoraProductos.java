/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Producto;
import Modelo.Repositorios.RepositorioProductos;
import java.util.List;

/**
 *
 * @author Hatake
 */
public class ControladoraProductos {
    private RepositorioProductos productos= new RepositorioProductos();

    public ControladoraProductos() {
    }
    
    public int proximoIdProducto() throws Exception
    {         
        return productos.maxProductos()+1;
    }
    
    public List<Producto> DevolverProductos() throws Exception
    {                
        return productos.DevolverProductos();        
    }
    
    public boolean AgregarProducto(int codigoProducto, String marca, String nombre, String descripcion, float precio, int stock)  throws Exception
    {
        boolean estado=false;
        Producto nuevo= new Producto( codigoProducto, marca, nombre, descripcion, precio, stock);
        
        if(productos.BuscarProducto(nuevo)==null)
        {
            productos.agregarProducto(nuevo);
            estado=true;
        }
        return estado;    
    }
    
    public boolean ModificarProducto(int codigoProducto, String marca, String nombre, String descripcion, float precio, int stock)  throws Exception
    {
        boolean estado=false;
        Producto aux= new Producto( codigoProducto, marca, nombre, descripcion, precio, stock);
        
        if(productos.BuscarProducto(aux)==null)
        {
            productos.modificarProducto(aux);
            estado=true;
        }
        return estado;    
    }
    
    
    public boolean EliminarProducto(int id) throws Exception
    {
        boolean estado=false;        
        
        //if(productos.buscarProductoPorId(id)!=null)
        if(productos.BuscarFacturasDelProducto(id)==false)
        {
            productos.eliminarProducto(id);
            estado=true;
        }
        return estado;    
    }
    
    public Producto buscarProductoId(int id) throws Exception
    {   
        Producto buscado= productos.buscarProductoPorId(id);        
        return buscado;    
    }
    
    public List<Producto> buscarProductoPorNombre(String nombre) throws Exception
    {   
        return productos.BuscarProductosPorNombre(nombre);        
    }
    
    public List<Producto> buscarProductoPorMarca(String marca) throws Exception
    {   
        return productos.BuscarProductosPorMarca(marca);        
    }
}
