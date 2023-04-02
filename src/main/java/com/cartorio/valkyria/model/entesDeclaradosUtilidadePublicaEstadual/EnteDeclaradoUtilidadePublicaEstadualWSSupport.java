package com.cartorio.valkyria.model.entesDeclaradosUtilidadePublicaEstadual;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.cartorio.valkyria.wsdl.GetEntesDeclaradosUtilidadePublicaEstadual;
import com.cartorio.valkyria.wsdl.GetEntesDeclaradosUtilidadePublicaEstadualResponse;
import com.cartorio.valkyria.wsdl.ObjectFactory;

public class EnteDeclaradoUtilidadePublicaEstadualWSSupport extends WebServiceGatewaySupport {

  public GetEntesDeclaradosUtilidadePublicaEstadualResponse getEntesDeclaradosUtilidadePublicaEstadualResponse() {
    GetEntesDeclaradosUtilidadePublicaEstadual request = new GetEntesDeclaradosUtilidadePublicaEstadual();
    JAXBElement<GetEntesDeclaradosUtilidadePublicaEstadual> jaxBElementRequest = 
        new ObjectFactory().createGetEntesDeclaradosUtilidadePublicaEstadual(request);
    
    logger.info("Requesting EnteDeclaradoUtilidadePublicaEstadual for http://selo.tjsc.jus.br/selo_teste/SeloService");

    JAXBElement<GetEntesDeclaradosUtilidadePublicaEstadualResponse> jaxBElementEntesDeclaradosResponse = 
        (JAXBElement<GetEntesDeclaradosUtilidadePublicaEstadualResponse>) getWebServiceTemplate()
				  .marshalSendAndReceive("http://selo.tjsc.jus.br/selo_teste/SeloService", jaxBElementRequest,
						new SoapActionCallback(
								""));

		return jaxBElementEntesDeclaradosResponse.getValue();

  }

}
