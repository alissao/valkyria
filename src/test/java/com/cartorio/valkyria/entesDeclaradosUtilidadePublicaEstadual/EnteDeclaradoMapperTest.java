package com.cartorio.valkyria.entesDeclaradosUtilidadePublicaEstadual;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual.EnteDeclaradoUtilidadePublicaEstadualEntity;
import com.cartorio.valkyria.wsdl.EnteDeclaradoUtilidadePublicaEstadual;

public class EnteDeclaradoMapperTest {

  ModelMapper mapper;

  @BeforeEach
  void typeMappingBeforeTest() {
    this.mapper = new ModelMapper();
    //Entity to XML
    mapper
        .typeMap(EnteDeclaradoUtilidadePublicaEstadualEntity.class, EnteDeclaradoUtilidadePublicaEstadual.class)
        .addMappings(mapperConsummable -> {
          mapperConsummable.map(src -> src.getCdComarca(), EnteDeclaradoUtilidadePublicaEstadual::setCdcomarca);
          mapperConsummable.map(src -> src.getCdEntePub(), EnteDeclaradoUtilidadePublicaEstadual::setCdentepub);
        });
    //XML to Entity
    mapper
        .typeMap(EnteDeclaradoUtilidadePublicaEstadual.class, EnteDeclaradoUtilidadePublicaEstadualEntity.class)
        .addMappings(mapperConsummable -> {
          mapperConsummable.map(src -> src.getCdcomarca(), EnteDeclaradoUtilidadePublicaEstadualEntity::setCdComarca);
          mapperConsummable.map(src -> src.getCdentepub(), EnteDeclaradoUtilidadePublicaEstadualEntity::setCdEntePub);
        });
  }

  @Test
  void mapEntityToXml() {
    
    EnteDeclaradoUtilidadePublicaEstadualEntity enteDeclaradoEntity = new EnteDeclaradoUtilidadePublicaEstadualEntity();
    enteDeclaradoEntity.setCdComarca(1);
    enteDeclaradoEntity.setCdEntePub(1L);
    enteDeclaradoEntity.setDtLei("01/04/2023");
    enteDeclaradoEntity.setDtLeiExtenso("Primeiro de Abril de Dois Mil e Vinte e Tres");
    enteDeclaradoEntity.setNomeComarca("Comarca Valkyrias");
    enteDeclaradoEntity.setNomeComarcaEntidade("Comarca Valkyrias Vikings");
    enteDeclaradoEntity.setNomeEntidade("Vikings");
    enteDeclaradoEntity.setLei("Lei numero um");

    EnteDeclaradoUtilidadePublicaEstadual enteXml = new EnteDeclaradoUtilidadePublicaEstadual();

    mapper.map(enteDeclaradoEntity, enteXml);

    assertAll("Group assertions of EnteDeclaradoEntity mapping to EnteXml",
      () -> assertEquals(enteDeclaradoEntity.getCdComarca(), enteXml.getCdcomarca(), "CdComarca should be equal"),
      () -> assertEquals(enteDeclaradoEntity.getCdEntePub(), enteXml.getCdentepub(), "CdEntePub should be equal"),
      () -> assertEquals(enteDeclaradoEntity.getDtLei(), enteXml.getDtLei(), "DtLei should be equal"),
      () -> assertEquals(enteDeclaradoEntity.getDtLeiExtenso(), enteXml.getDtLeiExtenso(), "DtLeiExtenso should be equal"),
      () -> assertEquals(enteDeclaradoEntity.getNomeComarca(), enteXml.getNomeComarca(), "NomeComarca should be equal"),
      () -> assertEquals(enteDeclaradoEntity.getNomeComarcaEntidade(), enteXml.getNomeComarcaEntidade(), "NomeComarcaEntidade should be equal"),
      () -> assertEquals(enteDeclaradoEntity.getNomeEntidade(), enteXml.getNomeEntidade(), "NomeEntidade should be equal"),
      () -> assertEquals(enteDeclaradoEntity.getLei(), enteXml.getLei(), "Lei should be equal")
    );
  }


  @Test
  void mapXmlToEntity() {
    
    EnteDeclaradoUtilidadePublicaEstadual enteXml = new EnteDeclaradoUtilidadePublicaEstadual();
    enteXml.setCdcomarca(1);
    enteXml.setCdentepub(1L);
    enteXml.setDtLei("01/04/2023");
    enteXml.setDtLeiExtenso("Primeiro de Abril de Dois Mil e Vinte e Tres");
    enteXml.setNomeComarca("Comarca Valkyrias");
    enteXml.setNomeComarcaEntidade("Comarca Valkyrias Vikings");
    enteXml.setNomeEntidade("Vikings");
    enteXml.setLei("Lei numero um");

    EnteDeclaradoUtilidadePublicaEstadualEntity enteDeclaradoEntity = new EnteDeclaradoUtilidadePublicaEstadualEntity();

    mapper.map(enteDeclaradoEntity, enteXml);

    assertAll("Group assertions of EnteDeclaradoEntity mapping to EnteXml",
      () -> assertEquals(enteXml.getCdcomarca(), enteDeclaradoEntity.getCdComarca(), "CdComarca should be equal"),
      () -> assertEquals(enteXml.getCdentepub(), enteDeclaradoEntity.getCdEntePub(), "CdEntePub should be equal"),
      () -> assertEquals(enteXml.getDtLei(), enteDeclaradoEntity.getDtLei(), "DtLei should be equal"),
      () -> assertEquals(enteXml.getDtLeiExtenso(), enteDeclaradoEntity.getDtLeiExtenso(), "DtLeiExtenso should be equal"),
      () -> assertEquals(enteXml.getNomeComarca(), enteDeclaradoEntity.getNomeComarca(), "NomeComarca should be equal"),
      () -> assertEquals(enteXml.getNomeComarcaEntidade(), enteDeclaradoEntity.getNomeComarcaEntidade(), "NomeComarcaEntidade should be equal"),
      () -> assertEquals(enteXml.getNomeEntidade(), enteDeclaradoEntity.getNomeEntidade(), "NomeEntidade should be equal"),
      () -> assertEquals(enteXml.getLei(), enteDeclaradoEntity.getLei(), "Lei should be equal")
    );
  }
  
}
