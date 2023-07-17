package com.project.service;


import java.util.ArrayList;

import com.project.model.Admin;
import com.project.util.Cryptage;

public class AdminService {
	
	public static int login(String identifiant,String password) throws Exception{
        ArrayList<Admin> admins=new Admin().getAll();
        for (Admin admin : admins) {
            if(admin.getIdentifiant().compareTo(identifiant)==0){
                if(admin.getPassword().compareTo(Cryptage.Md5(password))==0){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        }
        return 2;
    }
	
	public static Admin getAdminConnecter(String identifiant,String password) throws Exception{
        ArrayList<Admin> admins=new Admin().getAll();
        for (Admin admin : admins) {
            if(admin.getIdentifiant().compareTo(identifiant)==0){
                if(admin.getPassword().compareTo(Cryptage.Md5(password))==0){
                    return admin;
                }
            }
        }
        return null;
    }
	
	
	
	
}
