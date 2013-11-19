/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

import java.rmi.AlreadyBoundException;
import java.rmi.ConnectException;

/**
 *
 * @author Aileen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AlreadyBoundException, ConnectException {
         GestorXml.obtenerConfiguracion();
         RemServer.CrearServidor();
 //CREO LA CONEXION PARA EL SERVER CENTRAL
         RemClient.CrearClienteServerCentral();
         boolean creo = false;
 //Mandar IP DEL CLIENTE CREADO       
  
        RemClient.enviarIp(Configuracion.IpServidorEnvio);
       // while (!creo){
       // creo= RemClient.CrearClientes();
  
       // }
          Menu menu = new Menu();
         menu.setVisible(true);
    }
    
}
