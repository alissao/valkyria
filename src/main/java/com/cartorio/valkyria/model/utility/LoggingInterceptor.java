package com.cartorio.valkyria.model.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

public class LoggingInterceptor implements ClientInterceptor {

  private static Log log = LogFactory.getLog(LoggingInterceptor.class);

  @Override
  public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
    log.info("Calling TJSC");
    log.debug("Request: " + messageContext.getRequest().toString());
    return true;
  }

  @Override
  public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException{
    log.info("TJSC response: " + messageContext.hasResponse());
    log.debug("Response: " + messageContext.getResponse().toString());
    return true;
  }

  @Override
  public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
    return false;
  }

  @Override
  public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {};

}
