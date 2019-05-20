package com.gigantedepe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gigantedepe.enums.EstadosEnum;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = -1270674257373548745L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String localConcentracao;
	private String hora;
	private int estado;
	
	public Cidade(Long id, String name, String localConcentracao, String hora, int estado) {
		super();
		this.id = id;
		this.name = name;
		this.localConcentracao = localConcentracao;
		this.hora = hora;
		this.estado = estado;
	}
	
	public Cidade() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalConcentracao() {
		return localConcentracao;
	}

	public void setLocalConcentracao(String localConcentracao) {
		this.localConcentracao = localConcentracao;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public EstadosEnum getEstado() {
		return EstadosEnum.parse(this.estado);
	}
	
	public void setEstado(EstadosEnum estado) {
		this.estado = estado.getCodigo();
	}

}
