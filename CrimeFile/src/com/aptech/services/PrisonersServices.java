/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.model.Prisoners;
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
public class PrisonersServices {

    public static int addPrisoners(Prisoners prisoners) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[prisoners] "
                + " ([id_crime],[detention_date],[prison_address],[jail_time]) "
                + " VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, prisoners.getId_crime());
            ps.setString(2, prisoners.getDetention_date());
            ps.setString(3, prisoners.getPrison_address());
            ps.setString(4, prisoners.getJail_time());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }

    public static int updatePrisoners(Prisoners prisoners) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[prisoners] "
                + " SET [detention_date] = ?,[prison_address] = ?,[jail_time] = ? "
                + " WHERE [id_crime] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, prisoners.getDetention_date());
            ps.setString(2, prisoners.getPrison_address());
            ps.setString(3, prisoners.getJail_time());
            ps.setInt(4, prisoners.getId_crime());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }

    public static int deletePrisoners(Prisoners prisoners) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[prisoners] WHERE [id_crime] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, prisoners.getId_crime());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }

    public static ArrayList<Prisoners> getAllPrisonerses() {
        ArrayList<Prisoners> arrPrisonerses = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[prisoners]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Prisoners temp = new Prisoners();

                temp.setId_crime(rs.getInt("id_crime"));
                temp.setDetention_date(rs.getString("detention_date"));
                temp.setPrison_address(rs.getString("prison_address"));
                temp.setJail_time(rs.getString("jail_time"));

                arrPrisonerses.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrPrisonerses;
    }

    public static Prisoners findById_crime(int id_crime) {
        Prisoners prisoners = new Prisoners();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[prisoners] WHERE [id_crime] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_crime);
            rs = ps.executeQuery();

            if (rs.next()) {
                prisoners = new Prisoners();

                prisoners.setId_crime(rs.getInt("id_crime"));
                prisoners.setDetention_date(rs.getString("detention_date"));
                prisoners.setPrison_address(rs.getString("prison_address"));
                prisoners.setJail_time(rs.getString("jail_time"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return prisoners;
    }
    
}
