/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SevidorCentral;

import Sucursal.Paquete;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Aileen
 */
public class RemServidorCentralImpl extends UnicastRemoteObject implements RemServidorCentral{

    public static ArrayList<String> listaSucursales = new ArrayList<>();
    public static ArrayList<Paquete> listaPaquetes = new ArrayList<>();

    public static ArrayList<String> getListaSucursales() {
        return listaSucursales;
    }
     public static ArrayList<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }
      

    public RemServidorCentralImpl() throws RemoteException  {
        
    }

   
  

    @Override
    public void agregarSucursalActiva(String ipSucursal, String numSucursal, boolean activa) {
        if (activa == true){
        listaSucursales.add("Sucursal "+numSucursal);
        System.out.println("Se Agrego el  ip de las sucursal" + ipSucursal +" num sucursal "+ numSucursal);
        }
        else if (activa == false){
        listaSucursales.remove("Sucursal "+numSucursal);
        
        }
        
    }

    @Override
    public String getMessage() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
        
    
    }

    @Override
    public ArrayList<String> listaSucursalActiva() throws RemoteException {
        return listaSucursales;
        
      
    }

    @Override
    public void agregarPaquete(Paquete paquete, boolean enviado) throws RemoteException {
        
         if (enviado == true){
        listaPaquetes.add(paquete);
        System.out.println("Se Agrego el paquete" );
        }
        else if (enviado == false){
        listaPaquetes.remove(paquete);
        
        }
        
    }
    
  
    
    
}
