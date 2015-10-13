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
public class CaseProfile {
    private int id_profile;
    private String day_admission;
    private String crime_scene;
    private String exhibit;
    private String accusation;
    private String conclude;
    private String status;

    @Override
    public String toString() {
        return "CaseProfile{" + "id_profile=" + id_profile + ", day_admission=" + day_admission + ", crime_scene=" + crime_scene + ", exhibit=" + exhibit + ", accusation=" + accusation + ", conclude=" + conclude + ", status=" + status + '}';
    }

    public CaseProfile() {
    }

    public CaseProfile(int id_profile, String day_admission, String crime_scene, String exhibit, String accusation, String conclude, String status) {
        this.id_profile = id_profile;
        this.day_admission = day_admission;
        this.crime_scene = crime_scene;
        this.exhibit = exhibit;
        this.accusation = accusation;
        this.conclude = conclude;
        this.status = status;
    } 
    
    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public String getDay_admission() {
        return day_admission;
    }

    public void setDay_admission(String day_admission) {
        this.day_admission = day_admission;
    }

    public String getCrime_scene() {
        return crime_scene;
    }

    public void setCrime_scene(String crime_scene) {
        this.crime_scene = crime_scene;
    }

    public String getExhibit() {
        return exhibit;
    }

    public void setExhibit(String exhibit) {
        this.exhibit = exhibit;
    }

    public String getAccusation() {
        return accusation;
    }

    public void setAccusation(String accusation) {
        this.accusation = accusation;
    }

    public String getConclude() {
        return conclude;
    }

    public void setConclude(String conclude) {
        this.conclude = conclude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
