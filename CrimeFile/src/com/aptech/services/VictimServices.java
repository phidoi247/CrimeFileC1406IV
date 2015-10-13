/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.services;

import com.aptech.model.Account;
import com.aptech.model.Victim;
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
public class VictimServices {
    public static int addVictim(Victim victim) {
        int rowAdded = 0;
        Connection connection = DBConnection.openConnection();
        String query = "INSERT INTO [crime_file].[dbo].[victim] "
                + " ([victim_name],[id_card],[gender],[birth],[address],[nationality],[isDead],[autopsy_date],[reasons_dead],[id_profile]) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, victim.getVictim_name());
            ps.setString(2, victim.getId_card());
            ps.setByte(3, victim.getGender());
            ps.setString(4, victim.getBirth());
            ps.setString(5, victim.getAddress());
            ps.setString(6, victim.getNationality());
            ps.setByte(7, victim.getIsDead());
            ps.setString(8, victim.getAutopsy_date());
            ps.setString(9, victim.getReasons_dead());
            ps.setString(10, victim.getId_profile());

            rowAdded += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }

        return rowAdded;
    }
    
    public static int updateVictim (Victim victim) {
        int rowUpdated = 0;
        Connection connection = DBConnection.openConnection();
        String query = " UPDATE [crime_file].[dbo].[victim] "
                + " SET [victim_name] = ?,[id_card] = ?,[gender] = ?,[birth] = ?,[address] = ?,[nationality] = ?,[isDead] = ?,[autopsy_date] = ?,[reasons_dead] = ?,[id_profile] = ? "
                + " WHERE [id_victim]=? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, victim.getVictim_name());
            ps.setString(2, victim.getId_card());
            ps.setByte(3, victim.getGender());
            ps.setString(4, victim.getBirth());
            ps.setString(5, victim.getAddress());
            ps.setString(6, victim.getNationality());
            ps.setByte(7, victim.getIsDead());
            ps.setString(8, victim.getAutopsy_date());
            ps.setString(9, victim.getReasons_dead());
            ps.setString(10, victim.getId_profile());
            ps.setInt(11, victim.getId_victim());

            rowUpdated += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowUpdated;
    }
    
    public static int deleteVictim (Victim victim) {
        int rowDeleted = 0;
        Connection connection = DBConnection.openConnection();
        String query = " DELETE FROM [crime_file].[dbo].[victim] WHERE [id_victim] = ? ";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, victim.getId_victim());

            rowDeleted += ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, null, null);
        }
        return rowDeleted;
    }
    
    public static ArrayList<Victim> getAllVictims() {
        ArrayList<Victim> arrVictims = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[victim]";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Victim temp = new Victim();
                
                temp.setId_victim(rs.getInt("id_victim"));
                temp.setVictim_name(rs.getString("victim_name"));
                temp.setId_card(rs.getString("id_card"));
                temp.setGender(rs.getByte("gender"));
                temp.setBirth(rs.getString("birth"));
                temp.setAddress(rs.getString("address"));
                temp.setNationality(rs.getString("nationality"));
                temp.setIsDead(rs.getByte("isDead"));
                temp.setAutopsy_date(rs.getString("autopsy_date"));
                temp.setReasons_dead(rs.getString("reason_dead"));
                temp.setId_profile(rs.getString("id_profile"));
                
                arrVictims.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return arrVictims;
    }
    
    public static Victim findById_victim(int id_victim) {
        Victim temp = null;
        Connection connection = DBConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = " SELECT * FROM [crime_file].[dbo].[victim] WHERE [id_victim] = ? ";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id_victim);
            rs = ps.executeQuery();

            while (rs.next()) {
                temp = new Victim();
                temp.setId_victim(rs.getInt("id_victim"));
                temp.setVictim_name(rs.getString("victim_name"));
                temp.setId_card(rs.getString("id_card"));
                temp.setGender(rs.getByte("gender"));
                temp.setBirth(rs.getString("birth"));
                temp.setAddress(rs.getString("address"));
                temp.setNationality(rs.getString("nationality"));
                temp.setIsDead(rs.getByte("isDead"));
                temp.setAutopsy_date(rs.getString("autopsy_date"));
                temp.setReasons_dead(rs.getString("reason_dead"));
                temp.setId_profile(rs.getString("id_profile"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBConnection.closeConnection(connection, ps, rs, null);
        }

        return temp;
    }
}
