/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.Depense;
import com.project.model.TypeActe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mamit
 */
public class DepenseService {
    
    public static ArrayList<Depense> getAll(){
        try {
            return new Depense().getAll();
        } catch (Exception e) {
            System.err.println("Depense select :"+e.getMessage());
            return null;
        }
    }

    public static Depense getById(Integer id){
        try {
            Depense depense=new Depense(id);
            return (Depense)depense.getById();
        } catch (Exception e) {
            System.err.println("Depense getById :"+e.getMessage());
            return null;
        }
    }
    
    public static void insert(String libelle,Integer prix,String dateDepense){
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date date=format.parse(dateDepense);
            Depense depense=new Depense(libelle, prix, date);
            depense.save();
        } catch (Exception e) {
            System.err.println("Depense save :"+e.getMessage());
        }
    }
    
    public static void update(Integer id,String libelle,Integer prix,String dateDepense){
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date date=format.parse(dateDepense);
            Depense depense=new Depense(id,libelle, prix, date);
            depense.update();
        } catch (Exception e) {
            System.err.println("Depense update :"+e.getMessage());
        }
    }
    
    public static void delete(Integer id){
        try {
            Depense depense=new Depense(id);
            depense.delete();
        } catch (Exception e) {
            System.err.println("Depense delete :"+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println(DepenseService.getAll());
    }
    
}
