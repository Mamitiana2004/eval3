package com.project.controller;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.model.Patient;
import com.project.model.TypeActe;
import com.project.service.PatientService;
import com.project.service.TypeActeService;
import com.project.util.PDF;

@Controller
public class RedirectController {

	@GetMapping("/")
    public String home(Model model) {
		model.addAttribute("pageTitle", "Index");
        return "index";
    }
	
	@GetMapping("/error")
	public String error() {
		return "error/error";
	}
	
	@GetMapping("/loginAdmin")
    public String Login() {
		return "admin/login";
    }

    @GetMapping("/utilisateur")
    public String acceuil(Model model){
        ArrayList<Patient> patients=PatientService.getAll();
        ArrayList<TypeActe> types=TypeActeService.getAll();
        model.addAttribute("patients",patients);
        model.addAttribute("types",types);
        return "user/acceuil";
    }


	@GetMapping("/pdf/{nom}/{type}/{prix}/{date}")
	public String genererFacture(@PathVariable("nom")String nom,
    @PathVariable("type")String type,
    @PathVariable("prix")Double prix,
    @PathVariable("date")String date,
    HttpServletResponse response)throws Exception
    {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date dateActe=format.parse(date);

        PDF.createInvoice(response, nom, type, prix, dateActe);

		return "user/acceuil";
	}
	
	
	
	
	
	
	
	
	
}
