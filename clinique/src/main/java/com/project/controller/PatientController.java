package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Patient;
import com.project.model.TypeActe;
import com.project.model.view.ActeV;
import com.project.service.ActeService;
import com.project.service.AdminService;
import com.project.service.PatientService;
import com.project.service.TypeActeService;
import com.project.service.UtilisateurService;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/patient")
public class PatientController {
    
    @GetMapping("/liste")
    public String getAll(Model model,HttpSession session) {
        ArrayList<Patient> patients=PatientService.getAll();
        model.addAttribute("patients", patients);
        return AdminService.redirectConnect(session, "admin/crud/patient/liste");
    }


    @PostMapping("/add")
    public String add(@RequestParam String nom,
        @RequestParam String dateNaissance,
        @RequestParam String genre,
        @RequestParam int remboursement,
        HttpSession session) 
    {
        PatientService.insert(nom, dateNaissance, genre, PatientService.getRemboursement(remboursement));
        return AdminService.redirectConnect(session, "redirect:liste");
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id,
        @RequestParam String nom,
        @RequestParam String dateNaissance,
        @RequestParam String genre,
        @RequestParam int remboursement,
        HttpSession session) 
    {
        PatientService.update(id,nom, dateNaissance, genre, PatientService.getRemboursement(remboursement));
        return AdminService.redirectConnect(session, "redirect:liste");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,HttpSession session) 
    {
        PatientService.delete(id);
        return AdminService.redirectConnect(session, "redirect:/patient/liste");
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model,HttpSession session) 
    {
        Patient patient=PatientService.getById(id);
        model.addAttribute("patient",patient);
        return AdminService.redirectConnect(session, "admin/crud/patient/update");
    }


    @GetMapping("/addActe/{id}")
    public String addActe(@PathVariable("id") int id,Model model,HttpSession session) 
    {
        Patient patient=PatientService.getById(id);
        model.addAttribute("patient",patient);
        ArrayList<ActeV> type_acte=ActeService.getByPatientNonValide(id);
        model.addAttribute("actes", type_acte);
        ArrayList<TypeActe> types=TypeActeService.getAll();
        model.addAttribute("types",types);
        return UtilisateurService.redirectConnect(session, "user/acte/add");
    }


    


}
