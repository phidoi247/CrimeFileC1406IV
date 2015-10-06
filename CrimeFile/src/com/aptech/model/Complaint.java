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
    private int id_complaint;
    private String victim_name;
    private String id_card;
    private byte sex;
    private String birth;
    private String address;
    private String nationality;
    private String testimony;
    private String id_profile;

    public Complaint() {
    }

    public Complaint(int id_complaint, String victim_name, String id_card, byte sex, String birth, String address, String nationality, String testimony, String id_profile) {
        this.id_complaint = id_complaint;
        this.victim_name = victim_name;
        this.id_card = id_card;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.nationality = nationality;
        this.testimony = testimony;
        this.id_profile = id_profile;
    }

    public int getId_complaint() {
        return id_complaint;
    }

    public void setId_complaint(int id_complaint) {
        this.id_complaint = id_complaint;
    }

    public String getVictim_name() {
        return victim_name;
    }

    public void setVictim_name(String victim_name) {
        this.victim_name = victim_name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTestimony() {
        return testimony;
    }

    public void setTestimony(String testimony) {
        this.testimony = testimony;
    }

    public String getId_profile() {
        return id_profile;
    }

    public void setId_profile(String id_profile) {
        this.id_profile = id_profile;
    }
    
    
}
