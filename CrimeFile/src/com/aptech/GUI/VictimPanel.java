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
public class VictimPanel extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    public VictimPanel() {
        initComponents();
        showAll();
    }

    private void showAll(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Victim ID");
        tblModel.addColumn("Victim name");
        tblModel.addColumn("ID Card");
        tblModel.addColumn("Gender");
        tblModel.addColumn("Birth");
        tblModel.addColumn("Address");
        tblModel.addColumn("Nationality");
        tblModel.addColumn("IsDead");
        tblModel.addColumn("Autopsy date");
        tblModel.addColumn("Dead reason");
        tblModel.addColumn("Profile ID");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v;
        try {
            ps = con.prepareStatement("select * from dbo.victim");
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
                datePickBirth.setDate(df.parse(rs.getString(5)));
                txtAddress.setText(rs.getString(6));
                txtNationality.setText(rs.getString(7));
                if("1".equals(rs.getString(8)))
                    rdoDead.setSelected(true);
                else
                    rdoAlive.setSelected(true);
                if(rs.getString(9)!=null&&!rs.getString(9).equals(""))
                datePickAutopsy.setDate(df.parse(rs.getString(9)));
                txtReason.setText(rs.getString(10));
                txtProfile.setText(rs.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VictimPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VictimPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        jTable2.removeAll();
        jTable2.setModel(tblModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        rdoAlive = new javax.swing.JRadioButton();
        rdoDead = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        rdoMale = new javax.swing.JRadioButton();
        txtProfile = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtNationality = new javax.swing.JTextField();
        txtReason = new javax.swing.JTextField();
        datePickAutopsy = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCard = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        datePickBirth = new org.jdesktop.swingx.JXDatePicker();
        lblDisplay = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Victim Manager"));
        setPreferredSize(new java.awt.Dimension(750, 500));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel11.setText("Autopsy date");

        buttonGroup2.add(rdoAlive);
        rdoAlive.setSelected(true);
        rdoAlive.setText("Alive");

        buttonGroup2.add(rdoDead);
        rdoDead.setText("Dead");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        jLabel13.setText("Profile ID");

        jLabel16.setText("Victim ID");

        lblID.setForeground(new java.awt.Color(255, 0, 0));
        lblID.setText("get ID");

        jLabel18.setText("Name");

        jLabel19.setText("ID card");

        jLabel20.setText("Address");

        jLabel21.setText("Birth");

        btnFind.setText("Find by ID");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnAdd.setText("Add victim");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update victim");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete victim");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Dead reason");
        jLabel1.setToolTipText("");

        jLabel2.setText("Nationality");

        lblDisplay.setEditable(false);
        lblDisplay.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datePickBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtCard)
                            .addComponent(txtName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(rdoMale)
                            .addComponent(rdoAlive))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdoDead)
                                    .addComponent(rdoFemale))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel11))
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblID)
                                .addGap(28, 28, 28)
                                .addComponent(lblDisplay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datePickAutopsy, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtReason, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtNationality, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFind, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnFind, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblID)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(btnFind)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel19)
                    .addComponent(btnAdd)
                    .addComponent(datePickAutopsy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoFemale)
                    .addComponent(rdoMale)
                    .addComponent(jLabel20)
                    .addComponent(btnUpdate)
                    .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAlive)
                    .addComponent(rdoDead)
                    .addComponent(jLabel21)
                    .addComponent(btnDelete)
                    .addComponent(txtReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(datePickBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");
        String str="select * from dbo.victim where dbo.victim.id_victim="+Integer.parseInt(txtID.getText());
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
                datePickBirth.setDate(df.parse(rs.getString(5)));
                txtAddress.setText(rs.getString(6));
                txtNationality.setText(rs.getString(7));
                if("1".equals(rs.getString(8)))
                    rdoDead.setSelected(true);
                else
                    rdoAlive.setSelected(true);
                if(rs.getString(9)!=null&&!rs.getString(9).equals(""))
                datePickAutopsy.setDate(df.parse(rs.getString(9)));
                txtReason.setText(rs.getString(10));
                txtProfile.setText(rs.getString(11));
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
        byte gender=(byte)1;byte isDead=(byte)1;
        if(rdoMale.isSelected())
            gender=(byte)1;
        if(rdoFemale.isSelected())
            gender=(byte)0;
        if(rdoDead.isSelected())
            isDead=(byte)1;
        if(rdoAlive.isSelected())
            isDead=(byte)0;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if(new com.aptech.services.VictimServices().addVictim(new com.aptech.model.Victim(
            0,txtName.getText(),txtCard.getText(),gender, df.format(datePickBirth.getDate())
            ,txtAddress.getText(),txtNationality.getText(),isDead,df.format(datePickBirth.getDate())
            ,txtReason.getText(), Integer.parseInt(txtProfile.getText())))==1)
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
        String str = "select * from dbo.victim where id_victim="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong crime ID");
            }else{
                byte gender=(byte)1;byte isDead=(byte)1;
        if(rdoMale.isSelected())
            gender=(byte)1;
        if(rdoFemale.isSelected())
            gender=(byte)0;
        if(rdoDead.isSelected())
            isDead=(byte)1;
        if(rdoAlive.isSelected())
            isDead=(byte)0;
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.VictimServices().updateVictim(new com.aptech.model.Victim(
            Integer.parseInt(txtID.getText()),txtName.getText(),txtCard.getText(),gender, df.format(datePickBirth.getDate())
            ,txtAddress.getText(),txtNationality.getText(),isDead,df.format(datePickBirth.getDate())
            ,txtReason.getText(), Integer.parseInt(txtProfile.getText())));
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
        String str = "select * from dbo.victim where id_victim="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong crime ID");
            }else{
                byte gender=(byte)1;byte isDead=(byte)1;
        if(rdoMale.isSelected())
            gender=(byte)1;
        if(rdoFemale.isSelected())
            gender=(byte)0;
        if(rdoDead.isSelected())
            isDead=(byte)1;
        if(rdoAlive.isSelected())
            isDead=(byte)0;
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.VictimServices().deleteVictim(new com.aptech.model.Victim(
            Integer.parseInt(txtID.getText()),txtName.getText(),txtCard.getText(),gender, df.format(datePickBirth.getDate())
            ,txtAddress.getText(),txtNationality.getText(),isDead,df.format(datePickBirth.getDate())
            ,txtReason.getText(), Integer.parseInt(txtProfile.getText())));
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private org.jdesktop.swingx.JXDatePicker datePickAutopsy;
    private org.jdesktop.swingx.JXDatePicker datePickBirth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lblDisplay;
    private javax.swing.JLabel lblID;
    private javax.swing.JRadioButton rdoAlive;
    private javax.swing.JRadioButton rdoDead;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCard;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtProfile;
    private javax.swing.JTextField txtReason;
    // End of variables declaration//GEN-END:variables
}
