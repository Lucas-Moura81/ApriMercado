package com.lucas.myapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.myapi.domain.Produto;
import com.lucas.myapi.service.ProdutoService;

@RestController // = resource
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	@Autowired

	private ProdutoService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/salvar")
	public ResponseEntity<Produto> create(@RequestBody Produto obj) {
		Produto newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		// quando cria um obj via instacia é uma boa pratica já criar o uri do usuario
	}

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto obj) {
		Produto newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
		
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@PostMapping(value = "/salvar-lista")
	public ResponseEntity<List<Produto>>addList(@RequestBody List<Produto> objList){
		service.saveAll(objList);
		return ResponseEntity.ok().body(objList); 
	}
	
}
