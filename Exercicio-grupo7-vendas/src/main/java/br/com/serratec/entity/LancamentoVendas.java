package br.com.serratec.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class LancamentoVendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoVenda;
	@NotBlank(message ="Data de venda não pode ser vazia ou nula.")
	private LocalDate dataVenda;
	@NotBlank(message ="Valor de venda não pode ser vazio ou nulo.")
	private Double valorVenda;
    
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "codigo_vendedor")
	@NotBlank(message ="Vendedor não pode ser vazio ou nulo.")
	private Vendedor vendedor;
	

	public Long getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
