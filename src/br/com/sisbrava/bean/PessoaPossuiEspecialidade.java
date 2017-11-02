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
@Table(name = "pessoaPossuiEspecialidade")
public class PessoaPossuiEspecialidade {

	private Integer id;
	private Pessoa pessoa;
	private Especialidades especialidade;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ppespecialidade_id")
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
	@JoinColumn(name = "especialidade_id")
	public Especialidades getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidades especialidade) {
		this.especialidade = especialidade;
	}
	
	public String toString() {
		return "Pessoa: " + this.pessoa.getNome() + " Especialidade: " + this.especialidade.getDescricao();
	}
	
}
