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
@Table("patient")
public class Patient extends Entity{
    @Column(pk=true,autoComplete = true)
    Integer id;
    
    @Column
    String nom;
    
    @Column
    Date dateNaissance;
    
    @Column
    String genre;
    
    @Column
    Boolean remboursement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getRemboursement() {
        return remboursement;
    }

    public void setRemboursement(Boolean remboursement) {
        this.remboursement = remboursement;
    }

    public Patient(Integer id) {
        this.id = id;
    }
    

    public Patient(String nom, Date dateNaissance, String genre, Boolean remboursement) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.remboursement = remboursement;
    }

    public Patient(Integer id, String nom, Date dateNaissance, String genre, Boolean remboursement) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.remboursement = remboursement;
    }
    
    

    public Patient() {
    }
    
    
    
}
