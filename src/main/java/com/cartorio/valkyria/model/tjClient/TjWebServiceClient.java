package com.cartorio.valkyria.model.tjClient;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.cartorio.valkyria.wsdl.GetEntesDeclaradosUtilidadePublicaEstadual;
import com.cartorio.valkyria.wsdl.GetEntesDeclaradosUtilidadePublicaEstadualResponse;
import com.cartorio.valkyria.wsdl.ObjectFactory;

public class TjWebServiceClient extends WebServiceGatewaySupport {
  private final String username = "cartorio";
  private final String password = "selodigital";

  public GetEntesDeclaradosUtilidadePublicaEstadualResponse getEntesDeclaradosUtilidadePublicaEstadualResponse() {
    GetEntesDeclaradosUtilidadePublicaEstadual request = new GetEntesDeclaradosUtilidadePublicaEstadual();
    JAXBElement<GetEntesDeclaradosUtilidadePublicaEstadual> jaxBElementRequest = 
        new ObjectFactory().createGetEntesDeclaradosUtilidadePublicaEstadual(request);
        
        logger.info("Requesting EnteDeclaradoUtilidadePublicaEstadual for http://selo.tjsc.jus.br/selo_teste/SeloService");
        
    JAXBElement<GetEntesDeclaradosUtilidadePublicaEstadualResponse> jaxBElementEntesDeclaradosResponse = 
        (JAXBElement<GetEntesDeclaradosUtilidadePublicaEstadualResponse>) getWebServiceTemplate()
				  .marshalSendAndReceive("http://selo.tjsc.jus.br/selo_teste/SeloService", jaxBElementRequest,
                  new AuthWebServiceCallback(username, password));

		return jaxBElementEntesDeclaradosResponse.getValue();

  }

}


// public class EnteDeclaradoUtilidadePublicaEstadualWSSupport extends WebServiceGatewaySupport {


// }
