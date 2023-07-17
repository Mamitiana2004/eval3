package com.project.controller;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.view.Budget;
import com.project.service.AdminService;
import com.project.service.BudgetService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@PostMapping("/login")
	public String login(@RequestParam("identifiant")String identifiant,@RequestParam("password")String password,Model model) throws Exception {
		switch (AdminService.login(identifiant, password)) {
		case 0: {
			return "redirect:/admin/acceuil";
		}
		case 1:{
			model.addAttribute("errorPassword","Mot de passe incorrect");
			return "admin/login";
		}
		case 2:{
			model.addAttribute("errorIdentifiant","Identifiant inconnue");
			return "admin/login";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + AdminService.login(identifiant, password));
		}
		
		
	}
	
	@GetMapping("/acceuil")
	public String home(Model model) {
		ArrayList<Budget> budget=BudgetService.getAll();
		model.addAttribute("budgets", budget);
		return "admin/acceuil";
	}
}
