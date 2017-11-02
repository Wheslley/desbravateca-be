package br.com.sisbrava.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSES")
public class Classes {

	private Integer id;
	private String descricao;
	private Integer idade_permitida;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLASSE_ID")
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

	public Integer getIdade_permitida() {
		return idade_permitida;
	}

	public void setIdade_permitida(Integer idade_permitida) {
		this.idade_permitida = idade_permitida;
	}
	
	public String toString() {
		return "Classe: " + this.descricao + " / IdadePermitida: " + this.idade_permitida;
	}
}
