package com.cartorio.valkyria.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
  
}
