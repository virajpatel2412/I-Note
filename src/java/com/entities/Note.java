/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name="inode")
public class Note implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Sr_no;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "disc")
    private String disc;
    
    @Column(name = "date")
    private Date date;
    
    public Note(){
        Date d = new Date();
        this.date = d;
    }

    public int getSr_no() {
        return Sr_no;
    }

    public void setSr_no(int Sr_no) {
        this.Sr_no = Sr_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public Date getDate() {
        return date;
    }

    
}
