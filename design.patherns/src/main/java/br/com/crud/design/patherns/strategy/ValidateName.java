package br.com.crud.design.patherns.strategy;

import org.springframework.stereotype.Service;

import br.com.crud.design.patherns.model.Student;
@Service
public class ValidateName implements IStrategy {
	@Override
	public Student process(Object obj) {
		if(obj instanceof Student) {
			this.validateStudentName((Student)obj);
		}
		return null;
	}
	
	private Student validateStudentName(Student student) {
		return (!student.getFirstName().isBlank() &&
				!student.getFinalName().isBlank()) ? 
				 student : null;
	}
}
