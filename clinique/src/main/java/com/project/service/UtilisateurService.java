package com.project.service;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.project.model.Utilisateur;
import com.project.util.Cryptage;

public class UtilisateurService {
	
	public static int login(String identifiant,String password) throws Exception{
        @SuppressWarnings("unchecked")
        ArrayList<Utilisateur> utilisateurs=new Utilisateur().getAll();
        for (Utilisateur utilisateur : utilisateurs) {
            if(utilisateur.getIdentifiant().compareTo(identifiant)==0){
                if(utilisateur.getPassword().compareTo(Cryptage.Md5(password))==0){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        }
        return 2;
    }
	
	public static Utilisateur getConnecter(String identifiant,String password) throws Exception{
        @SuppressWarnings("unchecked")
        ArrayList<Utilisateur> utilisateurs=new Utilisateur().getAll();
        for (Utilisateur utilisateur : utilisateurs) {
            if(utilisateur.getIdentifiant().compareTo(identifiant)==0){
                if(utilisateur.getPassword().compareTo(Cryptage.Md5(password))==0){
                    return utilisateur;
                }
            }
        }
        return null;
    }

    public static String redirectConnect(HttpSession session,String page){
        if(session.getAttribute("idEmp")==null){
            return "redirect:/loginEmploye";
        }
        else{
            return page;
        }
    }
	
	
	
	
}
