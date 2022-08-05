package br.com.crud.design.patherns.strategy;

import org.springframework.stereotype.Service;

import br.com.crud.design.patherns.model.Student;
@Service
public class ValidateEmail implements IStrategy {
	@Override
	public Student process(Object obj) {
		if(obj instanceof Student) {
			return this.validateStudentEmail((Student)obj);
		}
				
		return null;
	}
	
	private Student validateStudentEmail(Student student) {
		return student.getEmail().isBlank() && 
				student.getEmail().contains("@") ? 
				student : null;
	}
}