/*
  The RMI Server 
 */
package Sucursal;


import java.rmi.*;
import java.net.*;
import java.rmi.registry.Registry;
import java.util.ArrayList;


/** 
 * @author Aileen
 */
public class RemServer {
 static Registry registro;

    
 public static void CrearServidor() throws AlreadyBoundException {
   
   GestorXml.obtenerConfiguracion();
    try {
            RemImpl mensajeRemoto = new RemImpl();
            System.setProperty("java.security.policy","file:files/politica.policy");
            System.setProperty("java.rmi.server.hostname","localhost");
            registro = java.rmi.registry.LocateRegistry.createRegistry(Configuracion.puertoSucursal);
            registro.bind("objetoServidor" + Configuracion.numeroSucursal, mensajeRemoto);
  
            
            
        } 
    catch(RemoteException re) 
        {

            System.out.println("RemoteException: " + re);
         } 
    
   }
    
}
