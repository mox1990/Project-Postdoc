//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.02 at 10:00:00 AM CAT 
//


package auto.softserve.XMLEntities.fellow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for attainment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="attainment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expectedAttainment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="actualAttainment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attainment", propOrder = {
    "expectedAttainment",
    "actualAttainment"
})
public class Attainment {

    @XmlElement(required = true)
    protected String expectedAttainment;
    @XmlElement(required = true)
    protected String actualAttainment;

    /**
     * Gets the value of the expectedAttainment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedAttainment() {
        return expectedAttainment;
    }

    /**
     * Sets the value of the expectedAttainment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedAttainment(String value) {
        this.expectedAttainment = value;
    }

    /**
     * Gets the value of the actualAttainment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualAttainment() {
        return actualAttainment;
    }

    /**
     * Sets the value of the actualAttainment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualAttainment(String value) {
        this.actualAttainment = value;
    }

}
