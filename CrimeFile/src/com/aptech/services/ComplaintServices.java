/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.model.Complaint;
import com.aptech.utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class ComplaintServices {

    public static int addComplaint(Complaint complaint) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[complaint] "
                + " ([id_profile],[id_crime],[id_victim],[testimony]) "
                + " VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, complaint.getId_profile());
            ps.setInt(2, complaint.getId_crime());
            ps.setInt(3, complaint.getId_victim());
            ps.setString(4, complaint.getTestimony());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }

    public static int updateComplaint(Complaint complaint) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[complaint] "
                + " SET [testimony] = ? "
                + " WHERE [id_profile] = ? AND [id_crime] = ? AND [id_victim] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, complaint.getTestimony());
            ps.setInt(2, complaint.getId_profile());
            ps.setInt(3, complaint.getId_crime());
            ps.setInt(4, complaint.getId_victim());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }

    public static int deleteComplaint(Complaint complaint) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[complaint] WHERE [id_profile]=? AND [id_crime] = ? AND [id_victim] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, complaint.getId_profile());
            ps.setInt(2, complaint.getId_crime());
            ps.setInt(3, complaint.getId_victim());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }

    public static ArrayList<Complaint> getAllComplaints() {
        ArrayList<Complaint> arrComplaints = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[complaint]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Complaint temp = new Complaint();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setId_crime(rs.getInt("id_crime"));
                temp.setId_victim(rs.getInt("id_victim"));
                temp.setTestimony(rs.getString("testimony"));

                arrComplaints.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrComplaints;
    }

    public static ArrayList<Complaint> findById_profile(int id_profile) {
        ArrayList<Complaint> arrComplaints = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[complaint] WHERE [id_profile] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_profile);
            rs = ps.executeQuery();

            while (rs.next()) {
                Complaint temp = new Complaint();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setId_crime(rs.getInt("id_crime"));
                temp.setId_victim(rs.getInt("id_victim"));
                temp.setTestimony(rs.getString("testimony"));

                arrComplaints.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrComplaints;
    }

    public static ArrayList<Complaint> findById_crime(int id_crime) {
        ArrayList<Complaint> arrComplaints = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[complaint] WHERE [id_crime] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_crime);
            rs = ps.executeQuery();

            while (rs.next()) {
                Complaint temp = new Complaint();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setId_crime(rs.getInt("id_crime"));
                temp.setId_victim(rs.getInt("id_victim"));
                temp.setTestimony(rs.getString("testimony"));

                arrComplaints.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrComplaints;
    }

    public static ArrayList<Complaint> findById_victim(int id_victim) {
        ArrayList<Complaint> arrComplaints = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[complaint] WHERE [id_victim] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_victim);
            rs = ps.executeQuery();

            while (rs.next()) {
                Complaint temp = new Complaint();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setId_crime(rs.getInt("id_crime"));
                temp.setId_victim(rs.getInt("id_victim"));
                temp.setTestimony(rs.getString("testimony"));

                arrComplaints.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrComplaints;
    }
    
}
