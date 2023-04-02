package com.cartorio.valkyria.service;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    logger.info("Populating database");
    // GetEntesDeclaradosUtilidadePublicaEstadualResponse entesDeclaradosResponse = enteSupport.getEntesDeclaradosUtilidadePublicaEstadualResponse();
    
    // entesDeclaradosResponse.getEntesDeclaradosUtilidadePublicaEstadual()
    //     .stream().map(enteResponse -> )
  }
  
}
