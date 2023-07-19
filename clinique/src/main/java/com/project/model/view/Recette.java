/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model.view;

import com.project.model.TypeActe;
import com.project.service.ActeService;
import com.project.service.AdminService;
import com.project.service.TypeActeService;

/**
 *
 * @author mamit
 */
public class Recette {
    
    RecetteMois recetteMois;

    Double reel;

    String reelStr;
    
    Double budget;

    String budgetStr;
    
    Double realisation;
    
    public Recette(RecetteMois recetteMois){
        this.recetteMois=recetteMois;
        TypeActe type=TypeActeService.getById(recetteMois.getIdType());
        budget=type.getBudget().doubleValue()/12;
        reel=recetteMois.getRecette().doubleValue();
        realisation=getValueRealisation();
        reelStr=ActeService.formatP(reel);
        budgetStr=ActeService.formatP(budget);
    }


    
    private Double getValueRealisation(){
        Double val=AdminService.arrondir((recetteMois.getRecette()/budget)*100);
        return val;
    }

    @Override
    public String toString() {
        return "Recette{" + "recetteMois=" + recetteMois + ", budget=" + budget + ", realisation=" + realisation + '}';
    }

    
    public RecetteMois getRecetteMois() {
        return recetteMois;
    }

    public void setRecetteMois(RecetteMois recetteMois) {
        this.recetteMois = recetteMois;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Double getRealisation() {
        return realisation;
    }

    public void setRealisation(Double realisation) {
        this.realisation = realisation;
    }

    public String getBudgetStr() {
        return budgetStr;
    }
    
    public void setBudgetStr(String budgetStr) {
        this.budgetStr = budgetStr;
    }

    public Double getReel() {
        return reel;
    }

    public String getReelStr() {
        return reelStr;
    }

    public void setReel(Double reel) {
        this.reel = reel;
    }

    public void setReelStr(String reelStr) {
        this.reelStr = reelStr;
    }
    
    
    
}
