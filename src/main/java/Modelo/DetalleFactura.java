/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Patricia
 * No incluir el nro de factura en esta clase porque detalle es redundante desde el punto de vista POO 
 * y en consecuncia tampoco en el mapeo con la tabla e01-detalle-factura
 */
 
public class DetalleFactura implements Serializable{
   
    private Factura factura;
    private Producto producto;
    private   int nroItem;
    private   float cantidad;
    
     public DetalleFactura() {
    }
    public DetalleFactura( Factura factura,Producto producto, int nroItem, float cantidad) {
       
        this.factura = factura;
        this.producto = producto;
        this.nroItem = nroItem;
        this.cantidad = cantidad;
    }

   
   
    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
         this.factura = factura;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getNroItem() {
        return this.nroItem;
    }

    public void setNroItem(int nroItem) {
        this.nroItem = nroItem;
    }

    public float getCantidad() {
        return this.cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.factura);
        hash = 71 * hash + Objects.hashCode(this.producto);
        hash = 71 * hash + this.nroItem;
        hash = 71 * hash + Float.floatToIntBits(this.cantidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleFactura other = (DetalleFactura) obj;
        if (this.nroItem != other.nroItem) {
            return false;
        }
        if (Float.floatToIntBits(this.cantidad) != Float.floatToIntBits(other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.factura, other.factura)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
 
    @Override
    public String toString() {
        return "DetalleFactura{" + "producto=" +
                producto + ", nroItem=" + nroItem + 
                ", cantidad=" + cantidad + '}';
    }
    
     
 
}

