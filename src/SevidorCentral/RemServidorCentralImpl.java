/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SevidorCentral;

import Sucursal.Paquete;
import com.thoughtworks.xstream.XStream;
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
    public static long relojLogico=0;

    public static long getRelojLogico() {
        return relojLogico;
    }

    public static void setRelojLogico(long relojLogico) {
        RemServidorCentralImpl.relojLogico = relojLogico;
    }
   
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
        
        listaSucursales.add("Sucursal "+ numSucursal);
        System.out.println("Se Agrego el  ip de las sucursal" + ipSucursal +" num sucursal "+ numSucursal);
       System.out.println("lista" + getListaSucursales() ); 
       
        
    }

    
    
    @Override
    public String getMessage() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
        
    
    }

    @Override
    public ArrayList<String> listaSucursalActiva() throws RemoteException {
        
        System.out.println("lista" + listaSucursales ); 
        return listaSucursales;
        
           
      
    }

    @Override
    public void agregarPaquete(String paquete, boolean enviado) throws RemoteException {
        
         if (enviado == true){
             
             XStream xstream = new XStream();
             xstream.alias("Paquete", Paquete.class);
             Paquete paqueteRecibido= (Paquete) xstream.fromXML(paquete);
             
        listaPaquetes.add(paqueteRecibido);
        System.out.println("Se Agrego el paquete" );
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

    @Override
    public void sistemaColapso(String listaTransporte) throws RemoteException {
        
        
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizarReloj(String reloj) throws RemoteException {
        System.out.println("reloj antes:" + relojLogico);
         long cambios=0;
         relojLogico = Long.parseLong(reloj);
       
        // String cambioHoraString= String.valueOf(cambios);
         
        //return cambioHoraString; 
        // relojLogico=cambios;
         System.out.println("relojdespues:" + relojLogico);
    }

    @Override
    public String mandarReloj() throws RemoteException {
        
        String tiempoString= String.valueOf(relojLogico);
        
        return tiempoString;
    }
    
  
    
    
}
