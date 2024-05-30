package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.entity.Carrinho;
import br.com.serratec.enums.StatusEnum;

public class CarrinhoResponseDTO {

	private Long pedidoId;
	private Integer quantidade;
	private Double valor;
	private Double total;
	private LocalDate dataPedido;
	private StatusEnum status;
	
	
	
	public CarrinhoResponseDTO(Carrinho c) {
		this.pedidoId = c.getId().getPedido().getId();
		this.quantidade = c.getQuantidade();
		this.valor = c.getValor();
		this.total = c.getTotal();
		this.dataPedido = c.getDataPedido();
		this.status = c.getId().getPedido().getStatus();
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
