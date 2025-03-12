
package Admin;


import config.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AdminUpdateUser extends javax.swing.JFrame {
 
    
    
    
    public AdminUpdateUser() {
        initComponents();
        
        
    }
    private String userId; // Declare userId at the class level

    public void setUserId(String id) {
        this.userId = id; // Store the user ID for later use
    }
    public void setFirstName(String firstName) {
    this.fn.setText(firstName);
}

    
     
     
     
 public boolean duplicateCheck() {
    DbConnect dbc = new DbConnect();
    try {
        String query = "SELECT * FROM users WHERE RegUser = '" + un.getText() + "' OR email = '" + em.getText() + "'";
        ResultSet resultSet = dbc.getData(query);

        if (resultSet.next()) {
            String email = resultSet.getString("email"); 
            if (email.equals(em.getText())) {
                JOptionPane.showMessageDialog(null, "Email is Already Used!");
                em.setText(""); 
            }

            String username = resultSet.getString("RegUser"); 
            if (username.equals(un.getText())) {
                JOptionPane.showMessageDialog(null, "Username is Already Used!");
                un.setText(""); 
            }
            return true;
        } else {
            return false;
        }
    } catch (SQLException ex) {
        System.out.println("" + ex);
        return false;
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UpdateButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        cn = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        ps = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        cmbUserType = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        AddButton2 = new javax.swing.JButton();
        AddButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtFirstName1 = new javax.swing.JTextField();
        txtLastName1 = new javax.swing.JTextField();
        txtContact1 = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        txtUsername1 = new javax.swing.JTextField();
        txtPassword1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbStatus1 = new javax.swing.JComboBox<>();
        cmbUserType1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UpdateButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 110, 40));

        CancelButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CancelButton.setText("CANCEL");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 110, 40));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel5.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 160, 30));
        jPanel5.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 160, 30));
        jPanel5.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 160, 30));
        jPanel5.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 160, 30));
        jPanel5.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 160, 30));
        jPanel5.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 160, 30));

        jLabel1.setText("Note: To Add and Update please fill all fields then click the button you want to function.");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 570, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 70, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("First Name:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 70, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Last Name:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 70, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Contact:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 70, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Email:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 70, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("User Type");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 70, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Username:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 70, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Password:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 70, 20));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        jPanel5.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 160, 30));

        cmbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User", "Borrower" }));
        cmbUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserTypeActionPerformed(evt);
            }
        });
        jPanel5.add(cmbUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 160, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 660, 350));

        jPanel2.setBackground(new java.awt.Color(153, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddButton2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton2.setText("ADD");
        AddButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(AddButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 110, 40));

        AddButton3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton3.setText("CANCEL");
        AddButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(AddButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 110, 40));

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFirstName1.setText("First Name");
        txtFirstName1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFirstName1MouseClicked(evt);
            }
        });
        jPanel6.add(txtFirstName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 160, 30));

        txtLastName1.setText("Last Name");
        jPanel6.add(txtLastName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 160, 30));

        txtContact1.setText("Contact Number");
        jPanel6.add(txtContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 160, 30));

        txtEmail1.setText("Email");
        jPanel6.add(txtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 160, 30));

        txtUsername1.setText("Username");
        jPanel6.add(txtUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 160, 30));

        txtPassword1.setText("Password");
        jPanel6.add(txtPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 160, 30));

        jLabel12.setText("Note: To Add and Update please fill all fields then click the button you want to function.");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 570, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Status:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 70, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("First Name:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 70, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Last Name:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 70, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Contact:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 70, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Email:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 70, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("User Type");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 70, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Username:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 70, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Password:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 70, 20));

        cmbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        jPanel6.add(cmbStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 160, 30));

        cmbUserType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User", "Borrower" }));
        jPanel6.add(cmbUserType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 160, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 680, 350));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Update User page");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 241, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
 
        
    String newFname = fn.getText().trim();
    String newLname = ln.getText().trim();
    String newContact = cn.getText().trim();
    String newEmail = em.getText().trim();
    String newUsername = un.getText().trim();
    String newUserType = cmbUserType.getSelectedItem().toString();
    String newUserStatus = cmbStatus.getSelectedItem().toString();

    // Email regex pattern
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    // Validate inputs
    if (newFname.isEmpty() || newLname.isEmpty() || newEmail.isEmpty() || newUsername.isEmpty() || newUserType.isEmpty() || newUserStatus.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newFname.matches("[a-zA-Z ]+") || !newLname.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(this, "Only letters are allowed for First and Last Name.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!newContact.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid contact number! Only numbers are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newEmail.matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Invalid Email! Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!newUsername.matches("[a-zA-Z0-9_]{5,}")) {
        JOptionPane.showMessageDialog(this, "Invalid Username! Must be at least 5 characters and contain only letters, numbers, and underscores.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    DbConnect dbc = new DbConnect();
    
    // Ensure userId is valid before running queries
    if (this.userId == null || this.userId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: User ID is missing.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String checkQuery = "SELECT COUNT(*) FROM users WHERE (RegUser = ? OR email = ?) AND u_id != ?";

    try (Connection conn = dbc.getConnection();
         PreparedStatement pst = conn.prepareStatement(checkQuery)) {

        pst.setString(1, newUsername);
        pst.setString(2, newEmail);
        pst.setString(3, this.userId);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Username or Email already exists! Please use different credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        // Proceed with update
        String updateQuery = "UPDATE users SET Fname = ?, Lname = ?, email = ?, RegUser = ?, type = ?, status = ? WHERE id = ?";
        try (PreparedStatement updatePst = conn.prepareStatement(updateQuery)) {
            updatePst.setString(1, newFname);
            updatePst.setString(2, newLname);
            updatePst.setString(3, newEmail);
            updatePst.setString(4, newUsername);
            updatePst.setString(5, newUserType);
            updatePst.setString(6, newUserStatus);
            updatePst.setString(7, this.userId);

            int updated = updatePst.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new AdminUserControl().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
   

    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        AdminUserControl adminusercontrol = new AdminUserControl();
        adminusercontrol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void AddButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButton2ActionPerformed

    private void AddButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButton3ActionPerformed

    private void txtFirstName1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFirstName1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstName1MouseClicked

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void cmbUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUserTypeActionPerformed

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
            java.util.logging.Logger.getLogger(AdminUpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUpdateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton2;
    private javax.swing.JButton AddButton3;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbStatus1;
    private javax.swing.JComboBox<String> cmbUserType;
    private javax.swing.JComboBox<String> cmbUserType1;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField em;
    private static javax.swing.JTextField fn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField ps;
    private javax.swing.JTextField txtContact1;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtFirstName1;
    private javax.swing.JTextField txtLastName1;
    private javax.swing.JTextField txtPassword1;
    private javax.swing.JTextField txtUsername1;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
