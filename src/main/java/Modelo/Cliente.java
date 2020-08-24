/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import java.util.Objects;


/**
 *
 * @author Hatake
 */
public class Cliente {
    private int nroCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private boolean activo;        
    private List<Telefono> telefonos;

 
    public Cliente(){
        super();
    }
    public Cliente(int nroCliente, String nombre, String apellido, String direccion, boolean activo, List<Telefono> telefonos) {
        this.nroCliente = nroCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.activo = activo;
        this.telefonos = telefonos;
    }
    
    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
   
    public int getNroCliente() {
        return nroCliente;
    }
    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nroCliente=" + nroCliente + ", nombre=" + nombre + ", apellido=" 
                + apellido + ", direccion=" + direccion + ", activo=" + activo + ", telefonos=" + telefonos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.nroCliente;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.apellido);
        hash = 59 * hash + Objects.hashCode(this.direccion);
        hash = 59 * hash + (this.activo ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.telefonos);
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
        final Cliente other = (Cliente) obj;
        if (this.nroCliente != other.nroCliente) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.telefonos, other.telefonos)) {
            return false;
        }
        return true;
    }

   
    
}
