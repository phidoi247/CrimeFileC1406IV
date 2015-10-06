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
public class CrimeList {
    private int id_profile;
    private int id_crime;

    public CrimeList() {
    }

    public CrimeList(int id_profile, int id_crime) {
        this.id_profile = id_profile;
        this.id_crime = id_crime;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public int getId_crime() {
        return id_crime;
    }

    public void setId_crime(int id_crime) {
        this.id_crime = id_crime;
    }
    
    
}
