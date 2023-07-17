/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.Patient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mamit
 */
public class PatientService {
    
    public static ArrayList<Patient> getAll(){
        try {
            return new Patient().getAll();
        } catch (Exception ex) {
            System.err.println("Patient insert :"+ex.getMessage());
            return null;
        }
    } 

    public static Patient getById(Integer id){
        try {
            Patient patient=new Patient(id);
            return (Patient)patient.getById();
        } catch (Exception e) {
            System.err.println("Patient gerByid : "+e.getMessage());
            return null;
        }
    }
    
    public static void insert(String nom,String dateNaissance,String genre,Boolean remboursement){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=format.parse(dateNaissance);
            Patient patient=new Patient(nom, date, genre, remboursement);
            patient.save();
        } catch (Exception e) {
            System.err.println("Patient save :"+e.getMessage());
        }
    }
    
    public static void update(Integer id,String nom,String dateNaissance,String genre,Boolean remboursement){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=format.parse(dateNaissance);
            Patient patient=new Patient(id,nom, date, genre, remboursement);
            patient.update();
        } catch (Exception e) {
            System.err.println("Patient update :"+e.getMessage());
        }
    }
    
    public static void delete(Integer id){
        try {
            Patient patient=new Patient(id);
            patient.delete();
        } catch (Exception e) {
            System.err.println("Patient delete :"+e.getMessage());
        }
    }

    public static boolean getRemboursement(int r){
        return r==1;
    }
    
    
    
}
