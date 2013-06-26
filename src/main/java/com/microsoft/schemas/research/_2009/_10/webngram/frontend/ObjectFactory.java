
package com.microsoft.schemas.research._2009._10.webngram.frontend;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOffloat;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.research._2009._10.webngram.frontend package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProbabilitiesPhrases_QNAME = new QName("http://schemas.microsoft.com/research/2009/10/webngram/frontend", "phrases");
    private final static QName _GetProbabilitiesAuthorizationToken_QNAME = new QName("http://schemas.microsoft.com/research/2009/10/webngram/frontend", "authorizationToken");
    private final static QName _GetProbabilitiesModelUrn_QNAME = new QName("http://schemas.microsoft.com/research/2009/10/webngram/frontend", "modelUrn");
    private final static QName _GetConditionalProbabilityPhrase_QNAME = new QName("http://schemas.microsoft.com/research/2009/10/webngram/frontend", "phrase");
    private final static QName _GetProbabilitiesResponseGetProbabilitiesResult_QNAME = new QName("http://schemas.microsoft.com/research/2009/10/webngram/frontend", "GetProbabilitiesResult");
    private final static QName _GetConditionalProbabilitiesResponseGetConditionalProbabilitiesResult_QNAME = new QName("http://schemas.microsoft.com/research/2009/10/webngram/frontend", "GetConditionalProbabilitiesResult");
    private final static QName _GetModelsResponseGetModelsResult_QNAME = new QName("http://schemas.microsoft.com/research/2009/10/webngram/frontend", "GetModelsResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.research._2009._10.webngram.frontend
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProbabilitiesResponse }
     * 
     */
    public GetProbabilitiesResponse createGetProbabilitiesResponse() {
        return new GetProbabilitiesResponse();
    }

    /**
     * Create an instance of {@link GetConditionalProbabilityResponse }
     * 
     */
    public GetConditionalProbabilityResponse createGetConditionalProbabilityResponse() {
        return new GetConditionalProbabilityResponse();
    }

    /**
     * Create an instance of {@link GetProbabilityResponse }
     * 
     */
    public GetProbabilityResponse createGetProbabilityResponse() {
        return new GetProbabilityResponse();
    }

    /**
     * Create an instance of {@link GetConditionalProbabilitiesResponse }
     * 
     */
    public GetConditionalProbabilitiesResponse createGetConditionalProbabilitiesResponse() {
        return new GetConditionalProbabilitiesResponse();
    }

    /**
     * Create an instance of {@link GetModelsResponse }
     * 
     */
    public GetModelsResponse createGetModelsResponse() {
        return new GetModelsResponse();
    }

    /**
     * Create an instance of {@link GetModels }
     * 
     */
    public GetModels createGetModels() {
        return new GetModels();
    }

    /**
     * Create an instance of {@link GetConditionalProbabilities }
     * 
     */
    public GetConditionalProbabilities createGetConditionalProbabilities() {
        return new GetConditionalProbabilities();
    }

    /**
     * Create an instance of {@link GetConditionalProbability }
     * 
     */
    public GetConditionalProbability createGetConditionalProbability() {
        return new GetConditionalProbability();
    }

    /**
     * Create an instance of {@link GetProbability }
     * 
     */
    public GetProbability createGetProbability() {
        return new GetProbability();
    }

    /**
     * Create an instance of {@link GetProbabilities }
     * 
     */
    public GetProbabilities createGetProbabilities() {
        return new GetProbabilities();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "phrases", scope = GetProbabilities.class)
    public JAXBElement<ArrayOfstring> createGetProbabilitiesPhrases(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetProbabilitiesPhrases_QNAME, ArrayOfstring.class, GetProbabilities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "authorizationToken", scope = GetProbabilities.class)
    public JAXBElement<String> createGetProbabilitiesAuthorizationToken(String value) {
        return new JAXBElement<String>(_GetProbabilitiesAuthorizationToken_QNAME, String.class, GetProbabilities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "modelUrn", scope = GetProbabilities.class)
    public JAXBElement<String> createGetProbabilitiesModelUrn(String value) {
        return new JAXBElement<String>(_GetProbabilitiesModelUrn_QNAME, String.class, GetProbabilities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "phrases", scope = GetConditionalProbabilities.class)
    public JAXBElement<ArrayOfstring> createGetConditionalProbabilitiesPhrases(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetProbabilitiesPhrases_QNAME, ArrayOfstring.class, GetConditionalProbabilities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "authorizationToken", scope = GetConditionalProbabilities.class)
    public JAXBElement<String> createGetConditionalProbabilitiesAuthorizationToken(String value) {
        return new JAXBElement<String>(_GetProbabilitiesAuthorizationToken_QNAME, String.class, GetConditionalProbabilities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "modelUrn", scope = GetConditionalProbabilities.class)
    public JAXBElement<String> createGetConditionalProbabilitiesModelUrn(String value) {
        return new JAXBElement<String>(_GetProbabilitiesModelUrn_QNAME, String.class, GetConditionalProbabilities.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "authorizationToken", scope = GetConditionalProbability.class)
    public JAXBElement<String> createGetConditionalProbabilityAuthorizationToken(String value) {
        return new JAXBElement<String>(_GetProbabilitiesAuthorizationToken_QNAME, String.class, GetConditionalProbability.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "phrase", scope = GetConditionalProbability.class)
    public JAXBElement<String> createGetConditionalProbabilityPhrase(String value) {
        return new JAXBElement<String>(_GetConditionalProbabilityPhrase_QNAME, String.class, GetConditionalProbability.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "modelUrn", scope = GetConditionalProbability.class)
    public JAXBElement<String> createGetConditionalProbabilityModelUrn(String value) {
        return new JAXBElement<String>(_GetProbabilitiesModelUrn_QNAME, String.class, GetConditionalProbability.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOffloat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "GetProbabilitiesResult", scope = GetProbabilitiesResponse.class)
    public JAXBElement<ArrayOffloat> createGetProbabilitiesResponseGetProbabilitiesResult(ArrayOffloat value) {
        return new JAXBElement<ArrayOffloat>(_GetProbabilitiesResponseGetProbabilitiesResult_QNAME, ArrayOffloat.class, GetProbabilitiesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOffloat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "GetConditionalProbabilitiesResult", scope = GetConditionalProbabilitiesResponse.class)
    public JAXBElement<ArrayOffloat> createGetConditionalProbabilitiesResponseGetConditionalProbabilitiesResult(ArrayOffloat value) {
        return new JAXBElement<ArrayOffloat>(_GetConditionalProbabilitiesResponseGetConditionalProbabilitiesResult_QNAME, ArrayOffloat.class, GetConditionalProbabilitiesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "GetModelsResult", scope = GetModelsResponse.class)
    public JAXBElement<ArrayOfstring> createGetModelsResponseGetModelsResult(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetModelsResponseGetModelsResult_QNAME, ArrayOfstring.class, GetModelsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "authorizationToken", scope = GetProbability.class)
    public JAXBElement<String> createGetProbabilityAuthorizationToken(String value) {
        return new JAXBElement<String>(_GetProbabilitiesAuthorizationToken_QNAME, String.class, GetProbability.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "phrase", scope = GetProbability.class)
    public JAXBElement<String> createGetProbabilityPhrase(String value) {
        return new JAXBElement<String>(_GetConditionalProbabilityPhrase_QNAME, String.class, GetProbability.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/research/2009/10/webngram/frontend", name = "modelUrn", scope = GetProbability.class)
    public JAXBElement<String> createGetProbabilityModelUrn(String value) {
        return new JAXBElement<String>(_GetProbabilitiesModelUrn_QNAME, String.class, GetProbability.class, value);
    }

}
