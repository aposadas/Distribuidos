/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosistemasdistribuidos;

import java.util.ArrayList;

/**
 *
 * @author Aileen
 */
public class Transporte {
    
    private String tipo;
    private ArrayList<Paquete> listaPaquete;

    public Transporte(String tipo, ArrayList<Paquete> listaPaquete) {
        this.tipo = tipo;
        this.listaPaquete = listaPaquete;
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
