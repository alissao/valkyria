package com.cartorio.valkyria.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual.EnteDeclaradoUtilidadePublicaEstadualEntity;
import com.cartorio.valkyria.model.tjClient.TjWebServiceClient;
import com.cartorio.valkyria.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import com.cartorio.valkyria.wsdl.EnteDeclaradoUtilidadePublicaEstadual;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class EnteDeclaradoUtilidadePublicaEstadualServiceTest {
  
  @Mock
  private EnteDeclaradoUtilidadePublicaEstadualRepository<EnteDeclaradoUtilidadePublicaEstadual> mockRepository;

  @Mock
  private TjWebServiceClient mockWebServiceClient;

  @Autowired
  @InjectMocks
  private EnteDeclaradoUtilidadePublicaEstadualService mockService;

  @Test
  void should_not_populate_database() {
    // Arrange
    when(mockRepository.count()).thenReturn(10L);

    // Act
    mockService.init();

    // Assert
    verify(mockRepository, times(1)).count();
    verifyNoMoreInteractions(mockRepository);
  }


  @Test
  void should_find_and_return_one_enteDeclarado() {
    // Arrange
    EnteDeclaradoUtilidadePublicaEstadualEntity enteDeclaradoEntity = new EnteDeclaradoUtilidadePublicaEstadualEntity();
    enteDeclaradoEntity.setCdComarca(1);
    enteDeclaradoEntity.setCdEntePub(1L);
    enteDeclaradoEntity.setDtLei("01/04/2023");
    enteDeclaradoEntity.setDtLeiExtenso("Primeiro de Abril de Dois Mil e Vinte e Tres");
    enteDeclaradoEntity.setNomeComarca("Comarca Valkyrias");
    enteDeclaradoEntity.setNomeComarcaEntidade("Comarca Valkyrias Vikings");
    enteDeclaradoEntity.setNomeEntidade("Vikings");
    enteDeclaradoEntity.setLei("Lei numero um");
    when(mockRepository.findByCdEntePub(anyLong())).thenReturn(Optional.of(enteDeclaradoEntity));

    // Act
    var optionalOfEntity = mockService.findByCdEntePub(1L);

    // Assert
    assertTrue(optionalOfEntity.isPresent());
  }

  @Test
  void should_find_and_return_list_of_enteDeclarados() {
    // Arrange
    EnteDeclaradoUtilidadePublicaEstadualEntity enteDeclaradoEntity = new EnteDeclaradoUtilidadePublicaEstadualEntity();
    enteDeclaradoEntity.setCdComarca(1);
    enteDeclaradoEntity.setCdEntePub(1L);
    enteDeclaradoEntity.setDtLei("01/04/2023");
    enteDeclaradoEntity.setDtLeiExtenso("Primeiro de Abril de Dois Mil e Vinte e Tres");
    enteDeclaradoEntity.setNomeComarca("Comarca Valkyrias");
    enteDeclaradoEntity.setNomeComarcaEntidade("Comarca Valkyrias Vikings");
    enteDeclaradoEntity.setNomeEntidade("Vikings");
    enteDeclaradoEntity.setLei("Lei numero um");
    
    EnteDeclaradoUtilidadePublicaEstadualEntity enteDeclaradoEntity2 = new EnteDeclaradoUtilidadePublicaEstadualEntity();
    enteDeclaradoEntity2.setCdComarca(2);
    enteDeclaradoEntity2.setCdEntePub(2L);
    enteDeclaradoEntity2.setDtLei("01/04/2024");
    enteDeclaradoEntity2.setDtLeiExtenso("Primeiro de Abril de Dois Mil e Vinte e Quatro");
    enteDeclaradoEntity2.setNomeComarca("Comarca Valkyrias 2");
    enteDeclaradoEntity2.setNomeComarcaEntidade("Comarca Valkyrias Vikings Segunda Divisao");
    enteDeclaradoEntity2.setNomeEntidade("Vikings 2");
    enteDeclaradoEntity2.setLei("Lei numero dois");
    
    when(mockRepository.findByNomeEntidade(anyString())).thenReturn(List.of(enteDeclaradoEntity, enteDeclaradoEntity2));

    // Act
    var listOfEntes = mockService.findByNomeEntidade(anyString());

    // Assert
    assertFalse(listOfEntes.isEmpty());
  }
  
}
