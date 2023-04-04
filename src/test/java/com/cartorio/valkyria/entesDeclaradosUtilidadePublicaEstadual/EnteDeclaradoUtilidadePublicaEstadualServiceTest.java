package com.cartorio.valkyria.entesDeclaradosUtilidadePublicaEstadual;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.cartorio.valkyria.model.tjClient.TjWebServiceClient;
import com.cartorio.valkyria.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import com.cartorio.valkyria.service.EnteDeclaradoUtilidadePublicaEstadualService;
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
  
}
