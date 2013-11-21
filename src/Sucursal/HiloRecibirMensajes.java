/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursal;

import com.thoughtworks.xstream.XStream;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class HiloRecibirMensajes extends Thread {
    
    @Override
    public void run(){
        while(1==1){
        try {
            String transporte= RemClient.remObjectRecepcion.pedirPaquetes(Configuracion.numeroSucursal);
            
           
            
            if (transporte!=null)
            {
                long tiempo =RemClient.pedirReloj();
                XStream xstream = new XStream();
                xstream.alias("Transporte", Transporte.class);
                xstream.alias("Paquete", Paquete.class);
                Transporte transporte_paquete = (Transporte) xstream.fromXML(transporte);
                
                
                
                for (int i = 0; i < transporte_paquete.getListaPaquete().size(); i++) {
                    Paquete paquete = transporte_paquete.getListaPaquete().get(i);
                    tiempo = tiempo+5;
                    
                    paquete.setTiempoDeLlegada(tiempo);
                    Configuracion.listaPaquetesRecibidos.add(paquete);
                    transporte_paquete.getListaPaquete().remove(i);
  
     String paqueteXML = xstream.toXML(paquete);
     RemClient.enviarPaqueteAServerCenral(paqueteXML,true);
                    
                    
                }
                transporte = xstream.toXML(transporte_paquete);
                RemClient.remObjectRecepcion.reenviarTransporteAjeno(transporte);
                
                RemClient.actualizarHoraServerCentral(tiempo);
            }
        }  
           catch (RemoteException ex) {
                Logger.getLogger(HiloRecibirMensajes.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
}