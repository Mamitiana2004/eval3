/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import java.util.ArrayList;

import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;

/**
 *
 * @author mamit
 */
@Table("mois")
public class Mois extends Entity{
    @Column(pk=true,autoComplete = true)
    Integer id;
    @Column
    String mois;

    public Mois() {
    }

    public Mois(Integer id) {
        this.id = id;
    }

    public Mois(String mois) {
        this.mois = mois;
    }

    public Mois(Integer id, String mois) {
        this.id = id;
        this.mois = mois;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }
    
    public String getMois(Integer id)throws Exception{
        ArrayList<Mois> l=new Mois().getAll();
        for (Mois mois1 : l) {
            if(mois1.getId()==id){
                return mois1.getMois();
            }
        }
        return null;
    }
    
}
