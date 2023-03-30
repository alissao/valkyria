package com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.cartorio.valkyria.wsdl.GetEntesDeclaradosUtilidadePublicaEstadual;
import com.cartorio.valkyria.wsdl.GetEntesDeclaradosUtilidadePublicaEstadualResponse;

public class EnteDeclaradoUtilidadePublicaEstadualWSSupport extends WebServiceGatewaySupport {

  public GetEntesDeclaradosUtilidadePublicaEstadualResponse getEntesDeclaradosUtilidadePublicaEstadualResponse() {
    GetEntesDeclaradosUtilidadePublicaEstadual request = new GetEntesDeclaradosUtilidadePublicaEstadual();
    
    logger.info("Requesting EnteDeclaradoUtilidadePublicaEstadual for http://selo.tjsc.jus.br/selo_teste/SeloService");

    GetEntesDeclaradosUtilidadePublicaEstadualResponse entesDeclaradosResponse = 
        (GetEntesDeclaradosUtilidadePublicaEstadualResponse) getWebServiceTemplate()
				  .marshalSendAndReceive("http://selo.tjsc.jus.br/selo_teste/SeloService", request,
						new SoapActionCallback(
								"http://selo.tjsc.jus.br/selo_teste/SeloService"));

		return entesDeclaradosResponse;

  }

}
