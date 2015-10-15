/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.Session;
import com.aptech.model.Account;
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
public class AccountServices {

    public static int addAccount(Account account) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[account] "
                + "([username],[password],[email],[permission],[full_name],[gender],[birth],[address],[phone_number],[workplace],[avartar])"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.setInt(4, account.getPermission());
            ps.setString(5, account.getFull_name());
            ps.setByte(6, account.getGender());
            ps.setString(7, account.getBirth());
            ps.setString(8, account.getAddress());
            ps.setString(9, account.getPhone_number());
            ps.setString(10, account.getWorkplace());
            ps.setString(11, account.getAvatar());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }

    public static int updateAccount(Account account) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[account] "
                + " SET [password]=?,[email]=?,[permission]=?,[full_name]=?,[gender]=?,[birth]=?,[address]=?,[phone_number]=?,[workplace]=?,[avartar]=? "
                + " WHERE [username]=? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, account.getPassword());
            ps.setString(2, account.getEmail());
            ps.setInt(3, account.getPermission());
            ps.setString(4, account.getFull_name());
            ps.setByte(5, account.getGender());
            ps.setString(6, account.getBirth());
            ps.setString(7, account.getAddress());
            ps.setString(8, account.getPhone_number());
            ps.setString(9, account.getWorkplace());
            ps.setString(10, account.getAvatar());
            ps.setString(11, account.getUsername());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }

    public static int deleteAccount(Account account) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[account] WHERE [username] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, account.getUsername());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }

    public static ArrayList<Account> getAllAccounts() {
        ArrayList<Account> arrAccounts = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[account]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Account temp = new Account();
                temp.setFull_name(rs.getString("full_name"));
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setEmail(rs.getString("email"));
                temp.setPermission(rs.getInt("permission"));
                temp.setGender(rs.getByte("gender"));
                temp.setBirth(rs.getString("birth"));
                temp.setAddress(rs.getString("address"));
                temp.setPhone_number(rs.getString("phone_number"));
                temp.setWorkplace(rs.getString("workplace"));
                temp.setAvatar(rs.getString("avartar"));
                arrAccounts.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrAccounts;
    }

    public static Account findByUsername(String username) {
        Account temp = null;
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[account] WHERE [username] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                temp = new Account();
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setEmail(rs.getString("email"));
                temp.setPermission(rs.getInt("permission"));
                temp.setGender(rs.getByte("gender"));
                temp.setBirth(rs.getString("birth"));
                temp.setAddress(rs.getString("address"));
                temp.setPhone_number(rs.getString("phone_number"));
                temp.setWorkplace(rs.getString("workplace"));
                temp.setAvatar(rs.getString("avartar"));
                temp.setFull_name(rs.getString("full_name"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return temp;
    }

    public static String login(String userName) {
        String password = "";
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT password, permission, full_name FROM [crime_file].[dbo].[account] WHERE [username] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                password = rs.getString("password");
                Session.permission = rs.getInt("permission");
                Session.userName = userName;
                Session.fullName = rs.getString("full_name");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return password;
    }

}
