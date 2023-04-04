package com.cartorio.valkyria.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cartorio.valkyria.model.utility.CustomMapper;
import com.cartorio.valkyria.service.EnteDeclaradoUtilidadePublicaEstadualService;
import com.cartorio.valkyria.wsdl.EnteDeclaradoUtilidadePublicaEstadual;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@WebMvcTest(controllers = {EnteDeclaradoUtilidadePublicaEstadualController.class}, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class EnteDeclaradoUtilidadePublicaEstadualControllerTest {

  @MockBean
  private EnteDeclaradoUtilidadePublicaEstadualService mockService;
  
  @MockBean
  private CustomMapper mapper;
  
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void should_return_not_found_for_non_existent_id() throws Exception {
    // Arrange
    when(mockService.findByCdEntePub(anyLong()))
        .thenReturn(Optional.empty());
    when(mapper.map(Optional.empty(), EnteDeclaradoUtilidadePublicaEstadual.class))
        .thenReturn(null);

    mockMvc
        // Act
        .perform(
            get("/api/ente-declarado-utilidade-publica-estadual/v1/id/1")
            .contentType(MediaType.APPLICATION_JSON)
        )
        // Assert
        .andExpect(status().isNotFound());
  }

  @Test
  public void should_return_second_page() throws Exception {
    // Arrange
    EnteDeclaradoUtilidadePublicaEstadual enteDeclarado = new EnteDeclaradoUtilidadePublicaEstadual();
    enteDeclarado.setCdcomarca(1);
    enteDeclarado.setCdentepub(1L);
    enteDeclarado.setDtLei("01/04/2023");
    enteDeclarado.setDtLeiExtenso("Primeiro de Abril de Dois Mil e Vinte e Tres");
    enteDeclarado.setNomeComarca("Comarca Valkyrias");
    enteDeclarado.setNomeComarcaEntidade("Comarca Valkyrias Vikings");
    enteDeclarado.setNomeEntidade("Vikings");
    enteDeclarado.setLei("Lei numero um");
    
    EnteDeclaradoUtilidadePublicaEstadual enteDeclarado2 = new EnteDeclaradoUtilidadePublicaEstadual();
    enteDeclarado2.setCdcomarca(2);
    enteDeclarado2.setCdentepub(2L);
    enteDeclarado2.setDtLei("01/04/2024");
    enteDeclarado2.setDtLeiExtenso("Primeiro de Abril de Dois Mil e Vinte e Quatro");
    enteDeclarado2.setNomeComarca("Comarca Valkyrias 2");
    enteDeclarado2.setNomeComarcaEntidade("Comarca Valkyrias Vikings Segunda Divisao");
    enteDeclarado2.setNomeEntidade("Vikings 2");
    enteDeclarado2.setLei("Lei numero dois");
    when(mockService.findByNomeEntidade(anyString(), Mockito.any(PageRequest.class)))
        .thenReturn(new PageImpl<EnteDeclaradoUtilidadePublicaEstadual>(List.of(enteDeclarado, enteDeclarado2), PageRequest.of(1, 2), 2));
    // when(mapper.map(Optional.empty(), EnteDeclaradoUtilidadePublicaEstadual.class))
    //     .thenReturn(null);

    mockMvc
        // Act
        .perform(
            get("/api/ente-declarado-utilidade-publica-estadual/v1/nome-entidade/asdasdqwe?page=2")
            .contentType(MediaType.APPLICATION_JSON)
        )
        // Assert
        .andExpect(status().isOk());
  }
  
}
