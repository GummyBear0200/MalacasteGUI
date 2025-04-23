
package Admin;

import config.DbConnect;
import config.Session;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class AdminAddUser extends javax.swing.JFrame {

    
    public AdminAddUser() {
        initComponents();
    }
    
   public String destination;
   File selectedFile;
   public String oldpath;
   public String path;
   
    private String BookId; 

    public void setUserId(String id) {
        this.BookId = id; 
    }
    public void setFirstName(String firstName) {
    this.fn.setText(firstName);
}

public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/profileImages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}

public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!"+ex);
        }
        
        return -1;
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
   private String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b)); 
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cc = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        AddButton1 = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        fn = new javax.swing.JTextField();
        cn = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
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
        ln = new javax.swing.JTextField();
        ps = new javax.swing.JPasswordField();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        select = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Add User page");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 241, 50));

        cc.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        cc.setForeground(new java.awt.Color(255, 255, 255));
        cc.setText("Current User ID:");
        jPanel2.add(cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 220, 50));

        acc_id.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        acc_id.setForeground(new java.awt.Color(255, 255, 255));
        acc_id.setText("ID");
        jPanel2.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 110, 50));

        AddButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        AddButton1.setText("ADD");
        AddButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(AddButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 150, 40));

        CancelButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CancelButton.setText("CANCEL");
        CancelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        jPanel2.add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 150, 40));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel5.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 40));
        jPanel5.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, 40));
        jPanel5.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 170, 40));
        jPanel5.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 180, 40));

        jLabel1.setText("Note: To Add, please fill all fields then click the add button to function.");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 570, 20));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Status:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 70, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("First Name:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Last Name:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 90, 20));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Contact:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 70, 20));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Email:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 60, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("User Type:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 70, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Username:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 70, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Password:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 70, 30));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });
        jPanel5.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 180, 40));

        cmbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User", "Borrower" }));
        jPanel5.add(cmbUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 170, 40));
        jPanel5.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, 40));
        jPanel5.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 180, 40));

        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, 40));

        jPanel3.setLayout(null);
        jPanel3.add(image);
        image.setBounds(10, 10, 260, 250);

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 280, 270));

        remove.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        remove.setText("REMOVE");
        remove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel5.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, 120, 30));

        select.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        select.setText("SELECT");
        select.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel5.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 120, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 940, 350));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Add User page");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 241, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        AdminUserControl adminusercontrol = new AdminUserControl();
        adminusercontrol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void AddButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton1ActionPerformed
      
    
      if (fn.getText().isEmpty() || ln.getText().isEmpty() || cn.getText().isEmpty()
        || em.getText().isEmpty() || un.getText().isEmpty() || ps.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required!");
        return;
    }

    if (ps.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
        ps.setText("");
        return;
    }

    if (duplicateCheck()) {
        JOptionPane.showMessageDialog(null, "Username already exists!");
        return;
    }

    String hashedPassword = hashPassword(ps.getText());
    if (hashedPassword == null) {
        JOptionPane.showMessageDialog(null, "Error hashing password. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   try (Connection connect = new DbConnect().getConnection()) {
    
    String insertQuery = "INSERT INTO users (Fname, Lname, Contactnum, email, RegUser, RegPass, usertype, status, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement insertStmt = connect.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
       
        insertStmt.setString(1, fn.getText());
        insertStmt.setString(2, ln.getText());
        insertStmt.setString(3, cn.getText());
        insertStmt.setString(4, em.getText());
        insertStmt.setString(5, un.getText());
        insertStmt.setString(6, hashedPassword);
        insertStmt.setString(7, (String) cmbUserType.getSelectedItem());
        insertStmt.setString(8, (String) cmbStatus.getSelectedItem());
        insertStmt.setString(9, destination);
        
        int insertedRows = insertStmt.executeUpdate();
        if (insertedRows > 0) {
            
            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userId = generatedKeys.getInt(1); 

                   
                    Logger logger = new Logger(connect); 
                    int adminId = Integer.parseInt(acc_id.getText()); 
                    logger.logAdd(adminId, "Admin added user: " + un.getText());
                }
            }

            
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "Registration Successful!");
            AdminUserControl au = new AdminUserControl();
            au.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Connection Error!");
        }
    }
} catch (SQLException | IOException ex) {
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_AddButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
       acc_id.setText(""+sess.getuid());
    }//GEN-LAST:event_formWindowActivated

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
       JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/profileImages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                            
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!"+ex);
                    }
                }

    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
       remove.setEnabled(false);
       select.setEnabled(true);
       image.setIcon(null);
       destination = "";
       path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if (jCheckBox4.isSelected()) {
            ps.setEchoChar((char) 0);
        } else {
            ps.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

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
            java.util.logging.Logger.getLogger(AdminAddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton1;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel cc;
    public javax.swing.JComboBox<String> cmbStatus;
    public javax.swing.JComboBox<String> cmbUserType;
    public javax.swing.JTextField cn;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JTextField ln;
    public javax.swing.JPasswordField ps;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
