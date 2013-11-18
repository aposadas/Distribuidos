/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

import com.thoughtworks.xstream.XStream;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aileen
 */
public class Logica {

   
    
    public static void CrearPaquete(String destino) {
      long tiempoCreacion= System.currentTimeMillis()/1000;
   
      
      ArrayList <Paquete> paquetesRecibidos = new ArrayList <>();//GestorXml.obtenerPaquetesRecibidos();
      
      int idPaqueteACrear;
      if (paquetesRecibidos.isEmpty())
        idPaqueteACrear = Integer.parseInt(Configuracion.numeroSucursal + Configuracion.numeroSucursalRecepcion) + 1;
      else
          idPaqueteACrear = Integer.parseInt(paquetesRecibidos.get(paquetesRecibidos.size() -1).getOrigen());
      
      Paquete paquete = new Paquete(idPaqueteACrear,tiempoCreacion,Configuracion.numeroSucursal, destino);
      Configuracion.transporteEnvio.getListaPaquete().add(paquete); 
      XStream xstream = new XStream();
      xstream.alias("Transporte", Transporte.class);
      xstream.alias("Paquete",Paquete.class);
      String transporteXML  = xstream.toXML(Configuracion.transporteEnvio);
        System.out.println("TransporteXML: " + transporteXML);
      try {
            RemClient.remObjectEnvio.enviarPaquete(transporteXML);
        } catch (RemoteException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //static ArrayList <String> obtenerSucursales() {
     
   // }
    
    public static void agregarPaquete(Paquete paquete, Transporte transporte){
    transporte.getListaPaquete().add(paquete);
    }
    
}
