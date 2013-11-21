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
    public void agregarPaquete( String paquete, boolean enviado) throws RemoteException;
    public boolean verificarSucursal(String sucursal) throws RemoteException; 
    public void eliminarSucursal(String sucursal)throws RemoteException;
    public void sistemaColapso(String listaTransporte) throws RemoteException;
    public String mandarReloj()throws RemoteException;
    public void actualizarReloj(String reloj)throws RemoteException;
    
    
    
}