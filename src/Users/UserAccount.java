
package Users;

import Admin.AdminUpdateUser;
import config.DbConnect;
import config.Session;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


public class UserAccount extends javax.swing.JFrame {

    
    public UserAccount() {
        initComponents();
       customizeButton(BackButton);
    customizeButton(LogoutButton);
    
    }
    
    private boolean hasShownPinReminder = false;
    private boolean isPinCreationOpen = false;
    
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Interface1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        acc_image_label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EditProfile = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        acc_fname_user = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        acc_lname_user = new javax.swing.JLabel();
        acc_lname_user1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        acc_cn_user = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        acc_cn_user2 = new javax.swing.JLabel();
        acc_cn_user3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        acc_cn_user4 = new javax.swing.JLabel();
        acc_cn_user5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        acc_cn_user6 = new javax.swing.JLabel();
        acc_cn_user7 = new javax.swing.JLabel();
        acc_cn_user8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        acc_em_user = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        acc_un_user = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        acc_ps_user = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        ChangePass = new javax.swing.JLabel();
        Sec = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Interface1.setBackground(new java.awt.Color(102, 102, 102));
        Interface1.setForeground(new java.awt.Color(102, 102, 102));
        Interface1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackButton.setBackground(new java.awt.Color(204, 0, 51));
        BackButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        BackButton.setText("Dashboard");
        BackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel3.add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 140, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 70));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SEE YOUR PERSONAL INFO HERE!");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 490, 50));

        LogoutButton.setBackground(new java.awt.Color(204, 0, 51));
        LogoutButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        LogoutButton.setText("LOGOUT");
        LogoutButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        jPanel2.add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 130, 30));

        Interface1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 70));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setLayout(null);
        jPanel14.add(acc_image_label);
        acc_image_label.setBounds(10, 10, 280, 280);

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 300, 300));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PROFILE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 140, 50));

        EditProfile.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        EditProfile.setForeground(new java.awt.Color(0, 0, 255));
        EditProfile.setText("EDIT PROFILE");
        EditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditProfileMouseExited(evt);
            }
        });
        jPanel1.add(EditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 120, 30));

        Interface1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 650));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_fname_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_fname_user.setText("User!");
        jPanel4.add(acc_fname_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 310, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel4.setText("Password:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 160, 50));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel8.setText("Last Name:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 170, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 350, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_lname_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_lname_user.setText("User!");
        jPanel6.add(acc_lname_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        acc_lname_user1.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_lname_user1.setText("User!");
        jPanel6.add(acc_lname_user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 350, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_cn_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user.setText("User!");
        jPanel7.add(acc_cn_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_cn_user2.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user2.setText("User!");
        jPanel8.add(acc_cn_user2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        acc_cn_user3.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user3.setText("User!");
        jPanel8.add(acc_cn_user3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_cn_user4.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user4.setText("User!");
        jPanel9.add(acc_cn_user4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        acc_cn_user5.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user5.setText("User!");
        jPanel9.add(acc_cn_user5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_cn_user6.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user6.setText("User!");
        jPanel10.add(acc_cn_user6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 80, -1));

        acc_cn_user7.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user7.setText("User!");
        jPanel10.add(acc_cn_user7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        acc_cn_user8.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_cn_user8.setText("User!");
        jPanel7.add(acc_cn_user8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel7.setText("Contact No:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 160, 50));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel9.setText("Email:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 160, 50));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel10.setText("Username:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 160, 50));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_em_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_em_user.setText("User!");
        jPanel11.add(acc_em_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        jPanel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 350, 40));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_un_user.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        acc_un_user.setText("User!");
        jPanel12.add(acc_un_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 320, 40));

        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 350, 40));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        acc_ps_user.setEditable(false);
        acc_ps_user.setText("jPasswordField1");
        acc_ps_user.setBorder(null);
        jPanel13.add(acc_ps_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, 300, 40));

        jPanel4.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 350, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/ACCOUNTT.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        ChangePass.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        ChangePass.setForeground(new java.awt.Color(0, 0, 255));
        ChangePass.setText("Change password");
        ChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangePassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChangePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChangePassMouseExited(evt);
            }
        });
        jPanel4.add(ChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 230, 30));

        Sec.setBackground(new java.awt.Color(0, 0, 0));
        Sec.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        Sec.setForeground(new java.awt.Color(51, 51, 255));
        Sec.setText("Security");
        Sec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SecMouseExited(evt);
            }
        });
        jPanel4.add(Sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 130, 50));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel13.setText("Account Details:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 241, 50));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel12.setText("First Name:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 170, 50));

        Interface1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 730, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Interface1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Interface1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        UserDashboard ud = new UserDashboard();
        ud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Are you sure you want to logout?", "Logout Confirmation",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose();

            Loginform loginPage = new Loginform();
            loginPage.setVisible(true);
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();

    if (sess.getuid() == 0) {
        JOptionPane.showMessageDialog(this, "No account found, Log in First!", "Login Required", JOptionPane.WARNING_MESSAGE);
        Loginform lf = new Loginform();
        lf.setVisible(true);
        this.dispose();
        return; 
    }

    acc_fname_user.setText(sess.getFname());
    acc_lname_user1.setText(sess.getLname());
    acc_cn_user8.setText(sess.getContact());
    acc_em_user.setText(sess.getemail());
    acc_un_user.setText(sess.getusername());
    acc_ps_user.setText(sess.getPassword());
    acc_ps_user.setEchoChar('*');

    
    String imagePath = sess.getImagePath();
    if (imagePath != null && !imagePath.isEmpty()) {
        File imgFile = new File(imagePath);
        if (imgFile.exists()) {
            acc_image_label.setIcon(ResizeImage(imagePath,null,acc_image_label)); 
        } else {
            System.out.println("Image not found: " + imagePath);
            acc_image_label.setIcon(new ImageIcon("path/to/default/icon.png")); 
        }
    }

   
       
    }//GEN-LAST:event_formWindowActivated

    private void ChangePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassMouseClicked
         UserChangePassForm ucpf = new UserChangePassForm();
            ucpf.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_ChangePassMouseClicked

    private void ChangePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassMouseEntered
      ChangePass.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
      ChangePass.setForeground(Color.BLACK); 
    }//GEN-LAST:event_ChangePassMouseEntered

    private void ChangePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassMouseExited
    ChangePass.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    ChangePass.setForeground(Color.BLUE); 
    }//GEN-LAST:event_ChangePassMouseExited

    private void SecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SecMouseClicked
       if (!isPinCreationOpen) { 
        isPinCreationOpen = true; 
        UserSecurity upc = new UserSecurity();
        
        
        upc.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                isPinCreationOpen = false; 
            }
        });

        upc.setVisible(true); 
    }
    }//GEN-LAST:event_SecMouseClicked

    private void SecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SecMouseEntered
        Sec.setCursor(new Cursor  (Cursor.HAND_CURSOR));
        Sec.setForeground(Color.BLACK);
    }//GEN-LAST:event_SecMouseEntered

    private void SecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SecMouseExited
       Sec.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
       Sec.setForeground(Color.BLUE);
    }//GEN-LAST:event_SecMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       Session sess = Session.getInstance(); 
    String pin = sess.getPIN(); 
    System.out.println("Retrieved PIN: " + pin); 

    
    if (pin == null || pin.isEmpty()) {
        if (!hasShownPinReminder) { 
            JOptionPane.showMessageDialog(this, "It is advisable that you create your PIN for your account security.", "PIN Reminder", JOptionPane.WARNING_MESSAGE);
            hasShownPinReminder = true; 
        }
    }
    }//GEN-LAST:event_formWindowOpened

    private void EditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProfileMouseClicked
       Session sess = Session.getInstance(); 
       String userId = String.valueOf(sess.getuid()); 

    if (userId == null || userId.equals("0")) { 
        JOptionPane.showMessageDialog(null, "No user is currently logged in!");
        return;
    }

    try {
        DbConnect dbc = new DbConnect();
        String query = "SELECT * FROM users WHERE u_id = ?";

        PreparedStatement pst = dbc.getConnection().prepareStatement(query);
        pst.setString(1, userId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            AdminUpdateUser crf = new AdminUpdateUser();
            crf.setUserId(userId);
            crf.fn.setText(rs.getString("Fname"));
            crf.ln.setText(rs.getString("Lname"));
            crf.cn.setText(rs.getString("Contactnum"));
            crf.em.setText(rs.getString("email"));
            crf.un.setText(rs.getString("RegUser"));
            crf.cmbStatus.setSelectedItem(rs.getString("status"));
            crf.cmbUserType.setSelectedItem(rs.getString("usertype"));

            String imagePath = rs.getString("image");
            File imgFile = new File(imagePath);
            if (imgFile.exists()) {
                crf.image.setIcon(crf.ResizeImage(imagePath, null, crf.image));
            } else {
                System.out.println("Image file does not exist: " + imagePath);
                crf.image.setIcon(new ImageIcon("path/to/default/icon.png"));
            }

            if (imagePath == null || imagePath.isEmpty()) { 
                crf.select.setEnabled(true); 
                crf.remove.setEnabled(false); 
            } else { 
                crf.select.setEnabled(false); 
                crf.remove.setEnabled(true); 
            }

            crf.oldpath = imagePath;
            crf.path = imagePath;
            crf.destination = imagePath;
            crf.ps.setEnabled(false); 
             crf.CancelButton1.setVisible(true);
             crf.CancelButton.setVisible(false);

            crf.setVisible(true);
            this.dispose();
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_EditProfileMouseClicked

    private void EditProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProfileMouseEntered
       EditProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
       EditProfile.setForeground(Color.BLACK);
    }//GEN-LAST:event_EditProfileMouseEntered

    private void EditProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditProfileMouseExited
       EditProfile.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
       EditProfile.setForeground(Color.BLUE);
    }//GEN-LAST:event_EditProfileMouseExited

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
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ChangePass;
    private javax.swing.JLabel EditProfile;
    private javax.swing.JPanel Interface1;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JLabel Sec;
    private javax.swing.JLabel acc_cn_user;
    private javax.swing.JLabel acc_cn_user2;
    private javax.swing.JLabel acc_cn_user3;
    private javax.swing.JLabel acc_cn_user4;
    private javax.swing.JLabel acc_cn_user5;
    private javax.swing.JLabel acc_cn_user6;
    private javax.swing.JLabel acc_cn_user7;
    private javax.swing.JLabel acc_cn_user8;
    private javax.swing.JLabel acc_em_user;
    private javax.swing.JLabel acc_fname_user;
    private javax.swing.JLabel acc_image_label;
    private javax.swing.JLabel acc_lname_user;
    private javax.swing.JLabel acc_lname_user1;
    private javax.swing.JPasswordField acc_ps_user;
    private javax.swing.JLabel acc_un_user;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
