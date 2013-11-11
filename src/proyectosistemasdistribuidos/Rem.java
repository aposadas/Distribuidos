/*
The Interface for the Remote Object
 */
package proyectosistemasdistribuidos;
import java.rmi.*;
import proyectosistemasdistribuidos.Transporte;
/**
 * The RMI client will use this interface directly.
 *  The RMI server will make a real remote object that
 *  implements this, then register an instance of it
 *  with some URL.
 * 
 * @author Aileen
 */
public interface Rem extends java.rmi.Remote {
    
    
    public String getMessage() throws RemoteException;
    public Transporte pedirTransportes() throws RemoteException;
    
}
