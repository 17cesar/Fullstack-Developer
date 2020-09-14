package com.maximatech.pp.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maximatech.pp.domain.modelo.Produto;
import com.maximatech.pp.domain.repository.ProdutoRepository;
import com.maximatech.pp.domain.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> listar() {
		return produtoService.consultarProduto();
	}
	
	@GetMapping("/{ProdutoId}")
	public ResponseEntity<Produto> buscarProduto(@PathVariable Long ProdutoId) {
		Optional<Produto> Produto = produtoService.buscarProdutoCodigo(ProdutoId);
		if (Produto.isPresent()) {
			return ResponseEntity.ok(Produto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
