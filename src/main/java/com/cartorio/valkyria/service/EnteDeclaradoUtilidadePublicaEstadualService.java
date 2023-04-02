package com.cartorio.valkyria.service;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual.EnteDeclaradoUtilidadePublicaEstadualEntity;
import com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual.EnteDeclaradoUtilidadePublicaEstadualWSSupport;
import com.cartorio.valkyria.model.utility.CustomMapper;
import com.cartorio.valkyria.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import com.cartorio.valkyria.wsdl.GetEntesDeclaradosUtilidadePublicaEstadualResponse;

@Service
public class EnteDeclaradoUtilidadePublicaEstadualService {

  private static final Log logger = LogFactory.getLog(EnteDeclaradoUtilidadePublicaEstadualService.class);

  @Autowired
  private EnteDeclaradoUtilidadePublicaEstadualRepository<EnteDeclaradoUtilidadePublicaEstadualEntity> repository;

  @Autowired
  private EnteDeclaradoUtilidadePublicaEstadualWSSupport enteSupport;

  @Autowired
  private CustomMapper mapper;

  @PostConstruct
  public void init() {
    logger.info("Checking if database has EntesDeclaradosUtilidadePublicaEstadual populated...");

    if (repository.count() < 1) {
      logger.info("Database empty. Populating it...");
      GetEntesDeclaradosUtilidadePublicaEstadualResponse entesDeclaradosResponse = enteSupport.getEntesDeclaradosUtilidadePublicaEstadualResponse();
      
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
  
}
