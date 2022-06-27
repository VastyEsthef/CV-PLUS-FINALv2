package com.example.controller;

import com.example.entities.Adviser;
import com.example.service.AdviserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/advisers")
public class AdviserController {

	@Autowired
	private AdviserService adviserService;
	
	@GetMapping("/new")
	public String RegistrarAdviser(Model model) {
		model.addAttribute("adviser", new Adviser());
	
		return "Adviser/form"; 
	}
	
	
	@GetMapping
	public String listarAdviser(Model model) {
		model.addAttribute("adviser", new Adviser());
		model.addAttribute("advisers", adviserService.listarAdviser());
		return "Adviser/list";
	}
	
	@PostMapping("/registrar")
	public String registrarAdviser(@Validated @ModelAttribute Adviser adviser, BindingResult result, Model model) {		
		int rpta;

		if(result.hasErrors()) {
			
			return "Adviser/form";
		}
	
		rpta=adviserService.registrarAdvisers(adviser);
		
		if(rpta>0) {
			model.addAttribute("mensaje", "El numero de DNI ya existe");
			
			
		}else {
			model.addAttribute("mensaje", "Se registró correctamente");
			model.addAttribute("adviser",new Adviser());
						
		}
		
		return "Adviser/form";
	}
	
	
	@PostMapping("/buscar")
	public String buscarEmpresa(Model model, @ModelAttribute Adviser adviser) {		
		model.addAttribute("advisers",adviserService.buscarAdviserPorDni(adviser.getDni_As()));
		return "Adviser/list";
	}
	
}
