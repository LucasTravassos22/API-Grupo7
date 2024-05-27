package br.com.serratec.dto;

import java.time.LocalDate;

public class LancamentoVendasMostrarDTO {
	
	private LocalDate dataVenda;
	private Double valorVenda;
	private String nomeVendedor;
		
	
	public LancamentoVendasMostrarDTO(LocalDate dataVenda, Double valorVenda, String nomeVendedor) {
		super();
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.nomeVendedor = nomeVendedor;
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
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	
	
}
