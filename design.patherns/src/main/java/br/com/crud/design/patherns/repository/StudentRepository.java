package br.com.crud.design.patherns.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crud.design.patherns.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{}