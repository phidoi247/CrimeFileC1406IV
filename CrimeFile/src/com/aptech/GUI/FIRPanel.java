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
 * @author Huy
 */
public class FIRPanel extends javax.swing.JPanel {

    DefaultTableModel tblModel;    
    public FIRPanel() {
        initComponents();
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;ResultSet rs = null;
        int total=0,now=0;
        try {
            ps = con.prepareStatement("select permission from dbo.account");
            rs = ps.executeQuery();
            while(rs.next()){                
                total+=1;
                if(rs.getString(1)!=null&&!rs.getString(1).equals("")){
                    if(Integer.parseInt(rs.getString(1))==2)
                        now+=1;
                }                
            }
            lblTotal.setText(""+total);
            lblAdmin.setText(""+(total-now));
            lblUser.setText(""+now);
        } catch (SQLException ex) {
            Logger.getLogger(FIRPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);};
        lblDate.setText(Calendar.getInstance().getTime().toString());
        int year = Calendar.getInstance().get(Calendar.YEAR);
        tblModel = new DefaultTableModel();
        tblModel.addColumn("");
        tblModel.addColumn("Total");
        tblModel.addColumn("PAST - 31/12/"+(year-1));
        tblModel.addColumn("01/01/"+year+" - THEN");
        display("select day_admission from dbo.case_profile","Case profile");        
        display("select detention_date from dbo.prisoners","Prisoners");
        display("select autopsy_date from dbo.victim","Victims");
        display("select notify_date from dbo.wanted","Wanted");
        tblDisplay.setModel(tblModel);
        
        tblModel = new DefaultTableModel();
        tblModel.addColumn("Age");
        tblModel.addColumn("Under 16");
        tblModel.addColumn("16 - 30");
        tblModel.addColumn("Over 30");
        tblShow("select birth from dbo.account","Officials");
        tblShow("select birth from dbo.crime_infomation","Criminals");
        tblShow("select birth from dbo.victim","Victims");
        tblShow.setModel(tblModel);
    }
    
    private void tblShow(String str,String title){
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;ResultSet rs = null;
        int under=0,medium=0,old=0;int year = Calendar.getInstance().get(Calendar.YEAR);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date; // your date
        
        try {
            ps = con.prepareStatement(str);rs = ps .executeQuery();
            while(rs.next()){               
                if(rs.getString(1)!=null&&!rs.getString(1).equals("")){
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(df.parse(rs.getString(1)));
                    int y = cal.get(Calendar.YEAR);
                    int age=year-y;
                    if(age<16)
                        under+=1;
                    if(age>=16&&age<=30)
                        medium+=1;
                    if(age>30)
                        old+=1;
                }                
            }                
        } catch (SQLException ex) {
            Logger.getLogger(FIRPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FIRPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        Vector v = new Vector();
        v.add(title);v.add(""+under);v.add(""+medium);v.add(""+old);
        tblModel.addRow(v);
    }

    private void display(String str,String title){
        Connection con = DBConnection.openConnection();
        PreparedStatement ps = null;ResultSet rs = null;
        int total=0,now=0;int year = Calendar.getInstance().get(Calendar.YEAR);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            ps = con.prepareStatement(str);rs = ps .executeQuery();
            while(rs.next()){                
                total+=1;
                if(rs.getString(1)!=null&&!rs.getString(1).equals("")){
                    if(df.parse(rs.getString(1)).getYear()>=year)
                        now+=1;
                }                
            }                
        } catch (SQLException ex) {
            Logger.getLogger(FIRPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FIRPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{DBConnection.closeConnection(con, ps, rs, null);}
        Vector v = new Vector();
        v.add(title);v.add(""+total);v.add(""+(total-now));v.add(""+now);
        tblModel.addRow(v);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblUser = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisplay = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblShow = new javax.swing.JTable();
        lblDate = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("First Information Report"));

        jLabel1.setText("Total account");

        lblTotal.setEditable(false);

        jLabel2.setText("Admin account");

        lblAdmin.setEditable(false);

        jLabel3.setText("User account");

        lblUser.setEditable(false);

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

        tblShow.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblShow);

        lblDate.setEditable(false);
        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblAdmin;
    private javax.swing.JTextField lblDate;
    private javax.swing.JTextField lblTotal;
    private javax.swing.JTextField lblUser;
    private javax.swing.JTable tblDisplay;
    private javax.swing.JTable tblShow;
    // End of variables declaration//GEN-END:variables
}
