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
public class CrimeInfomation {

    @Override
    public String toString() {
        return "CrimeInfomation{" + "id_crime=" + id_crime + ", crime_name=" + crime_name + ", id_card=" + id_card + ", gender=" + gender + ", birth=" + birth + ", hometown=" + hometown + ", address=" + address + ", jobs=" + jobs + ", nationality=" + nationality + ", crime_type=" + crime_type + ", avatar=" + avatar + '}';
    }
    private int id_crime;
    private String crime_name;
    private String id_card;
    private byte gender;
    private String birth;
    private String hometown;
    private String address;
    private String jobs;
    private String nationality;
    private String crime_type;
    private String avatar;

    public CrimeInfomation() {
    }

    public CrimeInfomation(int id_crime, String crime_name, String id_card, byte gender, String birth, String hometown, String address, String jobs, String nationality, String crime_type, String avatar) {
        this.id_crime = id_crime;
        this.crime_name = crime_name;
        this.id_card = id_card;
        this.gender = gender;
        this.birth = birth;
        this.hometown = hometown;
        this.address = address;
        this.jobs = jobs;
        this.nationality = nationality;
        this.crime_type = crime_type;
        this.avatar = avatar;
    }

    public int getId_crime() {
        return id_crime;
    }

    public void setId_crime(int id_crime) {
        this.id_crime = id_crime;
    }

    public String getCrime_name() {
        return crime_name;
    }

    public void setCrime_name(String crime_name) {
        this.crime_name = crime_name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCrime_type() {
        return crime_type;
    }

    public void setCrime_type(String crime_type) {
        this.crime_type = crime_type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    
}
