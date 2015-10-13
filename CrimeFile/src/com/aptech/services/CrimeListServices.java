/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.model.CrimeList;
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
public class CrimeListServices {

    public static int addCrimeList(CrimeList crimeList) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[crime_list] "
                + " ([id_profile],[id_crime]) "
                + " VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, crimeList.getId_profile());
            ps.setInt(2, crimeList.getId_crime());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }

    public static int updateCrimeList(CrimeList crimeList) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[crime_list] "
                + " SET [id_crime] = ? "
                + " WHERE [id_profile] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, crimeList.getId_crime());
            ps.setInt(2, crimeList.getId_profile());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }

    public static int deleteCrimeList(CrimeList crimeList) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[crime_list] WHERE [id_profile]=? AND [id_crime] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, crimeList.getId_profile());
            ps.setInt(2, crimeList.getId_crime());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }

    public static ArrayList<CrimeList> getAllCrimeLists() {
        ArrayList<CrimeList> arrCrimeLists = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[crime_list]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                CrimeList temp = new CrimeList();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setId_crime(rs.getInt("id_crime"));

                arrCrimeLists.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrCrimeLists;
    }

    public static ArrayList<CrimeList> findById_profile(int id_profile) {
        ArrayList<CrimeList> arrCrimeLists = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[crime_list] WHERE [id_profile] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_profile);
            rs = ps.executeQuery();

            while (rs.next()) {
                CrimeList temp = new CrimeList();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setId_crime(rs.getInt("id_crime"));

                arrCrimeLists.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrCrimeLists;
    }

    public static ArrayList<CrimeList> findById_crime(int id_crime) {
        ArrayList<CrimeList> arrCrimeLists = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[crime_list] WHERE [id_crime] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_crime);
            rs = ps.executeQuery();

            while (rs.next()) {
                CrimeList temp = new CrimeList();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setId_crime(rs.getInt("id_crime"));

                arrCrimeLists.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrCrimeLists;
    }
   
   }
