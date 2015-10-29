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
public class CrimePanel extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    public CrimePanel() {
        initComponents();
        showAll();
    }

    private void showAll(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Crime ID");
        tblModel.addColumn("Crime name");
        tblModel.addColumn("ID Card");
        tblModel.addColumn("Gender");
        tblModel.addColumn("Birth");
        tblModel.addColumn("Hometown");
        tblModel.addColumn("Address");
        tblModel.addColumn("Job");
        tblModel.addColumn("Nationality");
        tblModel.addColumn("Crimetype");
        tblModel.addColumn("Avatar");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v;
        try {
            ps = con.prepareStatement("select * from dbo.crime_infomation");
            rs = ps.executeQuery();
            while(rs.next()){
                v = new Vector();
                for (int i = 1; i < 12; i++) {
                    v.add(rs.getString(i));
                }tblModel.addRow(v);
                lblID.setText(rs.getString(1));
                txtName.setText(rs.getString(2));
                txtCard.setText(rs.getString(3));
                if("1".equals(rs.getString(4)))
                    rdoMale.setSelected(true);
                else
                    rdoFemale.setSelected(true);
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(5)!=null&&!rs.getString(5).equals(""))
                datePick.setDate(df.parse(rs.getString(5)));
                txtTown.setText(rs.getString(6));
                txtAddress.setText(rs.getString(7));
                txtJob.setText(rs.getString(8));
                txtNationality.setText(rs.getString(9));
                txtType.setText(rs.getString(10));
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnBrowse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNationality = new javax.swing.JTextField();
        txtTown = new javax.swing.JTextField();
        txtJob = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        lblID = new javax.swing.JTextField();
        datePick = new org.jdesktop.swingx.JXDatePicker();
        lblDisplay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCard = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Crime Manager"));
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

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(120, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnBrowse.setText("Browse");

        jLabel3.setText("Name");

        jLabel4.setText("Nationality");

        jLabel5.setText("Crime type");

        jLabel6.setText("Gender");

        jLabel7.setText("Birth");

        jLabel8.setText("Town");

        jLabel9.setText("Address");

        jLabel10.setText("Job");

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");

        lblID.setEditable(false);
        lblID.setForeground(new java.awt.Color(255, 0, 0));

        lblDisplay.setEditable(false);
        lblDisplay.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setText("Card ID");

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
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoMale)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoFemale))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(datePick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(txtTown, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtType)
                            .addComponent(txtAddress)
                            .addComponent(txtNationality, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtJob, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete)
                            .addComponent(btnBrowse)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd)
                            .addComponent(btnFind))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnBrowse, btnDelete, btnFind, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFind)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(jLabel4)
                            .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(datePick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBrowse)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");
        String str="select * from dbo.crime_infomation where id_crime="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("No record found");
            }else{
                lblDisplay.setText("Record found");
                lblID.setText(rs.getString(1));
                txtName.setText(rs.getString(2));
                txtCard.setText(rs.getString(3));
                if("1".equals(rs.getString(4)))
                    rdoMale.setSelected(true);
                else
                    rdoFemale.setSelected(true);
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(5)!=null&&!rs.getString(5).equals(""))
                datePick.setDate(df.parse(rs.getString(5)));
                txtTown.setText(rs.getString(6));
                txtAddress.setText(rs.getString(7));
                txtJob.setText(rs.getString(8));
                txtNationality.setText(rs.getString(9));
                txtType.setText(rs.getString(10));
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
        byte gender=(byte)1;
        if(rdoMale.isSelected())
            gender=(byte)1;
        if(rdoFemale.isSelected())
            gender=(byte)0;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if(new com.aptech.services.CrimeInfomationServices().addCrimeInfomation(new com.aptech.model.CrimeInfomation(
            0,txtName.getText(),txtCard.getText(),gender, df.format(datePick.getDate())
            ,txtTown.getText(),txtAddress.getText(),txtJob.getText(),txtNationality.getText()
            ,txtType.getText(),"avatar"))==1)
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
        String str = "select * from dbo.crime_infomation where id_crime="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong crime ID");
            }else{
                byte gender=(byte)1;
        if(rdoMale.isSelected())
            gender=(byte)1;
        if(rdoFemale.isSelected())
            gender=(byte)0;
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.CrimeInfomationServices().updateCrimeInfomation(new com.aptech.model.CrimeInfomation(
            Integer.parseInt(txtID.getText()),txtName.getText(),txtCard.getText(),gender, df.format(datePick.getDate())
            ,txtTown.getText(),txtAddress.getText(),txtJob.getText(),txtNationality.getText()
            ,txtType.getText(),"avatar"));
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
        String str = "select * from dbo.crime_infomation where id_crime="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong crime ID");
            }else{
                byte gender=(byte)1;
        if(rdoMale.isSelected())
            gender=(byte)1;
        if(rdoFemale.isSelected())
            gender=(byte)0;
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.CrimeInfomationServices().deleteCrimeInfomation(new com.aptech.model.CrimeInfomation(
            Integer.parseInt(txtID.getText()),txtName.getText(),txtCard.getText(),gender, df.format(datePick.getDate())
            ,txtTown.getText(),txtAddress.getText(),txtJob.getText(),txtNationality.getText()
            ,txtType.getText(),"avatar"));
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
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datePick;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lblDisplay;
    private javax.swing.JTextField lblID;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCard;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtTown;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
