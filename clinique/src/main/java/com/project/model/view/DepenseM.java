/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model.view;

import com.project.model.TypeActe;
import com.project.model.TypeDepense;
import com.project.service.TypeActeService;
import com.project.service.TypeDepenseService;

/**
 *
 * @author mamit
 */
public class DepenseM {
    
    DepenseMois depenseMois;
    
    Double budget;
    
    Double realisation;
    
    public DepenseM(DepenseMois depenseMois){
        this.depenseMois=depenseMois;
        TypeDepense type=TypeDepenseService.getById(depenseMois.getIdType());
        budget=type.getBudget().doubleValue()/12;
        realisation=reealisation();
    }
    
    private Double reealisation(){
        Double val=(double)Math.round(((depenseMois.getDepense()/budget)*100));
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

   
    

    
}
