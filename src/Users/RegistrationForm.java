
package Users;

import config.DbConnect;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import config.DbConnect;

public class RegistrationForm extends javax.swing.JFrame {

   
    public RegistrationForm() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Interface = new javax.swing.JPanel();
        Lname = new javax.swing.JTextField();
        Fname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CancelB = new javax.swing.JButton();
        Contact = new javax.swing.JLabel();
        Contactnum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        RegUser = new javax.swing.JTextField();
        RegB = new javax.swing.JButton();
        Email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        RegPass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Interface.setBackground(new java.awt.Color(0, 0, 0));
        Interface.setForeground(new java.awt.Color(102, 102, 102));
        Interface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LnameActionPerformed(evt);
            }
        });
        Interface.add(Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 200, 30));

        Fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FnameActionPerformed(evt);
            }
        });
        Interface.add(Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 200, 30));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name:");
        Interface.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First name:");
        Interface.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        CancelB.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        CancelB.setText("CANCEL");
        CancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBActionPerformed(evt);
            }
        });
        Interface.add(CancelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        Contact.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Contact.setForeground(new java.awt.Color(255, 255, 255));
        Contact.setText("Contact:");
        Interface.add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        Contactnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactnumActionPerformed(evt);
            }
        });
        Interface.add(Contactnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 200, 30));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username:");
        Interface.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        RegUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegUserActionPerformed(evt);
            }
        });
        Interface.add(RegUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 200, 30));

        RegB.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        RegB.setText("REGISTER");
        RegB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegBActionPerformed(evt);
            }
        });
        Interface.add(RegB, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        Interface.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 200, 30));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password:");
        Interface.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email:");
        Interface.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        RegPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegPassActionPerformed(evt);
            }
        });
        Interface.add(RegPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 200, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngtree-book-clipart-vector-png-image_6653535.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        Interface.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, -30, 410, 410));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngtree-book-clipart-vector-png-image_6653535.png"))); // NOI18N
        jLabel10.setText("jLabel9");
        Interface.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 160, 410));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        Interface.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, 30));

        jComboBox1.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Borrower", "Admin", "Libririan" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        Interface.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 200, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Type:");
        Interface.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, 30));

        jPanel2.add(Interface, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 420));

        Header.setBackground(new java.awt.Color(102, 102, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRATION");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 390, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/png-transparent-person-doing-thumbs-up-building-hvac-business-house-customer-thumbs-up-miscellaneous-hand-service-thumbnail.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setOpaque(true);
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        jPanel2.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LnameActionPerformed
        String lname = Lname.getText().trim();
    
    if (!lname.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(this, "Invalid Last Name! Only letters are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        Lname.setText(""); 
    }
    }//GEN-LAST:event_LnameActionPerformed

    private void FnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FnameActionPerformed
         String fname = Fname.getText().trim();
    
    if (!fname.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(this, "Invalid First Name! Only letters are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        Fname.setText(""); 
    }
    }//GEN-LAST:event_FnameActionPerformed

    private void CancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBActionPerformed
         Loginform login = new Loginform(); 
    login.setVisible(true);  
    this.dispose();  
    }//GEN-LAST:event_CancelBActionPerformed

    private void ContactnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactnumActionPerformed
         String ageText = Contactnum.getText().trim();
    
    if (!ageText.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid Number! Only numbers are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        Contactnum.setText(""); 
    }
    }//GEN-LAST:event_ContactnumActionPerformed

    private void RegUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegUserActionPerformed
        String username = RegUser.getText().trim();
    
    if (!username.matches("[a-zA-Z0-9_]{5,}")) {  
        JOptionPane.showMessageDialog(this, "Invalid Username! Must be at least 5 characters and contain only letters, numbers, and underscores.", "Error", JOptionPane.ERROR_MESSAGE);
        RegUser.setText(""); 
    }
    }//GEN-LAST:event_RegUserActionPerformed

    private void RegBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegBActionPerformed

      String fname = Fname.getText().trim();
    String lname = Lname.getText().trim();
    String contactnum = Contactnum.getText().trim();
    String email = Email.getText().trim();
    String UserType = jComboBox1.getSelectedItem().toString();  // Assuming userTypeComboBox exists


    String username = RegUser.getText().trim();
    String password = new String(RegPass.getPassword()).trim(); 

    
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

  
    if (fname.isEmpty() || lname.isEmpty() || contactnum.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required. Please fill out the form.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    
    if (!fname.matches("[a-zA-Z ]+") || !lname.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(this, "Only letters are allowed for First and Last Name.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    
    if (!contactnum.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid contact number! Only numbers are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    if (!email.matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Invalid Email! Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    if (!username.matches("[a-zA-Z0-9_]{5,}")) {
        JOptionPane.showMessageDialog(this, "Invalid Username! Must be at least 5 characters and contain only letters, numbers, and underscores.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    if (!password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*\\d).{8,}$")) {
        JOptionPane.showMessageDialog(this, "Invalid Password! Must be at least 8 characters long, contain one uppercase letter, one special character, and one number.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    
    System.out.println("Debug: Validation passed, attempting to insert user...");

    
    String hashedPassword = hashPassword(password);

    
    DbConnect db = new DbConnect();
        
    int inserted = db.insertUser(fname, lname, contactnum, email, UserType, username, hashedPassword);

    if (inserted > 0) {
        JOptionPane.showMessageDialog(this, "Registration Successful! Your account is pending approval.", "Success", JOptionPane.INFORMATION_MESSAGE);
        Loginform login = new Loginform();
        login.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


private String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }

    }//GEN-LAST:event_RegBActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        String address = Email.getText().trim();
    
   String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    if (address.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Email cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!address.matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Invalid Email! Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    }//GEN-LAST:event_EmailActionPerformed

    private void RegPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegPassActionPerformed
        String password = new String(RegPass.getPassword()); 
    
    if (!password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*\\d).{8,}$")) {
        JOptionPane.showMessageDialog(this, "Invalid Password! Must be at least 8 characters long, contain one uppercase letter, one special character, and one number.", "Error", JOptionPane.ERROR_MESSAGE);
        RegPass.setText(""); 
    }
    }//GEN-LAST:event_RegPassActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            RegPass.setEchoChar((char) 0);
        } else {
            RegPass.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelB;
    private javax.swing.JLabel Contact;
    private javax.swing.JTextField Contactnum;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Fname;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Interface;
    private javax.swing.JTextField Lname;
    private javax.swing.JButton RegB;
    private javax.swing.JPasswordField RegPass;
    private javax.swing.JTextField RegUser;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
