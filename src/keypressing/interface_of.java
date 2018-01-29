/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypressing;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lakshi Athapaththu
 */
public class interface_of extends javax.swing.JFrame {
    Connection conn =null;
    PreparedStatement pst = null;
    int counter = 0;
    
    /**
     * Creates new form interface_of
     */
    public interface_of() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email = new javax.swing.JTextField();
        emaillabel = new javax.swing.JLabel();
        passwordlabel = new javax.swing.JLabel();
        signin = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });

        emaillabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emaillabel.setText("E-MAIL");

        passwordlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordlabel.setText("PASS WORD");

        signin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        signin.setText("SIGN IN");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });

        signup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        signup.setText("SIGN UP");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signin)
                        .addGap(38, 38, 38)
                        .addComponent(signup)
                        .addGap(49, 49, 49)
                        .addComponent(reset)
                        .addGap(46, 46, 46)
                        .addComponent(exit)
                        .addContainerGap(139, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(emaillabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(email)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emaillabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signin)
                    .addComponent(signup)
                    .addComponent(reset)
                    .addComponent(exit))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
KeyDemo kd = new KeyDemo();
ConnectDB con = new ConnectDB(); 


    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        long startTime = System.nanoTime();
        //System.out.println("Key typed:" + e.getKeyChar());
        kd.str=kd.str+evt.getKeyChar();
        //System.out.println(str);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime); 
        kd.totemail+=duration;
        //System.out.println("released duration is for:"+evt.getKeyChar()+" "+duration);
        kd.released.add(duration);
    }//GEN-LAST:event_emailKeyReleased

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        long startTime = System.nanoTime();
        //System.out.println("Key typed:" + e.getKeyChar());
        kd.str=kd.str+evt.getKeyChar();
        //System.out.println(str);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime); 
        //System.out.println("pressed duration is for:"+evt.getKeyChar()+"  "+duration);
        kd.totemail+=duration;
        kd.pressed.add(duration);
        
    }//GEN-LAST:event_emailKeyPressed

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        long startTime = System.nanoTime();
        //System.out.println("Key typed:" + e.getKeyChar());
        kd.str=kd.str+evt.getKeyChar();
        //System.out.println(str);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime); 
        //System.out.println("Typed duration is for:"+evt.getKeyChar()+"  "+duration);
        kd.totemail+=duration;
        kd.typed.add(duration);
        
    }//GEN-LAST:event_emailKeyTyped

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        password.setText(null);
        email.setText(null);
    }//GEN-LAST:event_resetActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
       if (email.getText().equals("")==false && password.getText().equals("")==false){
        
        
       signin.setVisible(false);
           try {
               kd.signUpAction(counter, email.getText(), password.getText());
           } catch (SQLException ex) {
               Logger.getLogger(interface_of.class.getName()).log(Level.SEVERE, null, ex);
           }
       if(counter<10){
           password.setText(null);
           email.setText(null);
           counter++;
       }
       
       else if(counter ==10){
           
           password.setText(null);
           email.setText(null);
           password.setText(null);
           email.setText(null);
           signin.setVisible(true);
           counter++;
       }
       else{
            signin.setVisible(true);
            password.setText(null);
            email.setText(null);
       }
       }
       else{
           System.out.println("input fields cannot be empty");
       }
    }//GEN-LAST:event_signupActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        long startTime = System.nanoTime();
        //System.out.println("Key typed:" + e.getKeyChar());
        kd.pw=kd.pw+evt.getKeyChar();
        //System.out.println(str);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime); 
        //System.out.println("pressed duration is for:"+evt.getKeyChar()+" "+duration);
        kd.totpw+=duration;
        kd.pressed.add(duration);
    }//GEN-LAST:event_passwordKeyPressed

    private void passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyReleased
        long startTime = System.nanoTime();
        //System.out.println("Key typed:" + e.getKeyChar());
        kd.pw=kd.pw+evt.getKeyChar();
        //System.out.println(str);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime); 
        //System.out.println("released duration is for:"+evt.getKeyChar()+" "+duration);
         kd.totpw+=duration;
         kd.released.add(duration);
    }//GEN-LAST:event_passwordKeyReleased

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        long startTime = System.nanoTime();
        //System.out.println("Key typed:" + e.getKeyChar());
        kd.pw=kd.pw+evt.getKeyChar();
        //System.out.println(str);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime); 
        //System.out.println("typed duration is for:"+evt.getKeyChar()+" "+duration);
         kd.totpw+=duration;
         kd.typed.add(duration);
    }//GEN-LAST:event_passwordKeyTyped

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        try {
            kd.signinAction(email.getText(),password.getText() );
        } catch (SQLException ex) {
            Logger.getLogger(interface_of.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(email.getText()+" "+password.getText());
        
    }//GEN-LAST:event_signinActionPerformed

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
            java.util.logging.Logger.getLogger(interface_of.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interface_of.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interface_of.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interface_of.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               interface_of a = new interface_of();
               a.setVisible(true);
              
                        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JButton exit;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JButton reset;
    private javax.swing.JButton signin;
    private javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables
}
