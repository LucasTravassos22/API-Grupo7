package br.com.serratec.dto;

import java.math.BigDecimal;

public class VendedorDTO {
	
	 private Long codigoVendedor;

	 private String nome;
	 private String email;
	 private BigDecimal salario;
	 private Double comissao;
	public VendedorDTO(Long codigoVendedor, String nome, String email, BigDecimal salario, Double comissao) {
		super();
		this.codigoVendedor = codigoVendedor;
		this.nome = nome;
		this.email = email;
		this.salario = salario;
		this.comissao = comissao;
	}
	public Long getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public Double getComissao() {
		return comissao;
	}
	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}
	 
	 
}
	 
	
