/*
The RMI Client
 */
package Sucursal;


import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import SevidorCentral.RemServidorCentral;
import java.util.ArrayList;



/**
 *
 * @author Aileen
 */
public class RemClient {
  private static Registry registroServidorCentral;
  private static Registry registroServidorEnvio;
  private static Registry registroServidorRecepcion;
  public static RemServidorCentral remObjectCentral;
  public static Rem remObjectEnvio;
  public static Rem remObjectRecepcion;
  
  
//PARA CREAR EL CLIENTE (SUCURSAL) QUE SE VA A COMUNICAR CON EL SERVER CENTRAL///
  public static boolean CrearClienteServerCentral(){
         boolean clienteServerCentral = true;
         try {
              System.setProperty("java.rmi.server.hostname", "localhost");   
              System.setProperty("java.security.policy","file:files/politica.policy");
              System.setSecurityManager(new RMISecurityManager());
              
                registroServidorCentral = LocateRegistry.getRegistry(Configuracion.ipServidorCentral, Configuracion.puertoServidorCentral);
              
                remObjectCentral =  ((RemServidorCentral) registroServidorCentral.lookup("objetoServidorCentral"));
              
            } catch (RemoteException ex) {
                Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
                clienteServerCentral= false;
           } catch (NotBoundException ex) {
              Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
               clienteServerCentral= false;
            }
      return clienteServerCentral;
      }
 //PARA CREAR EL CLIENTE (SUCURSAL)///    
     public static boolean CrearClientes() throws ConnectException {
        boolean creo=true;
         try {
            //Configuracion de la jvm para rmi requerida
            System.setProperty("java.rmi.server.hostname", "localhost");   
            System.setProperty("java.security.policy","file:files/politica.policy");
            System.setSecurityManager(new RMISecurityManager());
            
            /// Me registro como cliente del Servidor Central
            //registroServidorCentral = LocateRegistry.getRegistry("localhost", Configuracion.puertoServidorCentral);
           // String hostCentral = Configuracion.ipServidorCentral;
            // Get remote object and store it in remObject:
             //remObjectCentral = (Rem) Naming.lookup("//" + hostCentral + "/objetoServidorCentral");
           //// Fin registro Servidor Central.
           
           /// Registro como cliente del Servidor Recepción
            registroServidorEnvio = LocateRegistry.getRegistry(Configuracion.IpServidorEnvio, Configuracion.puertoServidorEnvio);
            String hostEnvio =Configuracion.IpServidorEnvio;
            try {
            remObjectEnvio =  ((Rem) registroServidorEnvio.lookup("objetoServidor" + Configuracion.numeroSucursalEnvio));
       
           //// Fin registro Servidor Recepcion.
            }
            catch (ConnectException e)
            {
            e.printStackTrace();
                System.out.println( "REMOBJECTENVIO: "+ "//" + hostEnvio + "/objetoServidor" + Configuracion.numeroSucursalEnvio);
            creo = false;
            }
            /// Registro como cliente del Servidor Envio
            registroServidorRecepcion = LocateRegistry.getRegistry(Configuracion.IpServidorRecepcion, Configuracion.puertoServidorRecepcion);
            String hostRecepcion = Configuracion.IpServidorRecepcion;
            try {
             remObjectRecepcion = ((Rem) registroServidorRecepcion.lookup("objetoServidor" + Configuracion.numeroSucursalRecepcion));
            //remObjectRecepcion = (Rem) Naming.lookup("//" + hostRecepcion + "/objetoServidor" + Configuracion.numeroSucursalRecepcion);
           //// Fin registro Servidor Envio.
            }
            catch (ConnectException e){
            e.printStackTrace();
             System.out.println( "REMOBJECRECEPCION: "+ "//" + hostEnvio + "/objetoServidor" + Configuracion.numeroSucursalRecepcion);
            creo = false;
            }
            
           
 
     } 
         
        catch(RemoteException re) 
        {
            System.out.println("RemoteException: " + re);
        } 
        catch(NotBoundException nbe) 
        {
            System.out.println("NotBoundException: " + nbe);
        } 
        /*catch(MalformedURLException mfe) 
        {
            System.out.println("MalformedURLException: "+ mfe);
        }*/
     return creo;
     }
 
// METODO PARA ENVIAR EL IP AL SERVIDOR CENTRAL, CAMBIAR LOCALHOST POR EL IP DEL SERVIDOR CUANDO LO TENGAMOS

     

     public static void enviarSucursalActiva(String ip, String numSucursal, boolean activa ){
        try {

            RemServidorCentral remServidorCentral = (RemServidorCentral) Naming.lookup("//localhost/"+"objetoServidorCentral");
            if ((remServidorCentral.verificarSucursal(numSucursal)) == true && (activa == true)) {
               
                remServidorCentral.agregarSucursalActiva(ip, numSucursal,activa);
                if (activa){
                    System.out.println("Se envio el ip :) " + numSucursal);
                }
            }
            
        } catch (NotBoundException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
     
     public static void eliminarSucursalActiva(String ip, String numSucursal ){
        try {
           
           
            RemServidorCentral remServidorCentral = (RemServidorCentral) Naming.lookup("//localhost/"+"objetoServidorCentral");
            
                remServidorCentral.eliminarSucursal(numSucursal);
                
        } catch (NotBoundException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public static void enviarPaqueteAServerCenral(String paquete, boolean enviado){
        try {
          
            RemServidorCentral remServidorCentral = (RemServidorCentral) Naming.lookup("//localhost/"+"objetoServidorCentral");
            remServidorCentral.agregarPaquete(paquete, enviado);
            
              } catch (NotBoundException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
     public static ArrayList <String> obtenerSucursales(){
     
         ArrayList <String> lista = new ArrayList ();
        try {
          
            RemServidorCentral remServidorCentral = (RemServidorCentral) Naming.lookup("//localhost/"+"objetoServidorCentral");
            lista=remServidorCentral.listaSucursalActiva();
            
            return lista;
              } catch (NotBoundException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RemClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
     }
     
}
