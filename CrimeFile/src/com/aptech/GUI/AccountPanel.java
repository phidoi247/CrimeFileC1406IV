/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.GUI;

import com.aptech.utilities.DBConnection;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author c1410l3608
 */
public class AccountPanel extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    public AccountPanel() {
        initComponents();showAll();
        
    }

    private void showAll(){
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Username");
        tableModel.addColumn("Password");
        tableModel.addColumn("Email");
        tableModel.addColumn("Permission");
        tableModel.addColumn("Fullname");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Birth");
        tableModel.addColumn("Address");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Workplace");
        tableModel.addColumn("Avatar");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v;
        
        try {
            ps = con.prepareStatement("select * from dbo.account");
            rs = ps.executeQuery();
            while(rs.next()){
                v = new Vector();
                for(int i=1;i<12;i++){
                    v.add(rs.getString(i));
                }tableModel.addRow(v);
                txtUsername.setText(rs.getString(1));
                txtPassword.setText(rs.getString(2));
                txtEmail.setText(rs.getString(3));
                if("1".equals(rs.getString(4)))
                    cboPermission.setSelectedIndex(1);
                else
                    cboPermission.setSelectedIndex(0);
                txtFullname.setText(rs.getString(5));
                if("1".equals(rs.getString(6)))
                    rdoMale.setSelected(true);
                else
                    rdoFemale.setSelected(true);
                
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(7)!=null&&!rs.getString(7).equals(""))
                datePick.setDate(df.parse(rs.getString(7)));  
                txtAddress.setText(rs.getString(8));
                txtPhone.setText(rs.getString(9));
                txtWorkplace.setText(rs.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
        }accTable.removeAll();
        accTable.setModel(tableModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtUsername = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnBrowse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        rdoFemale = new javax.swing.JRadioButton();
        rdoMale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        txtWorkplace = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboPermission = new javax.swing.JComboBox();
        datePick = new org.jdesktop.swingx.JXDatePicker();
        txtEmail = new javax.swing.JTextField();
        lblDisplay = new javax.swing.JTextField();
        lblAvatar = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Account Manager"));
        setPreferredSize(new java.awt.Dimension(750, 500));

        btnFind.setText("Find username");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnBrowse.setText("Browse avatar");

        jLabel3.setText("Fullname");

        jLabel8.setText("Work place");

        btnUpdate.setText("Update account");
        btnUpdate.setPreferredSize(new java.awt.Dimension(120, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        jLabel7.setText("Address");

        accTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(accTable);

        jLabel2.setText("Email");

        jLabel10.setText("Phone");

        btnAdd.setText("Add account");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete account");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel11.setText("Username");

        jLabel6.setText("Birth");

        jLabel4.setText("Password");

        cboPermission.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User", "Admin" }));

        lblDisplay.setEditable(false);
        lblDisplay.setForeground(new java.awt.Color(255, 0, 0));

        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(rdoMale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(datePick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdoFemale)
                                .addGap(18, 18, 18)
                                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtWorkplace, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnFind)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete)
                            .addComponent(btnBrowse))
                        .addGap(18, 18, 18)
                        .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnBrowse, btnDelete, btnFind, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFind)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(jLabel3)
                            .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtWorkplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(jLabel6)
                            .addComponent(datePick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBrowse)
                            .addComponent(cboPermission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale)))
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtUsername.getText()))
            txtUsername.setText("0");
        try {
            ps = con.prepareStatement("select * from dbo.account where username='"+txtUsername.getText()+"'");
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Not found");
            }else{
                lblDisplay.setText("Found username");
                txtPassword.setText(rs.getString(2));
                txtEmail.setText(rs.getString(3));
                if("1".equals(rs.getString(4)))
                    cboPermission.setSelectedIndex(1);
                else
                    cboPermission.setSelectedIndex(0);
                txtFullname.setText(rs.getString(5));
                if("1".equals(rs.getString(6)))
                    rdoMale.setSelected(true);
                else
                    rdoFemale.setSelected(true);                
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(7)!=null&&!rs.getString(7).equals(""))
                datePick.setDate(df.parse(rs.getString(7)));  
                txtAddress.setText(rs.getString(8));
                txtPhone.setText(rs.getString(9));
                txtWorkplace.setText(rs.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        if("0".equals(txtUsername.getText()))
            txtUsername.setText("");
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if("".equals(txtUsername.getText())||"".equals(txtPassword.getText()))
            lblDisplay.setText("Add fail");
        else{
            int permission=2;byte gender = (byte)1;
            if(cboPermission.getSelectedIndex()==1)
                permission=1;
            if(rdoFemale.isSelected())
                gender = (byte)0;
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            if(new com.aptech.services.AccountServices().addAccount(new com.aptech.model.Account(
                txtUsername.getText(),txtPassword.getText(),txtEmail.getText(),permission,txtFullname.getText(),gender,
                df.format(datePick.getDate()),txtAddress.getText(),txtPhone.getText(),txtWorkplace.getText(),"avatar"))==1)
                lblDisplay.setText("Insert success");
            else
                lblDisplay.setText("Insert fail");
            showAll();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if("".equals(txtUsername.getText())||"".equals(txtPassword.getText()))
            lblDisplay.setText("Update fail");
        else{
            Connection con = DBConnection.openConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = con.prepareStatement("select * from dbo.account where username='"+txtUsername.getText()+"'");
                rs = ps.executeQuery();
                if(!rs.next()){
                    lblDisplay.setText("Wrong username");
                }else{
                    int permission=2;byte gender = (byte)1;
                    if(cboPermission.getSelectedIndex()==1)
                        permission=1;
                    if(rdoFemale.isSelected())
                        gender = (byte)0;
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    new com.aptech.services.AccountServices().updateAccount(new com.aptech.model.Account(
                        txtUsername.getText(),txtPassword.getText(),txtEmail.getText(),permission,txtFullname.getText(),gender,
                        df.format(datePick.getDate()),txtAddress.getText(),txtPhone.getText(),txtWorkplace.getText(),"avatar"));
                    lblDisplay.setText("Update success");                    
                }
            } catch (SQLException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
            } finally{DBConnection.closeConnection(con, ps, rs, null);}
            showAll();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if("".equals(txtUsername.getText()))
            lblDisplay.setText("Username empty");
        else{
            Connection con = DBConnection.openConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = con.prepareStatement("select * from dbo.account where username='"+txtUsername.getText()+"'");
                rs = ps.executeQuery();
                if(!rs.next()){
                    lblDisplay.setText("Wrong username");
                }else{
                    int permission=2;byte gender = (byte)1;
                    if(cboPermission.getSelectedIndex()==0)
                        permission=1;
                    if(rdoFemale.isSelected())
                        gender = (byte)0;
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    new com.aptech.services.AccountServices().deleteAccount(new com.aptech.model.Account(
                        txtUsername.getText(),txtPassword.getText(),txtEmail.getText(),permission,txtFullname.getText(),gender,
                        df.format(datePick.getDate()),txtAddress.getText(),txtPhone.getText(),txtWorkplace.getText(),"avatar"));
                    lblDisplay.setText("Delete success");                    
                }
            } catch (SQLException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
            } finally{DBConnection.closeConnection(con, ps, rs, null);}
            showAll();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboPermission;
    private org.jdesktop.swingx.JXDatePicker datePick;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JTextField lblDisplay;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtWorkplace;
    // End of variables declaration//GEN-END:variables
}
