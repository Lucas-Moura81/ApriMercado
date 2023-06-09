package com.lucas.myapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.myapi.domain.Categoria;
import com.lucas.myapi.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@Autowired

	private CategoriaService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping()
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
		Categoria newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
