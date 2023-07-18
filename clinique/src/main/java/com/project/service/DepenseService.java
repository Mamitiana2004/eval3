/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.Depense;
import com.project.model.TypeActe;
import com.project.model.view.DepenseV;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mamit
 */
public class DepenseService {
    
    public static ArrayList<DepenseV> getAll(){
        try {
            return new DepenseV().getAll();
        } catch (Exception e) {
            System.err.println("Depense select :"+e.getMessage());
            return null;
        }
    }

    public static DepenseV getById(Integer id){
        try {
            DepenseV depense=new DepenseV(id);
            return (DepenseV)depense.getById();
        } catch (Exception e) {
            System.err.println("Depense getById :"+e.getMessage());
            return null;
        }
    }
    
    public static void insert(Integer type,Integer prix,String dateDepense){
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date date=format.parse(dateDepense);
            Depense depense=new Depense(type, prix, date);
            depense.save();
        } catch (Exception e) {
            System.err.println("Depense save :"+e.getMessage());
        }
    }
    
    public static void update(Integer id,Integer type,Integer prix,String dateDepense){
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date date=format.parse(dateDepense);
            Depense depense=new Depense(id,type, prix, date);
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

    public static void getDepense(List<String[]> datas) throws Exception{
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        for (String[] data : datas) {
            System.out.println(data.length);
            if(data.length==3){
                Date date=format.parse(data[0]);
                Integer montant=Integer.parseInt(data[2]);
                Integer type=TypeDepenseService.getIdByCode(data[1]);
                System.out.println(date +" "+montant+" "+type);
                if(date!=null && type != 0){
                    Depense depense=new Depense(type, montant, date);
                    depense.save();
                }
                
            }
        }
    }
    
    
}
