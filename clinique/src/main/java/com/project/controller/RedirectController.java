package com.project.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.model.Patient;
import com.project.service.PatientService;
import com.project.service.UtilisateurService;

@Controller
public class RedirectController {

	@GetMapping("/")
    public String home(Model model,HttpSession session) {
        session.removeAttribute("idAdmin");
        session.removeAttribute("idEmploye");
		model.addAttribute("pageTitle", "Index");
        return "index";
    }

	@GetMapping("/loginAdmin")
    public String Login() {
		return "admin/login";
    }

    @GetMapping("/utilisateur")
    public String acceuil(Model model,HttpSession session){
        ArrayList<Patient> patients=PatientService.getAll();
        model.addAttribute("patients",patients);
        return UtilisateurService.redirectConnect(session, "user/acceuil");
    }

    @GetMapping("/loginEmploye")
    public String loginEmploye(){
        return "user/login";
    }


	
	
	
}
