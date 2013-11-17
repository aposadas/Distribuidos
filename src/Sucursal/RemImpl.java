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
    public void enviarPaquete(Paquete paquete) throws RemoteException{
        
       Configuracion.transporteEnvio.getListaPaquete().add(paquete); 
       XStream xstream = new XStream();
       xstream.alias("Transporte", Transporte.class);
       this.transporteXML  = xstream.toXML(Configuracion.transporteEnvio);
        try {
            UnicastRemoteObject.exportObject(this);
        } catch (RemoteException ex) {
            Logger.getLogger(RemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }
    
    public void reenviarPaqueteAjeno(Transporte transporteEnvio)throws RemoteException{
        
        try {
            UnicastRemoteObject.exportObject(this);
        } catch (RemoteException ex) {
            Logger.getLogger(RemImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
