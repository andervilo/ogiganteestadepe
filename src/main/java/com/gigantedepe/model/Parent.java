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

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Parent implements Serializable{

	private static final long serialVersionUID = 8840170241321557914L;
	
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	  private String name;
	  
	  @JsonIgnore	  
	  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	  private List<Child> childs = new ArrayList<Child>();
  
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
	public List<Child> getChilds() {
		return childs;
	}
	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}
	
	public void addChild(Child child) {
		child.setParent(this);
		getChilds().add(child);
	}

	public void removeChild(Child child) {		
		child.setParent(null);
		getChilds().remove(child);
	}

	

}
