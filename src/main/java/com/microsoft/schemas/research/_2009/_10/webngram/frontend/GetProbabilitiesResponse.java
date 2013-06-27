
package com.microsoft.schemas.research._2009._10.webngram.frontend;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOffloat;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetProbabilitiesResult" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOffloat" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getProbabilitiesResult"
})
@XmlRootElement(name = "GetProbabilitiesResponse")
public class GetProbabilitiesResponse {

    @XmlElementRef(name = "GetProbabilitiesResult", namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", type = JAXBElement.class)
    protected JAXBElement<ArrayOffloat> getProbabilitiesResult;

    /**
     * Gets the value of the getProbabilitiesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOffloat }{@code >}
     *     
     */
    public JAXBElement<ArrayOffloat> getGetProbabilitiesResult() {
        return getProbabilitiesResult;
    }

    /**
     * Sets the value of the getProbabilitiesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOffloat }{@code >}
     *     
     */
    public void setGetProbabilitiesResult(JAXBElement<ArrayOffloat> value) {
        this.getProbabilitiesResult = value;
    }

}
