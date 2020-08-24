/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Patricia
 */
 
public class Producto {
    private int codigoProducto;
    private transient String marca;
    private transient String nombre;
    private transient String descripcion;
    private transient float precio;
    private transient int stock;

    public Producto() {
    }

    public Producto(int codigoProducto, String marca, String nombre, String descripcion, float precio, int stock) {
        this.codigoProducto = codigoProducto;
        this.marca = marca;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + 
                ", marca=" + marca + ", nombre=" + nombre + ", descripcion=" + 
                descripcion + ", precio=" + precio + ", stock=" + stock + '}';
    }
    
}
