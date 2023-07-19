/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.Acte;
import com.project.model.TypeActe;
import com.project.model.view.ActeV;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mamit
 */
public class ActeService {
    
    
    public static ArrayList<ActeV> getAll(){
        try {
            return new ActeV().getAll();
        } catch (Exception e) {
            System.err.println("Acte select : "+e.getMessage());
            return null;
        }
    }

    public static ArrayList<ActeV> getByPatientNonValide(Integer patient){
        try {
            ActeV acte=new ActeV();
            acte.setIdPatient(patient);
            acte.setValide(false);
            return (ArrayList<ActeV>)acte.get("idPatient","valide");
        } catch (Exception e) {
            System.err.println("Acte select : "+e.getMessage());
            return null;
        }
    }


    public static String formatP(Double val){
        DecimalFormat decimal=new DecimalFormat("#,##0.00");
        return decimal.format(val);
    }

    public static ActeV getById(Integer id){
        try {
            ActeV acte=new ActeV(id);
            return (ActeV)acte.getById();
        } catch (Exception e) {
            System.err.println("TypeActe getById :"+e.getMessage());
            return null;
        }
    }

    public static Acte getByIdT(Integer id){
        try {
            Acte acte=new Acte(id);
            return (Acte)acte.getById();
        } catch (Exception e) {
            System.err.println("TypeActe getById :"+e.getMessage());
            return null;
        }
    }
    
    public static void insert(Integer type_acte,Integer patient,Integer prix,String dateActe){
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date date=format.parse(dateActe);
            Acte acte=new Acte(type_acte, patient, prix, date,false);
            acte.save();
        } catch (Exception e) {
            System.err.println("Acte save : "+e.getMessage());
        }
    }

    public static void valider(Integer patient){
        try {
            ArrayList<ActeV> actes=ActeService.getByPatientNonValide(patient);
            for (ActeV acteV : actes) {
                Acte acte=ActeService.getByIdT(acteV.getId());
                acte.setValide(true);
                acte.update();
            }
        } catch (Exception e) {
            System.err.println("Acte save : "+e.getMessage());
        }
    }
    
    public static void update(Integer id,Integer type_acte,Integer patient,Integer prix,String dateActe){
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date date=format.parse(dateActe);
            Acte acte=new Acte(id,type_acte, patient, prix, date,true);
            acte.update();
        } catch (Exception e) {
            System.err.println("Acte update : "+e.getMessage());
        }
    }
    
    public static void delete(Integer id){
        try {
            Acte acte=new Acte(id);
            acte.delete();
        } catch (Exception e) {
            System.err.println("Acte delete : "+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println(ActeService.getAll());
    }
    
}
