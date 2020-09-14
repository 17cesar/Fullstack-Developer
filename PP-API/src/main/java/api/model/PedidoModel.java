package api.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.maximatech.pp.domain.modelo.Cliente;

public class PedidoModel {

	
	private Long codigoPedido;
	private Cliente cliente;
	private List<ItensPedidoModel> itensPedido = new ArrayList<>();	
	private BigDecimal frete;
	private BigDecimal valorTotalPedido;
	private Integer quantidadeProdutos;
	private BigDecimal valorFreteUnitario;
	
	public Long getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItensPedidoModel> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItensPedidoModel> itensPedido) {
		this.itensPedido = itensPedido;
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
	public BigDecimal getValorFreteUnitario() {
		return valorFreteUnitario;
	}
	public void setValorFreteUnitario(BigDecimal valorFreteUnitario) {
		this.valorFreteUnitario = valorFreteUnitario;
	}
	
	
	
	
	
	
}
