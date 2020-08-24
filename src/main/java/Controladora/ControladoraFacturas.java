/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Cliente;
import Modelo.DetalleFactura;
import Modelo.Factura;
import Modelo.Repositorios.RepositorioFacturas;
import Modelo.Telefono;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Hatake
 */
public class ControladoraFacturas {
    private RepositorioFacturas facturas= new RepositorioFacturas();
    
    public ControladoraFacturas()
    {}
    
    public int proximoIdFactura()
    {
        return facturas.maxFactura()+1;
    }
    
    
    public List<Factura> DevolverFacturas() throws Exception
    {                
        return facturas.DevolverFacturas();        
    }
    
    public boolean AgregarFactura(int nroFactura, Date fecha, double totalSinIva, double iva
            , double totalConIva, Cliente cliente, List<DetalleFactura> detalleFactura) throws Exception
    {
        boolean estado=false;
        Factura nuevo= new Factura(nroFactura, fecha, totalSinIva, iva, totalConIva, cliente, detalleFactura);
        
        //if(facturas.BuscarFactura(nuevo)==null)
        {
            facturas.agregarFactura(nuevo);
            estado=true;
        }
        return estado;    
    }
    
    public Factura BuscarFacturaPorNro(int id) throws Exception
    {
        return facturas.buscarFacturaPorId(id);
    }
    
    public void ModificarDetallesFactura() throws Exception,HibernateException
    {
        facturas.modificarDetallesFacturas();
    }
    
    public int CantidadProductosVendidos()throws Exception,HibernateException
    {
        return facturas.cantidadProductosVendidos();
    }
}
