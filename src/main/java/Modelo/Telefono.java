
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
 * @author Hatake
 */
public class Telefono {
        
    public static class Numero implements Serializable {
        private int codigoArea;
        private int nroTelefono;

        public Numero() {
        }
        public Numero(int codigoArea, int nroTelefono) {
            this.codigoArea = codigoArea;
            this.nroTelefono = nroTelefono;
        }
        public int getCodigoArea() {
            return codigoArea;
        }
        public void setCodigoArea(int codigoArea) {
            this.codigoArea = codigoArea;
        }
        public int getNroTelefono() {
            return nroTelefono;
        }
        public void setNroTelefono(int nroTelefono) {
            this.nroTelefono = nroTelefono;
        }
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 29 * hash + this.codigoArea;
            hash = 29 * hash + this.nroTelefono;
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
            final Numero other = (Numero) obj;
            
            if (this.codigoArea != other.codigoArea) {
                return false;
            }
            return this.nroTelefono == other.nroTelefono;            
        }
        @Override
        public String toString() {
            return "Numero{" + "codigoArea=" + codigoArea + ", nroTelefono=" + nroTelefono + '}';
        }
    }
    
    private Numero numero;
    private String tipo;    
 
    public Telefono() {
    }
    public Telefono(Numero numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        
    }
    public void setNumero(Numero numero) {
        this.numero = numero;
    }
    public Numero getNumero() {
        return numero;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   @Override
    public String toString() {
        return "(" + tipo +") "+  numero.getCodigoArea() +"-"+ numero.getNroTelefono();
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.numero);
        hash = 79 * hash + Objects.hashCode(this.tipo);
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
        final Telefono other = (Telefono) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }
    
    
}
