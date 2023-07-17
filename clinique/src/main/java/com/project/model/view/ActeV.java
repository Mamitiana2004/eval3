/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model.view;

import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;
import java.util.Date;

/**
 *
 * @author mamit
 */
@Table("v_acte")
public class ActeV extends Entity{
    
    @Column(pk=true,autoComplete = true)
    Integer id;
    
    @Column
    Integer idType;
    
    @Column
    String type;
    
    @Column
    Integer idPatient;
    
    @Column
    String nom;
    
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

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Date getDateActe() {
        return dateActe;
    }

    public void setDateActe(Date dateActe) {
        this.dateActe = dateActe;
    }

    public ActeV(){}

    public ActeV(Integer id){
        setId(id);
    }
    
}
