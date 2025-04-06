/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import config.DbConnect;
import java.awt.Color;
import java.awt.Component;
import java.awt.print.Book;
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
public class AdminBookControl extends javax.swing.JFrame {

    /**
     * Creates new form AdminBookControl
     */
    public AdminBookControl() {
        initComponents();
        
        loadBookData();
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
     void loadBookData() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM books"); 

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("b_id"),
                rs.getString("b_title"),
                rs.getString("b_author"),
                rs.getString("b_pubdate"),
                rs.getString("b_status")
            });
        }

        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage());
    }
}

    void addBook() {
    if (txtBookTtle == null || txtAthr == null || txtPubdte == null || 
        txtSttus == null ) {
        JOptionPane.showMessageDialog(this, "One or more fields are not initialized.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String booktitle = txtBookTtle.getText();
    String author = txtAthr.getText();
    String pubdate = txtPubdte.getText();
    String status = txtSttus.getText();
    

    try (Connection con = new DbConnect().getConnection()) {
        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO books (b_title, b_author, b_pubdate, b_status) VALUES (?, ?, ?, ?)";

        
        try (PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, booktitle);
            pst.setString(2, author);
            pst.setString(3, pubdate);
            pst.setString(4, status);
           

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                
                int newBookId = -1;
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    if (rs.next()) {
                        newBookId = rs.getInt(1);  
                    }
                }

                JOptionPane.showMessageDialog(this, "User added successfully! ID: " + newBookId);
                loadBookData();  

               
              
              

            } else {
                JOptionPane.showMessageDialog(this, "Failed to add user.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
private void updateBook() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to update.");
            return;
        }

        int bookId = (int) jTable1.getValueAt(selectedRow, 0);
         String booktitle = txtBookTtle.getText();
         String author = txtAthr.getText();
         String pubdate = txtPubdte.getText();
         String status = txtSttus.getText();

        String sql = "UPDATE books SET b_title=?, b_author=?, b_pubdate=?, b_status=? WHERE b_id=?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, booktitle);
            pst.setString(2, author);
            pst.setString(3, pubdate);
            pst.setString(4, status);         
            pst.setInt(5, bookId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "User Updated Successfully!");
            loadBookData(); 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
}
     private void deleteBook() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to delete.");
            return;
        }

        int userId = (int) jTable1.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this book?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM books WHERE b_id=?";

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
                 PreparedStatement pst = con.prepareStatement(sql)) {

                pst.setInt(1, userId);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Book Deleted Successfully!");
                loadBookData(); 

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
     }
     private void viewBook() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to view.");
            return;
        }

       txtBookTtle.setText("Book: " + jTable1.getValueAt(selectedRow, 1).toString());
       txtAthr.setText("Author: " + jTable1.getValueAt(selectedRow, 2).toString());
       txtPubdte.setText("Published: " + jTable1.getValueAt(selectedRow, 3).toString());
       txtSttus.setText("Status: " + jTable1.getValueAt(selectedRow, 4).toString());
  
        
    

}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Interface = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ViewButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtBookTtle = new javax.swing.JTextField();
        txtAthr = new javax.swing.JTextField();
        txtPubdte = new javax.swing.JTextField();
        txtSttus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtBookTitle1 = new javax.swing.JTextField();
        txtAuthor1 = new javax.swing.JTextField();
        txtPubdate1 = new javax.swing.JTextField();
        txtStatus1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtBookTitle2 = new javax.swing.JTextField();
        txtAuthor2 = new javax.swing.JTextField();
        txtPubdate2 = new javax.swing.JTextField();
        txtStatus2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtBookTitle3 = new javax.swing.JTextField();
        txtAuthor3 = new javax.swing.JTextField();
        txtPubdate3 = new javax.swing.JTextField();
        txtStatus3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Interface.setBackground(new java.awt.Color(102, 102, 102));
        Interface.setForeground(new java.awt.Color(102, 102, 102));
        Interface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 145, 170, 50));

        jLabel2.setBackground(new java.awt.Color(153, 0, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/54476.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 70));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book management");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 241, 50));

        Interface.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 70));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, 40));

        UpdateButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 110, 40));

        DeleteButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 110, 40));

        ViewButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        ViewButton.setText("VIEW");
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ViewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 110, 40));

        Interface.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 650));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("Current Books:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 250, 40));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookTtle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBookTtleMouseClicked(evt);
            }
        });
        txtBookTtle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTtleActionPerformed(evt);
            }
        });
        jPanel5.add(txtBookTtle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));
        jPanel5.add(txtAthr, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));
        jPanel5.add(txtPubdte, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));
        jPanel5.add(txtSttus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("View Log: Select a row in the table then click View button to display their data.");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 570, 20));

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookTitle1.setText("Title");
        txtBookTitle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBookTitle1MouseClicked(evt);
            }
        });
        txtBookTitle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitle1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtBookTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        txtAuthor1.setText("Author");
        jPanel6.add(txtAuthor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));

        txtPubdate1.setText("Publication Date");
        jPanel6.add(txtPubdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));

        txtStatus1.setText("Status of the book");
        jPanel6.add(txtStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        jLabel5.setText("Note: To Add and Update please fill all fields then click the button you want to function.");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 570, 20));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 720, 70));

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookTitle2.setText("Title");
        txtBookTitle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBookTitle2MouseClicked(evt);
            }
        });
        txtBookTitle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitle2ActionPerformed(evt);
            }
        });
        jPanel7.add(txtBookTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        txtAuthor2.setText("Author");
        jPanel7.add(txtAuthor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));

        txtPubdate2.setText("Publication Date");
        jPanel7.add(txtPubdate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));

        txtStatus2.setText("Status of the book");
        jPanel7.add(txtStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        jLabel7.setText("Note: To Add and Update please fill all fields then click the button you want to function.");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 570, 20));

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookTitle3.setText("Title");
        txtBookTitle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBookTitle3MouseClicked(evt);
            }
        });
        txtBookTitle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitle3ActionPerformed(evt);
            }
        });
        jPanel8.add(txtBookTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        txtAuthor3.setText("Author");
        jPanel8.add(txtAuthor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));

        txtPubdate3.setText("Publication Date");
        jPanel8.add(txtPubdate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));

        txtStatus3.setText("Status of the book");
        jPanel8.add(txtStatus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        jLabel8.setText("Note: To Add and Update please fill all fields then click the button you want to function.");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 570, 20));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 720, 70));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 720, 70));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 720, 70));

        jTable1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
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
        jScrollPane2.setViewportView(jTable1);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 40, 700, 330));

        Interface.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 780, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1082, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Interface, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Interface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
         AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
         AdminAddBook adminaddbook = new AdminAddBook();
        adminaddbook.setVisible(true);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        updateBook();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        deleteBook();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButtonActionPerformed
        viewBook();
    }//GEN-LAST:event_ViewButtonActionPerformed

    private void txtBookTtleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBookTtleMouseClicked

    }//GEN-LAST:event_txtBookTtleMouseClicked

    private void txtBookTtleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTtleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTtleActionPerformed

    private void txtBookTitle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBookTitle1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle1MouseClicked

    private void txtBookTitle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle1ActionPerformed

    private void txtBookTitle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBookTitle2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle2MouseClicked

    private void txtBookTitle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitle2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle2ActionPerformed

    private void txtBookTitle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBookTitle3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle3MouseClicked

    private void txtBookTitle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle3ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminBookControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminBookControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminBookControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminBookControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminBookControl().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAthr;
    private javax.swing.JTextField txtAuthor1;
    private javax.swing.JTextField txtAuthor2;
    private javax.swing.JTextField txtAuthor3;
    private javax.swing.JTextField txtBookTitle1;
    private javax.swing.JTextField txtBookTitle2;
    private javax.swing.JTextField txtBookTitle3;
    private javax.swing.JTextField txtBookTtle;
    private javax.swing.JTextField txtPubdate1;
    private javax.swing.JTextField txtPubdate2;
    private javax.swing.JTextField txtPubdate3;
    private javax.swing.JTextField txtPubdte;
    private javax.swing.JTextField txtStatus1;
    private javax.swing.JTextField txtStatus2;
    private javax.swing.JTextField txtStatus3;
    private javax.swing.JTextField txtSttus;
    // End of variables declaration//GEN-END:variables
}
