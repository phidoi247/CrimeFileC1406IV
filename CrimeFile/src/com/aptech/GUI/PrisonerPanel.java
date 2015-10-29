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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author c1410l3608
 */
public class PrisonerPanel extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    public PrisonerPanel() {
        initComponents();
        showAll();
    }

    private void showAll(){
        tblModel = new DefaultTableModel();
        tblModel.addColumn("Crime ID");
        tblModel.addColumn("Crime type");
        tblModel.addColumn("Birth");
        tblModel.addColumn("Jobs");
        tblModel.addColumn("Gender");
        tblModel.addColumn("Jail time");
        tblModel.addColumn("Detention date");
        tblModel.addColumn("Prison address");
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v;
        String str="select dbo.prisoners.id_crime,crime_type,birth,jobs,gender,jail_time,detention_date,prison_address "
                + "from dbo.crime_infomation join dbo.prisoners on dbo.crime_infomation.id_crime=dbo.prisoners.id_crime";
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            while(rs.next()){
                v = new Vector();
                for (int i = 1; i < 9; i++) {
                    v.add(rs.getString(i));
                }tblModel.addRow(v);
                lblID.setText(rs.getString(1));
                lblType.setText(rs.getString(2));
                lblBirth.setText(rs.getString(3));
                lblJob.setText(rs.getString(4));
                if("1".equals(rs.getString(5)))
                    rdoMale.setSelected(true);
                else
                    rdoFemale.setSelected(true);
                txtJail.setText(rs.getString(6));
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(7)!=null&&!rs.getString(7).equals(""));
                datePick.setDate(df.parse(rs.getString(7)));
                txtAddress.setText(rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PrisonerPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        jTable1.removeAll();
        jTable1.setModel(tblModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdoMale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtJail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        rdoFemale = new javax.swing.JRadioButton();
        txtID = new javax.swing.JTextField();
        lblID = new javax.swing.JTextField();
        lblBirth = new javax.swing.JTextField();
        lblJob = new javax.swing.JTextField();
        lblType = new javax.swing.JTextField();
        datePick = new org.jdesktop.swingx.JXDatePicker();
        lblDisplay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Prison Manager"));

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");
        rdoMale.setEnabled(false);

        jLabel7.setText("Type");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Detention date");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel12.setText("Job");

        jLabel4.setText("Jail time");

        btnFind.setText("Find by ID");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel3.setText("Prison address");

        jLabel9.setText("Birth");

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(120, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");
        rdoFemale.setEnabled(false);

        lblID.setEditable(false);
        lblID.setForeground(new java.awt.Color(204, 0, 0));

        lblBirth.setEditable(false);

        lblJob.setEditable(false);

        lblType.setEditable(false);

        datePick.setDate(Calendar.getInstance().getTime());

        lblDisplay.setEditable(false);
        lblDisplay.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setText("Gender");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(lblJob))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoMale)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdoFemale))
                                    .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datePick, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnFind, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnFind)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(lblBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(lblJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(rdoFemale)
                    .addComponent(rdoMale)
                    .addComponent(jLabel3)
                    .addComponent(txtJail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");
        String str="select dbo.prisoners.id_crime,crime_type,birth,jobs,gender,jail_time,detention_date,prison_address "
                + "from dbo.crime_infomation join dbo.prisoners on dbo.crime_infomation.id_crime=dbo.prisoners.id_crime where dbo.prisoners.id_crime="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("No record found");
            }else{
                lblDisplay.setText("Record found");
                lblID.setText(rs.getString(1));
                lblType.setText(rs.getString(2));
                lblBirth.setText(rs.getString(3));
                lblJob.setText(rs.getString(4));
                if("1".equals(rs.getString(5)))
                    rdoMale.setSelected(true);
                else
                    rdoFemale.setSelected(true);
                txtJail.setText(rs.getString(6));
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(rs.getString(7)!=null&&!rs.getString(7).equals(""));
                datePick.setDate(df.parse(rs.getString(7)));
                txtAddress.setText(rs.getString(8));
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
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if(new com.aptech.services.PrisonersServices().addPrisoners(new com.aptech.model.Prisoners(Integer.parseInt(txtID.getText()), df.format(datePick.getDate()),txtAddress.getText(), txtJail.getText()))==1)
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");
        String str = "select * from dbo.prisoners where id_crime="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong crime ID");
            }else{
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.PrisonersServices().deletePrisoners(new com.aptech.model.Prisoners(Integer.parseInt(txtID.getText()), df.format(datePick.getDate()),txtAddress.getText(), txtJail.getText()));
                lblDisplay.setText("Delete success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);} 
        showAll();
        if("0".equals(txtID.getText()))
            txtID.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if("".equals(txtID.getText()))
            txtID.setText("0");
        String str = "select * from dbo.prisoners where id_crime="+Integer.parseInt(txtID.getText());
        try {
            ps = con.prepareStatement(str);
            rs = ps.executeQuery();
            if(!rs.next()){
                lblDisplay.setText("Wrong crime ID");
            }else{
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                new com.aptech.services.PrisonersServices().updatePrisoners(new com.aptech.model.Prisoners(Integer.parseInt(txtID.getText()), df.format(datePick.getDate()),txtAddress.getText(), txtJail.getText()));
                lblDisplay.setText("Update success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WantedPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);} 
        showAll();
        if("0".equals(txtID.getText()))
            txtID.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datePick;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lblBirth;
    private javax.swing.JTextField lblDisplay;
    private javax.swing.JTextField lblID;
    private javax.swing.JTextField lblJob;
    private javax.swing.JTextField lblType;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJail;
    // End of variables declaration//GEN-END:variables
}
