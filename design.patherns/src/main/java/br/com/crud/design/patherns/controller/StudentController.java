package br.com.crud.design.patherns.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.design.patherns.dto.StudentDto;
import br.com.crud.design.patherns.facade.StudentFacade;
import br.com.crud.design.patherns.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	private StudentFacade service;
	
	@Autowired
	public StudentController(StudentFacade service) {
		this.service = service;
	}
	
	@PostMapping("save")
	public ResponseEntity<StudentDto> save(@RequestBody StudentDto studentDto) {
		Student student = this.service.save(studentDto.toEntity());
		return ResponseEntity.ok().body(student != null ? student.toDto() : null);
	}
	
	@GetMapping("list")
	public List<StudentDto> list() {
		List<StudentDto> students = new ArrayList<>();
		this.service.list().stream().forEach(o -> {
			students.add(((Student)o).toDto());
		});
		return students; 
	}
}
