package br.com.crud.design.patherns.strategy;

import org.springframework.stereotype.Service;

import br.com.crud.design.patherns.model.Student;
@Service
public class ValidateNascimento implements IStrategy {
	@Override
	public Student process(Object obj) {
		if(obj instanceof Student) {
			return this.validateStudentNascimento((Student)obj);
		}
		return null;
	}
	
	private Student validateStudentNascimento(Student student) {
		return student.getNascimento().getYear() < 17 ?
				student : null;
	}
}