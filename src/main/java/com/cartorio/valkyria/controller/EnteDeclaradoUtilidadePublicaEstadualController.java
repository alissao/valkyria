package com.cartorio.valkyria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cartorio.valkyria.model.utility.CustomMapper;
import com.cartorio.valkyria.service.EnteDeclaradoUtilidadePublicaEstadualService;
import com.cartorio.valkyria.wsdl.EnteDeclaradoUtilidadePublicaEstadual;

@RestController
@RequestMapping("api/ente-declarado-utilidade-publica-estadual")
public class EnteDeclaradoUtilidadePublicaEstadualController {

  @Autowired
  private EnteDeclaradoUtilidadePublicaEstadualService service;

  @Autowired
  private CustomMapper mapper;

  @GetMapping("/v1/id/{id}")
  public ResponseEntity<EnteDeclaradoUtilidadePublicaEstadual> findByCdEnte(@PathVariable Long id) {
    return service.findByCdEntePub(id)
        .map(entity -> ResponseEntity.ok(mapper.map(entity, EnteDeclaradoUtilidadePublicaEstadual.class)))
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/v1/nome-entidade/{name}")
  public ResponseEntity<Page<EnteDeclaradoUtilidadePublicaEstadual>> findByNomeEnte(@PathVariable String name, @RequestParam int page) {
    return ResponseEntity.ok(service.findByNomeEntidade(name, PageRequest.of(page, 5)));
  }

  
}
