package com.example.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.example.entities.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	
	public List<Student> listarStudent() throws Exception {
		
		List<Student> students=studentRepository.findAll();
		
		return  students;
	}
	public List<Student> getAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }
	

	public int registrarStudents(Student student) throws Exception {
		int existeStudent=studentRepository.verificarExistenciaStudent(student.getDni());
		
		if(existeStudent==0)
			studentRepository.save(student);
		
		return existeStudent;
	}
	

	public List<Student> buscarStudentPorDni(String Dni) throws Exception {
		
		List<Student> students= studentRepository.buscarStudentPorDni(Dni);
		
		
		return students;
	}
	
	public void eliminar(Long IdStudent) throws Exception {
       studentRepository.deleteById(IdStudent);
    }
	
	
	public Optional<Student> getOne(Long IdStudent) throws Exception {
		return studentRepository.findById(IdStudent);
	}
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	public List<Student> getAllStudentByName(){
		return studentRepository.findAllSortByName();
	}
	
	public List<Student> getAllStudentByValoracion(){
		return studentRepository.findAllSortByValoracion();
	}
	
	
	public List<Student> buscarStudentByFirstName(String firstName){
		List<Student> students=studentRepository.buscarStudent(firstName);
		return students;
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudentByid(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

}
