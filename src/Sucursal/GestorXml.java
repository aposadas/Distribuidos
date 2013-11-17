/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Aileen
 */
public class GestorXml {
   
    public static void obtenerConfiguracion(){
    try {
	File fXmlFile = new File("files/configuracionSucursal.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();
	NodeList nList = doc.getElementsByTagName("Configuracion");

		Node nNode = nList.item(0);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode; 
                        Configuracion.numeroSucursal = eElement.getElementsByTagName("numeroSucursal").item(0).getTextContent();
                        Configuracion.puertoSucursal = Integer.parseInt(eElement.getElementsByTagName("puertoSucursal").item(0).getTextContent());
                        Configuracion.numeroSucursalEnvio = eElement.getElementsByTagName("numeroSucursalEnvio").item(0).getTextContent();
                        Configuracion.numeroSucursalRecepcion = eElement.getElementsByTagName("numeroSucursalRecepcion").item(0).getTextContent();
                        Configuracion.ipServidorCentral = eElement.getElementsByTagName("ipSevidorCentral").item(0).getTextContent();
                        Configuracion.puertoServidorCentral=  Integer.parseInt(eElement.getElementsByTagName("puertoServidorCentral").item(0).getTextContent());
                        Configuracion.IpServidorEnvio = eElement.getElementsByTagName("ipSevidorEnvio").item(0).getTextContent();
                        Configuracion.puertoServidorEnvio=  Integer.parseInt(eElement.getElementsByTagName("puertoServidorEnvio").item(0).getTextContent());
                        Configuracion.IpServidorRecepcion=  eElement.getElementsByTagName("ipServidorRecepcion").item(0).getTextContent();
                        Configuracion.puertoServidorRecepcion=  Integer.parseInt(eElement.getElementsByTagName("puertoServidorRecepcion").item(0).getTextContent());
                        
                }
	}
     catch (Exception e) {
	e.printStackTrace();
    }
  }
   public static ArrayList<Paquete>obtenerPaquetesRecibidos(){
   
       ArrayList<Paquete> lista = new ArrayList<>();
    try {
        
	File fXmlFile = new File("files/paquetesRecibidos.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	doc.getDocumentElement().normalize();



	NodeList nList = doc.getElementsByTagName("paquetes");



	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());


                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
                        Paquete paquete = new Paquete();


                        paquete.setId(Integer.parseInt( eElement.getElementsByTagName("id").item(0).getTextContent()));
                        paquete.setTiempoDeSalida(Long.parseLong( eElement.getElementsByTagName("tiempoSalida").item(0).getTextContent()));
                        paquete.setTiempoDeLlegada(Long.parseLong(eElement.getElementsByTagName("tiempoLlegada").item(0).getTextContent()));
                        paquete.setOrigen(eElement.getElementsByTagName("Origen").item(0).getTextContent());
                        paquete.setDestino(eElement.getElementsByTagName("Destino").item(0).getTextContent());
                        
                        lista.add(paquete);

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    return lista;
  }
 }

