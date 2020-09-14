package com.maximatech.pp.domain.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.maximatech.pp.domain.modelo.Produto;

public interface ProdutoRepository extends JpaRepositoryImplementation<Produto, Long>{

}
