/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosistemasdistribuidos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aileen
 */
public class Paquete {
    private int id;
    private Date tiempoDeLlegada;
    private Date tiempoDeSalida;
    private int origen;
    private int destino;
    private ArrayList<Incidencia> listaIncidencia;

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public ArrayList<Incidencia> getListaIncidencia() {
        return listaIncidencia;
    }

    public void setListaIncidencia(ArrayList<Incidencia> listaIncidencia) {
        this.listaIncidencia = listaIncidencia;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public Date getTiempoDeLlegada() {
        return tiempoDeLlegada;
    }

    public void setTiempoDeLlegada(Date tiempoDeLlegada) {
        this.tiempoDeLlegada = tiempoDeLlegada;
    }

    public Date getTiempoDeSalida() {
        return tiempoDeSalida;
    }

    public void setTiempoDeSalida(Date tiempoDeSalida) {
        this.tiempoDeSalida = tiempoDeSalida;
    }

    public Paquete(Date tiempoDeLlegada, Date tiempoDeSalida, int origen, int destino, ArrayList<Incidencia> listaIncidencia) {
        this.tiempoDeLlegada = tiempoDeLlegada;
        this.tiempoDeSalida = tiempoDeSalida;
        this.origen = origen;
        this.destino = destino;
        this.listaIncidencia = listaIncidencia;
    }

    public Paquete(Date tiempoDeSalida, int origen, int destino) {
        this.tiempoDeSalida = tiempoDeSalida;
        this.origen = origen;
        this.destino = destino;
    }
    
    
}
