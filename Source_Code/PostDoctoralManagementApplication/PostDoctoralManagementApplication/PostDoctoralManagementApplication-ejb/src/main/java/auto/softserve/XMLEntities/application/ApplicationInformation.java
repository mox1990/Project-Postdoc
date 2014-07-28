//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.28 at 11:55:59 AM CAT 
//


package auto.softserve.XMLEntities.application;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="projectMotivation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="projectAims">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="aim" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="researchMethodology" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="researchWorkPlan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expectedOutcomes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="outcome" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="projectInfrastructureFunding" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="teamMembers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="member" type="{}member" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="selfEvaluation" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "projectMotivation",
    "projectAims",
    "researchMethodology",
    "researchWorkPlan",
    "expectedOutcomes",
    "projectInfrastructureFunding",
    "teamMembers",
    "selfEvaluation"
})
@XmlRootElement(name = "applicationInformation")
public class ApplicationInformation {

    @XmlElement(required = true)
    protected String projectMotivation;
    @XmlElement(required = true)
    protected ApplicationInformation.ProjectAims projectAims;
    @XmlElement(required = true)
    protected String researchMethodology;
    @XmlElement(required = true)
    protected String researchWorkPlan;
    @XmlElement(required = true)
    protected ApplicationInformation.ExpectedOutcomes expectedOutcomes;
    @XmlElement(required = true)
    protected String projectInfrastructureFunding;
    @XmlElement(required = true)
    protected ApplicationInformation.TeamMembers teamMembers;
    @XmlElement(required = true)
    protected String selfEvaluation;

    /**
     * Gets the value of the projectMotivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectMotivation() {
        return projectMotivation;
    }

    /**
     * Sets the value of the projectMotivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectMotivation(String value) {
        this.projectMotivation = value;
    }

    /**
     * Gets the value of the projectAims property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationInformation.ProjectAims }
     *     
     */
    public ApplicationInformation.ProjectAims getProjectAims() {
        return projectAims;
    }

    /**
     * Sets the value of the projectAims property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationInformation.ProjectAims }
     *     
     */
    public void setProjectAims(ApplicationInformation.ProjectAims value) {
        this.projectAims = value;
    }

    /**
     * Gets the value of the researchMethodology property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResearchMethodology() {
        return researchMethodology;
    }

    /**
     * Sets the value of the researchMethodology property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResearchMethodology(String value) {
        this.researchMethodology = value;
    }

    /**
     * Gets the value of the researchWorkPlan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResearchWorkPlan() {
        return researchWorkPlan;
    }

    /**
     * Sets the value of the researchWorkPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResearchWorkPlan(String value) {
        this.researchWorkPlan = value;
    }

    /**
     * Gets the value of the expectedOutcomes property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationInformation.ExpectedOutcomes }
     *     
     */
    public ApplicationInformation.ExpectedOutcomes getExpectedOutcomes() {
        return expectedOutcomes;
    }

    /**
     * Sets the value of the expectedOutcomes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationInformation.ExpectedOutcomes }
     *     
     */
    public void setExpectedOutcomes(ApplicationInformation.ExpectedOutcomes value) {
        this.expectedOutcomes = value;
    }

    /**
     * Gets the value of the projectInfrastructureFunding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectInfrastructureFunding() {
        return projectInfrastructureFunding;
    }

    /**
     * Sets the value of the projectInfrastructureFunding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectInfrastructureFunding(String value) {
        this.projectInfrastructureFunding = value;
    }

    /**
     * Gets the value of the teamMembers property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationInformation.TeamMembers }
     *     
     */
    public ApplicationInformation.TeamMembers getTeamMembers() {
        return teamMembers;
    }

    /**
     * Sets the value of the teamMembers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationInformation.TeamMembers }
     *     
     */
    public void setTeamMembers(ApplicationInformation.TeamMembers value) {
        this.teamMembers = value;
    }

    /**
     * Gets the value of the selfEvaluation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    /**
     * Sets the value of the selfEvaluation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelfEvaluation(String value) {
        this.selfEvaluation = value;
    }


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
     *         &lt;element name="outcome" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "outcome"
    })
    public static class ExpectedOutcomes {

        @XmlElement(required = true)
        protected List<String> outcome;

        /**
         * Gets the value of the outcome property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the outcome property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOutcome().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getOutcome() {
            if (outcome == null) {
                outcome = new ArrayList<String>();
            }
            return this.outcome;
        }

    }


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
     *         &lt;element name="aim" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "aim"
    })
    public static class ProjectAims {

        @XmlElement(required = true)
        protected List<String> aim;

        /**
         * Gets the value of the aim property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the aim property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAim().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAim() {
            if (aim == null) {
                aim = new ArrayList<String>();
            }
            return this.aim;
        }

    }


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
     *         &lt;element name="member" type="{}member" maxOccurs="unbounded" minOccurs="0"/>
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
        "member"
    })
    public static class TeamMembers {

        protected List<Member> member;

        /**
         * Gets the value of the member property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the member property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMember().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Member }
         * 
         * 
         */
        public List<Member> getMember() {
            if (member == null) {
                member = new ArrayList<Member>();
            }
            return this.member;
        }

    }

}
