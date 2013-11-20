/*
The Remote Object Implementation
 */
package Sucursal;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Sucursal.Paquete;
import Sucursal.Transporte;
import com.thoughtworks.xstream.XStream;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/** This is the actual implementation of Rem that
 *  the RMI server uses. The server builds an instance
 *  of this then registers it with a URL. The
 *  client accesses the URL and binds the result to
 *  a Rem (not a RemImpl; it doesn't have this).
 */
/**
 *
 * @author Aileen
 */
public class RemImpl extends UnicastRemoteObject implements Rem {
    public String transporteXML;
    public RemImpl() throws RemoteException 
    {
    
    }

   
    @Override
    public String getMessage() throws RemoteException 
    {
        return("llega el mensaje"); 
    }
    

    
   
    public String pedirPaquetes(String sucursal) throws RemoteException {
       // RemClient.remObjectRecepcion.
             //Así aca podemos setear aca colocar el thread sleep de 5 seg         
        if (Configuracion.transporteRecepcion.isDisponible() && !Configuracion.transporteRecepcion.getListaPaquete().isEmpty())
        {
        XStream xstream = new XStream();
        xstream.alias("Transporte", Transporte.class);
        xstream.alias("Paquete",Paquete.class);
        Configuracion.transporteRecepcion.setDisponible(false);
        String transporte = xstream.toXML(Configuracion.transporteRecepcion);
        return transporte;
        }
        return null;
    }
        
    
    
    @Override
    public void enviarPaquete(String transporte) throws RemoteException{
     // this.transporteXML = transporte;
        System.out.println(transporte);
        XStream xstream = new XStream ();
        xstream.alias("Transporte",Transporte.class);
        xstream.alias("Paquete",Paquete.class);
        Transporte transportePaquetes =(Transporte) xstream.fromXML(transporte);
        
       int tamanio = transportePaquetes.getListaPaquete().size();
       final Lock lock = new ReentrantLock();
       final Condition TiempoCumplido = lock.newCondition();
       
       
       
       
       //chequeo si el paquete es para esta o sucursal y lo agrego sino le agrego una incidencia y lo reenvio
       if (tamanio>0){
           
        for (int j=0;j<tamanio;j++){
         if (transportePaquetes.getListaPaquete().get(j).getDestino().equals(Configuracion.numeroSucursal)){
             transportePaquetes.getListaPaquete().get(j).setTiempoDeLlegada(System.currentTimeMillis()/1000);
             Configuracion.listaPaquetesRecibidos.add(transportePaquetes.getListaPaquete().get(j));
             transportePaquetes.getListaPaquete().remove(j);
             //duerme 10 segundos
             
         }
         else {
                Incidencia incidencia = new Incidencia (Configuracion.numeroSucursal,System.currentTimeMillis()/1000,"Traslado","El paquete pasó por la sucursal: " + Configuracion.numeroSucursal);
                transportePaquetes.getListaPaquete().get(j).getListaIncidencia().add(incidencia);
                //agregar espera de tiempo
         }
        }
       }
        transporte = xstream.toXML(transportePaquetes);
        
        //chequeo si estoy en la misma sucursal de donde salí.
       if (transportePaquetes.getSucursal().equals(Configuracion.numeroSucursal))
           Configuracion.transporteEnvio.setDisponible(true);
       
       else {
       RemClient.remObjectEnvio.enviarPaquete(transporte);
       }
             
    } 
       
    
    
    public void reenviarTransporteAjeno(String transporteRecepcion)throws RemoteException{
        
    
    
    
    }
}
