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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aileen
 */
public class Logica {

   
    
    public static void CrearPaquete(String destino) {
      
        long tiempoCreacion ;
         
        tiempoCreacion = RemClient.pedirReloj();
        
       // long tiempoCreacion= System.currentTimeMillis()/1000 ;
    
  
      
      ArrayList <Paquete> paquetesRecibidos = new ArrayList <>();//GestorXml.obtenerPaquetesRecibidos();
      
      int idPaqueteACrear;
      Random rand = new Random(); 
       rand.nextInt(40); 
      
        idPaqueteACrear = Integer.parseInt(Configuracion.numeroSucursal + Configuracion.numeroSucursalRecepcion) + rand.nextInt(40);
      
      
      ArrayList <Incidencia> listaIncidencia = new ArrayList <>();
      Paquete paquete = new Paquete(idPaqueteACrear,tiempoCreacion,Configuracion.numeroSucursal, destino);


     
      if (!paquete.getDestino().equals(Configuracion.numeroSucursalEnvio)){
      //ARREGLAR MOVER A LISTA
        Configuracion.transporteEnvio.getListaPaquete().add(paquete);
    
        XStream xstream = new XStream();
        xstream.alias("Transporte", Transporte.class);
        xstream.alias("Paquete",Paquete.class);
        if (Configuracion.transporteEnvio.isDisponible())
            {
            String transporteXML  = xstream.toXML(Configuracion.transporteEnvio);
        
            try {
             RemClient.remObjectEnvio.enviarPaquete(transporteXML);
             
             
             } catch (RemoteException ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        else
          Configuracion.listaPaquetesAEnviar.add(paquete);
      ///modificar para que meta en la lista mientras tanto
    }
      else 
          Configuracion.transporteRecepcion.getListaPaquete().add(paquete);
    }
   

    public static void agregarPaquete(Paquete paquete, Transporte transporte){
    transporte.getListaPaquete().add(paquete);

    }
    
}
