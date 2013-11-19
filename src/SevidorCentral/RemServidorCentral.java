/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SevidorCentral;

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
     
    
    
    
    
}
