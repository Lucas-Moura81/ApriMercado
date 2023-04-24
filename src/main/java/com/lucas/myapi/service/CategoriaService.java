package com.lucas.myapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.myapi.domain.Categoria;
import com.lucas.myapi.repositories.CategoriaRepository;
import com.lucas.myapi.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!! id: " + id + ", tipo: " + Categoria.class.getName()));
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria update(Integer id, Categoria obj) {
		Categoria newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		return repository.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);

	}

}
