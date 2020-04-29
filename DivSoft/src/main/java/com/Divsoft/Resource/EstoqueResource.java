package com.Divsoft.Resource;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Divsoft.Entidade.Estoque;
import com.Divsoft.Service.EstoqueService;

@RestController
@RequestMapping(value = "/Estoque")
public class EstoqueResource {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Estoque> BuscaTodosEstoque(){
		return estoqueService.BuscaTodos();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	public Estoque BuscaPorID(@PathVariable  Long id) {
		return estoqueService.BuscaId(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Estoque estoque) {
		Estoque obj = estoqueService.Salvar(estoque);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}" )
	public ResponseEntity<Void> update(@RequestBody Estoque obj, @PathVariable Long id) {
		obj.setId(id);
		estoqueService.Atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		estoqueService.Deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
