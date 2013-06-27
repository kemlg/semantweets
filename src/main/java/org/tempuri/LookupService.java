
package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.0
 * 
 */
@WebServiceClient(name = "LookupService", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://web-ngram.research.microsoft.com/Lookup.svc/mex?wsdl")
public class LookupService
    extends Service
{

    private final static URL LOOKUPSERVICE_WSDL_LOCATION;
    private final static WebServiceException LOOKUPSERVICE_EXCEPTION;
    private final static QName LOOKUPSERVICE_QNAME = new QName("http://tempuri.org/", "LookupService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://web-ngram.research.microsoft.com/Lookup.svc/mex?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LOOKUPSERVICE_WSDL_LOCATION = url;
        LOOKUPSERVICE_EXCEPTION = e;
    }

    public LookupService() {
        super(__getWsdlLocation(), LOOKUPSERVICE_QNAME);
    }

    public LookupService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns ILookupService
     */
    @WebEndpoint(name = "WSHttpBinding_ILookupService")
    public ILookupService getWSHttpBindingILookupService() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_ILookupService"), ILookupService.class);
    }

    private static URL __getWsdlLocation() {
        if (LOOKUPSERVICE_EXCEPTION!= null) {
            throw LOOKUPSERVICE_EXCEPTION;
        }
        return LOOKUPSERVICE_WSDL_LOCATION;
    }

}
