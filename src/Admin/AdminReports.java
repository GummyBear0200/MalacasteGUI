
package Admin;

import java.awt.Color;
import java.awt.Component;
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


public class AdminReports extends javax.swing.JFrame {

    public AdminReports() {
        setUndecorated(true);
        initComponents();
        loadPinRequestData();
         loadTransactionHistory(jTable1);
        
        
         Logs.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!isSelected) {
            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
        }
        return c;
    }
});


JTableHeader header = Logs.getTableHeader();
header.setFont(new Font("Tahoma", Font.BOLD, 14));
header.setBackground(new Color(200, 0, 0));
header.setForeground(Color.WHITE);


jTable1.setRowHeight(25);

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


 header = jTable1.getTableHeader();
header.setFont(new Font("Tahoma", Font.BOLD, 14));
header.setBackground(new Color(200, 0, 0));
header.setForeground(Color.WHITE);


jTable1.setRowHeight(25);
    }
  public void loadPinRequestData() {
    DefaultTableModel model = (DefaultTableModel) Logs.getModel();
    
    
    String[] columnNames = {"Log ID", "User ID", "Log Action", "Log Performed"};
    model.setColumnIdentifiers(columnNames);
    model.setRowCount(0); 

    String sql = "SELECT log_id , u_id, log_action, log_date FROM logs";

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Object[] row = {
                rs.getString("log_id"),
                rs.getString("u_id"),
                rs.getString("log_action"),
                rs.getString("log_date")
            };
            model.addRow(row); 
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
public void loadTransactionHistory(JTable Table) {
    try {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/malacaste_db", "root", ""
        );

        String sql = "SELECT t.trans_id, u.Fname AS user_name, b.b_title AS book_title, " +
                     "t.borrow_date, t.return_date " +
                     "FROM transactions t " +
                     "INNER JOIN users u ON t.user_id = u.u_id " +
                     "INNER JOIN books b ON t.book_id = b.b_id " +
                     "ORDER BY t.borrow_date DESC";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Transaction ID");
        model.addColumn("User Name");
        model.addColumn("Book Title");
        model.addColumn("Borrow Date");
        model.addColumn("Return Date");

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("trans_id"),
                rs.getString("user_name"),
                rs.getString("book_title"),
                rs.getString("borrow_date"),
                rs.getString("return_date")
            });
        }

        jTable1.setModel(model);
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to load transaction history.");
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Logs = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, -1, -1));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, -1, -1));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Reports / Logs");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 1020, 67));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 920, 67));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 700));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logs.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Logs.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Logs);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 820, 240));

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Transactions:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

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
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 820, 280));

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("System Logs:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 860, 630));

        jLabel2.setBackground(new java.awt.Color(153, 0, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/54476.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 110, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked


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
            java.util.logging.Logger.getLogger(AdminReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Logs;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
