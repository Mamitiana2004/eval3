package com.project.service;

import java.util.ArrayList;

import com.project.model.view.Budget;

public class BudgetService {
    
    public static ArrayList<Budget> getAll(){
        try {
            return new Budget().getAll();
        } catch (Exception e) {
            System.err.println("Budget select : "+e.getMessage());
            return null;
        }
    }

}
