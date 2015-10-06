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
public class Account {
    private String username;
    private String password;
    private String email;
    private int level;
    private String fullname;
    private byte sex;
    private String birth;
    private String address;
    private String phone_number;
    private String workplace;
    private String avatar;

    public Account() {
    }

    public Account(String username, String password, String email, int level, String fullname, byte sex, String birth, String address, String phone_number, String workplace, String avatar) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.level = level;
        this.fullname = fullname;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.phone_number = phone_number;
        this.workplace = workplace;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
