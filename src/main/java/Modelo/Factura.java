/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Patricia
 */
public class Factura implements Serializable{
    private int nroFactura;
    private   Date fecha;
    private   double totalSinIva;
    private   double iva;
    private   double totalConIva;
    private   Cliente cliente;
    private   List<DetalleFactura> detalleFactura;

    public Factura() {
    }

    public Factura(int nroFactura, Date fecha, double totalSinIva, double iva
            , double totalConIva, Cliente cliente, List<DetalleFactura> detalleFactura) {
        this.nroFactura = nroFactura;
        this.fecha = fecha;
        this.totalSinIva = totalSinIva;
        this.iva = iva;
        this.totalConIva = totalConIva;
        this.cliente = cliente;
        this.detalleFactura = new ArrayList<>();
        this.detalleFactura = detalleFactura;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTotalSinIva(double totalSinIva) {
        this.totalSinIva = totalSinIva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setTotalConIva(double totalConIva) {
        this.totalConIva = totalConIva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<DetalleFactura> getDetalleFactura() {
        return this.detalleFactura;
    }
    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public double getTotalSinIva() {
        return totalSinIva;
    }

    public double getIva() {
        return iva;
    }

    public double getTotalConIva() {
        return totalConIva;
    }

  

    @Override
    public String toString() {
        return "Factura{" + "nroFactura=" + nroFactura + ", fecha=" + fecha + 
                ", totalSinIva=" + totalSinIva + ", iva=" + iva + 
                ", totalConIva=" + totalConIva + ", cliente=" + cliente + 
                ", detalleFactura=" + detalleFactura + '}';
    }
    
}


