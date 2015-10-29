/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.GUI;

import com.aptech.utilities.DBConnection;
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
public class CasePanel extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    public CasePanel() {
        initComponents();
        showAll();
    }

    private void showAll(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Profile ID");
        tblModel.addColumn("Admission date");
        tblModel.addColumn("Crime scene");
        tblModel.addColumn("Exhibit");
        tblModel.addColumn("Accusation");
        tblModel.addColumn("Conclude");
        tblModel.addColumn("Status");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v;
        try {
            ps = con.prepareStatement("select * from dbo.case_profile");
            rs = ps.executeQuery();while(rs.next()){
                v = new Vector();
                for (int i = 1; i < 8; i++) {
                    v.add(rs.getString(i));
                }tblModel.addRow(v);
                lblID.setText(rs.getString(1));
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(2)!=null&&!rs.getString(2).equals(""))
                datePick.setDate(df.parse(rs.getString(2)));  
                txtArea.setText(rs.getString(3));
                txtExhibit.setText(rs.getString(4));
                txtAccusasion.setText(rs.getString(5));
                txtConclude.setText(rs.getString(6));
                txtStatus.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrimePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CrimePanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        jTable1.removeAll();
        jTable1.setModel(tblModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtConclude = new javax.swing.JTextField();
        datePick = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        txtStatus = new javax.swing.JTextField();
        txtExhibit = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAccusasion = new javax.swing.JTextField();
        lblID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblDisplay = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Case Manager"));
        setPreferredSize(new java.awt.Dimension(750, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel17.setText("Accusasion");

        btnDelete.setText("Delete case");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update case");
        btnUpdate.setToolTipText("");
        btnUpdate.setPreferredSize(new java.awt.Dimension(120, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnFind.setText("Find by ID");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnAdd.setText("Add case");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel15.setText("Admission date");

        jLabel7.setText("Conclude");

        txtArea.setColumns(20);
        txtArea.setLineWrap(true);
        txtArea.setRows(5);
        jScrollPane3.setViewportView(txtArea);

        jLabel16.setText("Exhibit");

        jLabel1.setText("Crime scene");

        jLabel11.setText("Status");

        lblID.setEditable(false);
        lblID.setForeground(new java.awt.Color(255, 0, 0));

        jLabel2.setText("Profile ID");

        lblDisplay.setEditable(false);
        lblDisplay.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(txtAccusasion)
                            .addComponent(datePick, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtStatus)
                            .addComponent(txtExhibit)
                            .addComponent(txtConclude))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnFind)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnFind, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFind)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel1)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(jLabel7)
                            .addComponent(datePick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConclude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExhibit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(jLabel11)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAccusasion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");
        try {
            ps = con.prepareStatement("select * from dbo.case_profile where id_profile="+Integer.parseInt(txtID.getText()));
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("No record found");
            }else{
                lblDisplay.setText("Record found");
                lblID.setText(rs.getString(1));
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(2)!=null&&!rs.getString(2).equals(""))
                datePick.setDate(df.parse(rs.getString(2)));  
                txtArea.setText(rs.getString(3));
                txtExhibit.setText(rs.getString(4));
                txtAccusasion.setText(rs.getString(5));
                txtConclude.setText(rs.getString(6));
                txtStatus.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrisonerPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PrisonerPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        if("0".equals(txtID.getText()))
            txtID.setText("");
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if(new com.aptech.services.CaseProfileServices().addCaseProfile(new com.aptech.model.CaseProfile(
            0,df.format(datePick.getDate()),txtArea.getText(),txtExhibit.getText(),txtAccusasion.getText()
            ,txtConclude.getText(),txtStatus.getText()))==1)
        lblDisplay.setText("Insert success");
        else
        lblDisplay.setText("Insert fail");
        showAll();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");        
        try {
            ps = con.prepareStatement("select * from dbo.case_profile where id_profile="+Integer.parseInt(txtID.getText()));
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong profile ID");
            }else{
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.CaseProfileServices().updateCaseProfile(new com.aptech.model.CaseProfile(
                    Integer.parseInt(txtID.getText()),df.format(datePick.getDate()),txtArea.getText(),txtExhibit.getText(),txtAccusasion.getText()
                    ,txtConclude.getText(),txtStatus.getText()));
                lblDisplay.setText("Update success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);} 
        showAll();
        if("0".equals(txtID.getText()))
            txtID.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");        
        try {
            ps = con.prepareStatement("select * from dbo.case_profile where id_profile="+Integer.parseInt(txtID.getText()));
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong profile ID");
            }else{
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.CaseProfileServices().deleteCaseprofile(new com.aptech.model.CaseProfile(
                    Integer.parseInt(txtID.getText()),df.format(datePick.getDate()),txtArea.getText(),txtExhibit.getText(),txtAccusasion.getText()
                    ,txtConclude.getText(),txtStatus.getText()));
                lblDisplay.setText("Delete success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);} 
        showAll();
        if("0".equals(txtID.getText()))
            txtID.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private org.jdesktop.swingx.JXDatePicker datePick;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lblDisplay;
    private javax.swing.JTextField lblID;
    private javax.swing.JTextField txtAccusasion;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtConclude;
    private javax.swing.JTextField txtExhibit;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
