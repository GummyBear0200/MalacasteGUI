
package Admin;


import Users.Loginform;
import Users.UserAccount;
import config.DbConnect;
import config.Logger;
import config.Session;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class AdminUpdateUser extends javax.swing.JFrame {
 
    
    
    
    public AdminUpdateUser() {
        initComponents();
        
        
    }
    
    public String destination;
   File selectedFile;
   public String oldpath;
   public String path;

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
    private String userId; 

    public void setUserId(String id) {
        this.userId = id; 
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
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        cmbUserType = new javax.swing.JComboBox<>();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        cn = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        ps = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        cc = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        CancelButton1 = new javax.swing.JButton();
        UpdateButton1 = new javax.swing.JButton();

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

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Note: To Update, please fill all fields then click the update button to function.");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 570, 20));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Status:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 70, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("First Name:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 130, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Last Name:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Contact:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, 20));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Email:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 70, 20));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("User Type:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 70, 20));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Username:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 90, 20));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Password:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 70, 20));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        jPanel6.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 160, 40));

        cmbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User", "Borrower" }));
        jPanel6.add(cmbUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 170, 40));
        jPanel6.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 40));
        jPanel6.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 170, 40));
        jPanel6.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 170, 40));
        jPanel6.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 170, 40));
        jPanel6.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 160, 40));
        jPanel6.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 160, 40));

        jPanel3.setLayout(null);
        jPanel3.add(image);
        image.setBounds(10, 10, 260, 250);

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 280, 270));

        select.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        select.setText("SELECT");
        select.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel6.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 120, 30));

        remove.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        remove.setText("REMOVE");
        remove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel6.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, 120, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 950, 350));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Update User page");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 241, 50));

        CancelButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CancelButton.setText("CANCEL");
        CancelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        jPanel2.add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 140, 40));

        UpdateButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 140, 40));

        cc.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        cc.setForeground(new java.awt.Color(255, 255, 255));
        cc.setText("Current User ID:");
        jPanel2.add(cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 220, 50));

        acc_id.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        acc_id.setForeground(new java.awt.Color(255, 255, 255));
        acc_id.setText("ID");
        jPanel2.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 110, 50));

        CancelButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CancelButton1.setText("CANCEL");
        CancelButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(CancelButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 140, 40));

        UpdateButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UpdateButton1.setText("Update");
        UpdateButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UpdateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(UpdateButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 140, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
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

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
 
     String newFname = fn.getText().trim();
    String newLname = ln.getText().trim();
    String newContact = cn.getText().trim();
    String newEmail = em.getText().trim();
    String newUsername = un.getText().trim();
    String newUserType = cmbUserType.getSelectedItem().toString();
    String newUserStatus = cmbStatus.getSelectedItem().toString();

    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

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

        String updateQuery = "UPDATE users SET Fname = ?, Lname = ?, email = ?, RegUser = ?, usertype = ?, status = ?";
        if (path != null && !path.isEmpty()) {
            updateQuery += ", image = ?"; 
        }
        updateQuery += " WHERE u_id = ?";

        try (PreparedStatement updatePst = conn.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS)) {
            updatePst.setString(1, newFname);
            updatePst.setString(2, newLname);
            updatePst.setString(3, newEmail);
            updatePst.setString(4, newUsername);
            updatePst.setString(5, newUserType);
            updatePst.setString(6, newUserStatus);
            
            if (path != null && !path.isEmpty()) {
                updatePst.setString(7, destination);
                updatePst.setString(8, this.userId);
            } else {
                updatePst.setString(7, this.userId); 
            }

            int updated = updatePst.executeUpdate();
            if (updated > 0) {
    
    Logger logger = new Logger(conn); 
    int adminId = Integer.parseInt(acc_id.getText()); 
    String logMessage = "Admin updated user info: " + newUsername + " (User ID: " + this.userId + ")";
    
    try {
        logger.logAdd(adminId, logMessage);
    } catch (Exception logEx) {
        JOptionPane.showMessageDialog(this, "Error logging the update: " + logEx.getMessage(), "Log Error", JOptionPane.ERROR_MESSAGE);
    }

                
                if (destination == null || destination.isEmpty()) {
                    
                    if (oldpath != null) {
                        File existingFile = new File(oldpath); 
                        if (existingFile.exists()) { 
                            existingFile.delete(); 
                        }
                    }

                    
                    String updateImageQuery = "UPDATE users SET image = NULL WHERE u_id = ?";
                    try (PreparedStatement updateImagePst = conn.prepareStatement(updateImageQuery)) {
                        updateImagePst.setString(1, this.userId);
                        updateImagePst.executeUpdate();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error updating image in database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else { 
                    if (oldpath != null && !oldpath.equals(path)) { 
                        imageUpdater(oldpath, path); 
                    } 
                }

                
                if (selectedFile != null && destination != null) {
                    try {
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error copying the image file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "User data updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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

    private void CancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButton1ActionPerformed
       UserAccount ua = new UserAccount();
        ua.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelButton1ActionPerformed

    private void UpdateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton1ActionPerformed
    
         String newFname = fn.getText().trim();
    String newLname = ln.getText().trim();
    String newContact = cn.getText().trim();
    String newEmail = em.getText().trim();
    String newUsername = un.getText().trim();
    String newUserType = cmbUserType.getSelectedItem().toString();
    String newUserStatus = cmbStatus.getSelectedItem().toString();

    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

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

        String updateQuery = "UPDATE users SET Fname = ?, Lname = ?, email = ?, RegUser = ?, usertype = ?, status = ?";
        if (path != null && !path.isEmpty()) {
            updateQuery += ", image = ?"; 
        }
        updateQuery += " WHERE u_id = ?";

        try (PreparedStatement updatePst = conn.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS)) {
            updatePst.setString(1, newFname);
            updatePst.setString(2, newLname);
            updatePst.setString(3, newEmail);
            updatePst.setString(4, newUsername);
            updatePst.setString(5, newUserType);
            updatePst.setString(6, newUserStatus);
            
            if (path != null && !path.isEmpty()) {
                updatePst.setString(7, destination);
                updatePst.setString(8, this.userId);
            } else {
                updatePst.setString(7, this.userId); 
            }

            int updated = updatePst.executeUpdate();
            if (updated > 0) {
    
    Logger logger = new Logger(conn); 
    int adminId = Integer.parseInt(acc_id.getText()); 
    String logMessage = "User updated their info: " + newUsername + " (User ID: " + this.userId + ")";
    
    try {
        logger.logAdd(adminId, logMessage);
    } catch (Exception logEx) {
        JOptionPane.showMessageDialog(this, "Error logging the update: " + logEx.getMessage(), "Log Error", JOptionPane.ERROR_MESSAGE);
    }

                
                if (destination == null || destination.isEmpty()) {
                    
                    if (oldpath != null) {
                        File existingFile = new File(oldpath); 
                        if (existingFile.exists()) { 
                            existingFile.delete(); 
                        }
                    }

                    
                    String updateImageQuery = "UPDATE users SET image = NULL WHERE u_id = ?";
                    try (PreparedStatement updateImagePst = conn.prepareStatement(updateImageQuery)) {
                        updateImagePst.setString(1, this.userId);
                        updateImagePst.executeUpdate();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error updating image in database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else { 
                    if (oldpath != null && !oldpath.equals(path)) { 
                        imageUpdater(oldpath, path); 
                    } 
                }

                
                if (selectedFile != null && destination != null) {
                    try {
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error copying the image file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "User data updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new UserAccount().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
   
    }//GEN-LAST:event_UpdateButton1ActionPerformed

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
    public javax.swing.JButton CancelButton;
    public javax.swing.JButton CancelButton1;
    public javax.swing.JButton UpdateButton;
    public javax.swing.JButton UpdateButton1;
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel cc;
    public javax.swing.JComboBox<String> cmbStatus;
    public javax.swing.JComboBox<String> cmbUserType;
    public javax.swing.JTextField cn;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JTextField ln;
    public javax.swing.JPasswordField ps;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
