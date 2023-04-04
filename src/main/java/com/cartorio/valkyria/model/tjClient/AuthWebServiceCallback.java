package com.cartorio.valkyria.model.tjClient;

import java.io.IOException;
import java.util.Base64;

import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;

public class AuthWebServiceCallback implements WebServiceMessageCallback {

  private static Log log = LogFactory.getLog(AuthWebServiceCallback.class);

  private String username;
  private String password;

  public AuthWebServiceCallback(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
    SoapMessage soapMessage = (SoapMessage) message;
    SoapHeader soapHeader = soapMessage.getSoapHeader();
    
    if (soapHeader != null) {
      String credentials = username + ":" + password;
      String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
    
      QName qname = new QName("http://selo.tjsc.jus.br/selo_teste/SeloService", "AuthorizationHeader");
      SoapHeaderElement headerElement = soapHeader.addHeaderElement(qname);
      headerElement.setText(encodedCredentials);
      log.info("Auth headers added to " + soapMessage.getSoapAction());
    }
  }
  
}
