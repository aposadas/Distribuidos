/*
The Interface for the Remote Object
 */
package Sucursal;
import java.rmi.*;
import Sucursal.Transporte;
import java.util.ArrayList;
/**
 * @author Aileen
 */
public interface Rem extends java.rmi.Remote {
    public String getMessage() throws RemoteException;
    public String pedirPaquetes(String sucursal) throws RemoteException;
    public void enviarPaquete(String paquete)throws RemoteException;
    public void reenviarTransporteAjeno (String tasnporteRecepcion) throws RemoteException;
    
     
     
}
