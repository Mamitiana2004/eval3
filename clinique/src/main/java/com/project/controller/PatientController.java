package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Patient;
import com.project.service.PatientService;
import java.util.ArrayList;


@Controller
@RequestMapping("/patient")
public class PatientController {
    
    @GetMapping("/liste")
    public String getAll(Model model) {
        ArrayList<Patient> patients=PatientService.getAll();
        model.addAttribute("patients", patients);
        return "admin/crud/patient/liste";
    }

    @GetMapping("/add")
    public String add() {
        return "admin/crud/patient/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam String nom,
        @RequestParam String dateNaissance,
        @RequestParam String genre,
        @RequestParam int remboursement) 
    {
        PatientService.insert(nom, dateNaissance, genre, PatientService.getRemboursement(remboursement));
        return "redirect:liste";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id,
        @RequestParam String nom,
        @RequestParam String dateNaissance,
        @RequestParam String genre,
        @RequestParam int remboursement) 
    {
        PatientService.update(id,nom, dateNaissance, genre, PatientService.getRemboursement(remboursement));
        return "redirect:liste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) 
    {
        PatientService.delete(id);
        return "redirect:/patient/liste";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model) 
    {
        Patient patient=PatientService.getById(id);
        model.addAttribute("patient",patient);
        return "admin/crud/patient/update";
    }


    


}
