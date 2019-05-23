package com.gigantedepe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_ORDEM")
public class Ordem implements Serializable {
	
	private static final long serialVersionUID = -5678974210696674503L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Boolean concluida;
	
	@OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
	private List<OrdemServico> ordemServico= new ArrayList<OrdemServico>();
	
	public Ordem(Long id, Boolean concluida) {
		super();
		this.id = id;
		this.concluida = concluida;
	}

	public Ordem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public List<OrdemServico> getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(List<OrdemServico> ordemServico) {
		this.ordemServico = ordemServico;
	}
	
	
	
	
	

}
