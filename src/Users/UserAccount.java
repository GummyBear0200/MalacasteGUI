
package Users;

import config.Session;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class UserAccount extends javax.swing.JFrame {

    
    public UserAccount() {
        initComponents();
       customizeButton(BackButton);
    customizeButton(LogoutButton);
    
    }
    
    private boolean hasShownPinReminder = false;
    private boolean isPinCreationOpen = false;
    
private void customizeButton(JButton button) {
   button.setOpaque(true);
button.setBorderPainted(false);
button.setFocusPainted(false);
button.setBackground(new Color(139, 0, 0)); 
button.setForeground(Color.WHITE);
button.setFont(new java.awt.Font("Arial Black", java.awt.Font.BOLD, 14));

   
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(0, 102, 204)); 
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(139, 0, 0)); 
        }
    });
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Interface1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        acc_fname_user = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        acc_lname_user = new javax.swing.JLabel();
        acc_lname_user1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        acc_cn_user = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        acc_cn_user2 = new javax.swing.JLabel();
        acc_cn_user3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        acc_cn_user4 = new javax.swing.JLabel();
        acc_cn_user5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        acc_cn_user6 = new javax.swing.JLabel();
        acc_cn_user7 = new javax.swing.JLabel();
        acc_cn_user8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        acc_em_user = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        acc_un_user = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        acc_ps_user = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        ChangePass = new javax.swing.JLabel();
        PIN = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Interface1.setBackground(new java.awt.Color(102, 102, 102));
        Interface1.setForeground(new java.awt.Color(102, 102, 102));
        Interface1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackButton.setBackground(new java.awt.Color(204, 0, 51));
        BackButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        BackButton.setText("BACK");
        BackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel3.add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 70));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SEE YOUR PERSONAL INFO HERE!");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 490, 50));

        LogoutButton.setBackground(new java.awt.Color(204, 0, 51));
        LogoutButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        LogoutButton.setText("LOGOUT");
        LogoutButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        jPanel2.add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 130, 30));

        Interface1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 70));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Interface1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 650));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_fname_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_fname_user.setText("User!");
        jPanel4.add(acc_fname_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 310, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel4.setText("Password:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 160, 50));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel6.setText("First Name:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 170, 50));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel8.setText("Last Name:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 170, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 350, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_lname_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_lname_user.setText("User!");
        jPanel6.add(acc_lname_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        acc_lname_user1.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_lname_user1.setText("User!");
        jPanel6.add(acc_lname_user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 350, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_cn_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user.setText("User!");
        jPanel7.add(acc_cn_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_cn_user2.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user2.setText("User!");
        jPanel8.add(acc_cn_user2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        acc_cn_user3.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user3.setText("User!");
        jPanel8.add(acc_cn_user3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_cn_user4.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user4.setText("User!");
        jPanel9.add(acc_cn_user4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        acc_cn_user5.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user5.setText("User!");
        jPanel9.add(acc_cn_user5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_cn_user6.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user6.setText("User!");
        jPanel10.add(acc_cn_user6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        acc_cn_user7.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user7.setText("User!");
        jPanel10.add(acc_cn_user7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        acc_cn_user8.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user8.setText("User!");
        jPanel7.add(acc_cn_user8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel7.setText("Contact No:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 160, 50));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel9.setText("Email:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 160, 50));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel10.setText("Username:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 160, 50));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_em_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_em_user.setText("User!");
        jPanel11.add(acc_em_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 350, 40));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_un_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_un_user.setText("User!");
        jPanel12.add(acc_un_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 320, 40));

        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 350, 40));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_ps_user.setEditable(false);
        acc_ps_user.setText("jPasswordField1");
        acc_ps_user.setBorder(null);
        jPanel13.add(acc_ps_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, 300, 40));

        jPanel4.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 350, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/ACCOUNTT.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        ChangePass.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        ChangePass.setForeground(new java.awt.Color(0, 0, 255));
        ChangePass.setText("Change password");
        ChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangePassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChangePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChangePassMouseExited(evt);
            }
        });
        jPanel4.add(ChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 408, 230, 30));

        PIN.setBackground(new java.awt.Color(0, 0, 0));
        PIN.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        PIN.setForeground(new java.awt.Color(51, 51, 255));
        PIN.setText("ΔPIN");
        PIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PINMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PINMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PINMouseExited(evt);
            }
        });
        jPanel4.add(PIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 120, 50));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel13.setText("Account Details:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 241, 50));

        Interface1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 730, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Interface1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Interface1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        UserDashboard ud = new UserDashboard();
        ud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Are you sure you want to logout?", "Logout Confirmation",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose();

            Loginform loginPage = new Loginform();
            loginPage.setVisible(true);
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         Session sess = Session.getInstance();
    
    
    if (sess.getuid() == 0) {
        JOptionPane.showMessageDialog(this, "No account found, Log in First!", "Login Required", JOptionPane.WARNING_MESSAGE);
        Loginform lf = new Loginform();
        lf.setVisible(true);
        this.dispose();
        return; 
    }

    
    acc_fname_user.setText(sess.getFname());
    acc_lname_user1.setText(sess.getLname());
    acc_cn_user8.setText(sess.getContact());
    acc_em_user.setText(sess.getemail());
    acc_un_user.setText(sess.getusername());
    acc_ps_user.setText(sess.getPassword());
    acc_ps_user.setEchoChar('*');

   
       
    }//GEN-LAST:event_formWindowActivated

    private void ChangePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassMouseClicked
         UserChangePassForm ucpf = new UserChangePassForm();
            ucpf.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_ChangePassMouseClicked

    private void ChangePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassMouseEntered
      ChangePass.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      ChangePass.setForeground(Color.BLACK); 
    }//GEN-LAST:event_ChangePassMouseEntered

    private void ChangePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassMouseExited
    ChangePass.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    ChangePass.setForeground(Color.BLUE); 
    }//GEN-LAST:event_ChangePassMouseExited

    private void PINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PINMouseClicked
       if (!isPinCreationOpen) { 
        isPinCreationOpen = true; 
        UserPINcreation upc = new UserPINcreation();
        
        
        upc.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                isPinCreationOpen = false; 
            }
        });

        upc.setVisible(true); 
    }
    }//GEN-LAST:event_PINMouseClicked

    private void PINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PINMouseEntered
        PIN.setCursor(new Cursor  (Cursor.HAND_CURSOR));
        PIN.setForeground(Color.BLACK);
    }//GEN-LAST:event_PINMouseEntered

    private void PINMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PINMouseExited
       PIN.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
       PIN.setForeground(Color.BLUE);
    }//GEN-LAST:event_PINMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       Session sess = Session.getInstance(); 
    String pin = sess.getPIN(); 
    System.out.println("Retrieved PIN: " + pin); 

    
    if (pin == null || pin.isEmpty()) {
        if (!hasShownPinReminder) { 
            JOptionPane.showMessageDialog(this, "It is advisable that you create your PIN for your account security.", "PIN Reminder", JOptionPane.WARNING_MESSAGE);
            hasShownPinReminder = true; 
        }
    }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ChangePass;
    private javax.swing.JPanel Interface1;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JLabel PIN;
    private javax.swing.JLabel acc_cn_user;
    private javax.swing.JLabel acc_cn_user2;
    private javax.swing.JLabel acc_cn_user3;
    private javax.swing.JLabel acc_cn_user4;
    private javax.swing.JLabel acc_cn_user5;
    private javax.swing.JLabel acc_cn_user6;
    private javax.swing.JLabel acc_cn_user7;
    private javax.swing.JLabel acc_cn_user8;
    private javax.swing.JLabel acc_em_user;
    private javax.swing.JLabel acc_fname_user;
    private javax.swing.JLabel acc_lname_user;
    private javax.swing.JLabel acc_lname_user1;
    private javax.swing.JPasswordField acc_ps_user;
    private javax.swing.JLabel acc_un_user;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
