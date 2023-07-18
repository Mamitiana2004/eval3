/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model.view;

import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;

/**
 *
 * @author mamit
 */
@Table("depense_mois")
public class DepenseMois extends Entity{
    
    @Column
    Integer idMois;
    
    @Column
    String mois;
    
    @Column
    Double annee;
    
    @Column
    Integer idType;
    
    @Column("type_acte")
    String type;
    
    @Column
    Long depense;

    public Integer getIdMois() {
        return idMois;
    }

    public void setIdMois(Integer idMois) {
        this.idMois = idMois;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Double getAnnee() {
        return annee;
    }

    public void setAnnee(Double annee) {
        this.annee = annee;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDepense() {
        return depense;
    }

    public void setDepense(Long depense) {
        this.depense = depense;
    }
    
    

    public DepenseMois() {
    }

    public DepenseMois(Integer idMois, String mois, Double annee, Integer idType, String type, Long depense) {
        this.idMois = idMois;
        this.mois = mois;
        this.annee = annee;
        this.idType = idType;
        this.type = type;
        this.depense = depense;
    }

    
    
    
    
}
