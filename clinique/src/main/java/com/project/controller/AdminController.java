package com.project.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Mois;
import com.project.model.view.DepenseM;
import com.project.model.view.Recette;
import com.project.model.view.TotalDepense;
import com.project.model.view.TotalRecette;
import com.project.service.ActeService;
import com.project.service.AdminService;
import com.project.service.DepenseMoiService;
import com.project.service.RecetteMoiService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@PostMapping("/login")
	public String login(@RequestParam("identifiant")String identifiant,@RequestParam("password")String password,Model model,HttpSession session) throws Exception {
		switch (AdminService.login(identifiant, password)) {
		case 0: {
			session.setAttribute("idAdmin",AdminService.getAdminConnecter(identifiant, password).getId());
			return "redirect:/admin/acceuil";
		}
		case 1:{
			model.addAttribute("errorPassword","Mot de passe incorrect.");
			return "admin/login";
		}
		case 2:{
			model.addAttribute("errorIdentifiant","Identifiant incorrect.");
			return "admin/login";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + AdminService.login(identifiant, password));
		}
		
		
	}
	
	@GetMapping("/acceuil")
	public String home(Model model,HttpSession session) throws Exception{
		@SuppressWarnings("unchecked")
        ArrayList<Mois> mois=new Mois().getAll();
        model.addAttribute("mois", mois);
		return AdminService.redirectConnect(session, "admin/acceuil");
	}


	@PostMapping("/filtrer")
	public String filter(
		Model model,
		@RequestParam Integer mois,
		@RequestParam Integer annee,HttpSession session) 
	throws Exception{
		ArrayList<Recette> recettes=RecetteMoiService.listeRecette(mois, annee);
		TotalRecette totalRecette=new TotalRecette(recettes);
		model.addAttribute("recettes",recettes);
		model.addAttribute("totalRecettes",totalRecette);

		ArrayList<DepenseM> depenses=DepenseMoiService.listeDepense(mois, annee);
		TotalDepense totalDepense=new TotalDepense(depenses);
		model.addAttribute("depenses",depenses);
		model.addAttribute("totalDepenses",totalDepense);


		Long beneficeReel=(totalRecette.getReel()-totalDepense.getReel());
		Long benificeBudget=(totalRecette.getBudget()-totalDepense.getBudget());

		Double totalReal=AdminService.arrondir((beneficeReel.doubleValue()/benificeBudget.doubleValue())*100);

		
		model.addAttribute("br",ActeService.formatP(beneficeReel.doubleValue()));
		model.addAttribute("bb",ActeService.formatP(benificeBudget.doubleValue()));
		model.addAttribute("bre",totalReal);
        
		
		@SuppressWarnings("unchecked")
        ArrayList<Mois> mo=new Mois().getAll();
        model.addAttribute("mois", mo);
		String filter=new Mois().getMois(mois)+" "+annee;
        model.addAttribute("fil", filter);
		return AdminService.redirectConnect(session, "admin/crud/Recette");
	}
}
