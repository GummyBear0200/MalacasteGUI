/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Users.Loginform;
import config.DbConnect;
import config.Logger;
import config.Session;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author II
 */
    public class AdminUserControl extends javax.swing.JFrame {

      
    public AdminUserControl() {
        setUndecorated(true);
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
        
    
    customizeButton(AddButton);
    customizeButton(UpdateButton);
    customizeButton(DeleteButton);
    jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!isSelected) {
            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
        }
        return c;
    }
});


JTableHeader header = jTable1.getTableHeader();
header.setFont(new Font("Tahoma", Font.BOLD, 14));
header.setBackground(new Color(200, 0, 0));
header.setForeground(Color.WHITE);


jTable1.setRowHeight(25);
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
   DefaultTableModel model = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 0; 
    }
};
jTable1.setModel(model);
    
jTable1.getModel().addTableModelListener(new TableModelListener() {
    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn();

            
            if (row == -1 || column == -1) {
                return; 
            }

            updateDatabase(row, column);
        }
    }
});
    Session sess = Session.getInstance();
    
    String[] columnNames = {"First Name", "First Name", "Last Name", "Contact", "Email", "User Type", "Username", "Status"};
    model.setColumnIdentifiers(columnNames); 
    model.setRowCount(0);

    String sql = "SELECT  u_id, Fname, Lname, Contactnum, email, usertype, RegUser, status FROM users WHERE u_id != '"+sess.getuid()+"';";

    try (Connection connect = new DbConnect().getConnection();
         PreparedStatement pst = connect.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Object[] row = {
                rs.getString("u_id"),
                rs.getString("Fname"),
                rs.getString("Lname"),
                rs.getString("Contactnum"),
                rs.getString("email"),
                rs.getString("usertype"),
                rs.getString("RegUser"),
                
                rs.getString("status")
            };
            model.addRow(row); 
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}

private void updateDatabase(int row, int column) {
    try (Connection connect = new DbConnect().getConnection()) {
        String columnName = jTable1.getColumnName(column); 
        String newValue = jTable1.getValueAt(row, column).toString(); 
        int userId = Integer.parseInt(jTable1.getValueAt(row, 0).toString());

        String sql = "UPDATE users SET " + columnName + " = ? WHERE u_id = ?";
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setString(1, newValue);
            pst.setInt(2, userId);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Database Updated Successfully!");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
    }
}


void addUser() {
   
     AdminAddUser adminadduser = new AdminAddUser();
     adminadduser.setVisible(true);
     adminadduser.remove.setEnabled(false);
     adminadduser.select.setEnabled(true);
     this.dispose();
}
    public boolean addUser(String firstName, String lastName, String contact, String email, String userType, String username, String password, String status) {
    Connection con = null;
    PreparedStatement pst = null;

    try {
       
        con = new DbConnect().getConnection();

        
        String query = "INSERT INTO users (Fname, Lname, Contactnum, email, usertype, Reguser, RegPass, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        pst = con.prepareStatement(query);
        
        
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, contact);
        pst.setString(4, email);
        pst.setString(5, userType);
        pst.setString(6, username);
        pst.setString(7, password);
        pst.setString(8, status);

        
        int rowsInserted = pst.executeUpdate();
        return rowsInserted > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

   public boolean updateUser(String firstName, String lastName, String contact, String email, String userType, String username, String password, String status) {
    try {
        
        Connection con = new DbConnect().getConnection();
        String query = "UPDATE users SET Fname=?, Lname=?, Contactnum=?, email=?, usertype=?, RegPass=?, status=? WHERE RegUser=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, contact);
        pst.setString(4, email);
        pst.setString(5, userType);
        pst.setString(6, password);
        pst.setString(7, status);
        pst.setString(8, username);

        int rowsUpdated = pst.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
   private void deleteUser() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a user to delete.");
        return;
    }

    int userId = (int) jTable1.getValueAt(selectedRow, 0);
    String username = (String) jTable1.getValueAt(selectedRow, 1); 
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        String sql = "DELETE FROM users WHERE u_id=?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, userId);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                
                Logger logger = new Logger(con); 
                int adminId = Integer.parseInt(acc_id.getText()); 
                logger.logAdd(adminId, "Admin deleted user: " + username);

                JOptionPane.showMessageDialog(this, "User Deleted Successfully!");
                loadUsersData(); 
            } else {
                JOptionPane.showMessageDialog(this, "No user found with that ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

   

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Interface = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        acc_id = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Interface.setBackground(new java.awt.Color(204, 204, 204));
        Interface.setForeground(new java.awt.Color(102, 102, 102));
        Interface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Interface.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/54476.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
        );

        Interface.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_id.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        acc_id.setForeground(new java.awt.Color(255, 255, 255));
        acc_id.setText("ID");
        jPanel2.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 40, 40));

        AddButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        jPanel2.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 110, 40));

        DeleteButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        jPanel2.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 110, 40));

        jLabel7.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CurrentID:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, 40));

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("User CONTROL");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 40));

        UpdateButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 110, 40));

        Interface.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 880, 90));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Interface.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 130, 490));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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

        Interface.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 790, 410));

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User CONTROL");
        Interface.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 330, 40));

        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User CONTROL");
        Interface.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 330, 40));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registered Users:");
        Interface.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 330, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Interface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
       addUser();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       deleteUser();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
    if (sess.getuid() == 0) {
        JOptionPane.showMessageDialog(this, "No account found, Log in First!", "Login Required", JOptionPane.WARNING_MESSAGE);
        Loginform lf = new Loginform();
        lf.setVisible(true);
        this.dispose();
        return; 
    }
   
    acc_id.setText(String.valueOf(sess.getuid()));
    }//GEN-LAST:event_formWindowActivated

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
       
    int rowIndex = jTable1.getSelectedRow();
    
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a User!");
    } else {
        try {
            DbConnect dbc = new DbConnect();
            TableModel tbl = jTable1.getModel();

            String userId = tbl.getValueAt(rowIndex, 0).toString();
            String query = "SELECT * FROM users WHERE u_id = ?";

            PreparedStatement pst = dbc.getConnection().prepareStatement(query);
            pst.setString(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                AdminUpdateUser crf = new AdminUpdateUser();
                crf.setVisible(true);
                crf.setUserId(userId);
                crf.fn.setText(rs.getString("Fname"));
                crf.ln.setText(rs.getString("Lname"));
                crf.cn.setText(rs.getString("Contactnum"));
                crf.em.setText(rs.getString("email"));
                crf.un.setText(rs.getString("RegUser"));
                crf.cmbStatus.setSelectedItem(rs.getString("status"));
                crf.cmbUserType.setSelectedItem(rs.getString("usertype"));

                String imagePath = rs.getString("image");

                if (imagePath != null && !imagePath.isEmpty()) {
                    File imgFile = new File(imagePath);
                    if (imgFile.exists()) {
                       
                        crf.image.setIcon(crf.ResizeImage(imagePath, null, crf.image));
                        crf.select.setEnabled(false);
                        crf.remove.setEnabled(true);
                    } else {
                        System.out.println("Image file does not exist: " + imagePath);
                        crf.image.setIcon(new ImageIcon("path/to/default/icon.png"));
                        crf.select.setEnabled(true);
                        crf.remove.setEnabled(false);
                    }
                } else {
                    crf.image.setIcon(new ImageIcon("path/to/default/icon.png"));
                    crf.select.setEnabled(true);
                    crf.remove.setEnabled(false);
                }

                crf.oldpath = imagePath;
                crf.path = imagePath;
                crf.destination = imagePath;
                crf.ps.setEnabled(false);
                crf.CancelButton1.setVisible(false);
                crf.CancelButton.setVisible(true);
                crf.UpdateButton.setVisible(true);
                crf.UpdateButton1.setVisible(false);

                
                
                

                

               this.dispose();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    } 

    }//GEN-LAST:event_UpdateButtonActionPerformed
    
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
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
