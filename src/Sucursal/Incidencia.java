/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

import java.util.Date;

/**
 *
 * @author Aileen
 */
public class Incidencia {
    private String sucursal;
    private long momento;
    private String tipo;
    private String datos;

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public long getMomento() {
        return momento;
    }

    public void setMomento(long momento) {
        this.momento = momento;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Incidencia(String sucursal, long momento, String tipo, String datos) {
        this.sucursal = sucursal;
        this.momento = momento;
        this.tipo = tipo;
        this.datos = datos;
    }
    
    
}
