/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

import java.util.ArrayList;

/**
 *
 * @author Aileen
 */
public class Configuracion {
   public static String numeroSucursal;
   public static int puertoSucursal;
   public static String numeroSucursalEnvio;
   public static String numeroSucursalRecepcion;
   public static String ipServidorCentral;
   public static int puertoServidorCentral;
   public static String IpServidorEnvio;
   public static int puertoServidorEnvio;
   public static String IpServidorRecepcion;
   public static int puertoServidorRecepcion;
   public static ArrayList<Paquete> listaPaquetesRecibidos = new ArrayList<>();
   public static ArrayList<Paquete> listaPaquetesSucursalSiguiente = new ArrayList<>();
   public static Transporte transporteEnvio;
   public static Transporte transporteRecepcion;
}
