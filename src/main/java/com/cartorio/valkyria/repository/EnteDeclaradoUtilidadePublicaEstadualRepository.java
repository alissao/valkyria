package com.cartorio.valkyria.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual.EnteDeclaradoUtilidadePublicaEstadualEntity;

public interface EnteDeclaradoUtilidadePublicaEstadualRepository<P> extends CrudRepository<EnteDeclaradoUtilidadePublicaEstadualEntity, Long> {
  
  Optional<EnteDeclaradoUtilidadePublicaEstadualEntity> findByCdEntePub(Long cdEntePub);

  Page<EnteDeclaradoUtilidadePublicaEstadualEntity> findByNomeEntidade(String nomeEntidade, Pageable pageable);

}
