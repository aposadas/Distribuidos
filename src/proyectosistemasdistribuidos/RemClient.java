/*
The RMI Client
 */
package proyectosistemasdistribuidos;


import java.rmi.*; // For Naming, RemoteException, etc.
import java.net.*; // For MalformedURLException
import java.io.*;  // For Serializable interface
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;



/**
 *
 *  Get a Rem object from the specified remote host.
 *  Use its methods as though it were a local object.
 * @see Rem

 * @author Aileen
 */
public class RemClient {
  private static Registry registro;
     public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            registro = LocateRegistry.getRegistry("localhost", RemServer.puertoCliente);        
            System.setProperty("java.security.policy","file:files/politica.policy");
            System.out.println(System.getProperty("java.security.policy"));
            System.setSecurityManager(new RMISecurityManager());
            String host =(args.length > 0) ? args[0] : "localhost";
            // Get remote object and store it in remObject:
            System.out.println(host);
            
            Rem remObject = (Rem) Naming.lookup("//" + host + "/ObjectRMIServer");
           
            // Call methods in remObject:
            System.out.println(remObject.getMessage());
            
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
