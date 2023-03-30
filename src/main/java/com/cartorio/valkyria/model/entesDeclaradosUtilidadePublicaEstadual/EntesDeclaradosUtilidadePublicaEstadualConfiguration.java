package com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class EntesDeclaradosUtilidadePublicaEstadualConfiguration {

  @Bean
  public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.cartorio.valkyria.wsdl");
		return marshaller;
	}

  @Bean
  public EnteDeclaradoUtilidadePublicaEstadualWSSupport enteDeclaradoUtilidadePublicaEstadual(Jaxb2Marshaller marshaller) {
		EnteDeclaradoUtilidadePublicaEstadualWSSupport client = new EnteDeclaradoUtilidadePublicaEstadualWSSupport();
		client.setDefaultUri("http://selo.tjsc.jus.br/selo_teste/SeloService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
  
}
