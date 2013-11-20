/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SevidorCentral;


import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aileen
 */
public class SevidorCentralProySistemasDistribuidos {
public static Registry registro;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 
    //Cración del server Central RMI /////////////////////////////// 
        try {
            RemServidorCentralImpl mensajeRemoto = new RemServidorCentralImpl();
            System.setProperty("java.rmi.server.hostname","localhost");
            System.setProperty("java.security.policy","file:files/politica.policy");
            
            
            
            registro = java.rmi.registry.LocateRegistry.createRegistry(1099);
            registro.bind("objetoServidorCentral", mensajeRemoto);
        
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(SevidorCentralProySistemasDistribuidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(SevidorCentralProySistemasDistribuidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    catch(RemoteException re) 
        {
            System.out.println("RemoteException: " + re);
         } 
     
     // invocación metodos GUI
      
   GUIServidorCentral gui = new GUIServidorCentral();
   gui.setVisible(true);
   
   System.out.println("lista" +RemServidorCentralImpl.getListaSucursales() );
    }
    
    
}
