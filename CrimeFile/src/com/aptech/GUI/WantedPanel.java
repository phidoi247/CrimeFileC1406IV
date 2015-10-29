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
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author c1410l3608
 */
public class WantedPanel extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    public WantedPanel() {
        initComponents();
        showAll();
        
    }

    private void showAll(){
        tblModel = new DefaultTableModel();
        tblModel.addColumn("Crime ID");
        tblModel.addColumn("Crime name");
        tblModel.addColumn("Birth");
        tblModel.addColumn("Home town");
        tblModel.addColumn("Gender");
        tblModel.addColumn("Notify date");
        tblModel.addColumn("Status");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v;
        String str="select dbo.wanted.id_crime,crime_name,birth,hometown,gender,notify_date,status "
                + "from dbo.crime_infomation join dbo.wanted on dbo.crime_infomation.id_crime=dbo.wanted.id_crime";
        try {            
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            while(rs.next()){
                    v = new Vector();
                    for (int i = 1; i < 8; i++) {
                        v.add(rs.getString(i));
                    }tblModel.addRow(v);
                    lblID.setText(rs.getString(1));
                    lblName.setText(rs.getString(2));
                    lblBirth.setText(rs.getString(3));
                    lblTown.setText(rs.getString(4));
                    if("1".equals(rs.getString(5)))
                        rdoMale.setSelected(true);
                    else
                        rdoFemale.setSelected(true);
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    if(rs.getString(6)!=null&&!rs.getString(6).equals(""));
                    Date myDate = df.parse(rs.getString(6));
                    datePick.setDate(myDate);
                    txtStatus.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        }  finally{DBConnection.closeConnection(con, ps, rs, null);}
        jTable1.removeAll();        
        jTable1.setModel(tblModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnFind = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtStatus = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        datePick = new org.jdesktop.swingx.JXDatePicker();
        lblName = new javax.swing.JTextField();
        lblBirth = new javax.swing.JTextField();
        lblTown = new javax.swing.JTextField();
        lblDisplay = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Wanted Manager"));
        setPreferredSize(new java.awt.Dimension(750, 500));

        btnFind.setText("Find by ID");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel6.setText("Name");

        jLabel10.setText("Birth");

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

        jLabel15.setText("Town");

        jLabel4.setText("Notify date");

        jLabel8.setText("Status");

        jLabel9.setText("Crime ID");

        lblID.setForeground(new java.awt.Color(204, 51, 0));
        lblID.setText("get ID");

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");
        rdoMale.setEnabled(false);

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");
        rdoFemale.setEnabled(false);

        datePick.setDate(Calendar.getInstance().getTime());

        lblName.setEditable(false);

        lblBirth.setEditable(false);

        lblTown.setEditable(false);

        lblDisplay.setEditable(false);
        lblDisplay.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(lblID))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rdoMale)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rdoFemale))
                                .addComponent(lblDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(datePick, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFind)
                                .addGap(29, 29, 29)
                                .addComponent(btnAdd)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnFind, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnFind)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(lblID)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4)
                    .addComponent(datePick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8)
                    .addComponent(rdoFemale)
                    .addComponent(lblTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMale))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");
        String str="select dbo.wanted.id_crime,crime_name,birth,hometown,gender,notify_date,status "
                + "from dbo.crime_infomation join dbo.wanted on dbo.crime_infomation.id_crime=dbo.wanted.id_crime where dbo.wanted.id_crime="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("No record found");
            }else{
                lblDisplay.setText("Record found");
                lblID.setText(rs.getString(1));
                lblName.setText(rs.getString(2));
                lblBirth.setText(rs.getString(3));
                lblTown.setText(rs.getString(4));
                if("1".equals(rs.getString(5)))
                    rdoMale.setSelected(true);
                else
                    rdoFemale.setSelected(true);
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(6)!=null&&!rs.getString(6).equals(""));
                Date myDate = df.parse(rs.getString(6));
                datePick.setDate(myDate);
                txtStatus.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        if("0".equals(txtID.getText()))
            txtID.setText("");
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
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
                txtID.setText("");
            }else{
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(new com.aptech.services.WantedServices().addWanted(new com.aptech.model.Wanted(Integer.parseInt(txtID.getText()), df.format(datePick.getDate()), txtStatus.getText()))==1)
                lblDisplay.setText("Insert success");
                else
                lblDisplay.setText("Insert fail");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);            
        } finally{DBConnection.closeConnection(con, ps, rs, null);} 
        showAll();
        if("0".equals(txtID.getText()))
            txtID.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");
        String str = "select * from dbo.wanted where id_crime="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong crime ID");
            }else{
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.WantedServices().updateWanted(new com.aptech.model.Wanted(Integer.parseInt(txtID.getText()), df.format(datePick.getDate()), txtStatus.getText()));
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
        String str = "select * from dbo.wanted where id_crime="+Integer.parseInt(txtID.getText());
        try {            
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong crime ID");
            }else{
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.WantedServices().deleteWanted(new com.aptech.model.Wanted(Integer.parseInt(txtID.getText()), df.format(datePick.getDate()), txtStatus.getText()));
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
    private org.jdesktop.swingx.JXDatePicker datePick;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lblBirth;
    private javax.swing.JTextField lblDisplay;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextField lblName;
    private javax.swing.JTextField lblTown;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
