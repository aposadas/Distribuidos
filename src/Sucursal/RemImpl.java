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
    

    
   
    public String pedirPaquetes(String Transporte) throws RemoteException {
       // RemClient.remObjectRecepcion.
             //AsÃ­ aca podemos setear aca colocar el thread sleep de 5 seg         
        
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
       ArrayList<Paquete> listaPaquetesAux = new ArrayList<>();
       
       long tiempo;
       tiempo =RemClient.pedirReloj();
       //chequeo si el paquete es para esta o sucursal y lo agrego sino le agrego una incidencia y lo reenvio
       
       if (!transportePaquetes.getSucursal().equals(Configuracion.numeroSucursal)){
       if (tamanio>0){
           
        for (int j=0;j<tamanio;j++){
         if (transportePaquetes.getListaPaquete().get(j).getDestino().equals(Configuracion.numeroSucursal)){
             listaPaquetesAux.add(transportePaquetes.getListaPaquete().get(j));
             tiempo= tiempo+11;
             transportePaquetes.getListaPaquete().get(j).setTiempoDeLlegada(tiempo);
             Configuracion.listaPaquetesRecibidos.add(transportePaquetes.getListaPaquete().get(j));
             Paquete paquete = transportePaquetes.getListaPaquete().get(j);
             //duerme 10 segundos
             String paqueteXML = xstream.toXML(paquete);
             RemClient.enviarPaqueteAServerCenral(paqueteXML,true);
             System.out.println("se mando el paquete");
             
         }
         
        
        else 
        {
             tiempo++;
               Incidencia incidencia = new Incidencia (Configuracion.numeroSucursal,tiempo,"Traslado","El paquete pasÃ³ por la sucursal: " + Configuracion.numeroSucursal);
                transportePaquetes.getListaPaquete().get(j).getListaIncidencia().add(incidencia);
                //agregar espera de tiempo
                 
              }
        }
       
      
       }
        transportePaquetes.getListaPaquete().removeAll(listaPaquetesAux);
       
        
        transporte = xstream.toXML(transportePaquetes);
           System.out.println("HEYYYYY" + transporte);
       
         RemClient.remObjectEnvio.enviarPaquete(transporte);
       }
        //chequeo si estoy en la misma sucursal de donde salÃ­.
           
       if (transportePaquetes.getSucursal().equals(Configuracion.numeroSucursal))
       { 
           
          
           Configuracion.transporteEnvio.setDisponible(true);
        
           for (int i = 0; i < Configuracion.listaPaquetesAEnviar.size(); i++) {
            if (!Configuracion.listaPaquetesAEnviar.get(i).getDestino().equals(Configuracion.numeroSucursalEnvio))
            {
        transportePaquetes.getListaPaquete().add(Configuracion.listaPaquetesAEnviar.get(i));
       listaPaquetesAux.add(Configuracion.listaPaquetesAEnviar.get(i));
        
            }
           }
        Configuracion.listaPaquetesAEnviar.removeAll(listaPaquetesAux);
        
        transporte = xstream.toXML(transportePaquetes);   
           System.out.println("EPAAAA" + transporte);
        if (!transportePaquetes.getListaPaquete().isEmpty()){
            transporte = xstream.toXML(transportePaquetes);
            
            RemClient.remObjectEnvio.enviarPaquete(transporte);
            Configuracion.transporteEnvio.setDisponible(false);
        }  
        
       }
       
   RemClient.actualizarHoraServerCentral(tiempo);
       
    }
    
    public void reenviarTransporteAjeno(String transporteRecepcion)throws RemoteException{
    ArrayList <Paquete> listaPaqueteAux = new ArrayList<>();
    XStream xstream =new XStream();    
    xstream.alias("Transporte", Transporte.class);
    xstream.alias("Paquete", Transporte.class);
    Transporte transporte = (Transporte) xstream.fromXML(transporteRecepcion);
    
    if (transporte.getSucursal().equals(Configuracion.numeroSucursal))
     {
     Configuracion.transporteRecepcion = transporte;
     
     for (int i=0;i<Configuracion.listaPaquetesAEnviar.size();i++)
     {
         if (Configuracion.listaPaquetesAEnviar.get(i).getDestino().equals(Configuracion.numeroSucursalEnvio)){
             Configuracion.transporteRecepcion.getListaPaquete().add(Configuracion.listaPaquetesAEnviar.get(i));
            
             listaPaqueteAux.add(Configuracion.listaPaquetesAEnviar.get(i));
         }
     }
         Configuracion.listaPaquetesAEnviar.removeAll(listaPaqueteAux);
         Configuracion.transporteRecepcion.setDisponible(true);
     
     }
    else {
        //aumentar tiempo
    RemClient.remObjectRecepcion.reenviarTransporteAjeno(transporteRecepcion);
    
    }
    }
}
