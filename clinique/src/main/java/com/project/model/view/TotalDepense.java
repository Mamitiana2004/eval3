/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model.view;

import java.util.ArrayList;

import com.project.service.ActeService;
import com.project.service.AdminService;

/**
 *
 * @author mamit
 */
public class TotalDepense {
    
    Long reel;

    String reelStr;
    
    Long budget;

    String budgetStr;
    
    Double realisation;
    
    
    public TotalDepense(ArrayList<DepenseM> depenses){
        reel=(long)0;
        budget=(long)0;
        for (DepenseM recette : depenses) {
            reel=reel+recette.getDepenseMois().getDepense();
            budget=budget+recette.getBudget().longValue();
        }
        realisation=getValueRealisation();
        reelStr=ActeService.formatP(reel.doubleValue());
        budgetStr=ActeService.formatP(budget.doubleValue());
    }
    
    private Double getValueRealisation(){
        Double val=AdminService.arrondir((reel.doubleValue()/budget.doubleValue())*100);
        return val;
    }

    public Long getReel() {
        return reel;
    }

    public void setReel(Long reel) {
        this.reel = reel;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
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
        return "TotalDepense{" + "reel=" + reel + ", budget=" + budget + ", realisation=" + realisation + '}';
    }

    
    public String getBudgetStr() {
        return budgetStr;
    }
    
    public void setBudgetStr(String budgetStr) {
        this.budgetStr = budgetStr;
    }


    public String getReelStr() {
        return reelStr;
    }

    

    public void setReelStr(String reelStr) {
        this.reelStr = reelStr;
    }

    
}
