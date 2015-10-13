/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.model.Wanted;
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
public class WantedServices {

    public static int addWanted(Wanted wanted) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[wanted] "
                + " ([id_crime],[notify_date],[status]) "
                + " VALUES (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, wanted.getId_crime());
            ps.setString(2, wanted.getNotify_date());
            ps.setString(3, wanted.getStatus());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }

    public static int updateWanted(Wanted wanted) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[wanted] "
                + " SET [notify_date] = ?, [status] = ? "
                + " WHERE [id_crime] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, wanted.getNotify_date());
            ps.setString(2, wanted.getStatus());
            ps.setInt(3, wanted.getId_crime());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }

    public static int deleteWanted(Wanted wanted) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[wanted] WHERE [id_crime] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, wanted.getId_crime());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }

    public static ArrayList<Wanted> getAllWanteds() {
        ArrayList<Wanted> arrWanteds = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[wanted]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Wanted temp = new Wanted();

                temp.setId_crime(rs.getInt("id_crime"));
                temp.setNotify_date(rs.getString("notify_date"));
                temp.setStatus(rs.getString("status"));

                arrWanteds.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrWanteds;
    }

    public static Wanted findById_crime(int id_crime) {
        Wanted temp = null;
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[wanted] WHERE [id_crime] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_crime);
            rs = ps.executeQuery();

            if (rs.next()) {
                temp = new Wanted();

                temp.setId_crime(rs.getInt("id_crime"));
                temp.setNotify_date(rs.getString("notify_date"));
                temp.setStatus(rs.getString("status"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return temp;
    }
}
