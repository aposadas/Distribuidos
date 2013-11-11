/*
The Remote Object Implementation
 */
package proyectosistemasdistribuidos;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import proyectosistemasdistribuidos.Paquete;
import proyectosistemasdistribuidos.Transporte;

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
    
    public RemImpl() throws RemoteException 
    {
    
    }

   
    public String getMessage() throws RemoteException 
    {
        return("habla betxo");
    }
    

    
    public Transporte pedirTransportes() throws RemoteException {
        
        if (RemServer.transporteEnvio.getListaPaquete().size()>0)
        
        return RemServer.transporteEnvio;
        
        else if (RemServer.tranporteRecepcion.getListaPaquete().size()>0) //transporteRecepcion  es el que recibe para luego enviar
            
        return RemServer.tranporteRecepcion;
        
        else
        return null;
    }
        
    
}
