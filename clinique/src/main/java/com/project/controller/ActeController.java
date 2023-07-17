package com.project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Acte;
import com.project.model.Patient;
import com.project.model.TypeActe;
import com.project.model.view.ActeV;
import com.project.service.ActeService;
import com.project.service.PatientService;
import com.project.service.TypeActeService;

@Controller
@RequestMapping("/acte")
public class ActeController {
    
     @GetMapping("/liste")
    public String getAll(Model model){
        ArrayList<ActeV> type_acte=ActeService.getAll();
        ArrayList<Patient> patients=PatientService.getAll();
        ArrayList<TypeActe> types=TypeActeService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("types",types);
        model.addAttribute("actes", type_acte);
        return "admin/crud/acte/liste";
    }

    @GetMapping("/add")
    public String add(Model model) {
        ArrayList<Patient> patients=PatientService.getAll();
        ArrayList<TypeActe> types=TypeActeService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("types",types);
        return "admin/crud/acte/add";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        ArrayList<Patient> patients=PatientService.getAll();
        ArrayList<TypeActe> types=TypeActeService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("types",types);
        return "user/acte/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam Integer type,
    @RequestParam Integer patient,
    @RequestParam Integer prix,
    @RequestParam String dateActe) 
    {
        ActeService.insert(type, patient, prix, dateActe);
        return "redirect:liste";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam Integer type,
    @RequestParam Integer patient,
    @RequestParam Integer prix,
    @RequestParam String dateActe,
    Model model) 
    {
        ActeService.insert(type, patient, prix, dateActe);
        Patient patient2=PatientService.getById(patient);
        TypeActe typeActe=TypeActeService.getById(type);

        model.addAttribute("patient", patient2);
        model.addAttribute("type", typeActe);
        model.addAttribute("prix", prix);
        model.addAttribute("dateActe", dateActe);
        return "user/acte/facture";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id,
    @RequestParam Integer type,
    @RequestParam Integer patient,
    @RequestParam Integer prix,
    @RequestParam String dateActe) 
    {
        ActeService.update(id, type, patient, prix, dateActe);
        return "redirect:liste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) 
    {
        ActeService.delete(id);
        return "redirect:/acte/liste";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model) 
    {
        ActeV acte=ActeService.getById(id);
        ArrayList<Patient> patients=PatientService.getAll();
        ArrayList<TypeActe> types=TypeActeService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("types",types);
        model.addAttribute("acte",acte);
        return "admin/crud/acte/update";
    }


}
