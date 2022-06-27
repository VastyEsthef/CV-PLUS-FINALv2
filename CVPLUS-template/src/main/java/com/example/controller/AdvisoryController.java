package com.example.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Advisory;
import com.example.service.AdvisoryService;
import com.example.service.ServicioXAdviserService;
import com.example.service.StudentService;

@Controller
@RequestMapping("/views/students/advisory")
public class AdvisoryController {
	
	private StudentService studentService;
	private AdvisoryService advisoryservice;
	private ServicioXAdviserService sxa_service;


    public AdvisoryController(StudentService studentService, AdvisoryService advisoryservice, ServicioXAdviserService servicioxadviserservice) {
        
    	this.studentService = studentService;
    	this.advisoryservice = advisoryservice;
        this.sxa_service = servicioxadviserservice;
        
    }
    
    @GetMapping("/list")
	public String showAllAdvisory(Model model) {
    	
    	try {
    		model.addAttribute("advisory", new Advisory());
    		model.addAttribute("advisory_collection", advisoryservice.getAllAdvisory());
    		
    	} catch (Exception e) {
    		model.addAttribute("error", e.getMessage());
    	}
    	
		return "views/students/list_advisories"; 
	}
    
    @GetMapping("/new")
	public String registrarAdvisory(Model model) {
    	
    	model.addAttribute("titulo", "Registro de Asesorías");
		model.addAttribute("advisory", new Advisory());
		model.addAttribute("students", studentService.getAllStudent());
		model.addAttribute("servicioAdvisers", sxa_service.getAllSxA());
		return "views/students/create_advisories";
	}
    
	
	@PostMapping("/save")
	public String saveAdvisory(@Validated Advisory advisory, BindingResult result, Model model) throws Exception {
		
		if (result.hasErrors()) {
			
			model.addAttribute("students", studentService.getAllStudent());
			model.addAttribute("servicioAdvisers", sxa_service.getAllSxA());
			System.out.println("Hay errores en el formulario");
			return "views/students/create_advisories";
		} else {
			System.out.println("Asesoría registrada con éxito");
			
			advisoryservice.saveAdvisory(advisory);
			model.addAttribute("students", studentService.getAllStudent());
			model.addAttribute("servicioAdvisers", sxa_service.getAllSxA());
			model.addAttribute("advisory_collection", advisoryservice.getAllAdvisory());
			return "redirect:/views/students/advisory/list";
		}
	}
	
	
	@RequestMapping("/edit/{id}")
	public String editAdvisory(@PathVariable(value="id") Long idAdv, Model model) {
		
		try {
			Optional<Advisory> advisory= advisoryservice.findAdvisoryById(idAdv);
			
			model.addAttribute("titulo", "Editar Asesoría");
			model.addAttribute("advisory", advisory.get());
			model.addAttribute("students", studentService.getAllStudent());
			model.addAttribute("servicioAdvisers", sxa_service.getAllSxA());
			model.addAttribute("advisory_collection", advisoryservice.getAllAdvisory());
			
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "views/students/create_advisories";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteAdvisory(@PathVariable("id") Long idAdv, Model model) {
		
		try {
			model.addAttribute("advisory", new Advisory());
			advisoryservice.delete(idAdv);
			model.addAttribute("mensaje", "Se eliminó correctamente");
			
		} catch (Exception e) {
			model.addAttribute("mensaje",
					"Ocurrió un error,  no es posible eliminar al Curso con docecnte asignado, ya que existen alumnos matriculados");
		}
		
		model.addAttribute("advisory_collection", advisoryservice.getAllAdvisory());
		
		return "redirect:/views/students/advisory/list";
	}
	

}
