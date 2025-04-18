
package Users;

import config.DbConnect;
import config.Logger;
import config.Session;
import java.awt.Cursor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UserResetPassword extends javax.swing.JFrame {

  
    public UserResetPassword() {
        initComponents();
    }
private boolean updatePassword(String newPassword) {
    String userId = Session.getInstance().getuid() + "";
    String hashedNewPassword = hashPassword(newPassword); 

    if (hashedNewPassword == null) return false;

    String sql = "UPDATE users SET RegPass = ? WHERE u_id = ?";

    try (Connection connect = new DbConnect().getConnection();
         PreparedStatement pst = connect.prepareStatement(sql)) {
        
        pst.setString(1, hashedNewPassword); 
        pst.setString(2, userId);

        return pst.executeUpdate() > 0; 
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
public static String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titlelabel7 = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        accname = new javax.swing.JLabel();
        titlelabel8 = new javax.swing.JLabel();
        titlelabel9 = new javax.swing.JLabel();
        titlelabel10 = new javax.swing.JLabel();
        ResetButton = new javax.swing.JButton();
        titlelabel11 = new javax.swing.JLabel();
        reenterPasswordField = new javax.swing.JPasswordField();
        currentPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        jPasswordField4 = new javax.swing.JPasswordField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titlelabel7.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel7.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        titlelabel7.setForeground(new java.awt.Color(255, 255, 255));
        titlelabel7.setText("You can now Reset your password!");
        jPanel2.add(titlelabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 740, 70));

        acc_id.setBackground(new java.awt.Color(0, 0, 0));
        acc_id.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        acc_id.setForeground(new java.awt.Color(255, 255, 255));
        acc_id.setText("ID");
        jPanel2.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        accname.setBackground(new java.awt.Color(0, 0, 0));
        accname.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        accname.setText("accname");
        jPanel1.add(accname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 220, 70));

        titlelabel8.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel8.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        titlelabel8.setText("Confirm Password:");
        jPanel1.add(titlelabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 270, 70));

        titlelabel9.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel9.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        titlelabel9.setText("ACCOUNT:");
        jPanel1.add(titlelabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 70));

        titlelabel10.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel10.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        titlelabel10.setText("Old  Password:");
        jPanel1.add(titlelabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, 70));

        ResetButton.setBackground(new java.awt.Color(51, 51, 255));
        ResetButton.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        ResetButton.setText("Reset");
        ResetButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetButton.setBorderPainted(false);
        ResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ResetButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ResetButtonMouseExited(evt);
            }
        });
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 150, 40));

        titlelabel11.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel11.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        titlelabel11.setText("New Password:");
        jPanel1.add(titlelabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 190, 70));
        jPanel1.add(reenterPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 290, 50));

        currentPasswordField.setEditable(false);
        currentPasswordField.setText("jPasswordField1");
        jPanel1.add(currentPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 290, 50));
        jPanel1.add(newPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 290, 50));

        jPasswordField4.setText("jPasswordField1");
        jPanel1.add(jPasswordField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 290, 50));

        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 30, 50));

        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 30, 50));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 860, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ResetButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetButtonMouseEntered
        ResetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ResetButtonMouseEntered

    private void ResetButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetButtonMouseExited
        ResetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ResetButtonMouseExited

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
   String newPass = String.valueOf(newPasswordField.getPassword());
        String reenterPass = String.valueOf(reenterPasswordField.getPassword());

        if (newPass.isEmpty() || reenterPass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!newPass.equals(reenterPass)) {
            JOptionPane.showMessageDialog(this, "New passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!newPass.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*\\d).{8,}$") || (!reenterPass.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*\\d).{8,}$"))) {
       JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long, contain at least one uppercase letter, one number, and one special character.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
      if (updatePassword(newPass)) {
    try (Connection con = new DbConnect().getConnection()) {
        Logger logger = new Logger(con); 
        Session sess = Session.getInstance();
        String username = String.valueOf(sess.getusername());
        String userIdText = acc_id.getText(); 
        
        if (userIdText == null || userIdText.isEmpty()) {
            System.err.println("User ID is null or empty. Cannot log password change.");
            logger.logAdd(0, "User has RESET their password without a valid ID, Username: " + username);
        } else {
            int userID = Integer.parseInt(userIdText); 
            logger.logAdd(userID, "User RESET their password, Username: " + username);
        }
    } catch (SQLException ex) {
        System.err.println("Error logging password change: " + ex.getMessage());
    } catch (NumberFormatException ex) {
        System.err.println("Invalid user ID format: " + ex.getMessage());
    }
            JOptionPane.showMessageDialog(this, "Password changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            Loginform lf = new Loginform();
        lf.setVisible(true);
        this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error updating password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        
        
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
       
       if(sess.getuid() == 0){
           JOptionPane.showMessageDialog(null,"No account found , Log in First!");
           Loginform lf = new Loginform();
           lf.setVisible(true);
           this.dispose();
       
       }
       acc_id.setText(""+sess.getuid());
       accname.setText(""+sess.getusername());
       currentPasswordField.setText(""+sess.getPassword());
       currentPasswordField.setEchoChar('*');
       
    }//GEN-LAST:event_formWindowActivated

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            newPasswordField.setEchoChar((char) 0);
        } else {
            newPasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if (jCheckBox3.isSelected()) {
            reenterPasswordField.setEchoChar((char) 0);
        } else {
            reenterPasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

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
            java.util.logging.Logger.getLogger(UserResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserResetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel accname;
    private javax.swing.JPasswordField currentPasswordField;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JPasswordField reenterPasswordField;
    private javax.swing.JLabel titlelabel10;
    private javax.swing.JLabel titlelabel11;
    private javax.swing.JLabel titlelabel7;
    private javax.swing.JLabel titlelabel8;
    private javax.swing.JLabel titlelabel9;
    // End of variables declaration//GEN-END:variables

}
