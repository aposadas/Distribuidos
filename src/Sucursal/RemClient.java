/*
The RMI Client
 */
package Sucursal;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



/**
 *
 *  Get a Rem object from the specified remote host.
 *  Use its methods as though it were a local object.
 * @see Rem

 * @author Aileen
 */
public class RemClient {
  private static Registry registroServidorCentral;
  private static Registry registroServidorEnvio;
  private static Registry registroServidorRecepcion;
  public static Rem remObjectCentral;
  public static Rem remObjectEnvio;
  public static Rem remObjectRecepcion;
     public static void CrearClientes() {
        try {
            //Configuracion de la jvm para rmi requerida
            System.setProperty("java.rmi.server.hostname", "localhost");   
            System.setProperty("java.security.policy","file:files/politica.policy");
            System.setSecurityManager(new RMISecurityManager());
            
            /// Me registro como cliente del Servidor Central
            registroServidorCentral = LocateRegistry.getRegistry("localhost", Configuracion.puertoServidorCentral);
            String hostCentral = Configuracion.ipServidorCentral;
            // Get remote object and store it in remObject:
             remObjectCentral = (Rem) Naming.lookup("//" + hostCentral + "/objetoServidorCentral");
           //// Fin registro Servidor Central.
           
           /// Registro como cliente del Servidor Recepción
            registroServidorEnvio = LocateRegistry.getRegistry("localhost", Configuracion.puertoServidorEnvio);
            String hostEnvio =Configuracion.IpServidorEnvio;
            remObjectEnvio = (Rem) Naming.lookup("//" + hostEnvio + "/objetoServidor" + Configuracion.numeroSucursalEnvio);
           //// Fin registro Servidor Recepcion.
            
            /// Registro como cliente del Servidor Envio
            registroServidorRecepcion = LocateRegistry.getRegistry("localhost", Configuracion.puertoServidorRecepcion);
            String hostRecepcion = Configuracion.IpServidorRecepcion;
             remObjectRecepcion = (Rem) Naming.lookup("//" + hostEnvio + "/objetoServidor" + Configuracion.numeroSucursalRecepcion);
           //// Fin registro Servidor Envio.
            
            
 
            
        } 
        catch(RemoteException re) 
        {
            System.out.println("RemoteException: " + re);
        } 
        catch(NotBoundException nbe) 
        {
            System.out.println("NotBoundException: " + nbe);
        } 
        catch(MalformedURLException mfe) 
        {
            System.out.println("MalformedURLException: "+ mfe);
        }
     }
     
}
