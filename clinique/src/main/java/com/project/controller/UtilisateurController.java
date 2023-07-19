package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.UtilisateurService;


@Controller
@RequestMapping("/user")
public class UtilisateurController {
	
	@PostMapping("/login")
	public String login(@RequestParam("identifiant")String identifiant,@RequestParam("password")String password,Model model,HttpSession session) throws Exception {
		switch (UtilisateurService.login(identifiant, password)) {
		case 0: {
			session.setAttribute("idEmp",UtilisateurService.getConnecter(identifiant, password).getId());
			return "redirect:/utilisateur";
		}
		case 1:{
			model.addAttribute("errorPassword","Mot de passe incorrect.");
			return "user/login";
		}
		case 2:{
			model.addAttribute("errorIdentifiant","Identifiant incorrect.");
			return "user/login";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + UtilisateurService.login(identifiant, password));
		}
		
		
	}
		
}
