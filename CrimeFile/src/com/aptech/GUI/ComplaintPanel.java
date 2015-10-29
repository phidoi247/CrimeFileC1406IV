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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huy
 */
public class ComplaintPanel extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    public ComplaintPanel() {
        initComponents();
        showAll();
    }

    private void showAll(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Profile ID");
        tblModel.addColumn("Profile status");
        tblModel.addColumn("Crime ID");
        tblModel.addColumn("Crime name");
        tblModel.addColumn("Victim ID");
        tblModel.addColumn("Victim name");
        tblModel.addColumn("Testimony");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v;
        try {
            ps = con.prepareStatement("select c.id_profile,p.status,c.id_crime,r.crime_name,c.id_victim,v.victim_name"
                    + ",c.testimony from dbo.complaint as c join dbo.case_profile as p on c.id_profile=p.id_profile"
                    + " join dbo.crime_infomation as r on c.id_crime=r.id_crime"
                    + " join dbo.victim as v on c.id_victim=v.id_victim");
            rs = ps.executeQuery();
            while(rs.next()){
                v = new Vector();
                for (int i = 1; i < 8; i++) {
                    v.add(rs.getString(i));
                }tblModel.addRow(v);
                txtProfile.setText(rs.getString(1));
                lblProfile.setText(rs.getString(2));
                txtCrime.setText(rs.getString(3));
                lblCrime.setText(rs.getString(4));
                txtVictim.setText(rs.getString(5));
                lblVictim.setText(rs.getString(6));
                txtArea.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        jTable2.removeAll();
        jTable2.setModel(tblModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        txtVictim = new javax.swing.JTextField();
        txtCrime = new javax.swing.JTextField();
        txtProfile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblProfile = new javax.swing.JTextField();
        lblCrime = new javax.swing.JTextField();
        lblVictim = new javax.swing.JTextField();
        lblDisplay = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Complaint Manager"));

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

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnFind.setText("Find by ID");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setLineWrap(true);
        txtArea.setRows(5);
        txtArea.setToolTipText("");
        jScrollPane1.setViewportView(txtArea);

        jLabel2.setText("Profile ID");

        jLabel3.setText("Crime ID");

        jLabel4.setText("Victim ID");

        jLabel5.setText("Profile status");

        jLabel6.setText("Crime name");

        jLabel7.setText("Victim name");

        lblProfile.setEditable(false);

        lblCrime.setEditable(false);

        lblVictim.setEditable(false);

        lblDisplay.setEditable(false);
        lblDisplay.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCrime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVictim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCrime, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVictim, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnFind, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnFind)
                    .addComponent(txtProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCrime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(lblCrime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVictim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(lblVictim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if("".equals(txtProfile.getText()))
            txtProfile.setText("0");
        if("".equals(txtCrime.getText()))
            txtCrime.setText("0");
        if("".equals(txtVictim.getText()))
            txtVictim.setText("0");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select c.id_profile,p.status,c.id_crime,r.crime_name,c.id_victim,v.victim_name"
                    + ",c.testimony from dbo.complaint as c join dbo.case_profile as p on c.id_profile=p.id_profile"
                    + " join dbo.crime_infomation as r on c.id_crime=r.id_crime"
                    + " join dbo.victim as v on c.id_victim=v.id_victim where p.id_profile="+Integer.parseInt(txtProfile.getText())+
                    " and r.id_crime="+Integer.parseInt(txtCrime.getText())+" and v.id_victim="+Integer.parseInt(txtVictim.getText()));
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("No record found");
            }else{
                lblDisplay.setText("Record found");
                txtProfile.setText(rs.getString(1));
                lblProfile.setText(rs.getString(2));
                txtCrime.setText(rs.getString(3));
                lblCrime.setText(rs.getString(4));
                txtVictim.setText(rs.getString(5));
                lblVictim.setText(rs.getString(6));
                txtArea.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        if("0".equals(txtProfile.getText()))
            txtProfile.setText("");
        if("0".equals(txtCrime.getText()))
            txtCrime.setText("");
        if("0".equals(txtVictim.getText()))
            txtVictim.setText("");
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if("".equals(txtProfile.getText()))
            txtProfile.setText("0");
        if("".equals(txtCrime.getText()))
            txtCrime.setText("0");
        if("".equals(txtVictim.getText()))
            txtVictim.setText("0");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps1 = null,ps2 = null,ps3 = null;
        ResultSet rs1 = null,rs2 = null,rs3 = null;
        String str1="select * from dbo.case_profile where id_profile="+Integer.parseInt(txtProfile.getText());
        String str2="select * from dbo.crime_infomation where id_crime="+Integer.parseInt(txtCrime.getText());
        String str3="select * from dbo.victim where id_victim="+Integer.parseInt(txtVictim.getText());
        try {
            ps1 = con.prepareStatement(str1);
            ps2 = con.prepareStatement(str2);
            ps3 = con.prepareStatement(str3);
            rs1 = ps1.executeQuery();
            rs2 = ps2.executeQuery();
            rs3 = ps3.executeQuery();
            if(rs1.next()&&rs2.next()&&rs3.next()){
                if(new com.aptech.services.ComplaintServices().addComplaint(new com.aptech.model.Complaint(
                        Integer.parseInt(txtProfile.getText()), Integer.parseInt(txtCrime.getText()),
                        Integer.parseInt(txtVictim.getText()), txtArea.getText()))==1)
                lblDisplay.setText("Insert success");
                else
                lblDisplay.setText("Insert fail");                
            }else{
                lblDisplay.setText("Wrong ID sets");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBConnection.closeConnection(con, ps1, rs1, null);
            DBConnection.closeConnection(con, ps2, rs2, null);
            DBConnection.closeConnection(con, ps3, rs3, null);
        } 
        showAll();
        if("0".equals(txtProfile.getText()))
            txtProfile.setText("");
        if("0".equals(txtCrime.getText()))
            txtCrime.setText("");
        if("0".equals(txtVictim.getText()))
            txtVictim.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if("".equals(txtProfile.getText()))
            txtProfile.setText("0");
        if("".equals(txtCrime.getText()))
            txtCrime.setText("0");
        if("".equals(txtVictim.getText()))
            txtVictim.setText("0");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select c.id_profile,p.status,c.id_crime,r.crime_name,c.id_victim,v.victim_name"
                    + ",c.testimony from dbo.complaint as c join dbo.case_profile as p on c.id_profile=p.id_profile"
                    + " join dbo.crime_infomation as r on c.id_crime=r.id_crime"
                    + " join dbo.victim as v on c.id_victim=v.id_victim where p.id_profile="+Integer.parseInt(txtProfile.getText())+
                    " and r.id_crime="+Integer.parseInt(txtCrime.getText())+" and v.id_victim="+Integer.parseInt(txtVictim.getText()));
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong ID sets");
            }else{
                new com.aptech.services.ComplaintServices().updateComplaint(new com.aptech.model.Complaint(
                        Integer.parseInt(txtProfile.getText()), Integer.parseInt(txtCrime.getText()),
                        Integer.parseInt(txtVictim.getText()), txtArea.getText()));
                lblDisplay.setText("Update success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        showAll();
        if("0".equals(txtProfile.getText()))
            txtProfile.setText("");
        if("0".equals(txtCrime.getText()))
            txtCrime.setText("");
        if("0".equals(txtVictim.getText()))
            txtVictim.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if("".equals(txtProfile.getText()))
            txtProfile.setText("0");
        if("".equals(txtCrime.getText()))
            txtCrime.setText("0");
        if("".equals(txtVictim.getText()))
            txtVictim.setText("0");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select c.id_profile,p.status,c.id_crime,r.crime_name,c.id_victim,v.victim_name"
                    + ",c.testimony from dbo.complaint as c join dbo.case_profile as p on c.id_profile=p.id_profile"
                    + " join dbo.crime_infomation as r on c.id_crime=r.id_crime"
                    + " join dbo.victim as v on c.id_victim=v.id_victim where p.id_profile="+Integer.parseInt(txtProfile.getText())+
                    " and r.id_crime="+Integer.parseInt(txtCrime.getText())+" and v.id_victim="+Integer.parseInt(txtVictim.getText()));
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong ID sets");
            }else{
                new com.aptech.services.ComplaintServices().deleteComplaint(new com.aptech.model.Complaint(
                        Integer.parseInt(txtProfile.getText()), Integer.parseInt(txtCrime.getText()),
                        Integer.parseInt(txtVictim.getText()), txtArea.getText()));
                lblDisplay.setText("Delete success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        showAll();
        if("0".equals(txtProfile.getText()))
            txtProfile.setText("");
        if("0".equals(txtCrime.getText()))
            txtCrime.setText("");
        if("0".equals(txtVictim.getText()))
            txtVictim.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lblCrime;
    private javax.swing.JTextField lblDisplay;
    private javax.swing.JTextField lblProfile;
    private javax.swing.JTextField lblVictim;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtCrime;
    private javax.swing.JTextField txtProfile;
    private javax.swing.JTextField txtVictim;
    // End of variables declaration//GEN-END:variables
}
