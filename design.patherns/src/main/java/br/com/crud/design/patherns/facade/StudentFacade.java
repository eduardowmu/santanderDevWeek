package br.com.crud.design.patherns.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.design.patherns.model.Student;
import br.com.crud.design.patherns.repository.StudentRepository;
import br.com.crud.design.patherns.strategy.IStrategy;
import br.com.crud.design.patherns.strategy.ValidateEmail;
import br.com.crud.design.patherns.strategy.ValidateName;
import br.com.crud.design.patherns.strategy.ValidateNascimento;
@Service
public class StudentFacade implements IFacade {
	@Autowired
	private StudentRepository studentRepository;
	Map<String, List<IStrategy>> studentBusiness;
	private static final String SAVE = "save";
	private static final String LIST = "list";
	
	public StudentFacade() {
		//Validações para salvar/alterar estudantes
		ValidateName vn = new ValidateName();
		ValidateNascimento vnt = new ValidateNascimento();
		ValidateEmail ve = new ValidateEmail();
		
		//Instanciando listas de validações para salvar/alterar e listar Estudantes
		List<IStrategy> saveStudentBusinessList = new ArrayList<>();
		List<IStrategy> listStudentBusinessList = new ArrayList<>();
		
		/*criando a lista de regras para cada evento. Neste caso não teremos regras
		 *para listagem de estudantes*/
		saveStudentBusinessList.add(vn);
		saveStudentBusinessList.add(vnt);
		saveStudentBusinessList.add(ve);
		
		//Intanciando as integrações de todas as regras de todos os eventos para estudantes
		studentBusiness = new HashMap<>();
		
		//Ligando todas as validações para cada evento
		studentBusiness.put(SAVE, saveStudentBusinessList);
		studentBusiness.put(LIST, listStudentBusinessList);
	}
	
	/*Processamento de todas as regras do evento selecionado*/
	private Student executeRules(Student student, String event) {
		if(!this.studentBusiness.isEmpty()) {
			List<IStrategy> rules = this.studentBusiness.get(event);
			for(IStrategy rule : rules) {
				if(rule.process(student) != null) continue;
				else break;
			}
			return student;
		}
		return null;
	}
	
	@Override
	public Student save(Object obj) {
		Student student = this.executeRules((Student)obj, SAVE);
		return student != null ? this.studentRepository.save(student) : null;
	}

	@Override
	public List<Object> list() {
		List<Object> students = new ArrayList<>();
		List<Student> list = this.studentRepository.findAll();
		if(list != null && !list.isEmpty()) {
			for(Student student : list) {
				students.add(student);
			}
		}
		return students;
	}

}
