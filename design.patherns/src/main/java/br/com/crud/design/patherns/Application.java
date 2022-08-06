package br.com.crud.design.patherns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*Esta aplicação se trata de um cadastro de estudantes
 com dados bem simples, utilizando os padrões de projetos
 Facade, DTO e Strategy. Na verdade gostaria de te-lo feito
 com maior nível de abstração mas com curto tempo para terminar
 decidi criar uma controller específica para estudante, ao invés
 de ter feita uma controller mais genérica. Para retornos nulos
 de cada evento, o tratamento deverá ser feito no front.*/
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
