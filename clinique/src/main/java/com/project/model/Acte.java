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
@Table("acte")
public class Acte extends Entity{
    
    @Column(pk=true,autoComplete = true)
    Integer id;
    
    @Column
    Integer type_acte;
    
    @Column
    Integer patient;
    
    @Column
    Integer prix;
    
    @Column
    Date dateActe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType_acte() {
        return type_acte;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    
    
    public void setType_acte(Integer type_acte) {
        this.type_acte = type_acte;
    }

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Date getDateActe() {
        return dateActe;
    }

    public void setDateActe(Date dateActe) {
        this.dateActe = dateActe;
    }

    public Acte() {
    }

    public Acte(Integer id) {
        this.id = id;
    }

    public Acte(Integer id, Integer type_acte, Integer patient, Integer prix, Date dateActe) {
        this.id = id;
        this.type_acte = type_acte;
        this.patient = patient;
        this.prix = prix;
        this.dateActe = dateActe;
    }

    public Acte(Integer type_acte, Integer patient, Integer prix, Date dateActe) {
        this.type_acte = type_acte;
        this.patient = patient;
        this.prix = prix;
        this.dateActe = dateActe;
    }

    
    
}
