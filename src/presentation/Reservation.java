/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import dao.IScolarite;
import dao.ScolariteImpl;
import javax.swing.JOptionPane;
import presentation.TableParkingspots;
import metier.entity.*;
import org.mindrot.jbcrypt.BCrypt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static presentation.Login_frame.idextract;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.Connexion;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author lenovo
 */
public class Reservation extends javax.swing.JFrame {
    IScolarite action=new ScolariteImpl();
    TableParkingspots me=new TableParkingspots();
    Connection conn = null;
    int parkingid;
    int clientid;
    /**
     * Creates new form Reservation
     */
    public Reservation() {
        initComponents();
        me.chargerTable(action.getAllParkings());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Prix = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Date_Debut = new com.toedter.calendar.JDateChooser();
        Date_Fin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(me);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 800, 220));

        Prix.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(Prix, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, -1));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\OneDrive\\Desktop\\Junk\\Parking\\Icons\\reservation (1).png")); // NOI18N
        jButton1.setText("Reserver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 110, 30));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\lenovo\\OneDrive\\Desktop\\Junk\\Parking\\Icons\\Cancel (1).png")); // NOI18N
        jButton2.setText("Annuler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Date Debut :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        Date_Debut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Date_DebutPropertyChange(evt);
            }
        });
        getContentPane().add(Date_Debut, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 300, 30));

        Date_Fin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Date_FinMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Date_FinMouseExited(evt);
            }
        });
        Date_Fin.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                Date_FinComponentAdded(evt);
            }
        });
        Date_Fin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Date_FinFocusLost(evt);
            }
        });
        Date_Fin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Date_FinPropertyChange(evt);
            }
        });
        getContentPane().add(Date_Fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 300, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date Fin :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Prix :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 840, 240));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Reservation");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    int ligne = jTable1.getSelectedRow();
    parkingid = Integer.parseInt(String.valueOf(me.getValueAt(ligne, 0)));
    clientid = idextract;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateDebut = Date_Debut.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateFin = Date_Fin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            long difference = Duration.between(dateDebut.atStartOfDay(), dateFin.atStartOfDay()).toHours();
            int duree = (int) difference;

            double PrixR = duree * 1.5;
            Prix.setText(Double.toString(PrixR));

            try {
                conn = Connexion.getConnect();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO reservation (PS_ID_R, C_ID, Date_Debut, Date_Fin, Duree, Prix) VALUES (?, ?, ?, ?, ?, ?)");
                pst.setInt(1, parkingid);
                pst.setInt(2, clientid);
                pst.setString(3, dateDebut.format(dateFormatter));
                pst.setString(4, dateFin.format(dateFormatter));
                pst.setInt(5, duree);
                pst.setDouble(6, PrixR);
                pst.executeUpdate();

                // Update the status of the reserved spot
                PreparedStatement updatePst = conn.prepareStatement("UPDATE parkingspots SET Status = ? WHERE PS_ID = ?");
                updatePst.setString(1, "Unavailable");
                updatePst.setInt(2, parkingid);
                updatePst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Reservation added successfully!");

                // Reset fields
                Date_Debut.setDate(null);
                Date_Fin.setDate(null);

                new UserP().setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to add reservation.");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Date_FinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Date_FinFocusLost
        // TODO add your handling code here:        
    }//GEN-LAST:event_Date_FinFocusLost

    private void Date_FinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Date_FinMouseExited
        // TODO add your handling code here:
       
    }//GEN-LAST:event_Date_FinMouseExited

    private void Date_FinComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_Date_FinComponentAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Date_FinComponentAdded

    private void Date_FinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Date_FinMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Date_FinMouseClicked

    private void Date_FinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Date_FinPropertyChange
        // TODO add your handling code here:
            if ("date".equals(evt.getPropertyName())) {
        updatePrix();
    }
    }//GEN-LAST:event_Date_FinPropertyChange

    private void Date_DebutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Date_DebutPropertyChange
        // TODO add your handling code here:
    if ("date".equals(evt.getPropertyName())) {
        updatePrix();
    }
    }//GEN-LAST:event_Date_DebutPropertyChange

    private void updatePrix() {
    LocalDate dateDebut = Date_Debut.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate dateFin = Date_Fin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    if (dateDebut != null && dateFin != null) {
        long difference = Duration.between(dateDebut.atStartOfDay(), dateFin.atStartOfDay()).toHours();
        int duree = (int) difference;

        double PrixR = duree * 1.5;
        Prix.setText(Double.toString(PrixR));
    }
}
    
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
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date_Debut;
    private com.toedter.calendar.JDateChooser Date_Fin;
    private javax.swing.JLabel Prix;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
