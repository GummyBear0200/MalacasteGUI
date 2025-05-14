
package Users;


import static Users.UserChangePassForm.hashPassword;
import javax.swing.JOptionPane;
import config.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.Logger;
import java.sql.Statement;

public class RegistrationForm extends javax.swing.JFrame {

   
    public RegistrationForm() {
        setUndecorated(true);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Interface = new javax.swing.JPanel();
        Lname = new javax.swing.JTextField();
        Fname = new javax.swing.JTextField();
        Contactnum = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        RegUser = new javax.swing.JTextField();
        RegPass = new javax.swing.JPasswordField();
        CancelB = new javax.swing.JButton();
        RegB = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        ans = new javax.swing.JTextField();
        sq = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/75fc308a-ab44-4e6d-af75-1b4533481b11_large.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Interface.setBackground(new java.awt.Color(0, 0, 0));
        Interface.setForeground(new java.awt.Color(102, 102, 102));
        Interface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LnameActionPerformed(evt);
            }
        });
        Interface.add(Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 200, 40));

        Fname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FnameActionPerformed(evt);
            }
        });
        Interface.add(Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 200, 40));

        Contactnum.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Contactnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactnumActionPerformed(evt);
            }
        });
        Interface.add(Contactnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 200, 40));

        Email.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        Interface.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 200, 40));

        RegUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        RegUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegUserActionPerformed(evt);
            }
        });
        Interface.add(RegUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 200, 40));

        RegPass.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        RegPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegPassActionPerformed(evt);
            }
        });
        Interface.add(RegPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 200, 40));

        CancelB.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        CancelB.setText("CANCEL");
        CancelB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBActionPerformed(evt);
            }
        });
        Interface.add(CancelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 110, 30));

        RegB.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        RegB.setText("REGISTER");
        RegB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RegB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegBActionPerformed(evt);
            }
        });
        Interface.add(RegB, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 110, 30));

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        Interface.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, 40));

        jComboBox1.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Borrower", "Admin", "Libririan" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        Interface.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 200, 40));

        ans.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });
        Interface.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 360, 40));

        sq.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqActionPerformed(evt);
            }
        });
        Interface.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 360, 40));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Security Question:");
        Interface.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("First name:");
        Interface.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("In case of Password Loss:");
        Interface.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Answer:");
        Interface.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Last Name:");
        Interface.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Contact:");
        Interface.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email:");
        Interface.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("User Type:");
        Interface.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Username:");
        Interface.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        Interface.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngtree-several-books-that-are-stacked-together-on-a-dark-black-background-picture-image_2714911.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        Interface.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-450, -200, 1440, 720));

        jPanel2.add(Interface, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 990, 490));

        Header.setBackground(new java.awt.Color(51, 51, 51));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREATE HERE!");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 390, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/ACCOUNTT.png"))); // NOI18N
        jLabel4.setOpaque(true);
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRATION PAGE");
        Header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 280, 50));

        jPanel2.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    String UserType = jComboBox1.getSelectedItem().toString(); 
    String username = RegUser.getText().trim();
    String password = new String(RegPass.getPassword()).trim(); 
    String squestion = sq.getText().trim();
    String answer = ans.getText().trim();

    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    if (fname.isEmpty() || lname.isEmpty() || contactnum.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || squestion.isEmpty() || answer.isEmpty()) {
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
   if (squestion.length() < 5 || !squestion.matches(".*[?]$")) {
        JOptionPane.showMessageDialog(this, "Invalid Question! It must be at least 5 characters long and end with a question mark.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    System.out.println("Debug: Validation passed, checking for duplicates...");
    
  
    String hashedPassword = hashPassword(password);
    if (hashedPassword == null) {
        JOptionPane.showMessageDialog(this, "Error hashing password. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection connect = new DbConnect().getConnection()) {

        String checkQuery = "SELECT COUNT(*) FROM users WHERE RegUser = ? OR Email = ?";
        try (PreparedStatement checkStmt = connect.prepareStatement(checkQuery)) {
            checkStmt.setString(1, username);
            checkStmt.setString(2, email);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Username or Email already exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        String insertQuery = "INSERT INTO users (Fname, Lname, Contactnum, Email, UserType, RegUser, RegPass, SecurityQuestion, answer, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'Pending')";
        try (PreparedStatement insertStmt = connect.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, fname);
            insertStmt.setString(2, lname);
            insertStmt.setString(3, contactnum);
            insertStmt.setString(4, email);
            insertStmt.setString(5, UserType);
            insertStmt.setString(6, username);
            insertStmt.setString(7, hashedPassword);
            insertStmt.setString(8, squestion);
            insertStmt.setString(9, answer);           

            int inserted = insertStmt.executeUpdate();
            if (inserted > 0) {
                // Retrieve the generated user ID
                ResultSet generatedKeys = insertStmt.getGeneratedKeys();
                int userId = 0; // Initialize userId
                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1); // Get the generated user ID
                }

                // Log the registration action
                Logger logger = new Logger(connect);
                logger.logAdd(userId, "User registered with username: " + username); // Use userId

                JOptionPane.showMessageDialog(this, "Registration Successful! Your account is pending approval.", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Loginform().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
       String answer = ans.getText().trim();
       
       if (answer.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Answer cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
       }
    }//GEN-LAST:event_ansActionPerformed

    private void sqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqActionPerformed
       String squestion = sq.getText().trim();
        
       
       if (squestion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Security Question cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
       }
       else if (squestion.length() < 5 || !squestion.matches(".*[?]$")) {
    JOptionPane.showMessageDialog(this, "Invalid Question! It must be at least 5 characters long and end with a question mark.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
       
       
    }//GEN-LAST:event_sqActionPerformed

    
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
    private javax.swing.JTextField Contactnum;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Fname;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Interface;
    private javax.swing.JTextField Lname;
    private javax.swing.JButton RegB;
    private javax.swing.JPasswordField RegPass;
    private javax.swing.JTextField RegUser;
    private javax.swing.JTextField ans;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField sq;
    // End of variables declaration//GEN-END:variables
}
