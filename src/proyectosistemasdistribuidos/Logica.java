/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosistemasdistribuidos;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Aileen
 */
public class Logica {

   public static void CrearPaquete(Integer origen) {
      Calendar tiempoActual = Calendar.getInstance();
      tiempoActual.getTime();
      ArrayList <Paquete> paquetesRecibidos = GestorXml.obtenerPaquetesRecibidos();
      int idPaqueteACrear=paquetesRecibidos.get(paquetesRecibidos.size() -1).getOrigen();
      Paquete paquete = new Paquete(idPaqueteACrear,tiempoActual.getTime(),origen, RemServer.numeroSucursal);
      agregarPaquete(paquete,RemServer.transporteEnvio);
    }

    //static ArrayList <String> obtenerSucursales() {
     
   // }
    
    public static void agregarPaquete(Paquete paquete, Transporte transporte){
    transporte.getListaPaquete().add(paquete);
    }
    
}
