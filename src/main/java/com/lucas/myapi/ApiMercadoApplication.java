package com.lucas.myapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.myapi.repositories.ProdutoRepository;

@SpringBootApplication
public class ApiMercadoApplication implements CommandLineRunner {
	@Autowired
	private ProdutoRepository produtoRepository; 

	public static void main(String[] args) {
		SpringApplication.run(ApiMercadoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Cadastro p1 = new Cadastro(1, "Notbook", null, "teste", "teste1", 200); 
//		Cadastro p2 = new Cadastro(2, "Notbook", null, "teste", "teste2", 250);
//		
//		cadastroRepository.saveAll(Arrays.asList(p1, p2));  
	}
       
}

                    
