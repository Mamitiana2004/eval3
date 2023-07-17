package com.project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Depense;
import com.project.model.TypeActe;
import com.project.service.DepenseService;
import com.project.service.TypeActeService;

@Controller
@RequestMapping("/depense")
public class DepenseController {
    
    @GetMapping("/liste")
    public String getAll(Model model){
        ArrayList<Depense> depense=DepenseService.getAll();
        model.addAttribute("depenses", depense);
        return "admin/crud/depense/liste";
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "user/depense/add";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String libelle,
    @RequestParam Integer prix,
    @RequestParam String dateDepense) 
    {
        DepenseService.insert(libelle, prix, dateDepense);
        return "user/acceuil";
    }

    @GetMapping("/add")
    public String add() {
        return "admin/crud/depense/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam String libelle,
    @RequestParam Integer prix,
    @RequestParam String dateDepense) 
    {
        DepenseService.insert(libelle, prix, dateDepense);
        return "redirect:liste";
    }

    
    @PostMapping("/update")
    public String update(@RequestParam Integer id,
    @RequestParam String libelle,
    @RequestParam Integer prix,
    @RequestParam String dateDepense) 
    {
        DepenseService.update(id, libelle, prix, dateDepense);;
        return "redirect:liste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) 
    {
        DepenseService.delete(id);
        return "redirect:/depense/liste";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model) 
    {
        Depense depense=DepenseService.getById(id);
        model.addAttribute("depense",depense);
        return "admin/crud/depense/update";
    }

}
