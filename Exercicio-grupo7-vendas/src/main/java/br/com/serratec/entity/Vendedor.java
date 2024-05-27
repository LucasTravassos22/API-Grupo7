package br.com.serratec.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Vendedor {
     
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long codigoVendedor;
	 @NotBlank(message ="Nome não pode ser vazio ou nulo.")
	 private String nome;
	 @Email
	 private String email;
	 @Min(1412)
	 private BigDecimal salario;
	 
	 private Double comissao;
	 
	 @JsonManagedReference
	 @OneToMany(mappedBy = "vendedor")
	 private List<LancamentoVendas> lancamentos;
	 
	 
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
