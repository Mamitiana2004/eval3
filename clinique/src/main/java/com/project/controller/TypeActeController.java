package com.project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Patient;
import com.project.model.TypeActe;
import com.project.service.PatientService;
import com.project.service.TypeActeService;

@Controller
@RequestMapping("/typeActe")
public class TypeActeController {
    
    @GetMapping("/liste")
    public String getAll(Model model){
        ArrayList<TypeActe> type_acte=TypeActeService.getAll();
        model.addAttribute("type", type_acte);
        return "admin/crud/type_acte/liste";
    }

    @GetMapping("/add")
    public String add() {
        return "admin/crud/type_acte/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam String type) 
    {
        TypeActeService.insert(type);
        return "redirect:liste";
    }

    
    @PostMapping("/update")
    public String update(@RequestParam Integer id,
        @RequestParam String type) 
    {
        TypeActeService.update(id, type);
        return "redirect:liste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) 
    {
        TypeActeService.delete(id);
        return "redirect:/typeActe/liste";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model) 
    {
        TypeActe type=TypeActeService.getById(id);
        model.addAttribute("type",type);
        return "admin/crud/type_acte/update";
    }



}
