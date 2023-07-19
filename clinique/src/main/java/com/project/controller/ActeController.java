package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Patient;
import com.project.model.TypeActe;
import com.project.model.view.ActeV;
import com.project.service.ActeService;
import com.project.service.AdminService;
import com.project.service.PatientService;
import com.project.service.TypeActeService;
import com.project.service.UtilisateurService;

@Controller
@RequestMapping("/acte")
public class ActeController {
    
     @GetMapping("/liste")
    public String getAll(Model model,HttpSession session){
        ArrayList<ActeV> type_acte=ActeService.getAll();
        ArrayList<Patient> patients=PatientService.getAll();
        ArrayList<TypeActe> types=TypeActeService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("types",types);
        model.addAttribute("actes", type_acte);
        return AdminService.redirectConnect(session, "admin/crud/acte/liste");
    }




    @PostMapping("/add")
    public String add(@RequestParam Integer type,
    @RequestParam Integer patient,
    @RequestParam Integer prix,
    @RequestParam String dateActe,
    HttpSession session) 
    {
        ActeService.insert(type, patient, prix, dateActe);
        return UtilisateurService.redirectConnect(session, "redirect:/patient/addActe/"+patient);
    }

    @GetMapping("/facture/{id}")
    public String addUser(@PathVariable("id") Integer id,Model model,HttpSession session) 
    {
        ArrayList<ActeV> liste=ActeService.getByPatientNonValide(id);
        ActeService.valider(id);
        Patient p=PatientService.getById(id);
        Integer montantT=0;
        for (ActeV acte : liste) {
            montantT+=acte.getPrix();
        }
        Date date=new Date();
        model.addAttribute("actes", liste);
        model.addAttribute("patient", p);
        model.addAttribute("montantT", montantT);
        model.addAttribute("dateN", date);
        return UtilisateurService.redirectConnect(session, "user/acte/facture");
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id,
    @RequestParam Integer type,
    @RequestParam Integer patient,
    @RequestParam Integer prix,
    @RequestParam String dateActe,HttpSession session) 
    {
        ActeService.update(id, type, patient, prix, dateActe);
        return AdminService.redirectConnect(session, "redirect:liste");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,HttpSession session) 
    {
        ActeService.delete(id);
        return AdminService.redirectConnect(session, "redirect:/acte/liste");
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model,HttpSession session) 
    {
        ActeV acte=ActeService.getById(id);
        ArrayList<Patient> patients=PatientService.getAll();
        ArrayList<TypeActe> types=TypeActeService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("types",types);
        model.addAttribute("acte",acte);
        return AdminService.redirectConnect(session, "admin/crud/acte/update");
    }


}
