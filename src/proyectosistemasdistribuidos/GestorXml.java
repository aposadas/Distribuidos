/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosistemasdistribuidos;

import java.io.File;
import java.util.ArrayList;
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
        
	File fXmlFile = new File("files/puertoslibres.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	doc.getDocumentElement().normalize();



	NodeList nList = doc.getElementsByTagName("Configuracion");



	 
		Node nNode = nList.item(0);



                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode; 
                       


                        RemServer.ipServidorCentral = eElement.getElementsByTagName("ipSevidorCentral").item(0).getTextContent();
                        RemServer.puertoCliente =  Integer.parseInt(eElement.getElementsByTagName("puertoServidorCentral").item(0).getTextContent());
                        RemServer.puertoServidor =  Integer.parseInt(eElement.getElementsByTagName("puertoSevidor").item(0).getTextContent());
                        RemServer.ipCliente =  eElement.getElementsByTagName("ipCliente").item(0).getTextContent();
                        RemServer.puertoCliente =  Integer.parseInt(eElement.getElementsByTagName("puertoCliente").item(0).getTextContent());

		}
	}
     catch (Exception e) {
	e.printStackTrace();
    }
  }
   public static ArrayList<Paquete>obtenerPaquetesRecibidos(){
   
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
                        Paquete aux = new Paquete();
                       


                        aux.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                        aux.setNombre(eElement.getElementsByTagName("nombreProducto").item(0).getTextContent());
                        aux.setCantidad(Integer.parseInt(eElement.getElementsByTagName("cantidad").item(0).getTextContent()));
                        aux.setId(Integer.parseInt(eElement.getElementsByTagName("idpedi").item(0).getTextContent()));
                        aux.setObservaciones(eElement.getElementsByTagName("observaciones").item(0).getTextContent());

                        lista.add(aux);

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    return lista;
  }
   }
}
