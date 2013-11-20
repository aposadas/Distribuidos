/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aileen
 */
public class Paquete  {
    private int id;
    private long tiempoDeSalida;
    private long tiempoDeLlegada;
    private String origen;
    private String destino;
    private ArrayList<Incidencia> listaIncidencia;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ArrayList<Incidencia> getListaIncidencia() {
        return listaIncidencia;
    }

    public void setListaIncidencia(ArrayList<Incidencia> listaIncidencia) {
        this.listaIncidencia = listaIncidencia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public long getTiempoDeLlegada() {
        return tiempoDeLlegada;
    }

    public void setTiempoDeLlegada(long tiempoDeLlegada) {
        this.tiempoDeLlegada = tiempoDeLlegada;
    }

    public long getTiempoDeSalida() {
        return tiempoDeSalida;
    }

    public void setTiempoDeSalida(long tiempoDeSalida) {
        this.tiempoDeSalida = tiempoDeSalida;
    }

    public Paquete(int id, long tiempoDeLlegada, long tiempoDeSalida,String origen, String destino, ArrayList<Incidencia> listaIncidencia) {
        this.id = id;
        this.tiempoDeLlegada = tiempoDeLlegada;
        this.tiempoDeSalida = tiempoDeSalida;
        this.origen = origen;
        this.destino = destino;
        this.listaIncidencia = listaIncidencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paquete(int id, long tiempoDeSalida, String origen, String destino) {
        this.id = id;
        this.tiempoDeSalida = tiempoDeSalida;
        this.origen = origen;
        this.destino = destino;
        this.listaIncidencia = new ArrayList<>();
    }

    public Paquete() {
    }
    
    
}
