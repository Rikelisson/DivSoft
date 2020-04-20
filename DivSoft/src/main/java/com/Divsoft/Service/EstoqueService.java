package com.Divsoft.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Divsoft.Entidade.Estoque;
import com.Divsoft.Entidade.Produto;
import com.Divsoft.Exception.objectNotFoundException;
import com.Divsoft.Repository.EstoqueRepository;
import com.Divsoft.Repository.ProdutoRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Estoque> BuscaTodos(){
		return estoqueRepository.findAll();
	}
	
	public Estoque BuscaId(Long id) {
		Optional<Estoque> obj = estoqueRepository.findById(id);
		return obj.orElseThrow(()-> new objectNotFoundException("Evento não encontrado.Id:"+id));
	}
	
	public Estoque Salvar(Estoque obj) {
		if(obj.getProduto()!=null) {
			for(Produto o :obj.getProduto()) {
				o.setEstoque(obj);
			}
		}
		
		return estoqueRepository.save(obj);


	}
	
	public Estoque Update(Estoque  obj) {
		Estoque objUpdate= BuscaId(obj.getId());
		List<Produto> produtoDeleta = new ArrayList<Produto>();
		if(obj.getProduto()!=null) {
			for(Produto o :obj.getProduto()) {
				o.setEstoque(obj);
			}
			
			for(Produto produtoUpdate:objUpdate.getProduto()) {
				boolean isPresent = false;
				for(Produto o :obj.getProduto()) {
					if(produtoUpdate.getId().equals(o.getId())) {
						isPresent= true;
					}
				}
				if(!isPresent) {
					produtoDeleta.add(produtoUpdate);
				}
			}
		}
		obj=estoqueRepository.save(obj);
		produtoRepository.deleteAll(produtoDeleta);
		return obj;
	}
	
	
	public void Deletar(Long id) {
		estoqueRepository.deleteById(id);
	}

}
