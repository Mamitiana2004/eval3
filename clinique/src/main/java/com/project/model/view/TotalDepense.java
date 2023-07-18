/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model.view;

import java.util.ArrayList;

/**
 *
 * @author mamit
 */
public class TotalDepense {
    
    Long reel;
    
    Long budget;
    
    Double realisation;
    
    
    public TotalDepense(ArrayList<DepenseM> depenses){
        reel=(long)0;
        budget=(long)0;
        for (DepenseM recette : depenses) {
            reel=reel+recette.getDepenseMois().getDepense();
            budget=budget+recette.getBudget().longValue();
        }
        realisation=getValueRealisation();
    }
    
    private Double getValueRealisation(){
        Double val=(double)Math.round(((reel.doubleValue()/budget.doubleValue())*100));
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

    
}
