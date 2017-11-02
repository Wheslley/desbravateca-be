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
@Table(name = "pessoaPossuiClasse")
public class PessoaPossuiClasse {

	private Integer id;
	private Pessoa pessoa;
	private Classes classes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ppclasse_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@ManyToOne
	@JoinColumn(name = "classe_id")
	public Classes getClasse() {
		return classes;
	}

	public void setClasse(Classes classes) {
		this.classes = classes;
	}
	
	public String toString() {
		return "Pessoa: " + this.pessoa.getNome() + " - Classe: " + this.classes.getDescricao();
	}
	
}
