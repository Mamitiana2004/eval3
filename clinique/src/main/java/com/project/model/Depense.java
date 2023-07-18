/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;
import java.util.Date;

/**
 *
 * @author mamit
 */
@Table("depense")
public class Depense extends Entity{
    
    @Column(pk=true,autoComplete = true)
    Integer id;
    
    @Column
    Integer type;
    
    @Column
    Integer prix;
    
    @Column
    Date dateDepense;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }

    public Depense(Integer id) {
        this.id = id;
    }

    public Depense(Integer id, Integer type, Integer prix, Date dateDepense) {
        this.id = id;
        this.type = type;
        this.prix = prix;
        this.dateDepense = dateDepense;
    }

    public Depense(Integer type, Integer prix, Date dateDepense) {
        this.type = type;
        this.prix = prix;
        this.dateDepense = dateDepense;
    }

    
    
    public Depense() {
    }
}
