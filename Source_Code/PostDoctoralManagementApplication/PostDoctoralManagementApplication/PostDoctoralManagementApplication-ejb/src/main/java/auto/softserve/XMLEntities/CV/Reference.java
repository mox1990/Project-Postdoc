//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.28 at 11:55:59 AM CAT 
//


package auto.softserve.XMLEntities.CV;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for reference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publicationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publicationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="publicationPageLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publicationMediumName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publisher" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publicationReferenceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publicationISBN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reference", propOrder = {
    "type",
    "publicationName",
    "publicationDate",
    "publicationPageLocation",
    "publicationMediumName",
    "publisher",
    "publicationReferenceCode",
    "publicationISBN"
})
public class Reference {

    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String publicationName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar publicationDate;
    @XmlElement(required = true)
    protected String publicationPageLocation;
    @XmlElement(required = true)
    protected String publicationMediumName;
    @XmlElement(required = true)
    protected String publisher;
    @XmlElement(required = true)
    protected String publicationReferenceCode;
    @XmlElement(required = true)
    protected String publicationISBN;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the publicationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationName() {
        return publicationName;
    }

    /**
     * Sets the value of the publicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationName(String value) {
        this.publicationName = value;
    }

    /**
     * Gets the value of the publicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the value of the publicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPublicationDate(XMLGregorianCalendar value) {
        this.publicationDate = value;
    }

    /**
     * Gets the value of the publicationPageLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationPageLocation() {
        return publicationPageLocation;
    }

    /**
     * Sets the value of the publicationPageLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationPageLocation(String value) {
        this.publicationPageLocation = value;
    }

    /**
     * Gets the value of the publicationMediumName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationMediumName() {
        return publicationMediumName;
    }

    /**
     * Sets the value of the publicationMediumName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationMediumName(String value) {
        this.publicationMediumName = value;
    }

    /**
     * Gets the value of the publisher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the value of the publisher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisher(String value) {
        this.publisher = value;
    }

    /**
     * Gets the value of the publicationReferenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationReferenceCode() {
        return publicationReferenceCode;
    }

    /**
     * Sets the value of the publicationReferenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationReferenceCode(String value) {
        this.publicationReferenceCode = value;
    }

    /**
     * Gets the value of the publicationISBN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationISBN() {
        return publicationISBN;
    }

    /**
     * Sets the value of the publicationISBN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationISBN(String value) {
        this.publicationISBN = value;
    }

}
