
package Users;


import config.DbConnect;
import config.Session;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


public class UserPINcreation extends javax.swing.JFrame {
private boolean isPinCreationOpen = false;
    
    public UserPINcreation() {
         setUndecorated(true);
         addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                
            }
        });
        addMouseMotionListener(new java.awt.event.MouseAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                
            }
        });
        initComponents();
        setUpPinFields();
    }

  private void setUpPinFields() {
        JTextField[] pinFields = {frstdigitPIN, seconddigitPIN, thirddigitPIN, fourthdigitPIN, fifthdigitPIN, sixthdigitPIN};

        for (int i = 0; i < pinFields.length; i++) {
            
            ((AbstractDocument) pinFields[i].getDocument()).setDocumentFilter(new OneCharFilter());

            
            final int index = i;
            pinFields[i].addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
                        if (index < pinFields.length - 1) {
                            pinFields[index + 1].requestFocus();
                        }
                    }
                }
            });
        }
  }
  private class OneCharFilter extends DocumentFilter {
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.length() > 0) {
                if (string.length() > 1) {
                    string = string.substring(0, 1); 
                }
                super.insertString(fb, offset, string, attr);
            }
        }

        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && text.length() > 0) {
                if (text.length() > 1) {
                    text = text.substring(0, 1); 
                }
                super.replace(fb, offset, length, text, attrs);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CLose = new javax.swing.JLabel();
        sixthdigitPIN = new javax.swing.JTextField();
        frstdigitPIN = new javax.swing.JTextField();
        seconddigitPIN = new javax.swing.JTextField();
        thirddigitPIN = new javax.swing.JTextField();
        fourthdigitPIN = new javax.swing.JTextField();
        fifthdigitPIN = new javax.swing.JTextField();
        pin = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CLose.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        CLose.setForeground(new java.awt.Color(255, 255, 255));
        CLose.setText("X");
        CLose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CLoseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CLoseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CLoseMouseExited(evt);
            }
        });
        jPanel1.add(CLose, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, -1, -1));

        sixthdigitPIN.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        sixthdigitPIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sixthdigitPINKeyPressed(evt);
            }
        });
        jPanel1.add(sixthdigitPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 60, 60));

        frstdigitPIN.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jPanel1.add(frstdigitPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, 60));

        seconddigitPIN.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel1.add(seconddigitPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 60, 60));

        thirddigitPIN.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel1.add(thirddigitPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 60, 60));

        fourthdigitPIN.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel1.add(fourthdigitPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 60, 60));

        fifthdigitPIN.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jPanel1.add(fifthdigitPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 60, 60));

        pin.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        pin.setForeground(new java.awt.Color(255, 255, 255));
        pin.setText("pin");
        jPanel1.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, 20));

        submit.setBackground(new java.awt.Color(0, 0, 0));
        submit.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        submit.setText("OK");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 10));

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Create/Change your 6 digit PIN:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Current PIN:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CLoseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLoseMouseClicked
    
        this.dispose();
    
       
    }//GEN-LAST:event_CLoseMouseClicked

    private void CLoseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLoseMouseEntered
        CLose.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_CLoseMouseEntered

    private void CLoseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLoseMouseExited
        CLose.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_CLoseMouseExited

    private void sixthdigitPINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sixthdigitPINKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
        submit.doClick(); 
      }
    }//GEN-LAST:event_sixthdigitPINKeyPressed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
    String pin = frstdigitPIN.getText() + 
                 seconddigitPIN.getText() + 
                 thirddigitPIN.getText() + 
                 fourthdigitPIN.getText() + 
                 fifthdigitPIN.getText() + 
                 sixthdigitPIN.getText();

    
    if (pin.length() != 6 || !pin.matches("\\d{6}")) {
        JOptionPane.showMessageDialog(this, "Please enter a valid 6-digit PIN. It should contain only numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }
    
    String username = Session.getInstance().getusername(); 
    String sql = "UPDATE users SET PIN = '" + pin + "' WHERE RegUser = '" + username + "'";
    
    DbConnect dbConnect = new DbConnect();
    boolean success = dbConnect.insertData(sql);
    
    if (success) {
        Session.getInstance().setPIN(pin); 
        JOptionPane.showMessageDialog(this, "PIN created successfully!");
        
    } else {
        JOptionPane.showMessageDialog(this, "Error saving PIN to database.", "Database Error", JOptionPane.ERROR_MESSAGE);
    }        
    }//GEN-LAST:event_submitActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
       
       if(sess.getuid() == 0){
           JOptionPane.showMessageDialog(null,"No account found , Log in First!");
           Loginform lf = new Loginform();
           lf.setVisible(true);
           this.dispose();
           
           
       
       }
       pin.setText(""+sess.getPIN());
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(UserPINcreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPINcreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPINcreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPINcreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPINcreation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CLose;
    private javax.swing.JTextField fifthdigitPIN;
    private javax.swing.JTextField fourthdigitPIN;
    private javax.swing.JTextField frstdigitPIN;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pin;
    private javax.swing.JTextField seconddigitPIN;
    private javax.swing.JTextField sixthdigitPIN;
    private javax.swing.JButton submit;
    private javax.swing.JTextField thirddigitPIN;
    // End of variables declaration//GEN-END:variables
}
