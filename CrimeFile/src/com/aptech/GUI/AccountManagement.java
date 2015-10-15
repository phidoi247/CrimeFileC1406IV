/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.GUI;

import com.aptech.model.Account;
import com.aptech.services.AccountServices;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MyPC
 */
public class AccountManagement extends javax.swing.JPanel {

    DefaultTableModel dtm = null;
    Vector<String> colName = null;
    Vector<Vector> rowData = null;
    ArrayList<Account> allAccounts = null;

    /**
     * Creates new form AccountManagement
     */
    public AccountManagement() {
        initComponents();
        colName = new Vector<>();
        rowData = new Vector<Vector>();
        allAccounts = AccountServices.getAllAccounts();
        setColName();
        setRowData();
        dtm = new DefaultTableModel(rowData, colName);
        tblDisplay.setModel(dtm);
    }

    public void setColName(){
        colName.add("username");
        colName.add("full_name");
        colName.add("email");
        colName.add("permission");
        colName.add("gender");
        colName.add("birth");
        colName.add("address");
        colName.add("phone_number");
        colName.add("workplace");
        colName.add("avartar");
    }
    
    public void setRowData(){
        for (Account obj : allAccounts) {
            Vector temp = new Vector();
            temp.addElement(obj.getUsername());
            temp.addElement(obj.getFull_name());
            temp.addElement(obj.getEmail());
            temp.addElement(obj.getPermission());
            temp.addElement(obj.getGender());
            temp.addElement(obj.getBirth());
            temp.addElement(obj.getAddress());
            temp.addElement(obj.getPhone_number());
            temp.addElement(obj.getWorkplace());
            temp.addElement(obj.getAvatar());
            rowData.add(temp);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisplay = new javax.swing.JTable();
        jbChangeInfomation = new javax.swing.JButton();
        jbAddAccount = new javax.swing.JButton();
        jbDeleteAccount = new javax.swing.JButton();
        jbDeleteAccount1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 485));

        tblDisplay.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDisplay);

        jbChangeInfomation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user1_refresh.png"))); // NOI18N
        jbChangeInfomation.setText("Change info");
        jbChangeInfomation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbChangeInfomationActionPerformed(evt);
            }
        });

        jbAddAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user1_add.png"))); // NOI18N
        jbAddAccount.setText("Add account");

        jbDeleteAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user1_delete.png"))); // NOI18N
        jbDeleteAccount.setText("Delete account");

        jbDeleteAccount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user1_view.png"))); // NOI18N
        jbDeleteAccount1.setText("Find account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAddAccount)
                .addGap(36, 36, 36)
                .addComponent(jbChangeInfomation)
                .addGap(28, 28, 28)
                .addComponent(jbDeleteAccount)
                .addGap(28, 28, 28)
                .addComponent(jbDeleteAccount1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDeleteAccount)
                    .addComponent(jbAddAccount)
                    .addComponent(jbChangeInfomation)
                    .addComponent(jbDeleteAccount1))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("All accounts", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbChangeInfomationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbChangeInfomationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbChangeInfomationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbAddAccount;
    private javax.swing.JButton jbChangeInfomation;
    private javax.swing.JButton jbDeleteAccount;
    private javax.swing.JButton jbDeleteAccount1;
    private javax.swing.JTable tblDisplay;
    // End of variables declaration//GEN-END:variables
}