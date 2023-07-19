package com.project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.Mois;
import com.project.model.TypeDepense;
import com.project.model.view.DepenseV;
import com.project.service.AdminService;
import com.project.service.DepenseService;
import com.project.service.TypeDepenseService;
import com.project.service.UtilisateurService;

@Controller
@RequestMapping("/depense")
public class DepenseController {
    
    @GetMapping("/liste")
    public String getAll(Model model,HttpSession session){
        ArrayList<DepenseV> depense=DepenseService.getAll();
        ArrayList<TypeDepense> type=TypeDepenseService.getAll();
        model.addAttribute("depenses", depense);
        model.addAttribute("types", type);
        return AdminService.redirectConnect(session, "admin/crud/depense/liste");
    }

    @GetMapping("/addUser")
    public String addUser(Model model,HttpSession session)throws Exception {
        ArrayList<TypeDepense> type=TypeDepenseService.getAll();
        @SuppressWarnings("unchecked")
        ArrayList<Mois> mois=new Mois().getAll();
        model.addAttribute("types", type);
        model.addAttribute("mois", mois);
        return UtilisateurService.redirectConnect(session, "user/depense/add");
    }


    @PostMapping("/addDepense")
    public String addDepense(@RequestParam Integer type,
    @RequestParam Integer jour,
    @RequestParam List<Integer> mois,
    @RequestParam Integer annee,
    @RequestParam Integer prix,HttpSession session) throws Exception
    {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        for (Integer moi : mois) {
            Date date=DepenseService.genererDateM(jour,moi,annee);
            DepenseService.insert(type, prix, format.format(date));
        }
        return UtilisateurService.redirectConnect(session,"redirect:addUser");
    }

 

    
    @PostMapping("/update")
    public String update(@RequestParam Integer id,
    @RequestParam Integer type,
    @RequestParam Integer prix,
    @RequestParam String dateDepense) 
    {
        DepenseService.update(id, type, prix, dateDepense);;
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
        DepenseV depense=DepenseService.getById(id);
        ArrayList<TypeDepense> type=TypeDepenseService.getAll();
        model.addAttribute("types", type);
        model.addAttribute("depense",depense);
        return "admin/crud/depense/update";
    }



    @PostMapping("/importCSV")
    public String importCSV(@RequestParam MultipartFile file){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(file.getInputStream()));
            List<String[]> data =new ArrayList<>();
            String line;
            while((line=br.readLine())!=null){
                    String[] row = line.split(";");
                    data.add(row);
            }
            DepenseService.getDepense(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:addUser";
    }

}
