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
public class Victim {
    private int id_victim;
    private String victim_name;
    private String id_card;
    private byte gender;
    private String birth;
    private String address;
    private String nationality;
    private byte isDead;
    private String autopsy_date;
    private String reasons_dead;
    private String id_profile;

    public Victim() {
    }

    @Override
    public String toString() {
        return "Victim{" + "id_victim=" + id_victim + ", victim_name=" + victim_name + ", id_card=" + id_card + ", gender=" + gender + ", birth=" + birth + ", address=" + address + ", nationality=" + nationality + ", isDead=" + isDead + ", autopsy_date=" + autopsy_date + ", reasons_dead=" + reasons_dead + ", id_profile=" + id_profile + '}';
    }

    public Victim(int id_victim, String victim_name, String id_card, byte gender, String birth, String address, String nationality, byte isDead, String autopsy_date, String reasons_dead, String id_profile) {
        this.id_victim = id_victim;
        this.victim_name = victim_name;
        this.id_card = id_card;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.nationality = nationality;
        this.isDead = isDead;
        this.autopsy_date = autopsy_date;
        this.reasons_dead = reasons_dead;
        this.id_profile = id_profile;
    }

    public int getId_victim() {
        return id_victim;
    }

    public void setId_victim(int id_victim) {
        this.id_victim = id_victim;
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

    public byte getIsDead() {
        return isDead;
    }

    public void setIsDead(byte isDead) {
        this.isDead = isDead;
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

    public String getId_profile() {
        return id_profile;
    }

    public void setId_profile(String id_profile) {
        this.id_profile = id_profile;
    }
    
}
