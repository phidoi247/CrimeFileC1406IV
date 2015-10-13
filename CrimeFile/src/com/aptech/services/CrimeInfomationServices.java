/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.model.CrimeInfomation;
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
public class CrimeInfomationServices {

    public static int addCrimeInfomation(CrimeInfomation crimeInfomation) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[crime_infomation] "
                + " ([crime_name],[id_card],[gender],[birth],[hometown],[address],[jobs],[nationality],[crime_type],[avatar]) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, crimeInfomation.getCrime_name());
            ps.setString(2, crimeInfomation.getId_card());
            ps.setByte(3, crimeInfomation.getGender());
            ps.setString(4, crimeInfomation.getBirth());
            ps.setString(5, crimeInfomation.getHometown());
            ps.setString(6, crimeInfomation.getAddress());
            ps.setString(7, crimeInfomation.getJobs());
            ps.setString(8, crimeInfomation.getNationality());
            ps.setString(9, crimeInfomation.getCrime_type());
            ps.setString(10, crimeInfomation.getAvatar());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }

    public static int updateCrimeInfomation(CrimeInfomation crimeInfomation) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[crime_infomation] "
                + " SET [crime_name] = ?,[id_card] = ?,[gender] = ?,[birth] = ?,[hometown] = ?,[address] = ?,[jobs] = ?,[nationality] = ?,[crime_type] = ?,[avatar] = ? "
                + " WHERE [id_crime] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, crimeInfomation.getCrime_name());
            ps.setString(2, crimeInfomation.getId_card());
            ps.setByte(3, crimeInfomation.getGender());
            ps.setString(4, crimeInfomation.getBirth());
            ps.setString(5, crimeInfomation.getHometown());
            ps.setString(6, crimeInfomation.getAddress());
            ps.setString(7, crimeInfomation.getJobs());
            ps.setString(8, crimeInfomation.getNationality());
            ps.setString(9, crimeInfomation.getCrime_type());
            ps.setString(10, crimeInfomation.getAvatar());
            ps.setInt(11, crimeInfomation.getId_crime());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }

    public static int deleteCrimeInfomation(CrimeInfomation crimeInfomation) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[crime_infomation] WHERE [id_crime]=? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, crimeInfomation.getId_crime());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }

    public static ArrayList<CrimeInfomation> getAllCrimeInfomations() {
        ArrayList<CrimeInfomation> arrCrimeInfomations = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[crime_infomation]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                CrimeInfomation temp = new CrimeInfomation();

                temp.setId_crime(rs.getInt("id_crime"));
                temp.setCrime_name(rs.getString("crime_name"));
                temp.setId_card(rs.getString("id_card"));
                temp.setGender(rs.getByte("gender"));
                temp.setBirth(rs.getString("birth"));
                temp.setHometown(rs.getString("hometown"));
                temp.setAddress(rs.getString("address"));
                temp.setJobs(rs.getString("jobs"));
                temp.setNationality(rs.getString("nationality"));
                temp.setCrime_type(rs.getString("crime_type"));
                temp.setAvatar(rs.getString("avatar"));

                arrCrimeInfomations.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrCrimeInfomations;
    }

    public static CrimeInfomation findById_crime(int id_crime) {
        CrimeInfomation crimeInfomation = null;
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[crime_infomation] WHERE [id_crime] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_crime);
            rs = ps.executeQuery();

            if (rs.next()) {
                crimeInfomation = new CrimeInfomation();

                crimeInfomation.setId_crime(rs.getInt("id_crime"));
                crimeInfomation.setCrime_name(rs.getString("crime_name"));
                crimeInfomation.setId_card(rs.getString("id_card"));
                crimeInfomation.setGender(rs.getByte("gender"));
                crimeInfomation.setBirth(rs.getString("birth"));
                crimeInfomation.setHometown(rs.getString("hometown"));
                crimeInfomation.setAddress(rs.getString("address"));
                crimeInfomation.setJobs(rs.getString("jobs"));
                crimeInfomation.setNationality(rs.getString("nationality"));
                crimeInfomation.setCrime_type(rs.getString("crime_type"));
                crimeInfomation.setAvatar(rs.getString("avatar"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return crimeInfomation;
    }
   
}
