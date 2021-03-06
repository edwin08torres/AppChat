/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import PackSent.PS;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author at289
 */
public class Cliente extends javax.swing.JFrame implements Runnable{

    Thread mihilo = new Thread(this);
       
    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtLlenar = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtChat = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtNick = new javax.swing.JTextField();
        TxtIP = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(TxtLlenar);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        TxtChat.setColumns(20);
        TxtChat.setRows(5);
        jScrollPane1.setViewportView(TxtChat);
        Thread hilo = new Thread(this);
        hilo.start();

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("??CHAT??");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        TxtNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNickActionPerformed(evt);
            }
        });
        jPanel2.add(TxtNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 60, -1));
        jPanel2.add(TxtIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 80, -1));

        btnExit.setText("X");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(768, 432));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
      
        TxtChat.append("\n" + TxtLlenar.getText());
        
        try {
            //        System.out.println(TxtLlenar.getText());

            Socket servidor = new Socket("192.168.1.6", 6666);
            
            PS datos= new PS ();
            
            datos.setNick(TxtNick.getText());
            
            datos.setIp(TxtIP.getText());
            
            datos.setMensaje(TxtLlenar.getText());
            
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(servidor.getOutputStream());

            paqueteDatos.writeObject(datos);
            
            servidor.close();
            
//            DataOutputStream salida  = new DataOutputStream(servidor.getOutputStream());
//            
//            salida.writeUTF(TxtLlenar.getText());
//            
//            salida.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void TxtNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNickActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtChat;
    private javax.swing.JTextField TxtIP;
    private javax.swing.JTextField TxtLlenar;
    private javax.swing.JTextField TxtNick;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
    
    
    
    @Override
    public void run() {
         try{
             
             ServerSocket listener = new ServerSocket(6060);
             
             Socket canal;
             
             PS recibido;
             
             while(true){
                 canal = listener.accept();
                 
                 ObjectInputStream entrada = new ObjectInputStream(canal.getInputStream());
                 
                 recibido = (PS) entrada.readObject();
                 
                 TxtChat.append("\n" + recibido.getNick() + " : " +recibido.getMensaje());
             }
             
         }   catch(Exception e){
             System.out.println(e.getMessage());
         }   
    }
}

// 192.168.1.6