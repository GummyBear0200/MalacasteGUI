
package Admin;

import config.DbConnect;
import config.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class AdminAddBorrower extends javax.swing.JFrame {

    
    public AdminAddBorrower() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtBookTitle = new javax.swing.JTextField();
        txtBookAuthor = new javax.swing.JTextField();
        txtBookPublicationDate = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txtBookTitle5 = new javax.swing.JTextField();
        txtAuthor5 = new javax.swing.JTextField();
        txtPubdate5 = new javax.swing.JTextField();
        txtStatus5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtBookTitle6 = new javax.swing.JTextField();
        txtAuthor6 = new javax.swing.JTextField();
        txtPubdate6 = new javax.swing.JTextField();
        txtStatus6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        txtBookTitle7 = new javax.swing.JTextField();
        txtAuthor7 = new javax.swing.JTextField();
        txtPubdate7 = new javax.swing.JTextField();
        txtStatus7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        AddButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        UpdateButton = new javax.swing.JButton();
        acc_id = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBookTitleMouseClicked(evt);
            }
        });
        txtBookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitleActionPerformed(evt);
            }
        });
        jPanel9.add(txtBookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 160, 40));
        jPanel9.add(txtBookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 180, 40));
        jPanel9.add(txtBookPublicationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 180, 40));

        jPanel10.setBackground(new java.awt.Color(255, 204, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookTitle5.setText("Title");
        txtBookTitle5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBookTitle5MouseClicked(evt);
            }
        });
        txtBookTitle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitle5ActionPerformed(evt);
            }
        });
        jPanel10.add(txtBookTitle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        txtAuthor5.setText("Author");
        jPanel10.add(txtAuthor5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));

        txtPubdate5.setText("Publication Date");
        jPanel10.add(txtPubdate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));

        txtStatus5.setText("Status of the book");
        jPanel10.add(txtStatus5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        jLabel10.setText("Note: To Add and Update please fill all fields then click the button you want to function.");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 570, 20));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 720, 70));

        jPanel11.setBackground(new java.awt.Color(255, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookTitle6.setText("Title");
        txtBookTitle6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBookTitle6MouseClicked(evt);
            }
        });
        txtBookTitle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitle6ActionPerformed(evt);
            }
        });
        jPanel11.add(txtBookTitle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        txtAuthor6.setText("Author");
        jPanel11.add(txtAuthor6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));

        txtPubdate6.setText("Publication Date");
        jPanel11.add(txtPubdate6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));

        txtStatus6.setText("Status of the book");
        jPanel11.add(txtStatus6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        jLabel11.setText("Note: To Add and Update please fill all fields then click the button you want to function.");
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 570, 20));

        jPanel12.setBackground(new java.awt.Color(255, 204, 204));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookTitle7.setText("Title");
        txtBookTitle7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBookTitle7MouseClicked(evt);
            }
        });
        txtBookTitle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitle7ActionPerformed(evt);
            }
        });
        jPanel12.add(txtBookTitle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        txtAuthor7.setText("Author");
        jPanel12.add(txtAuthor7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 160, -1));

        txtPubdate7.setText("Publication Date");
        jPanel12.add(txtPubdate7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));

        txtStatus7.setText("Status of the book");
        jPanel12.add(txtStatus7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, -1));

        jLabel12.setText("Note: To Add and Update please fill all fields then click the button you want to function.");
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 570, 20));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 720, 70));

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 720, 70));

        jLabel9.setText("Note: To Add please fill all fields then click the add button to function.");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 340, 20));

        AddButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton.setText("CANCEL");
        AddButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        jPanel9.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 110, 40));

        AddButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton1.setText("ADD");
        AddButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton1ActionPerformed(evt);
            }
        });
        jPanel9.add(AddButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 130, 40));

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 10)); // NOI18N
        jLabel1.setText("STATUS: (AVAILABLE)");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 140, 20));

        jLabel2.setFont(new java.awt.Font("Arial Black", 2, 10)); // NOI18N
        jLabel2.setText("Name:");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 34, 50, 20));

        jLabel3.setFont(new java.awt.Font("Arial Black", 2, 10)); // NOI18N
        jLabel3.setText("Address:");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 50, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 2, 10)); // NOI18N
        jLabel5.setText("Contact:");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 200, 20));

        jComboBox1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Unavailable", "Out Of Stock", " " }));
        jPanel9.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 180, 40));

        UpdateButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        jPanel9.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 130, 40));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 660, 330));

        acc_id.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        acc_id.setForeground(new java.awt.Color(255, 255, 255));
        acc_id.setText("Id");
        jPanel1.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 40, 50));

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Borrower Page");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 241, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBookTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBookTitleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitleMouseClicked

    private void txtBookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitleActionPerformed

    private void txtBookTitle5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBookTitle5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle5MouseClicked

    private void txtBookTitle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitle5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle5ActionPerformed

    private void txtBookTitle6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBookTitle6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle6MouseClicked

    private void txtBookTitle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle6ActionPerformed

    private void txtBookTitle7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBookTitle7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle7MouseClicked

    private void txtBookTitle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitle7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitle7ActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        AdminBookControl adminbookcontrol = new AdminBookControl();
        adminbookcontrol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void AddButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton1ActionPerformed
        if (txtBookTitle.getText().isEmpty() || txtBookAuthor.getText().isEmpty() || txtBookPublicationDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
            return;
        }

        try (Connection connect = new DbConnect().getConnection()) {
            String insertQuery = "INSERT INTO books (b_title, b_author, b_pubdate, b_status) VALUES (?, ?, ?, ?)";

            try (PreparedStatement insertStmt = connect.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                insertStmt.setString(1, txtBookTitle.getText());
                insertStmt.setString(2, txtBookAuthor.getText());
                insertStmt.setString(3, txtBookPublicationDate.getText());
                insertStmt.setString(4, (String) jComboBox1.getSelectedItem());

                int insertedRows = insertStmt.executeUpdate();

                if (insertedRows > 0) {
                    int bookId = -1;

                    try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            bookId = generatedKeys.getInt(1);
                            System.out.println("New book ID: " + bookId);
                        }
                    }

                    int adminId = Integer.parseInt(acc_id.getText());
                    Logger logger = new Logger(connect);
                    logger.logAdd(adminId, "Admin Added book: " + txtBookTitle.getText());

                    JOptionPane.showMessageDialog(null, "Book added successfully!");
                    AdminBookControl au = new AdminBookControl();
                    au.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Insertion failed!");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AddButton1ActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        if (txtBookTitle.getText().isEmpty() || txtBookAuthor.getText().isEmpty() || txtBookPublicationDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
            return;
        }

        try (Connection connect = new DbConnect().getConnection()) {
            String updateQuery = "UPDATE books SET b_title = ?, b_author = ?, b_pubdate = ?, b_status = ? WHERE b_id = ?";

            try (PreparedStatement updateStmt = connect.prepareStatement(updateQuery)) {
                updateStmt.setString(1, txtBookTitle.getText());
                updateStmt.setString(2, txtBookAuthor.getText());
                updateStmt.setString(3, txtBookPublicationDate.getText());
                updateStmt.setString(4, (String) jComboBox1.getSelectedItem());
               

                int updatedRows = updateStmt.executeUpdate();

                if (updatedRows > 0) {

                    int adminId = Integer.parseInt(acc_id.getText());
                    Logger logger = new Logger(connect);
                    logger.logAdd(adminId, "Admin Updated book: " + txtBookTitle.getText());

                    JOptionPane.showMessageDialog(null, "Book updated successfully!");
                    AdminBookControl au = new AdminBookControl();
                    au.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No book was updated.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(AdminAddBorrower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddBorrower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddBorrower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddBorrower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAddBorrower().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    public javax.swing.JButton AddButton1;
    public javax.swing.JButton UpdateButton;
    private javax.swing.JLabel acc_id;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField txtAuthor5;
    private javax.swing.JTextField txtAuthor6;
    private javax.swing.JTextField txtAuthor7;
    public javax.swing.JTextField txtBookAuthor;
    public javax.swing.JTextField txtBookPublicationDate;
    public javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtBookTitle5;
    private javax.swing.JTextField txtBookTitle6;
    private javax.swing.JTextField txtBookTitle7;
    private javax.swing.JTextField txtPubdate5;
    private javax.swing.JTextField txtPubdate6;
    private javax.swing.JTextField txtPubdate7;
    private javax.swing.JTextField txtStatus5;
    private javax.swing.JTextField txtStatus6;
    private javax.swing.JTextField txtStatus7;
    // End of variables declaration//GEN-END:variables
}
