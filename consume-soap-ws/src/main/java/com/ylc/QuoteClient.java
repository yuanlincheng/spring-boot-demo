package com.ylc;

import com.ylc.wsdl.GetQuote;
import com.ylc.wsdl.GetQuoteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/28 11:31
 * description: xxx
 * own: Aratek
 */

public class QuoteClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(QuoteClient.class);

    public GetQuoteResponse getQuote(String ticker) {

        GetQuote request = new GetQuote();
        request.setSymbol(ticker);

        log.info("Requesting quote for " + ticker);

        GetQuoteResponse response = (GetQuoteResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.com/stockquote.asmx",
                        request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetQuote"));
        return response;
    }

}
