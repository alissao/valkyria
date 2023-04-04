package com.cartorio.valkyria.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual.EnteDeclaradoUtilidadePublicaEstadualEntity;
import com.cartorio.valkyria.model.tjClient.TjWebServiceClient;
import com.cartorio.valkyria.model.utility.CustomMapper;
import com.cartorio.valkyria.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import com.cartorio.valkyria.wsdl.EnteDeclaradoUtilidadePublicaEstadual;
import com.cartorio.valkyria.wsdl.GetEntesDeclaradosUtilidadePublicaEstadualResponse;

@Service
public class EnteDeclaradoUtilidadePublicaEstadualService {

  private static final Log logger = LogFactory.getLog(EnteDeclaradoUtilidadePublicaEstadualService.class);

  @Autowired
  private EnteDeclaradoUtilidadePublicaEstadualRepository<EnteDeclaradoUtilidadePublicaEstadualEntity> repository;

  @Autowired
  private TjWebServiceClient webServiceClient;

  @Autowired
  private CustomMapper mapper;

  @PostConstruct
  public void init() {
    logger.info("Checking if database has EntesDeclaradosUtilidadePublicaEstadual populated...");

    if (repository.count() < 1) {
      logger.info("Database empty. Populating it...");
      GetEntesDeclaradosUtilidadePublicaEstadualResponse entesDeclaradosResponse = webServiceClient.getEntesDeclaradosUtilidadePublicaEstadualResponse();
      
      entesDeclaradosResponse.getEntesDeclaradosUtilidadePublicaEstadual()
          .stream()
          .map(enteResponse -> mapper.map(enteResponse, EnteDeclaradoUtilidadePublicaEstadualEntity.class))
          .forEach(enteEntity -> 
            repository.save(enteEntity)
          );
      logger.info("Database populated.");
    } else {
      logger.info("Database already populated. Starting service.");
    }
  }

  public Optional<EnteDeclaradoUtilidadePublicaEstadualEntity> findByCdEntePub(Long cdEntePub) {
    return repository.findByCdEntePub(cdEntePub);
  }

  public Page<EnteDeclaradoUtilidadePublicaEstadual> findByNomeEntidade(String nomeEntidade, Pageable pageable) {
    var pagedQuery = repository.findByNomeEntidade(nomeEntidade, pageable);
    List<EnteDeclaradoUtilidadePublicaEstadual> mappedPagedContent = pagedQuery.toList().stream()
        .map(entity -> mapper.map(entity, EnteDeclaradoUtilidadePublicaEstadual.class))
        .collect(Collectors.toList());
    return new PageImpl<EnteDeclaradoUtilidadePublicaEstadual>(mappedPagedContent, pageable, mappedPagedContent.size());
  }
  
}
