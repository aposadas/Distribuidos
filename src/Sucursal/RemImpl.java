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
    

    
   
    public Transporte pedirPaquetes() throws RemoteException {
        
             //Así aca podemos setear aca colocar el thread sleep de 5 seg         
        return Configuracion.tranporteRecepcion;
        
    }
        
    
    
    @Override
    public void enviarPaquete(String transporte) throws RemoteException{
      this.transporteXML = transporte;
        System.out.println(transporte);
        XStream xstream = new XStream ();
        Transporte transportePaquetes =(Transporte) xstream.fromXML(transporte);
        
       int tamanio =transportePaquetes.getListaPaquete().size();
     
       if (tamanio>0){
        for (int j=0;j<tamanio+1;j++)
         if (transportePaquetes.getListaPaquete().get(j).getDestino().equals(Configuracion.numeroSucursal)){
             transportePaquetes.getListaPaquete().get(j).setTiempoDeLlegada(System.currentTimeMillis()/1000);
             Configuracion.listaPaquetesRecibidos.add(transportePaquetes.getListaPaquete().get(j));
             transportePaquetes.getListaPaquete().remove(j);
         }
        //ELSE!!!!!! 
       }
             
        try {
            UnicastRemoteObject.exportObject(this);
        } catch (RemoteException ex) {
            Logger.getLogger(RemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          catch (Exception e){
          e.printStackTrace();
          }
       
    }
    
    public void reenviarPaqueteAjeno(String transporteEnvio)throws RemoteException{
        
        try {
            UnicastRemoteObject.exportObject(this);
        } catch (RemoteException ex) {
            Logger.getLogger(RemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
