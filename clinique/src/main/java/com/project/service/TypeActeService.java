/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.TypeActe;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author mamit
 */
public class TypeActeService {
    
    public static ArrayList<TypeActe> getAll(){
        try {
            return new TypeActe().getAll();
        } catch (Exception e) {
            System.err.println("TypeActe select : "+e.getMessage());
            return null;
        }
    }

    public static TypeActe getById(Integer id){
        try {
            TypeActe type=new TypeActe(id);
            return (TypeActe)type.getById();
        } catch (Exception e) {
            System.err.println("TypeActe getById :"+e.getMessage());
            return null;
        }
    }
    
    public static void insert(String type,BigDecimal budget,String code){
        try {
            TypeActe typeActe=new TypeActe(type,budget,code);
            typeActe.save();
        } catch (Exception e) {
            System.err.println("TypeActe save :"+e.getMessage());
        }
    }
    
    public static void update(Integer id,String type,BigDecimal budget,String code){
        try {
            TypeActe typeActe=new TypeActe(id,type,budget,code);
            typeActe.update();
        } catch (Exception e) {
            System.err.println("TypeActe update :"+e.getMessage());
        }
    }
    
    public static void delete(Integer id){
        try {
            TypeActe typeActe=new TypeActe(id);
            typeActe.delete();
        } catch (Exception e) {
            System.err.println("TypeActe delete :"+e.getMessage());
        }
    }
    
    
}
