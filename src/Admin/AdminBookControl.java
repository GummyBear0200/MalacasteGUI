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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
public class AdminBookControl extends javax.swing.JFrame {

    /**
     * Creates new form AdminBookControl
     */
    public AdminBookControl() {
        setUndecorated(true);
        initComponents();
        
        
        loadBookData();
        
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
    customizeButton(jButton1);
    
    
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
        AdminAddBook adb = new AdminAddBook();
        adb.setVisible(true);
        this.dispose();
  
    }
   

   private void updateBook() {
    int rowIndex = jTable1.getSelectedRow();
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a Book!");
    } else {
        try {
            DbConnect dbc = new DbConnect();
            TableModel tbl = jTable1.getModel();

            String bookId = tbl.getValueAt(rowIndex, 0).toString();
            String query = "SELECT * FROM books WHERE b_id = ?";

            PreparedStatement pst = dbc.getConnection().prepareStatement(query);
            pst.setString(1, bookId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                AdminAddBook bookForm = new AdminAddBook();
               
                bookForm.AddButton1.setVisible(false);
                 bookForm.UpdateButton.setVisible(true);
                bookForm.setBookId(bookId); // you should create this setter
                bookForm.txtBookTitle.setText(rs.getString("b_title"));
                bookForm.txtBookAuthor.setText(rs.getString("b_author"));
                bookForm.txtBookPublicationDate.setText(rs.getString("b_pubdate"));
                bookForm.jComboBox1.setSelectedItem(rs.getString("b_status"));

                bookForm.setVisible(true);
                this.dispose();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Interface = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 70));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book management");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 241, 50));

        jButton1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 150, 30));

        Interface.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 0, 1120, 70));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Interface.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 650));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("Current Books:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 250, 40));

        jTable1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book ID", "Book Title", "Author", "Date Published"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 700, 430));

        Interface.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 760, 490));

        AddButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        Interface.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 110, 40));

        UpdateButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        Interface.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 110, 40));

        DeleteButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        Interface.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Interface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Interface, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        addBook();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        updateBook();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        deleteBook();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this, "Are you sure you want to logout?", "Logout Confirmation",
        javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        
        try (Connection conn = new DbConnect().getConnection()) {
            Session sess = Session.getInstance();
            int userId = sess.getuid();
            String username = sess.getusername();

            Logger logger = new Logger(conn);
            logger.logAdd(userId, "User logged out: " + username);
        } catch (Exception e) {
            System.err.println("Failed to log logout action: " + e.getMessage());
        }

        this.dispose(); 
        
        Loginform loginPage = new Loginform(); 
        loginPage.setVisible(true);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    public javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JPanel Interface;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
