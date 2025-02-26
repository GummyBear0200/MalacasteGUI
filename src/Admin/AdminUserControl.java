/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import config.DbConnect;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author II
 */
    public class AdminUserControl extends javax.swing.JFrame {

      
    public AdminUserControl() {
        
        initComponents();
        

        loadUsersData();
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); 

        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!isSelected) {
            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
        }
        return c;
    }
});
        
    customizeButton(ViewButton);
    customizeButton(AddButton);
    customizeButton(UpdateButton);
    customizeButton(DeleteButton);
    
    }
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
private void loadUsersData() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    
    String[] columnNames = {"ID", "First Name", "Last Name", "Contact", "Email", "User Type", "Username","Password", "Status"};
    model.setColumnIdentifiers(columnNames); 
    model.setRowCount(0);

    String sql = "SELECT u_id, Fname, Lname, Contactnum, email, usertype, RegUser,RegPass, status FROM users";

    try (Connection connect = new DbConnect().getConnection();
         PreparedStatement pst = connect.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Object[] row = {
                rs.getInt("u_id"),
                rs.getString("Fname"),
                rs.getString("Lname"),
                rs.getString("Contactnum"),
                rs.getString("email"),
                rs.getString("usertype"),
                rs.getString("RegUser"),
                rs.getString("RegPass"),
                rs.getString("status")
            };
            model.addRow(row); 
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}

private void addUser() {
    if (txtFirstName == null || txtLastName == null || txtContact == null || 
        txtEmail == null || txtUserType == null || txtUsername == null || txtStatus == null) {
        JOptionPane.showMessageDialog(this, "One or more fields are not initialized.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String firstName = txtFirstName.getText();
    String lastName = txtLastName.getText();
    String contact = txtContact.getText();
    String email = txtEmail.getText();
    String userType = txtUserType.getText();
    String username = txtUsername.getText();
    String password = txtPassword.getText();
    String status = txtStatus.getText();

    try (Connection con = new DbConnect().getConnection()) {
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO users (Fname, Lname, Contactnum, email, usertype, RegUser, RegPass, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        
        try (PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, contact);
            pst.setString(4, email);
            pst.setString(5, userType);
            pst.setString(6, username);
            pst.setString(7, password);
            pst.setString(8, status);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                
                int newUserId = -1;
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    if (rs.next()) {
                        newUserId = rs.getInt(1);  
                    }
                }

                JOptionPane.showMessageDialog(this, "User added successfully! ID: " + newUserId);
                loadUsersData();  

               
               AdminDashboard dashboard = new AdminDashboard(); 
               dashboard.addLog("New User registered: " + firstName + " (ID: " + newUserId + ")");

            } else {
                JOptionPane.showMessageDialog(this, "Failed to add user.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    
    private void updateUser() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to update.");
            return;
        }

        int userId = (int) jTable1.getValueAt(selectedRow, 0);
        String fname = txtFirstName.getText();
        String lname = txtLastName.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String userType = txtUserType.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String status = txtStatus.getText();

        String sql = "UPDATE users SET Fname=?, Lname=?, Contactnum=?, email=?, usertype=?, RegUser=?,RegPass=?, status=? WHERE u_id=?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, contact);
            pst.setString(4, email);
            pst.setString(5, userType);
            pst.setString(6, username);
            pst.setString(7, password);
            pst.setString(8, status);
            pst.setInt(9, userId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "User Updated Successfully!");
            loadUsersData(); 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void deleteUser() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
            return;
        }

        int userId = (int) jTable1.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM users WHERE u_id=?";

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
                 PreparedStatement pst = con.prepareStatement(sql)) {

                pst.setInt(1, userId);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "User Deleted Successfully!");
                loadUsersData(); 

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   
    private void viewUser() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to view.");
            return;
        }

        txtFirstName.setText(jTable1.getValueAt(selectedRow, 1).toString());
        txtLastName.setText(jTable1.getValueAt(selectedRow, 2).toString());
        txtContact.setText(jTable1.getValueAt(selectedRow, 3).toString());
        txtEmail.setText(jTable1.getValueAt(selectedRow, 4).toString());
        txtUserType.setText(jTable1.getValueAt(selectedRow, 5).toString());
        txtUsername.setText(jTable1.getValueAt(selectedRow, 6).toString());
        txtStatus.setText(jTable1.getValueAt(selectedRow, 7).toString());
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Interface = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ViewButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtUserType = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Interface.setBackground(new java.awt.Color(102, 0, 0));
        Interface.setForeground(new java.awt.Color(102, 102, 102));
        Interface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Interface.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, -1));

        jPanel3.setBackground(new java.awt.Color(102, 0, 0));

        jLabel2.setBackground(new java.awt.Color(153, 0, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/54476.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Interface.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User CONTROL");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 330, 40));

        Interface.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 830, 90));

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        ViewButton.setText("VIEW");
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });
        jPanel4.add(ViewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 110, 40));

        AddButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        jPanel4.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 40));

        UpdateButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        jPanel4.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 40));

        DeleteButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        jPanel4.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, 40));

        Interface.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 130, 490));

        jTable1.setBackground(new java.awt.Color(255, 204, 204));
        jTable1.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        Interface.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 710, 300));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFirstName.setText("First Name");
        txtFirstName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFirstNameMouseClicked(evt);
            }
        });
        jPanel5.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        txtLastName.setText("Last Name");
        jPanel5.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));

        txtContact.setText("Contact Number");
        jPanel5.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));

        txtStatus.setText("Status");
        jPanel5.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 160, -1));

        txtEmail.setText("Email");
        jPanel5.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        txtUserType.setText("User Type");
        jPanel5.add(txtUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, -1));

        txtUsername.setText("Username");
        jPanel5.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 160, -1));

        txtPassword.setText("Password");
        jPanel5.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 160, -1));

        jLabel1.setText("Note: To Add and Update please fill all fields and click the button you want to function.");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4, 570, 20));

        Interface.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 720, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Interface, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Interface, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButtonActionPerformed
        viewUser();
    }//GEN-LAST:event_ViewButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
       addUser();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
       updateUser();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       deleteUser();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void txtFirstNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFirstNameMouseClicked
       
    }//GEN-LAST:event_txtFirstNameMouseClicked
    
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
            java.util.logging.Logger.getLogger(AdminUserControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUserControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUserControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUserControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUserControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JPanel Interface;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton ViewButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtUserType;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
