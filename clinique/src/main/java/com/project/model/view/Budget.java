package com.project.model.view;

import java.math.BigDecimal;

import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;

@Table("budget")
public class Budget extends Entity{
    
    @Column
    Integer mois;

    @Column
    BigDecimal annee;

    @Column
    Long recettes;

    @Column
    Long depenses;

    @Column
    Long budget;


    public Integer getMois() {
        return mois;
    }

    public BigDecimal getAnnee() {
        return annee;
    }
    
    public Long getRecettes() {
        return recettes;
    }

    public Long getDepenses() {
        return depenses;
    }

    public Long getBudget() {
        return budget;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public void setAnnee(BigDecimal annee) {
        this.annee = annee;
    }

    public void setRecettes(Long recettes) {
        this.recettes = recettes;
    }

    public void setDepenses(Long depenses) {
        this.depenses = depenses;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    
    
}
