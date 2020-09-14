package com.maximatech.pp.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximatech.pp.domain.modelo.Pedido;
import com.maximatech.pp.domain.modelo.Produto;
import com.maximatech.pp.domain.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@Autowired
	private ProdutoService produtoService;
	
	private List<Pedido> listaPedido;
	
	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	
	public List<Pedido> consultarPedido(){	
		listaPedido = pedidoRepository.findAll();
		return  listaPedido;
	}
	
	@Transactional
	public Pedido emitirPedido(Pedido pedido) {
		validarItensPedido(pedido);
		pedido.definirQuantidadeTotalPedido();
		pedido.definirFrete();
		pedido.definirValorTotalPedido();
		return pedidoRepository.save(pedido);
	}
	
	private void validarItensPedido(Pedido pedido) {
		pedido.getItensPedido().forEach(item -> {
			Optional<Produto> produto = produtoService.buscarProdutoCodigo(item.getProduto().getCodigo_Produto());			
			item.setPedido(pedido);
			item.setProduto(produto.get());
			item.setValorTotalItem(item.getProduto().getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidadeProduto()).setScale(2, BigDecimal.ROUND_UP)));
		});
	}
}

