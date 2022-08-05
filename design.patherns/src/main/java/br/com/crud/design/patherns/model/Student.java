package br.com.crud.design.patherns.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.crud.design.patherns.dto.StudentDto;
import br.com.crud.design.patherns.implement.EntityToDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table
public class Student implements Serializable, EntityToDto {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String finalName;
	private String email;
	private LocalDate nascimento;
	
	@Override
	public StudentDto toDto() {
		return StudentDto.builder()
				.id(this.id)
				.firstName(this.firstName != null ? this.firstName : "")
				.finalName(this.finalName != null ? this.finalName : "")
				.email(this.email != null ? this.email : "")
				.nascimento(String.format("yyyy-MM-dd", this.nascimento))
				.build();
	}
	
	
}
