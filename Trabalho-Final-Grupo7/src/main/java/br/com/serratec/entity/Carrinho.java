package br.com.serratec.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.serratec.dto.CarrinhoRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carrinho")
public class Carrinho {
	
	@EmbeddedId
	private PedidoProdutoPK id = new PedidoProdutoPK();
	
	private LocalDate dataPedido;

	@Column(name = "preço")
	private Double valor;
	
	@Column(name = "total")
	private Double total = 0.0;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	public Carrinho() {
		super();
	}

	public Carrinho(CarrinhoRequestDTO carrinho, Pedido pedido, Produto produto) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.quantidade = carrinho.getQuantidade();
		this.valor = produto.getValor();
		this.total += produto.getValor() * carrinho.getQuantidade();
		this.dataPedido = LocalDate.now();
	}

	@JsonIgnore
	public PedidoProdutoPK getId() {
		return id;
	}

	public void setId(PedidoProdutoPK id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", dataPedido=" + dataPedido + ", valor=" + valor + ", total=" + total
				+ ", quantidade=" + quantidade + "]";
	}
}
