package com.project.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.TypeDepense;
import com.project.service.AdminService;
import com.project.service.TypeDepenseService;

@Controller
@RequestMapping("/typeDepense")
public class TypeDepenseController {
    
    @GetMapping("/liste")
    public String getAll(Model model,HttpSession session){
        ArrayList<TypeDepense> type_acte=TypeDepenseService.getAll();
        model.addAttribute("type", type_acte);
        return AdminService.redirectConnect(session, "admin/crud/type_depense/liste");
    }


    @PostMapping("/add")
    public String add( @RequestParam String type,
    @RequestParam String budget,
    @RequestParam String code) 
    {
        BigDecimal bu=new BigDecimal(budget);
        TypeDepenseService.insert(type,bu,code);
        return "redirect:liste";
    }

    
    @PostMapping("/update")
    public String update(@RequestParam Integer id,
    @RequestParam String type,
    @RequestParam String budget,
    @RequestParam String code) 
    {
        BigDecimal bu=new BigDecimal(budget);
        TypeDepenseService.update(id, type,bu,code);
        return "redirect:liste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) 
    {
        TypeDepenseService.delete(id);
        return "redirect:/typeDepense/liste";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model,HttpSession session) 
    {
        TypeDepense type=TypeDepenseService.getById(id);
        model.addAttribute("type",type);
        return AdminService.redirectConnect(session, "admin/crud/type_depense/update");
    }


}
