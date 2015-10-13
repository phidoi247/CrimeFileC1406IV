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
public class Complaint {
    private int id_profile;
    private int id_crime;
    private int id_victim;
    private String testimony;

    public Complaint() {
    }

    @Override
    public String toString() {
        return "Complaint{" + "id_profile=" + id_profile + ", id_crime=" + id_crime + ", id_victim=" + id_victim + ", testimony=" + testimony + '}';
    }

    public Complaint(int id_profile, int id_crime, int id_victim, String testimony) {
        this.id_profile = id_profile;
        this.id_crime = id_crime;
        this.id_victim = id_victim;
        this.testimony = testimony;
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

    public int getId_victim() {
        return id_victim;
    }

    public void setId_victim(int id_victim) {
        this.id_victim = id_victim;
    }

    public String getTestimony() {
        return testimony;
    }

    public void setTestimony(String testimony) {
        this.testimony = testimony;
    }

    
    
}
