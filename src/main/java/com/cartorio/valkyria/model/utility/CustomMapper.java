package com.cartorio.valkyria.model.utility;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual.EnteDeclaradoUtilidadePublicaEstadualEntity;
import com.cartorio.valkyria.wsdl.EnteDeclaradoUtilidadePublicaEstadual;

@Component
public class CustomMapper extends ModelMapper {
  
  @PostConstruct
  private void init() {
    typeMappingFor_EnteDeclaradoUtilidadePublicaEstadual();
  }

  private void typeMappingFor_EnteDeclaradoUtilidadePublicaEstadual() {
    //Entity to XML
    this
        .typeMap(EnteDeclaradoUtilidadePublicaEstadualEntity.class, EnteDeclaradoUtilidadePublicaEstadual.class)
        .addMappings(mapperConsummable -> {
          mapperConsummable.map(src -> src.getCdComarca(), EnteDeclaradoUtilidadePublicaEstadual::setCdcomarca);
          mapperConsummable.map(src -> src.getCdEntePub(), EnteDeclaradoUtilidadePublicaEstadual::setCdentepub);
        });
    //XML to Entity
    this
        .typeMap(EnteDeclaradoUtilidadePublicaEstadual.class, EnteDeclaradoUtilidadePublicaEstadualEntity.class)
        .addMappings(mapperConsummable -> {
          mapperConsummable.map(src -> src.getCdcomarca(), EnteDeclaradoUtilidadePublicaEstadualEntity::setCdComarca);
          mapperConsummable.map(src -> src.getCdentepub(), EnteDeclaradoUtilidadePublicaEstadualEntity::setCdEntePub);
        });
  }


}
