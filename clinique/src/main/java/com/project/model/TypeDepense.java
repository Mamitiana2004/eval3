/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import java.math.BigDecimal;

import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;

/**
 *
 * @author mamit
 */
@Table("type_depense")
public class TypeDepense extends Entity{
    
    @Column(pk=true,autoComplete = true)
    Integer id;
    
    @Column
    String libelle;
    
    @Column
    BigDecimal budget;
    
    @Column
    String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    

    public TypeDepense() {
    }

    public TypeDepense(Integer id) {
        this.id = id;
    }

    public TypeDepense(String libelle, BigDecimal budget, String code) {
        this.libelle = libelle;
        this.budget = budget;
        this.code = code;
    }

    public TypeDepense(Integer id, String libelle, BigDecimal budget, String code) {
        this.id = id;
        this.libelle = libelle;
        this.budget = budget;
        this.code = code;
    }
    
    
}
