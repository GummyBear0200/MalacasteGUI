
package Users;

import config.Session;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class UserRecoverySQchoice extends javax.swing.JFrame {
private int attempts = 10;
    
    public UserRecoverySQchoice() {
        setUndecorated(true);
        
        initComponents();
        
        
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                
            }
        });
        addMouseMotionListener(new java.awt.event.MouseAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                
            }
        });
         
     
        
    }
private String getCorrectAnswerFromDatabase() {
        
        Session sess = Session.getInstance();
        return sess.getAnswer(); 
    }
private void resetPassword() {
        
        JOptionPane.showMessageDialog(this, "Answer is correct! Proceeding to reset password.");
        UserResetPassword urp = new UserResetPassword();
        urp.setVisible(true);
        this.dispose();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        titlelabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        answer = new javax.swing.JTextField();
        sq = new javax.swing.JLabel();
        verify = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        titlelabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(244, 244, 244));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<<");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        titlelabel7.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel7.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        titlelabel7.setForeground(new java.awt.Color(255, 255, 255));
        titlelabel7.setText("SECURITY QUESTION");
        jPanel1.add(titlelabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 320, 50));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        answer.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        answer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        answer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                answerKeyPressed(evt);
            }
        });
        jPanel2.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 410, 50));

        sq.setBackground(new java.awt.Color(0, 0, 0));
        sq.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        sq.setText("SECURITY QUESTION");
        jPanel2.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 320, 50));

        verify.setBackground(new java.awt.Color(51, 51, 255));
        verify.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        verify.setForeground(new java.awt.Color(255, 255, 255));
        verify.setText("Verify");
        verify.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        verify.setBorderPainted(false);
        verify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verifyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verifyMouseExited(evt);
            }
        });
        verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyActionPerformed(evt);
            }
        });
        jPanel2.add(verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 150, 40));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 480, 210));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 900, 60));

        titlelabel6.setBackground(new java.awt.Color(0, 0, 0));
        titlelabel6.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        titlelabel6.setText("<html>Note: The question you're about to answer is the question you registered for emergency password recovery. you have 10<br> attempts to answer the question, if 10 attempts were used and you still ddn't get the correct password, you cant proceed the recovery process .</html>");
        jPanel3.add(titlelabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 890, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();

    
    if (sess.getusername() == null) {
        JOptionPane.showMessageDialog(null, "No account found, find your account first!");
        UserForgotPass ufp = new UserForgotPass();
        ufp.setVisible(true);
        this.dispose();
    } else {
               
        sq.setText(sess.getSecurityQuestion());
    }
    }//GEN-LAST:event_formWindowActivated

    private void verifyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifyMouseEntered
        verify.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_verifyMouseEntered

    private void verifyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifyMouseExited
        verify.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_verifyMouseExited

    private void verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyActionPerformed
        String userAnswer = answer.getText().trim(); 
        String correctAnswer = getCorrectAnswerFromDatabase(); 

        if (userAnswer.equals(correctAnswer)) {
            
            resetPassword();
        } else {
            attempts--; 
            if (attempts > 0) {
                JOptionPane.showMessageDialog(this, "Incorrect answer. You have " + attempts + " attempts left.");
            } else {
                JOptionPane.showMessageDialog(this, "Maximum attempts reached. You cannot proceed.");
                verify.setEnabled(false); 
            }
        }
        
    }//GEN-LAST:event_verifyActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       UserRecoveryOption uro = new UserRecoveryOption();
       uro.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
       jLabel2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel2MouseExited

    private void answerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_answerKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
        verify.doClick(); 
          }
    }//GEN-LAST:event_answerKeyPressed

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
            java.util.logging.Logger.getLogger(UserRecoverySQchoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRecoverySQchoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRecoverySQchoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRecoverySQchoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRecoverySQchoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel sq;
    private javax.swing.JLabel titlelabel6;
    private javax.swing.JLabel titlelabel7;
    private javax.swing.JButton verify;
    // End of variables declaration//GEN-END:variables
}
