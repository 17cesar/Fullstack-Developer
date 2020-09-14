package com.maximatech.pp.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maximatech.pp.domain.modelo.Pedido;
import com.maximatech.pp.domain.repository.PedidoRepository;
import com.maximatech.pp.domain.service.PedidoService;

import api.assembler.PedidoModelAssembler;
import api.model.PedidoModel;

@RestController
@RequestMapping(value= "/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoService pedidoService;
	
//	@Autowired(required=true)
	private PedidoModelAssembler pedidoModelAssembler = new PedidoModelAssembler();
	
	@GetMapping
	public List<PedidoModel> listar() {		
		List<Pedido> todosPedidos = pedidoRepository.findAll();		
		return pedidoModelAssembler.toCollectionModel(todosPedidos);
		
	}
	
	@GetMapping("/{pedidoId}")
	public ResponseEntity<PedidoModel> buscarPedido(@PathVariable Long pedidoId) {
		Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(pedidoModelAssembler.toModel(pedido.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoModel salvar(@RequestBody Pedido pedido) {
		return  pedidoModelAssembler.toModel(pedidoService.emitirPedido(pedido));
	}
	

}
