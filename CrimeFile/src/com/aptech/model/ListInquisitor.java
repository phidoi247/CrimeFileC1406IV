/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.model;

/**
 *
 * @author MyPC
 */
public class ListInquisitor {
    private int id_profile;
    private  String username;

    public ListInquisitor() {
    }

    @Override
    public String toString() {
        return "ListInquisitor{" + "id_profile=" + id_profile + ", username=" + username + '}';
    }

    public ListInquisitor(int id_profile, String username) {
        this.id_profile = id_profile;
        this.username = username;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
