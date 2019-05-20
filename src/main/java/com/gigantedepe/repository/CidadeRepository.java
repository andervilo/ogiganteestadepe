package com.gigantedepe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigantedepe.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
