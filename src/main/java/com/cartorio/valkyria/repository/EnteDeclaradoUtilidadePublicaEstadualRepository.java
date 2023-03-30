package com.cartorio.valkyria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual.EnteDeclaradoUtilidadePublicaEstadualEntity;

public interface EnteDeclaradoUtilidadePublicaEstadualRepository<P> extends CrudRepository<EnteDeclaradoUtilidadePublicaEstadualEntity, Long> {
  
  EnteDeclaradoUtilidadePublicaEstadualEntity findByCdEntePub(Long cdEntePub);

  List<EnteDeclaradoUtilidadePublicaEstadualEntity> findByNomeEntidade(String nomeEntidade);

}
