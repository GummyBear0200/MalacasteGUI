
package Admin;

import java.awt.Color;
import javax.swing.JButton;
import Admin.AdminUserControl;
import Internal.BorrowedBookPenalties;
import Users.Loginform;
import config.DbConnect;
import config.Logger;
import config.Session;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public final class AdminDashboard extends javax.swing.JFrame {

    
    public AdminDashboard() {
        setUndecorated(true);
        initComponents();
        
        JButton userButton = new JButton("User Control");


userButton.setBackground(new Color(200, 0, 0)); 
userButton.setForeground(Color.WHITE);
userButton.setFont(new Font("Arial", Font.BOLD, 14));
userButton.setFocusPainted(false);
userButton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); 


userButton.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        userButton.setBackground(new Color(220, 0, 0)); 
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        userButton.setBackground(new Color(200, 0, 0)); 
    }
});

       
        loadBooksTable();
        loadUsersData();
        loadBorrowersToTable();
    customizeButton(jButton1);
    customizeButton(jButton2);
    customizeButton(jButton3);
    customizeButton(jButton4);
    customizeButton(jButton5);
    customizeButton(jButton6);
    
    
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


jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!isSelected) {
            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
        }
        return c;
    }
});
 header = jTable2.getTableHeader();
header.setFont(new Font("Tahoma", Font.BOLD, 14));
header.setBackground(new Color(200, 0, 0));
header.setForeground(Color.WHITE);


jTable3.setRowHeight(25);
jTable3.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!isSelected) {
            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
        }
        return c;
    }
});
 header = jTable3.getTableHeader();
header.setFont(new Font("Tahoma", Font.BOLD, 14));
header.setBackground(new Color(200, 0, 0));
header.setForeground(Color.WHITE);


jTable3.setRowHeight(25);
    }
    
      private void loadBorrowersToTable() {
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    model.setRowCount(0); 

    try {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/malacaste_db",  
            "root",                            
            ""                         
        );

        String sql = "SELECT b.br_id, u.Fname, u.email, b.br_status " +
                     "FROM borrowers b " +
                     "JOIN users u ON b.u_id = u.u_id";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int brId = rs.getInt("br_id");
            String fname = rs.getString("Fname");           
            String email = rs.getString("email");
            String status = rs.getString("br_status");
            model.addRow(new Object[]{brId, fname + " " ,   status});
        }

        conn.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading borrowers: " + ex.getMessage());
    }
}
     public void getTotalAcc() {
        try {
            DbConnect dbc = new DbConnect();
            ResultSet rs = dbc.getData("SELECT COUNT(*) FROM users ");
            if (rs.next()) {
                int count = rs.getInt(1);
              totalacc.setText(String.valueOf(count));
            }
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }
 
  


 public void loadBooksTable() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    
    
    String[] columnNames = {"Book Title", "Author", "Status"};
    model.setColumnIdentifiers(columnNames);
    model.setRowCount(0); 

    String sql = "SELECT b_title, b_author, b_status FROM books";

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Object[] row = {
                rs.getString("b_title"),
                rs.getString("b_author"),
                rs.getString("b_status")
            };
            model.addRow(row); 
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

   private void loadUsersData() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    
    String[] columnNames = {"ID", "First Name", "Last Name", "Contact", "Email", "User Type", "Username", "Status"};
    model.setColumnIdentifiers(columnNames); 
    model.setRowCount(0);

    String sql = "SELECT u_id, Fname, Lname, Contactnum, email, usertype, RegUser, status FROM users";

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
                rs.getString("status")
            };
            model.addRow(row); 
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
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
private String generateTempPin() {
    StringBuilder pin = new StringBuilder();
    for (int i = 0; i < 6; i++) {
        int digit = (int)(Math.random() * 10); // generates 0-9
        pin.append(digit);
    }
    return pin.toString();
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Interface = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        acc_fname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        totalacc = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Interface.setBackground(new java.awt.Color(102, 102, 102));
        Interface.setForeground(new java.awt.Color(102, 102, 102));
        Interface.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LIBRARY MANAGEMENT SYSTEM");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 470, 50));

        jTextField1.setText("Search...");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 160, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/seacrhh.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 70, 70));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Online");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 50, -1, -1));

        acc_fname.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_fname.setForeground(new java.awt.Color(255, 255, 255));
        acc_fname.setText("Admin");
        jPanel3.add(acc_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 30));

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome!");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        Interface.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 60));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/ACCOUNTT.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/patients.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/log out.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 50, 50));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Online");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 50, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/reports.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 60, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/c6131e0206d37d4f4146d53c6e3d16f3.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 50, 40));

        jButton5.setBackground(new java.awt.Color(204, 0, 51));
        jButton5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton5.setText("User Control");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 140, 40));

        jButton3.setBackground(new java.awt.Color(204, 0, 51));
        jButton3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton3.setText("Books  ");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 140, 40));

        jButton4.setBackground(new java.awt.Color(204, 0, 51));
        jButton4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton4.setText("Borrowers");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 140, 40));

        jButton1.setBackground(new java.awt.Color(204, 0, 51));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setText("Reports");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 140, 40));

        jButton2.setBackground(new java.awt.Color(204, 0, 51));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton2.setText("LOGOUT");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 130, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Online");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 50, -1, -1));

        jButton6.setBackground(new java.awt.Color(204, 0, 51));
        jButton6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton6.setText("Penalties");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 140, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/reports.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 60, 60));

        Interface.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 590));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 710, 210));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Current Borrowers:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 250, 40));

        totalacc.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jPanel4.add(totalacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 40, 40));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setText("Current Books:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 250, 40));

        jTable2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 390, 260));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/patients.png"))); // NOI18N
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/c6131e0206d37d4f4146d53c6e3d16f3.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 50, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/reports.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 60, 60));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("Registered Users:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 250, 40));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Online");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 50, -1, -1));

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
            jTable3.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 290, 260));

        Interface.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 730, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Interface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Interface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 AdminReports ar = new AdminReports(); 
    ar.setVisible(true);  
    this.dispose();           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this, "Are you sure you want to logout?", "Logout Confirmation",
        javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        
        try (Connection conn = new DbConnect().getConnection()) {
            Session sess = Session.getInstance();
            int userId = sess.getuid();
            String username = sess.getusername();

            Logger logger = new Logger(conn);
            logger.logAdd(userId, "Admin logged out: " + username);
        } catch (Exception e) {
            System.err.println("Failed to log logout action: " + e.getMessage());
        }

        this.dispose(); 
        
        Loginform loginPage = new Loginform(); 
        loginPage.setVisible(true);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
AdminBookControl bookControl = new AdminBookControl(); 
    bookControl.setVisible(true);  
    this.dispose();        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       AdminBorrowers ab = new AdminBorrowers(); 
    ab.setVisible(true);  
    this.dispose();   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    AdminUserControl userControl = new AdminUserControl(); 
    userControl.setVisible(true);  
    this.dispose(); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        if (jTextField1.getText().equals("Search...")) {
        jTextField1.setText(""); 
    }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed
       
    
    }//GEN-LAST:event_jTextField1MousePressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
        String searchText = jTextField1.getText().trim();
        if (!searchText.isEmpty() && !searchText.equals("Search...")) {
            performSearch(searchText); 
        }
       }
    }//GEN-LAST:event_jTextField1KeyPressed
    
    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
      if (jTextField1.getText().trim().isEmpty()) {
        jTextField1.setText("Search...");
    }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
       
       if(sess.getuid() == 0){
           JOptionPane.showMessageDialog(null,"No account found , Log in First!");
           Loginform lf = new Loginform();
           lf.setVisible(true);
           this.dispose();
       
       }
       acc_fname.setText(sess.getFname() +" "+  sess.getLname());
       
    }//GEN-LAST:event_formWindowActivated

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       BorrowedBookPenalties bbp = new BorrowedBookPenalties();
       bbp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
    
private void performSearch(String query) {
    JOptionPane.showMessageDialog(this, "Searching for: " + query);
}
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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Interface;
    private javax.swing.JLabel acc_fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel totalacc;
    // End of variables declaration//GEN-END:variables
}
