package br.com.crud.design.patherns.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.crud.design.patherns.implement.DtoToEntity;
import br.com.crud.design.patherns.model.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class StudentDto implements Serializable, DtoToEntity {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String finalName;
	private String email;
	private String nascimento;
	
	@Override
	public Student toEntity() {
		return Student.builder().id(this.id)
				.firstName(this.firstName != null ? this.firstName : "")
				.finalName(this.finalName != null ? this.finalName : "")
				.email(this.email != null ? this.email : "")
				.nascimento(LocalDate.parse(this.nascimento != null ? this.nascimento : ""))
				.build();
	}
}