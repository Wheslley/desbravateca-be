package br.com.sisbrava.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLUBE")
public class Clube {

	private Integer id;
	private String descricao;
	private Integer regiao;
	private Cep cep;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLUBE_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getRegiao() {
		return regiao;
	}

	public void setRegiao(Integer regiao) {
		this.regiao = regiao;
	}
	
	@ManyToOne
	@JoinColumn(name = "CEP_ID")
	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}
	
	public String toString() {
		return "Clube: " + this.descricao + " - Região: " + this.regiao + " - CEP: " + this.cep.toString();
	}
}
