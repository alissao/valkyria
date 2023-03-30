package com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EnteDeclaradoUtilidadePublicaEstadual")
public class EnteDeclaradoUtilidadePublicaEstadualEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cdEntePub;
  
  @Column
  private Integer cdComarca;

  @Column
  private String dtLei;
  
  @Column
  private String dtLeiExtenso;
  
  @Column
  private String lei;
  
  @Column
  private String nomeComarca;
  
  @Column
  private String nomeComarcaEntidade;
  
  @Column
  private String nomeEntidade;
  
}
