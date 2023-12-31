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

import com.project.model.TypeActe;
import com.project.service.AdminService;
import com.project.service.TypeActeService;

@Controller
@RequestMapping("/typeActe")
public class TypeActeController {
    
    @GetMapping("/liste")
    public String getAll(Model model,HttpSession session){
        ArrayList<TypeActe> type_acte=TypeActeService.getAll();
        model.addAttribute("type", type_acte);
        return AdminService.redirectConnect(session, "admin/crud/type_acte/liste");
    }

    @PostMapping("/add")
    public String add(@RequestParam String type,
    @RequestParam String budget,
    @RequestParam String code) 
    {
        BigDecimal bu=new BigDecimal(budget);
        TypeActeService.insert(type,bu,code);
        return "redirect:liste";
    }

    
    @PostMapping("/update")
    public String update(@RequestParam Integer id,
        @RequestParam String type,
        @RequestParam String budget,
        @RequestParam String code) 
    {
        BigDecimal bu=new BigDecimal(budget);
        TypeActeService.update(id, type,bu,code);
        return "redirect:liste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,HttpSession session) 
    {
        TypeActeService.delete(id);
        return AdminService.redirectConnect(session, "redirect:/typeActe/liste");
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model,HttpSession session) 
    {
        TypeActe type=TypeActeService.getById(id);
        model.addAttribute("type",type);
        return AdminService.redirectConnect(session, "admin/crud/type_acte/update");
    }



}
