package com.maximatech.pp.domain.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoPedido;
	
	@ManyToOne
	@JoinColumn(name = "cliente_codigo_cliente", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido" , cascade = CascadeType.ALL)
	private List<ItensPedido> itensPedido = new ArrayList<>();	
	
	private BigDecimal frete;

	private BigDecimal valorTotalPedido;
	
	private Integer quantidadeProdutos;

	private BigDecimal valorFreteUnitario;

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getFrete() {
		return frete;
	}

	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}

	public BigDecimal getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(BigDecimal valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public Integer getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(Integer quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public List<ItensPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItensPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
		
	public BigDecimal getValorFreteUnitario() {
		return valorFreteUnitario;
	}

	public void setValorFreteUnitario(BigDecimal valorFreteUnitario) {
		this.valorFreteUnitario = valorFreteUnitario;
	}

	public void atribuirPedidoAosItens() {
		getItensPedido().forEach(item -> item.setPedido(this));
	}
	
	public void definirQuantidadeTotalPedido() {
		setQuantidadeProdutos(getItensPedido().stream().mapToInt(ItensPedido::getQuantidadeProduto).sum());
	}
	
	
	//Metodo Responsavel Por definir o valor do frete por unidade de produto do pedido , o valor e definido randomicamente de 5.0 a 9,99
	private void definiValorFreteUnitario() {
		Random random = new Random();
		Double valorFrete = random.nextDouble() + (random.nextInt((9 - 5) + 1 ) +5);
		setValorFreteUnitario(BigDecimal.valueOf(valorFrete).setScale(2, BigDecimal.ROUND_UP));		
	}
	
	public void definirFrete() {
		definiValorFreteUnitario();
		setFrete(getValorFreteUnitario().multiply(BigDecimal.valueOf(getQuantidadeProdutos())).setScale(2, BigDecimal.ROUND_UP));
	}
	
	public void definirValorTotalPedido() {
		setValorTotalPedido(BigDecimal.valueOf(getItensPedido().stream().map(a -> a.getValorTotalItem()).mapToDouble(BigDecimal::doubleValue).sum()).add(getFrete().setScale(2, BigDecimal.ROUND_UP)));
	}
	
	
}
