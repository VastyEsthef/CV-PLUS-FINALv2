package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Portafolio2;
import com.example.entities.Proyecto;
import com.example.service.ProyectoService;
import com.example.service.impl.PortafolioServiceJ;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private PortafolioServiceJ portafolioService;
	
	private List<Portafolio2> portafolioList=new ArrayList<>();
	
	public ProyectoController(ProyectoService proyectoService,PortafolioServiceJ portafolioService) {
		
		this.proyectoService=proyectoService;
		this.portafolioService=portafolioService;
		
	}
	
	@GetMapping
	public String home(Model model) {
		 model.addAttribute("proyecto", new Proyecto());
		model.addAttribute("proyectos",proyectoService.getAllProyectos());
		return "proyectos/proyectos";
	}
	
	
	 @GetMapping("/proyectos")
	    public String listProyectos(Model model) {
		    model.addAttribute("proyecto", new Proyecto());
	        model.addAttribute("proyectos", proyectoService.getAllProyectos());
	        return "proyectos";
	    }
	 
	 
	 
	
	
	
	@GetMapping("/new")
	public String createProyectoForm(Model model) {
		Proyecto proyecto=new Proyecto();
		this.portafolioList=this.portafolioService.getAllPortafolios();
		
		model.addAttribute("proyecto",proyecto);
		model.addAttribute("portafolioList",portafolioList);
		return "proyectos/create_proyecto";
	}
	
	@PostMapping("/save")
	public String saveProyecto(@ModelAttribute("proyecto")Proyecto proyecto) {
		proyectoService.saveProyecto(proyecto);
		return "redirect:/proyectos";
		
	}
	
	//@GetMapping("/proyectos/edit/{id}")
    public String editSProyectoForm(@PathVariable Long id, Model model) {
        Proyecto pr = proyectoService.getProyectoById(id);
        
        model.addAttribute("proyecto", pr);
        
        model.addAttribute("portafoliosList", portafolioList);
        
        return "edit_proyecto";
    }
	
	@PostMapping("/update/{id}")
    public String updateProyecto(@PathVariable Long id,  @ModelAttribute("proyecto") Proyecto proyecto,
            Model model) {
        //sacar el esudiante de la b.d. por el id
        Proyecto existentProyecto = proyectoService.getProyectoById(id);
        // cargarlo
        existentProyecto.setIdProyecto(id);
        existentProyecto.setTitulo_Proyect(proyecto.getTitulo_Proyect());
        existentProyecto.setDescripcion_Proyect(proyecto.getDescripcion_Proyect());
        existentProyecto.setColaboradores(proyecto.getColaboradores());
        existentProyecto.setPortafolios(proyecto.getPortafolios());

        // guardar el estudiante actualizado
        proyectoService.updateProyecto(existentProyecto);
        
        return "redirect:/proyectos";
    }
	
	
	
	
	@GetMapping("/edit/{id}")
    public String editProyectoForm(@PathVariable("id") long id, Model model) {
        Proyecto proyecto = proyectoService.getProyectoById(id);
        List<Portafolio2> portafolios = portafolioService.getAllPortafolios();
        model.addAttribute("portafolios", portafolios);
        model.addAttribute("proyecto", proyecto);
        return "proyectos/edit_proyecto";
    }
	
	
	 @PostMapping("/buscar")
	 public String buscarProyecto(Model model,@ModelAttribute Proyecto proyecto) {
		 model.addAttribute("proyectos",proyectoService.buscarProyectoPorNombre(proyecto.getTitulo_Proyect()));
		 return "proyectos/proyectos";
	 }

	 @GetMapping("/{id}")
	    public String deleteProyecto(@PathVariable Long id) {
	        proyectoService.deleteProyectoById(id);
	        return "redirect:/proyectos";
	    }


}