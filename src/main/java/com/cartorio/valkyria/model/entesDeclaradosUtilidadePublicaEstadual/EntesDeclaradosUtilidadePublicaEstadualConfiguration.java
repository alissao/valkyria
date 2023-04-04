package com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

import com.cartorio.valkyria.model.tjClient.TjWebServiceClient;
import com.cartorio.valkyria.model.utility.LoggingInterceptor;

// import com.cartorio.valkyria.model.tjClient.EnteDeclaradoUtilidadePublicaEstadualWSSupport;

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
  public TjWebServiceClient tjWebServiceClient(Jaxb2Marshaller marshaller) {
		TjWebServiceClient client = new TjWebServiceClient();
		client.setDefaultUri("http://selo.tjsc.jus.br/selo_teste/SeloService");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		client.setInterceptors(new ClientInterceptor[]{new LoggingInterceptor()});
		return client;
	}
  
}
