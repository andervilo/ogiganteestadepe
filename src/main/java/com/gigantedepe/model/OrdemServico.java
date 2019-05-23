package com.gigantedepe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_ORDEM_SERVICO")
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = -4663160873818027786L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ordem_id", nullable=false)
	private Ordem ordem;
	
	@ManyToOne
	@JoinColumn(name="servico_id", nullable=false)
	private Servico servico;
}
