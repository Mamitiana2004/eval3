package com.project.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.project.model.TypeDepense;

public class TypeDepenseService {
    
    public static ArrayList<TypeDepense> getAll(){
        try {
            return new TypeDepense().getAll();
        } catch (Exception e) {
            System.err.println("TypeDepense select : "+e.getMessage());
            return null;
        }
    }

    public static TypeDepense getById(Integer id){
        try {
            TypeDepense type=new TypeDepense(id);
            return (TypeDepense)type.getById();
        } catch (Exception e) {
            System.err.println("TypeDepense select : "+e.getMessage());
            return null;
        }
    }
    
    public static void insert(String type,BigDecimal budget,String code){
        try {
            TypeDepense typeDepense=new TypeDepense(type,budget,code);
            typeDepense.save();
        } catch (Exception e) {
            System.err.println("TypeDepense save :"+e.getMessage());
        }
    }
    
    public static void update(Integer id,String type,BigDecimal budget,String code){
        try {
            TypeDepense typeActe=new TypeDepense(id,type,budget,code);
            typeActe.update();
        } catch (Exception e) {
            System.err.println("TypeDepense update :"+e.getMessage());
        }
    }
    
    public static void delete(Integer id){
        try {
            TypeDepense typeActe=new TypeDepense(id);
            typeActe.delete();
        } catch (Exception e) {
            System.err.println("TypeActe delete :"+e.getMessage());
        }
    }

    public static Integer getIdByCode(String code){
        try {
            ArrayList<TypeDepense> type=TypeDepenseService.getAll();
            for (TypeDepense typeDepense : type) {
                if(typeDepense.getCode().compareTo(code)==0){
                    return typeDepense.getId();
                }
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
