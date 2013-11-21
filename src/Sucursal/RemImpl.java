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

/*
 *
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
    

    
   
    public String pedirPaquetes(String Transporte) throws RemoteException {
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
       
       long tiempo;
       tiempo =RemClient.pedirReloj();
      // teimpo =System.currentTimeMillis()/1000;
       
       
       
       //chequeo si el paquete es para esta o sucursal y lo agrego sino le agrego una incidencia y lo reenvio
       if (tamanio>0){
           
        for (int j=0;j<tamanio;j++){
         if (transportePaquetes.getListaPaquete().get(j).getDestino().equals(Configuracion.numeroSucursal)){
            tiempo= tiempo+10;
             transportePaquetes.getListaPaquete().get(j).setTiempoDeLlegada(tiempo);
             Configuracion.listaPaquetesRecibidos.add(transportePaquetes.getListaPaquete().get(j));
    Paquete paquete = transportePaquetes.getListaPaquete().get(j);
             
             transportePaquetes.getListaPaquete().remove(j);
             //duerme 10 segundos
     
     String paqueteXML = xstream.toXML(paquete);
     RemClient.enviarPaqueteAServerCenral(paqueteXML,true);
              
     System.out.println("se mando el paquete");
         }
         else {
             //tiempo2=System.currentTimeMillis()/1000
             tiempo=tiempo+1;
                Incidencia incidencia = new Incidencia (Configuracion.numeroSucursal,tiempo,"Traslado","El paquete pasó por la sucursal: " + Configuracion.numeroSucursal);
                transportePaquetes.getListaPaquete().get(j).getListaIncidencia().add(incidencia);
                //agregar espera de tiempo
         }
        }
       }
        transporte = xstream.toXML(transportePaquetes);
        
        //chequeo si estoy en la misma sucursal de donde salí.
       if (transportePaquetes.getSucursal().equals(Configuracion.numeroSucursal))
       { Configuracion.transporteEnvio.setDisponible(true);
        
           for (int i = 0; i < Configuracion.listaPaquetesAEnviar.size(); i++) {
               
           
        transportePaquetes.getListaPaquete().add(Configuracion.listaPaquetesAEnviar.get(i));
        Configuracion.listaPaquetesAEnviar.remove(i);
        transporte = xstream.toXML(transportePaquetes);
        RemClient.remObjectEnvio.enviarPaquete(transporte);
           }
       }
       
       else {
       RemClient.remObjectEnvio.enviarPaquete(transporte);
       }
       
       RemClient.actualizarHoraServerCentral(tiempo);
             
    } 
       
    
    
    public void reenviarTransporteAjeno(String transporteRecepcion)throws RemoteException{
    XStream xstream =new XStream();    
    xstream.alias("Transporte", Transporte.class);
    xstream.alias("Paquete", Transporte.class);
    Transporte transporte = (Transporte) xstream.fromXML(transporteRecepcion);
    
    if (transporte.getSucursal().equals(Configuracion.numeroSucursal))
     {
     Configuracion.transporteRecepcion = transporte;
     
     }
    else {
        //aumentar tiempo
    RemClient.remObjectRecepcion.reenviarTransporteAjeno(transporteRecepcion);
    
    }
    }
    
       

    
}
