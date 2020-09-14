package api.model;

import java.math.BigDecimal;

public class ItensPedidoModel {

	private Long pedido;
	private String produtoNome;	
	private Integer quantidadeProduto;	
	private BigDecimal valorTotalItem;
	
	public Long getPedido() {
		return pedido;
	}
	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}	
	
	public String getProdutoNome() {
		return produtoNome;
	}
	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}
	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}
	public void setValorTotalItem(BigDecimal valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}
	
	
	
	
	
}
