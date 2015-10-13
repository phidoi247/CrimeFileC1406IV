/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.model.CaseProfile;
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
public class CaseProfileServices {

    public static int addCaseProfile(CaseProfile caseProfile) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[case_profile] "
                + " ([day_admission],[crime_scene],[exhibit],[accusation],[conclude],[status]) "
                + " VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, caseProfile.getDay_admission());
            ps.setString(2, caseProfile.getCrime_scene());
            ps.setString(3, caseProfile.getExhibit());
            ps.setString(4, caseProfile.getAccusation());
            ps.setString(5, caseProfile.getConclude());
            ps.setString(6, caseProfile.getStatus());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }

    public static int updateCaseProfile(CaseProfile caseProfile) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[case_profile] "
                + " SET [day_admission] = ?,[crime_scene] = ?,[exhibit] = ?,[accusation] = ?,[conclude] = ?,[status] = ? "
                + " WHERE [id_profile]=? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, caseProfile.getDay_admission());
            ps.setString(2, caseProfile.getCrime_scene());
            ps.setString(3, caseProfile.getExhibit());
            ps.setString(4, caseProfile.getAccusation());
            ps.setString(5, caseProfile.getConclude());
            ps.setString(6, caseProfile.getStatus());
            ps.setInt(7, caseProfile.getId_profile());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }

    public static int deleteCaseprofile(CaseProfile caseProfile) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[case_profile] WHERE [id_profile] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, caseProfile.getId_profile());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }

    public static ArrayList<CaseProfile> getAllCaseProfiles() {
        ArrayList<CaseProfile> arrCaseProfiles = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[case_profile]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                CaseProfile temp = new CaseProfile();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setDay_admission(rs.getString("day_admission"));
                temp.setCrime_scene(rs.getString("crime_scene"));
                temp.setExhibit(rs.getString("exhibit"));
                temp.setAccusation(rs.getString("accusation"));
                temp.setConclude(rs.getString("conclude"));
                temp.setStatus(rs.getString("status"));

                arrCaseProfiles.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrCaseProfiles;
    }

    public static CaseProfile findById_profile(int id_profile) {
        CaseProfile temp = null;
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[case_profile] WHERE [id_profile] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_profile);
            rs = ps.executeQuery();

            if (rs.next()) {
                temp = new CaseProfile();

                temp.setId_profile(rs.getInt("id_profile"));
                temp.setDay_admission(rs.getString("day_admission"));
                temp.setCrime_scene(rs.getString("crime_scene"));
                temp.setExhibit(rs.getString("exhibit"));
                temp.setAccusation(rs.getString("accusation"));
                temp.setConclude(rs.getString("conclude"));
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
