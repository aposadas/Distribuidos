/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SevidorCentral;

import Sucursal.Incidencia;
import Sucursal.Paquete;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Aileen
 */
public class DetalleTraza extends javax.swing.JFrame {

   
    private Paquete paquete;
    private javax.swing.JFrame ventanaPadre;
    
    public DetalleTraza(javax.swing.JFrame ventanaPadre, Paquete paquete) {
        
        initComponents();
        this.paquete= paquete;
        this.ventanaPadre = ventanaPadre;
        this.ventanaPadre.setVisible(false);
        iniciar();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabelIpOrigen = new javax.swing.JLabel();
        jLabelIpDestino = new javax.swing.JLabel();
        jLabelHoraCarga = new javax.swing.JLabel();
        jLabelHoraSalida = new javax.swing.JLabel();
        jLabelHoraLLegada = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonRegresar = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabeltiempoTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Detalle Traza del Paquete");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sucursal Origen:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sucursal Destino: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tiempo de carga en el Sistema:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tiempo de salida del paquete:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tiempo de llegada del paquete: ");

        jScrollPane1.setViewportView(jList1);

        jLabelIpOrigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIpOrigen.setText("-");

        jLabelIpDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIpDestino.setText("-");

        jLabelHoraCarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraCarga.setText("-");

        jLabelHoraSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraSalida.setText("-");

        jLabelHoraLLegada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraLLegada.setText("-");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Sucursales Recorridas");

        jButtonRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Back.png"))); // NOI18N
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.setContentAreaFilled(false);
        jButtonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegresar.setDefaultCapable(false);
        jButtonRegresar.setFocusPainted(false);
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tiempo total de la traza:");

        jLabeltiempoTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabeltiempoTotal.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel1)
                        .addGap(0, 287, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator8)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelHoraCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(37, 37, 37)
                                .addComponent(jLabelHoraLLegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRegresar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabelHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelIpDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelIpOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabeltiempoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIpOrigen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelIpDestino))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabelHoraSalida))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabelHoraCarga))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabelHoraLLegada))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeltiempoTotal)
                            .addComponent(jLabel9))
                        .addGap(28, 28, 28)
                        .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        this.ventanaPadre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed
    
    
    private void iniciar(){
        
        long tiempoTotal=0;
        jLabelIpOrigen.setText(paquete.getOrigen());
        jLabelIpDestino.setText(paquete.getDestino());
     
        jLabelHoraCarga.setText(String.valueOf(paquete.getTiempoDeSalida()+1)+" Seg.");
        
        jLabelHoraSalida.setText(String.valueOf(paquete.getTiempoDeSalida())+ " Seg.");
        
        jLabelHoraLLegada.setText(String.valueOf(paquete.getTiempoDeLlegada())+ " Seg.");
        
        DefaultListModel model = new DefaultListModel();
        
        
       if (paquete.getListaIncidencia().isEmpty() == true){
       
            model.addElement("Sucursal " +paquete.getOrigen()+ " Tiempo: " + paquete.getTiempoDeSalida()+ " seg. "+ " -->");
            model.addElement("Sucursal " + paquete.getDestino()+ " Tiempo: " + paquete.getTiempoDeLlegada()+" seg. " );

                tiempoTotal=paquete.getTiempoDeLlegada()+paquete.getTiempoDeSalida();

            jList1.setModel(model);  
       
       }
       else{
            Iterator iterator = paquete.getListaIncidencia().iterator();
            model.addElement("  Sucursal " + paquete.getOrigen()+ " tiempo: " + paquete.getTiempoDeSalida() +" seg. " + " -->");
            while (iterator.hasNext()){
                Incidencia incidencia = (Incidencia) iterator.next();
                String sucursal = incidencia.getSucursal();
                String tiempo = String.valueOf(incidencia.getMomento());
                model.addElement("  Sucursal " + sucursal + " tiempo: " + tiempo + " seg. " + " -->");
                tiempoTotal=incidencia.getMomento()+tiempoTotal;
            }
            model.addElement("  Sucursal " + paquete.getDestino()+ " tiempo: " + paquete.getTiempoDeLlegada() +" seg. ");
            jList1.setModel(model);  
     
                tiempoTotal=tiempoTotal+paquete.getTiempoDeLlegada()+1;
       }
       
       jLabeltiempoTotal.setText(String.valueOf(tiempoTotal-paquete.getTiempoDeSalida())+" Segundos.");
       
    }
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelHoraCarga;
    private javax.swing.JLabel jLabelHoraLLegada;
    private javax.swing.JLabel jLabelHoraSalida;
    private javax.swing.JLabel jLabelIpDestino;
    private javax.swing.JLabel jLabelIpOrigen;
    private javax.swing.JLabel jLabeltiempoTotal;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator8;
    // End of variables declaration//GEN-END:variables
}
