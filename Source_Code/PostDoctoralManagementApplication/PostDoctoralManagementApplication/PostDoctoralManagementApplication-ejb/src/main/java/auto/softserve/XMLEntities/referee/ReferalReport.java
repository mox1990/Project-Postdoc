//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.26 at 10:39:25 AM CAT 
//


package auto.softserve.XMLEntities.referee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="projectTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="projectSummary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="refereeAndCandidateAssociation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="evaluationOfCandidateTowardsProposedProject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="evaluationOfCandidateSelf" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "projectTitle",
    "projectSummary",
    "refereeAndCandidateAssociation",
    "evaluationOfCandidateTowardsProposedProject",
    "evaluationOfCandidateSelf"
})
@XmlRootElement(name = "referalReport")
public class ReferalReport {

    @XmlElement(required = true)
    protected String projectTitle;
    @XmlElement(required = true)
    protected String projectSummary;
    @XmlElement(required = true)
    protected String refereeAndCandidateAssociation;
    @XmlElement(required = true)
    protected String evaluationOfCandidateTowardsProposedProject;
    @XmlElement(required = true)
    protected String evaluationOfCandidateSelf;

    /**
     * Gets the value of the projectTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * Sets the value of the projectTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectTitle(String value) {
        this.projectTitle = value;
    }

    /**
     * Gets the value of the projectSummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectSummary() {
        return projectSummary;
    }

    /**
     * Sets the value of the projectSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectSummary(String value) {
        this.projectSummary = value;
    }

    /**
     * Gets the value of the refereeAndCandidateAssociation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefereeAndCandidateAssociation() {
        return refereeAndCandidateAssociation;
    }

    /**
     * Sets the value of the refereeAndCandidateAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefereeAndCandidateAssociation(String value) {
        this.refereeAndCandidateAssociation = value;
    }

    /**
     * Gets the value of the evaluationOfCandidateTowardsProposedProject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluationOfCandidateTowardsProposedProject() {
        return evaluationOfCandidateTowardsProposedProject;
    }

    /**
     * Sets the value of the evaluationOfCandidateTowardsProposedProject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluationOfCandidateTowardsProposedProject(String value) {
        this.evaluationOfCandidateTowardsProposedProject = value;
    }

    /**
     * Gets the value of the evaluationOfCandidateSelf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluationOfCandidateSelf() {
        return evaluationOfCandidateSelf;
    }

    /**
     * Sets the value of the evaluationOfCandidateSelf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluationOfCandidateSelf(String value) {
        this.evaluationOfCandidateSelf = value;
    }

}
