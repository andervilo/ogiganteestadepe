package com.gigantedepe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigantedepe.model.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer>{
	
}
