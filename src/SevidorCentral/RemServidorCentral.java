/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SevidorCentral;

import Sucursal.Paquete;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Aileen
 */
public interface RemServidorCentral extends java.rmi.Remote {
   
    public String getMessage() throws RemoteException;
    public ArrayList<String> listaSucursalActiva() throws RemoteException;
    public void agregarSucursalActiva(String ipSucursal, String sucursal, boolean Activa) throws RemoteException;
    public void agregarPaquete( Paquete paquete, boolean enviado) throws RemoteException;
    public boolean verificarSucursal(String ip) throws RemoteException; 
    public void eliminarSucursal(String Sucursal)throws RemoteException;
    
    
    
    
}
