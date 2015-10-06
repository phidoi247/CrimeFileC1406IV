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
public class Corpse {
    private int id_corpse;
    private String corpse_name;
    private String id_card;
    private byte sex;
    private String birth;
    private String address;
    private String nationality;
    private String autopsy_date;
    private String reasons_dead;
    private String username;
    private String id_profile;

    public Corpse() {
    }

    public Corpse(int id_corpse, String corpse_name, String id_card, byte sex, String birth, String address, String nationality, String autopsy_date, String reasons_dead, String username, String id_profile) {
        this.id_corpse = id_corpse;
        this.corpse_name = corpse_name;
        this.id_card = id_card;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.nationality = nationality;
        this.autopsy_date = autopsy_date;
        this.reasons_dead = reasons_dead;
        this.username = username;
        this.id_profile = id_profile;
    }

    public int getId_corpse() {
        return id_corpse;
    }

    public void setId_corpse(int id_corpse) {
        this.id_corpse = id_corpse;
    }

    public String getCorpse_name() {
        return corpse_name;
    }

    public void setCorpse_name(String corpse_name) {
        this.corpse_name = corpse_name;
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

    public String getAutopsy_date() {
        return autopsy_date;
    }

    public void setAutopsy_date(String autopsy_date) {
        this.autopsy_date = autopsy_date;
    }

    public String getReasons_dead() {
        return reasons_dead;
    }

    public void setReasons_dead(String reasons_dead) {
        this.reasons_dead = reasons_dead;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId_profile() {
        return id_profile;
    }

    public void setId_profile(String id_profile) {
        this.id_profile = id_profile;
    }
    
}
