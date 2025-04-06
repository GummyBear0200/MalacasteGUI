
package Users;


import config.Session;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class UserForgotPass extends javax.swing.JFrame {
private Connection connect;

    public UserForgotPass() {
        
      
        initComponents();
         customizeButton(BackButton);
         customizeButton(search);
         DbConnect();
        
     search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchUsername();
            }
        });

        setVisible(true);
    
    }
    
    
    private void customizeButton(JButton button) {
   button.setOpaque(true);
   button.setBorderPainted(false);
   button.setFocusPainted(false);
   button.setBackground(new Color(51, 51, 255)); 
   button.setForeground(Color.WHITE);


   
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(102, 153, 255)); 
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(51, 51, 255)); 
        }
    });
}
    private void DbConnect() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
            System.out.println("Connected to database successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 private void searchUsername() {
    String input = usernamefield.getText().trim();

    if (input.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a username or mobile number!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        String query = "SELECT * FROM users WHERE RegUser=? OR Contactnum=?";
        PreparedStatement pst = connect.prepareStatement(query);
        pst.setString(1, input); 
        pst.setString(2, input); 

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Account found!", "Success", JOptionPane.INFORMATION_MESSAGE);
            UserRecoveryOption uro = new UserRecoveryOption();
            uro.setVisible(true);
            this.dispose();

            Session sess = Session.getInstance();
            sess.setuid(rs.getInt("u_id"));  
            sess.setFname(rs.getString("Fname"));
            sess.setLname(rs.getString("Lname"));
            sess.setContact(rs.getString("Contactnum"));
            sess.setemail(rs.getString("email"));
            sess.setusername(rs.getString("RegUser"));
            sess.setPassword(rs.getString("RegPass"));
            sess.setSecurityQuestion(rs.getString("SecurityQuestion"));
            sess.setAnswer(rs.getString("answer"));
            sess.settype(rs.getString("usertype"));
            sess.setStatus(rs.getString("status"));
            sess.setPIN(rs.getString("PIN"));
            sess.setImagePath(rs.getString("image"));
            
            
        } else {
            JOptionPane.showMessageDialog(this, "Account not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Interface1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        titlelabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        usernamefield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        titlelabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Interface1.setBackground(new java.awt.Color(102, 102, 102));
        Interface1.setForeground(new java.awt.Color(102, 102, 102));
        Interface1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackButton.setBackground(new java.awt.Color(51, 51, 255));
        BackButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setText("Back to Login");
        BackButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BackButton.setBorderPainted(false);
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackButtonMouseExited(evt);
            }
        });
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel2.add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 140, 30));

        titlelabel2.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel2.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        titlelabel2.setForeground(new java.awt.Color(51, 51, 255));
        titlelabel2.setText("Library Management System");
        jPanel2.add(titlelabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/scc.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 70));

        Interface1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 70));

        jPanel4.setBackground(new java.awt.Color(239, 239, 239));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/ACCOUNTT.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernamefield.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        usernamefield.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        usernamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernamefieldActionPerformed(evt);
            }
        });
        usernamefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernamefieldKeyPressed(evt);
            }
        });
        jPanel5.add(usernamefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 620, 50));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Lets find your account first!");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 170, 20));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("<html>Please enter your username/mobile number to search for  your <br>account.</html> ");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 590, 60));

        search.setBackground(new java.awt.Color(51, 51, 255));
        search.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        search.setBorderPainted(false);
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel5.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 150, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 720, 280));

        titlelabel3.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel3.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        titlelabel3.setText("Find your account");
        jPanel4.add(titlelabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 241, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1050, 70));

        Interface1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1050, 580));

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
        Loginform lf = new Loginform();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void usernamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamefieldActionPerformed

    private void BackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseEntered
      BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    }//GEN-LAST:event_BackButtonMouseEntered

    private void BackButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseExited
       BackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
    }//GEN-LAST:event_BackButtonMouseExited

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
       search.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
       search.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    }//GEN-LAST:event_searchMouseExited

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void usernamefieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernamefieldKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
        searchUsername(); 
    }
    }//GEN-LAST:event_usernamefieldKeyPressed

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
            java.util.logging.Logger.getLogger(UserForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForgotPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel Interface1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton search;
    private javax.swing.JLabel titlelabel2;
    private javax.swing.JLabel titlelabel3;
    private javax.swing.JTextField usernamefield;
    // End of variables declaration//GEN-END:variables
}
