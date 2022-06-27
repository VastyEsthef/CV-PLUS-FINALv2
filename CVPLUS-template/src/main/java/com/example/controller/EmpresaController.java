package com.example.controller;

import com.example.entities.Empresa;
import com.example.service.EmpresaService;

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
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/new")
	public String RegistrarEmpresa(Model model) {
		model.addAttribute("empresa", new Empresa());
	
		return "Empresa/form"; 
	}
	
	
	@GetMapping
	public String listarEmpresa(Model model) {
		model.addAttribute("empresa", new Empresa());
		model.addAttribute("empresas", empresaService.listarEmpresa());
		return "Empresa/list";
	}
	
	@PostMapping("/registrar")
	public String registrarEmpresa(@Validated @ModelAttribute Empresa empresa, BindingResult result, Model model) {		
		int rpta;

		if(result.hasErrors()) {
			
			return "Empresa/form";
		}
	
		rpta=empresaService.registrarEmpresa(empresa);
		
		if(rpta>0) {
			model.addAttribute("mensaje", "El numero de ruc ya existe");
			
			
		}else {
			model.addAttribute("mensaje", "Se registró correctamente");
			model.addAttribute("empresa",new Empresa());
						
		}
		
		return "Empresa/form";
	}
	
	
	
	
	
	@PostMapping("/buscar")
	public String buscarEmpresa(Model model, @ModelAttribute Empresa empresa) {		
		model.addAttribute("Empresas",empresaService.buscarEmpresaporRuc(empresa.getRuc()));
		return "Empresa/list";
	}
	
}
