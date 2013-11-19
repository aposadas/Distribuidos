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
import java.util.Iterator;

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
        
        listaSucursales.add("Sucursal "+numSucursal);
        System.out.println("Se Agrego el  ip de las sucursal" + ipSucursal +" num sucursal "+ numSucursal);
       
       
        
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

    @Override
    public boolean verificarSucursal(String ipNuevaSurcusal) throws RemoteException{
        Iterator iterator = listaSucursales.iterator();
        String ip;
        while (iterator.hasNext()){
             ip = iterator.next().toString();
             if (ip.contains(ipNuevaSurcusal))
                 return false;
        }
        return true;
    }

    @Override
    public void eliminarSucursal(String numSucursal) {
        
      listaSucursales.remove("Sucursal "+numSucursal);
    }
    
  
    
    
}
