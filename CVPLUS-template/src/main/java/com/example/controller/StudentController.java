package com.example.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Student;
import com.example.service.StudentService;


@Controller


@RequestMapping("/estudiantes")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/*@GetMapping
	public String homee(Model model) {
		model.addAttribute("students",studentService.getAllStudent());
		model.addAttribute("student",studentService.getAllStudent());
		return "estudiantes/list";
	}*/
	
	
	@GetMapping("/new")
	public String RegistrarStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("title","Nuevo Estudiante");
		return "estudiantes/form"; 
	}
	
	@GetMapping
	public String listarStudent(Model model) {
		try {
			List<Student> students=studentService.listarStudent();
			model.addAttribute("students",students);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "estudiantes/list";
	}
	
	@PostMapping("/buscar")
	public String buscarStudent(Model model, @ModelAttribute Student student) throws Exception {		
		model.addAttribute("students",studentService.buscarStudentPorDni(student.getDni()));
		return "estudiantes/list";
	}

	
	@PostMapping("/registrar")
	public String registrarStudent(@Validated @ModelAttribute Student student, BindingResult result, Model model,
			SessionStatus status) {		
		
		try {
			if(result.hasErrors()) {
				return "estudiantes/form";
			}
			
			studentService.registrarStudents(student);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "estudiantes/list";
	}
	
	

	
	@GetMapping("/eliminar")
    public String eliminarStudent(@RequestParam(value = "IdStudent") Long IdStudent, Model model) throws Exception {

        /// Hacer la eliminación
        
		studentService.eliminar(IdStudent);

        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.listarStudent());
        return "estudiantes/list";
    }
	
	@GetMapping(value ="/edit/{IdStudent}")
    public String editStudentForm(@PathVariable(value="IdStudent") Long IdStudent, Model model, RedirectAttributes flash) {
        Optional<Student> student=null;
        
        try {
      
		student = studentService.getOne(IdStudent);
		
        model.addAttribute("student", student);
        model.addAttribute("title", "Editar Estudiante");
        }catch (Exception e) {
        	e.printStackTrace();
        }
        
        return "estudiantes/form";
    }
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
		}
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
