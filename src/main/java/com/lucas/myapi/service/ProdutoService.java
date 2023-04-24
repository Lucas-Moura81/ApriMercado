package com.lucas.myapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.myapi.domain.Produto;
import com.lucas.myapi.repositories.ProdutoRepository;
import com.lucas.myapi.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!! id: " + id + ", tipo: " + Produto.class.getName()));
	}

	public Produto create(Produto obj) {
		obj.setId(null);
		obj.setDataCadastro(new Date());
		return repository.save(obj);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto update(Integer id, Produto obj) {
		Produto newObj = findById(id); 
		newObj.setNome(obj.getNome());
		newObj.setTipo(obj.getTipo());
		newObj.setValor(obj.getValor());
		newObj.setDescricao(obj.getDescricao());
		return repository.save(newObj); 
	}

	public void delete(Integer id) {
		findById(id); 
		repository.deleteById(id);

	}

	public List<Produto> saveAll(List<Produto> obj) { 
		for(Produto produto : obj) {
			produto.setDataCadastro(new Date());
		}
		return repository.saveAll(obj);		
	}
}
