
package org.tempuri;

import javax.xml.ws.WebFault;
import com.microsoft.schemas.research._2009._10.webngram.fault.ServiceFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.0
 * 
 */
@WebFault(name = "ServiceFault", targetNamespace = "http://schemas.microsoft.com/research/2009/10/webngram/fault")
public class ILookupServiceGetProbabilityServiceFaultFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ServiceFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ILookupServiceGetProbabilityServiceFaultFaultFaultMessage(String message, ServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ILookupServiceGetProbabilityServiceFaultFaultFaultMessage(String message, ServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.microsoft.schemas.research._2009._10.webngram.fault.ServiceFault
     */
    public ServiceFault getFaultInfo() {
        return faultInfo;
    }

}
