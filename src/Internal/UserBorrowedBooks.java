/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Internal;

import Users.UserDashboard;
import config.Logger;
import config.Session;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author II
 */
public class UserBorrowedBooks extends javax.swing.JFrame {

    /**
     * Creates new form UserBorrowedBooks
     */
    public UserBorrowedBooks() {
        setUndecorated(true);
        initComponents();
        loadUserBorrowedBooks();
        
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

     void loadUserBorrowedBooks() {
    int userId = Session.getInstance().getuid();

    try {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/malacaste_db", 
            "root", 
            ""
        );

        String sql = "SELECT bb.bbr_id, b.b_title, b.b_author, bb.borrowdays, bb.created_at, bb.updated_at " +
                     "FROM Borrowedbooks bb " +
                     "INNER JOIN borrowers br ON bb.br_id = br.br_id " +
                     "INNER JOIN books b ON bb.b_fk = b.b_id " +
                     "WHERE br.u_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = new DefaultTableModel(
            new String[]{"BorrowedBook ID", "Book Title", "Author", "Borrow Days", "Borrowed Date", "Updated Date"}, 
            0
        );

        while (rs.next()) {
            int bbrId = rs.getInt("bbr_id");
            String title = rs.getString("b_title");
            String author = rs.getString("b_author");
            int days = rs.getInt("borrowdays");
            String createdAt = rs.getString("created_at");
            String updatedAt = rs.getString("updated_at");

            model.addRow(new Object[]{bbrId, title, author, days, createdAt, updatedAt});
        }

        jTable1.setModel(model);

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading borrowed books: " + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        returnbutton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("YOUR BORROWED BOOKS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 880, 70));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 750, 459));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("If you want to return a book you can select the book and click return.");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 645, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 103, 34));

        returnbutton.setBackground(new java.awt.Color(204, 0, 0));
        returnbutton.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        returnbutton.setText("Return");
        returnbutton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returnbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnbuttonMouseExited(evt);
            }
        });
        returnbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(returnbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 500, 180, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 770, 540));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 70));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 150, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       UserDashboard us = new UserDashboard();
       us.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      UserDashboard udb = new UserDashboard();
      udb.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
     jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
     jButton2.setBackground(Color.WHITE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
         jButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
     jButton2.setBackground(Color.RED);
    }//GEN-LAST:event_jButton2MouseExited

    private void returnbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnbuttonMouseClicked
 int selectedRow = jTable1.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a borrowed book to return.");
        return;
    }

    try {
        int userId = Session.getInstance().getuid();
        String borrowerName = Session.getInstance().getusername();

        int bbrId = (int) jTable1.getValueAt(selectedRow, 0);
        String bookTitle = jTable1.getValueAt(selectedRow, 1).toString();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");

        String getBookId = "SELECT b_fk, br_id FROM Borrowedbooks WHERE bbr_id = ?";
        PreparedStatement psBook = conn.prepareStatement(getBookId);
        psBook.setInt(1, bbrId);
        ResultSet rsBook = psBook.executeQuery();

        if (!rsBook.next()) {
            JOptionPane.showMessageDialog(null, "Book record not found.");
            conn.close();
            return;
        }

        int bookId = rsBook.getInt("b_fk");
        int borrowerId = rsBook.getInt("br_id");

        String deleteQuery = "DELETE FROM Borrowedbooks WHERE bbr_id = ?";
        PreparedStatement psDelete = conn.prepareStatement(deleteQuery);
        psDelete.setInt(1, bbrId);
        psDelete.executeUpdate();

        String updateBook = "UPDATE books SET b_status = 'available' WHERE b_id = ?";
        PreparedStatement psUpdateBook = conn.prepareStatement(updateBook);
        psUpdateBook.setInt(1, bookId);
        psUpdateBook.executeUpdate();

        String checkOtherBorrowed = "SELECT COUNT(*) AS total FROM Borrowedbooks WHERE br_id = ?";
        PreparedStatement psCheck = conn.prepareStatement(checkOtherBorrowed);
        psCheck.setInt(1, borrowerId);
        ResultSet rsCheck = psCheck.executeQuery();

        if (rsCheck.next() && rsCheck.getInt("total") == 0) {
            String updateBorrower = "UPDATE borrowers SET br_status = 'not borrowed' WHERE br_id = ?";
            PreparedStatement psUpdateBorrower = conn.prepareStatement(updateBorrower);
            psUpdateBorrower.setInt(1, borrowerId);
            psUpdateBorrower.executeUpdate();
        }

        String updateTransaction = "UPDATE transactions SET return_date = NOW() WHERE user_id = ? AND book_id = ? AND return_date IS NULL";
        PreparedStatement psTransaction = conn.prepareStatement(updateTransaction);
        psTransaction.setInt(1, userId);
        psTransaction.setInt(2, bookId);
        psTransaction.executeUpdate();

       
        Logger logger = new Logger(conn);
        String logMessage = "Borrower '" + borrowerName + "' returned the book '" + bookTitle + "' (ID: " + bookId + ")";
        logger.logAdd(userId, logMessage);

        JOptionPane.showMessageDialog(null, "Book '" + bookTitle + "' has been returned successfully.");
        loadUserBorrowedBooks();

        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    }
    }//GEN-LAST:event_returnbuttonMouseClicked

    private void returnbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnbuttonMouseEntered
        returnbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
     returnbutton.setBackground(Color.WHITE);
    }//GEN-LAST:event_returnbuttonMouseEntered

    private void returnbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnbuttonMouseExited
         returnbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
     returnbutton.setBackground(Color.RED);
    }//GEN-LAST:event_returnbuttonMouseExited

    private void returnbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(UserBorrowedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserBorrowedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserBorrowedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserBorrowedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserBorrowedBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton returnbutton;
    // End of variables declaration//GEN-END:variables
}
