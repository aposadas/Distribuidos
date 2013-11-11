/*
  The RMI Server 
 */
package proyectosistemasdistribuidos;


import java.rmi.*;
import java.net.*;
import java.rmi.registry.Registry;
import java.util.ArrayList;


/** The server creates a RemImpl (which implements
 *  the Rem interface), then registers it with
 *  the URL Rem, where clients can access it.
 *
 * @author Aileen
 */
public class RemServer {
 static Registry registro;
   public static int numeroSucursal;
   public static String ipServidorCentral;
   public static int puertoServidorCentral;
   public static int puertoServidor;
   public static String ipCliente;
   public static int puertoCliente;
   public static ArrayList<Paquete> listaPaquetesRecibidos = new ArrayList<>();
   public static ArrayList<Paquete> listaPaquetesOtrasSucursales = new ArrayList<>();
   public static Transporte transporteEnvio = new Transporte("envio");
   public static Transporte tranporteRecepcion = new Transporte("recepcion");
   public static void main(String[] args) throws AlreadyBoundException {
   
   GestorXml.obtenerConfiguracion();
    try {
            RemImpl mensajeRemoto = new RemImpl();
            System.setProperty("java.security.policy","file:files/politica.policy");
            System.setProperty("java.rmi.server.hostname","localhost");
            registro = java.rmi.registry.LocateRegistry.createRegistry(puertoServidor);
            registro.bind("ObjectRMIServer", mensajeRemoto);
        } 
    catch(RemoteException re) 
        {
            System.out.println("RemoteException: " + re);
         } 
    
   }
    
}
