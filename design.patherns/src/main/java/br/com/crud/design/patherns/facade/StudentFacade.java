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
	private Map<String, Map<String, List<IStrategy>>> businessRules;
	private static final String SAVE = "save";
	private static final String LIST = "list";
	
	public StudentFacade() {
		businessRules = new HashMap<>();
		
		//Validações para salvar/alterar estudantes
		ValidateName vn = new ValidateName();
		ValidateNascimento vnt = new ValidateNascimento();
		ValidateEmail ve = new ValidateEmail();
		
		//Instanciando listas de validações para salvar/alterar e listar Estudantes
		List<IStrategy> saveStudentBusiness = new ArrayList<>();
		List<IStrategy> listStudentBusiness = new ArrayList<>();
		
		//criando a lista de regras para cada evento
		saveStudentBusiness.add(vn);
		saveStudentBusiness.add(vnt);
		saveStudentBusiness.add(ve);
		
		//Intanciando as integrações de todas as regras de todos os eventos para estudantes
		Map<String, List<IStrategy>> studentBusiness = new HashMap<>();
		
		//Ligando todas as validações para cada evento
		studentBusiness.put(SAVE, saveStudentBusiness);
		studentBusiness.put(LIST, listStudentBusiness);
		
		
	}
	
	@Override
	public Student save(Object obj) {
		return this.studentRepository.save((Student)obj);
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
