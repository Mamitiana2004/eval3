/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.Mois;
import com.project.model.TypeActe;
import com.project.model.view.Recette;
import com.project.model.view.RecetteMois;
import java.util.ArrayList;

/**
 *
 * @author mamit
 */
public class RecetteMoiService {
    
    public static ArrayList<RecetteMois> getAll()throws Exception{
        return new RecetteMois().getAll();
    }
    
    public static RecetteMois getByMois(Integer type,Integer mois,Integer annee)throws Exception{
        RecetteMois recetteMois=new RecetteMois();
        recetteMois.setIdType(type);
        recetteMois.setIdMois(mois);
        recetteMois.setAnnee(annee.doubleValue());
        ArrayList<RecetteMois> listes=recetteMois.get("idtype","idmois","annee");
        if(listes.size()==1){
            return listes.get(0);
        }
        else{
            return null;
        }
    }
    
    public static ArrayList<RecetteMois> getByMois(Integer mois,Integer annee)throws Exception{
        RecetteMois recetteMois=new RecetteMois();
        recetteMois.setIdMois(mois);
        recetteMois.setAnnee(annee.doubleValue());
        return recetteMois.get("idmois","annee");
    }
    
    public static ArrayList<RecetteMois> getNonType(Integer mois,Integer annee)throws Exception{
        ArrayList<RecetteMois> recetteMoises=new ArrayList<>();
        ArrayList<RecetteMois> liste=RecetteMoiService.getByMois(mois, annee);
        ArrayList<TypeActe> types=TypeActeService.getAll();
        if(liste.size()!=0){
            for (TypeActe type : types) {
                boolean exist=false;
                for (RecetteMois recetteMois : liste) {
                    if(type.getId()==recetteMois.getIdType()){
                        exist=true;
                    }
                }
                if(!exist){
                    RecetteMois recet=new RecetteMois(mois,new Mois().getMois(mois), annee.doubleValue(), type.getId(), type.getType(), (long)0);
                    recetteMoises.add(recet);
                }
            }
        }
        else{
            for (TypeActe type : types) {
                RecetteMois recet=new RecetteMois(mois,new Mois().getMois(mois), annee.doubleValue(), type.getId(), type.getType(), (long)0);
                recetteMoises.add(recet);
            }
        }
        return recetteMoises;
    }
    
    public static ArrayList<Recette> listeRecette(Integer mois,Integer annee)throws Exception{
        ArrayList<RecetteMois> existant=RecetteMoiService.getByMois(mois, annee);
        ArrayList<Recette> recettes=new ArrayList<>();
        ArrayList<RecetteMois> inexistant=RecetteMoiService.getNonType(mois, annee);
        for (RecetteMois recetteMois : existant) {
            Recette recette=new Recette(recetteMois);
            recettes.add(recette);
        }
        for (RecetteMois recetteMois : inexistant) {
            Recette recette=new Recette(recetteMois);
            recettes.add(recette);
        }
        return recettes;
    }
    
    public static void main(String[] args) throws Exception{
        ArrayList<Recette> liste=RecetteMoiService.listeRecette(7,2004);
        for (Recette recette : liste) {
            System.out.println(recette);
        }
    }
}
