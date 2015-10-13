/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.model.ListInquisitor;
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
public class ListInquisitorServices {

    public static int addListInquisitor(ListInquisitor listInquisitor) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[list_inquisitor] "
                + " ([id_profile],[username]) "
                + " VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, listInquisitor.getId_profile());
            ps.setString(2, listInquisitor.getUsername());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }

    public static int updateListInquisitor(ListInquisitor listInquisitor) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[list_inquisitor] "
                + " SET [username] = ? "
                + " WHERE [id_profile] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, listInquisitor.getId_profile());
            ps.setString(2, listInquisitor.getUsername());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }

    public static int deleteListInquisitor(ListInquisitor listInquisitor) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[list_inquisitor] WHERE [id_profile]=? AND [username] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, listInquisitor.getId_profile());
            ps.setString(2, listInquisitor.getUsername());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }

    public static ArrayList<ListInquisitor> getAllListInquisitors() {
        ArrayList<ListInquisitor> arrListInquisitors = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[list_inquisitor]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                ListInquisitor temp = new ListInquisitor();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setUsername(rs.getString("username"));

                arrListInquisitors.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrListInquisitors;
    }

    public static ArrayList<ListInquisitor> findById_profile(int id_profile) {
        ArrayList<ListInquisitor> arrListInquisitors = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[list_inquisitor] WHERE [id_profile] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_profile);
            rs = ps.executeQuery();

            while (rs.next()) {
                ListInquisitor temp = new ListInquisitor();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setUsername(rs.getString("username"));

                arrListInquisitors.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrListInquisitors;
    }

    public static ArrayList<ListInquisitor> findByUsername(String username) {
        ArrayList<ListInquisitor> arrListInquisitors = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[list_inquisitor] WHERE [username] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                ListInquisitor temp = new ListInquisitor();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setUsername(rs.getString("username"));

                arrListInquisitors.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrListInquisitors;
    }
   
}
