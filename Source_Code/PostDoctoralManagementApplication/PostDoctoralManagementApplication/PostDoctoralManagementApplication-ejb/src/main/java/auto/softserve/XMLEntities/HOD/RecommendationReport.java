//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.23 at 03:49:46 PM CAT 
//


package auto.softserve.XMLEntities.HOD;

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
 *         &lt;element name="scientificMeritOfApplication" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="academicMeritOfResearchLeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fulltimeAcademicStaffMember" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="academicMeritAndSuitablityOfCandidate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="candidateMeetsPhDAgeRequirement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="candidateMeetsAgeRequirment" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="candidateAgeMotivation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="doesCandidateFit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="infrastructureAvailability" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "scientificMeritOfApplication",
    "academicMeritOfResearchLeader",
    "fulltimeAcademicStaffMember",
    "academicMeritAndSuitablityOfCandidate",
    "candidateMeetsPhDAgeRequirement",
    "candidateMeetsAgeRequirment",
    "candidateAgeMotivation",
    "doesCandidateFit",
    "infrastructureAvailability"
})
@XmlRootElement(name = "recommendationReport")
public class RecommendationReport {

    @XmlElement(required = true)
    protected String scientificMeritOfApplication;
    @XmlElement(required = true)
    protected String academicMeritOfResearchLeader;
    protected boolean fulltimeAcademicStaffMember;
    @XmlElement(required = true)
    protected String academicMeritAndSuitablityOfCandidate;
    protected boolean candidateMeetsPhDAgeRequirement;
    protected boolean candidateMeetsAgeRequirment;
    @XmlElement(required = true)
    protected String candidateAgeMotivation;
    protected boolean doesCandidateFit;
    @XmlElement(required = true)
    protected String infrastructureAvailability;

    /**
     * Gets the value of the scientificMeritOfApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScientificMeritOfApplication() {
        return scientificMeritOfApplication;
    }

    /**
     * Sets the value of the scientificMeritOfApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScientificMeritOfApplication(String value) {
        this.scientificMeritOfApplication = value;
    }

    /**
     * Gets the value of the academicMeritOfResearchLeader property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcademicMeritOfResearchLeader() {
        return academicMeritOfResearchLeader;
    }

    /**
     * Sets the value of the academicMeritOfResearchLeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcademicMeritOfResearchLeader(String value) {
        this.academicMeritOfResearchLeader = value;
    }

    /**
     * Gets the value of the fulltimeAcademicStaffMember property.
     * 
     */
    public boolean isFulltimeAcademicStaffMember() {
        return fulltimeAcademicStaffMember;
    }

    /**
     * Sets the value of the fulltimeAcademicStaffMember property.
     * 
     */
    public void setFulltimeAcademicStaffMember(boolean value) {
        this.fulltimeAcademicStaffMember = value;
    }

    /**
     * Gets the value of the academicMeritAndSuitablityOfCandidate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcademicMeritAndSuitablityOfCandidate() {
        return academicMeritAndSuitablityOfCandidate;
    }

    /**
     * Sets the value of the academicMeritAndSuitablityOfCandidate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcademicMeritAndSuitablityOfCandidate(String value) {
        this.academicMeritAndSuitablityOfCandidate = value;
    }

    /**
     * Gets the value of the candidateMeetsPhDAgeRequirement property.
     * 
     */
    public boolean isCandidateMeetsPhDAgeRequirement() {
        return candidateMeetsPhDAgeRequirement;
    }

    /**
     * Sets the value of the candidateMeetsPhDAgeRequirement property.
     * 
     */
    public void setCandidateMeetsPhDAgeRequirement(boolean value) {
        this.candidateMeetsPhDAgeRequirement = value;
    }

    /**
     * Gets the value of the candidateMeetsAgeRequirment property.
     * 
     */
    public boolean isCandidateMeetsAgeRequirment() {
        return candidateMeetsAgeRequirment;
    }

    /**
     * Sets the value of the candidateMeetsAgeRequirment property.
     * 
     */
    public void setCandidateMeetsAgeRequirment(boolean value) {
        this.candidateMeetsAgeRequirment = value;
    }

    /**
     * Gets the value of the candidateAgeMotivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCandidateAgeMotivation() {
        return candidateAgeMotivation;
    }

    /**
     * Sets the value of the candidateAgeMotivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCandidateAgeMotivation(String value) {
        this.candidateAgeMotivation = value;
    }

    /**
     * Gets the value of the doesCandidateFit property.
     * 
     */
    public boolean isDoesCandidateFit() {
        return doesCandidateFit;
    }

    /**
     * Sets the value of the doesCandidateFit property.
     * 
     */
    public void setDoesCandidateFit(boolean value) {
        this.doesCandidateFit = value;
    }

    /**
     * Gets the value of the infrastructureAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfrastructureAvailability() {
        return infrastructureAvailability;
    }

    /**
     * Sets the value of the infrastructureAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfrastructureAvailability(String value) {
        this.infrastructureAvailability = value;
    }

}