/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model.view;

import com.project.model.TypeDepense;
import com.project.service.ActeService;
import com.project.service.AdminService;
import com.project.service.TypeDepenseService;

/**
 *
 * @author mamit
 */
public class DepenseM {
    
    DepenseMois depenseMois;

    Double reel;

    String reelStr;
    
    Double budget;

    String budgetStr;
    
    Double realisation;
    
    public DepenseM(DepenseMois depenseMois){
        this.depenseMois=depenseMois;
        TypeDepense type=TypeDepenseService.getById(depenseMois.getIdType());
        budget=type.getBudget().doubleValue()/12;
        reel=depenseMois.getDepense().doubleValue();
        realisation=reealisation();
        reelStr=ActeService.formatP(reel);
        budgetStr=ActeService.formatP(budget);
    }
    
    private Double reealisation(){
        Double val=AdminService.arrondir((depenseMois.getDepense()/budget)*100);
        return val;
    }

    public DepenseMois getDepenseMois() {
        return depenseMois;
    }

    public void setDepenseMois(DepenseMois depenseMois) {
        this.depenseMois = depenseMois;
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

    @Override
    public String toString() {
        return "DepenseM{" + "depenseMois=" + depenseMois + ", budget=" + budget + ", realisation=" + realisation + '}';
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
