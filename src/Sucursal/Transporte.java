/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

import java.util.ArrayList;

/**
 *
 * @author Aileen
 */
public class Transporte {
    
    private String tipo;
    private ArrayList<Paquete> listaPaquete;
    private String sucursal;
    private boolean disponible;

    public boolean isDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Transporte(String tipo, ArrayList<Paquete> listaPaquete,String sucursal,boolean disponible) {
        this.tipo = tipo;
        this.listaPaquete = listaPaquete;
        this.sucursal = sucursal;
        this.disponible = true;
    }

    Transporte(String tipo) {
     this.tipo = tipo;
    }
    
    public ArrayList<Paquete> getListaPaquete() {
        return listaPaquete;
    }

    public void setListaPaquete(ArrayList<Paquete> listaPaquete) {
        this.listaPaquete = listaPaquete;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
