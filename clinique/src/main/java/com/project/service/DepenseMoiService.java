/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.Mois;
import com.project.model.TypeActe;
import com.project.model.TypeDepense;
import com.project.model.view.DepenseM;
import com.project.model.view.DepenseMois;
import com.project.model.view.Recette;
import com.project.model.view.RecetteMois;
import java.util.ArrayList;

/**
 *
 * @author mamit
 */
public class DepenseMoiService {
    public static ArrayList<DepenseMois> getAll()throws Exception{
        return new RecetteMois().getAll();
    }
    
    public static DepenseMois getByMois(Integer type,Integer mois,Integer annee)throws Exception{
        DepenseMois recetteMois=new DepenseMois();
        recetteMois.setIdType(type);
        recetteMois.setIdMois(mois);
        recetteMois.setAnnee(annee.doubleValue());
        ArrayList<DepenseMois> listes=recetteMois.get("idtype","idmois","annee");
        if(listes.size()==1){
            return listes.get(0);
        }
        else{
            return null;
        }
    }
    
    public static ArrayList<DepenseMois> getByMois(Integer mois,Integer annee)throws Exception{
        DepenseMois recetteMois=new DepenseMois();
        recetteMois.setIdMois(mois);
        recetteMois.setAnnee(annee.doubleValue());
        return recetteMois.get("idmois","annee");
    }
    
    public static ArrayList<DepenseMois> getNonType(Integer mois,Integer annee)throws Exception{
        ArrayList<DepenseMois> depenseMoises=new ArrayList<>();
        ArrayList<DepenseMois> liste=DepenseMoiService.getByMois(mois, annee);
        ArrayList<TypeDepense> types=TypeDepenseService.getAll();
        if(liste.size()!=0){
            for (TypeDepense type : types) {
                boolean exist=false;
                for (DepenseMois depenseMois : liste) {
                    if(type.getId()==depenseMois.getIdType()){
                        exist=true;
                    }
                }
                if(!exist){
                    DepenseMois recet=new DepenseMois(mois,new Mois().getMois(mois), annee.doubleValue(), type.getId(), type.getLibelle(), (long)0);
                    depenseMoises.add(recet);
                }
            }
        }
        else{
            for (TypeDepense type : types) {
                DepenseMois recet=new DepenseMois(mois,new Mois().getMois(mois), annee.doubleValue(), type.getId(), type.getLibelle(), (long)0);
                depenseMoises.add(recet);
            }
        }
        return depenseMoises;
    }
    
     public static ArrayList<DepenseM> listeDepense(Integer mois,Integer annee)throws Exception{
        ArrayList<DepenseMois> existant=DepenseMoiService.getByMois(mois, annee);
        ArrayList<DepenseM> depenseMs=new ArrayList<>();
        ArrayList<DepenseMois> inexistant=DepenseMoiService.getNonType(mois, annee);
        for (DepenseMois depenseMois : existant) {
            DepenseM recette=new DepenseM(depenseMois);
            depenseMs.add(recette);
        }
        for (DepenseMois depenseMois : inexistant) {
            DepenseM recette=new DepenseM(depenseMois);
            depenseMs.add(recette);
        }
        return depenseMs;
    }
    
    
    public static void main(String[] args) throws Exception{
        ArrayList<DepenseM> li=DepenseMoiService.listeDepense(3, 2003);
        for (DepenseM depenseM : li) {
            System.out.println(depenseM);
        }
    }
}
