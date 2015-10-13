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
public class Prisoners {
    private int id_crime;
    private String detention_date;
    private String prison_address;
    private String jail_time;

    public Prisoners() {
    }

    @Override
    public String toString() {
        return "Prisoners{" + "id_crime=" + id_crime + ", detention_date=" + detention_date + ", prison_address=" + prison_address + ", jail_time=" + jail_time + '}';
    }

    public Prisoners(int id_crime, String detention_date, String prison_address, String jail_time) {
        this.id_crime = id_crime;
        this.detention_date = detention_date;
        this.prison_address = prison_address;
        this.jail_time = jail_time;
    }

    public int getId_crime() {
        return id_crime;
    }

    public void setId_crime(int id_crime) {
        this.id_crime = id_crime;
    }

    public String getDetention_date() {
        return detention_date;
    }

    public void setDetention_date(String detention_date) {
        this.detention_date = detention_date;
    }

    public String getPrison_address() {
        return prison_address;
    }

    public void setPrison_address(String prison_address) {
        this.prison_address = prison_address;
    }

    public String getJail_time() {
        return jail_time;
    }

    public void setJail_time(String jail_time) {
        this.jail_time = jail_time;
    }
    
}
