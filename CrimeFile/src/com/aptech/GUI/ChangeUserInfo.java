/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.GUI;

import com.aptech.Session;
import com.aptech.model.Account;
import com.aptech.services.AccountServices;
import com.aptech.utilities.Validator;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author MyPC
 */
public class ChangeUserInfo extends javax.swing.JDialog {
    
    Account currentAccount = null;

    /**
     * Creates new form ChangeUserInfo
     */
    public ChangeUserInfo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            this.setIconImage(ImageIO.read(new File("images/favicon.png")));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        currentAccount = AccountServices.findByUsername(Session.userName);
        setUserInfomationForm(currentAccount);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBirth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jbUpdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtWorkPlace = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtRepassword = new javax.swing.JPasswordField();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Full name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, -1));
        getContentPane().add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 260, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 260, -1));

        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, -1));

        jLabel4.setText("Gender:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, -1));
        getContentPane().add(txtBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 260, -1));

        jLabel5.setText("Birth:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 60, -1));
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 260, -1));

        jLabel6.setText("Address:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 60, -1));
        getContentPane().add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 260, -1));

        jLabel7.setText("Phone number:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, -1));

        jbUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user1_refresh.png"))); // NOI18N
        jbUpdate.setText("Change");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jbUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        jLabel8.setText("Work place:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, -1));
        getContentPane().add(txtWorkPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 260, -1));

        buttonGroup1.add(rdoMale);
        rdoMale.setText("Male");
        getContentPane().add(rdoMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");
        getContentPane().add(rdoFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel9.setText("Password: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 80, -1));

        jLabel10.setText("RePassword: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 80, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 130, -1));
        getContentPane().add(txtRepassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 130, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        String error = "Error: ";
        if (Validator.isNotNull(txtFullName.getText())) {
            currentAccount.setFull_name(txtFullName.getText());
        } else {
            error += "\n- Full name should not be empty!";
        }
        
        if (Validator.isNotNull(txtEmail.getText())) {
            currentAccount.setEmail(txtEmail.getText());
        } else {
            error += "\n- Email should not be empty!";
        }
        
        if (Validator.isNotNull(txtBirth.getText())) {
            currentAccount.setBirth(txtBirth.getText());
        } else {
            error += "\n- Birth should not be empty!";
        }
        
        if (Validator.isNotNull(txtAddress.getText())) {
            currentAccount.setAddress(txtAddress.getText());
        } else {
            error += "\n- Address should not be empty!";
        }
        
        if (Validator.isNotNull(txtPhoneNumber.getText())) {
            currentAccount.setPhone_number(txtPhoneNumber.getText());
        } else {
            error += "\n- Phone number should not be empty!";
        }
        
        if (Validator.isNotNull(txtWorkPlace.getText())) {
            currentAccount.setWorkplace(txtWorkPlace.getText());
        } else {
            error += "\n- Workplace should not be empty!";
        }
        
        if (Validator.isNotNull(String.valueOf(txtPassword.getPassword())) || Validator.isNotNull(String.valueOf(txtRepassword.getPassword()))) {
            if (Validator.equals(String.valueOf(txtPassword.getPassword()), String.valueOf(txtRepassword.getPassword()))) {
                currentAccount.setPassword(String.valueOf(txtPassword.getPassword()));
            } else {
                error += "\n- Password and RePassword shold be equals!";
            }
        } else {
            error += "\n- Password shold not be empty!";
        }
        
        if (rdoMale.isSelected()) {
            currentAccount.setGender((byte) 1);
        } else if (rdoFemale.isSelected()) {
            currentAccount.setGender((byte) 0);
        }
        currentAccount.setUsername(Session.userName);
        
        if (error.equals("Error: ")) {
            int updateAccount = AccountServices.updateAccount(currentAccount);
            if (updateAccount > 0) {
                JOptionPane.showMessageDialog(null, "Update Success!");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Update fail!");
            }
        }

    }//GEN-LAST:event_jbUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(ChangeUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangeUserInfo dialog = new ChangeUserInfo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void setUserInfomationForm(Account currentAccount) {
        this.txtAddress.setText(currentAccount.getAddress());
        this.txtBirth.setText(currentAccount.getBirth());
        this.txtEmail.setText(currentAccount.getEmail());
        this.txtFullName.setText(currentAccount.getFull_name());
        this.txtPhoneNumber.setText(currentAccount.getPhone_number());
        this.txtWorkPlace.setText(currentAccount.getWorkplace());
        if (currentAccount.getGender() == (byte) 1) {
            rdoMale.setSelected(true);
        } else if (currentAccount.getGender() == (byte) 0) {
            rdoFemale.setSelected(true);
        }
        this.txtPassword.setText(currentAccount.getPassword());
        this.txtRepassword.setText(currentAccount.getPassword());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JPasswordField txtRepassword;
    private javax.swing.JTextField txtWorkPlace;
    // End of variables declaration//GEN-END:variables
}
