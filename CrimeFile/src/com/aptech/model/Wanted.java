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
public class Wanted {
    private int id_crime;
    private String notify_date;
    private String status;

    public Wanted() {
    }

    @Override
    public String toString() {
        return "Wanted{" + "id_crime=" + id_crime + ", notify_date=" + notify_date + ", status=" + status + '}';
    }

    public Wanted(int id_crime, String notify_date, String status) {
        this.id_crime = id_crime;
        this.notify_date = notify_date;
        this.status = status;
    }

    public int getId_crime() {
        return id_crime;
    }

    public void setId_crime(int id_crime) {
        this.id_crime = id_crime;
    }

    public String getNotify_date() {
        return notify_date;
    }

    public void setNotify_date(String notify_date) {
        this.notify_date = notify_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
