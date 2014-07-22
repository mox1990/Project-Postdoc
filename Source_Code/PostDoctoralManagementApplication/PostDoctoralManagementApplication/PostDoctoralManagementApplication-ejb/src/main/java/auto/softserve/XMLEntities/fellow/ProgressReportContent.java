//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 11:58:58 AM CAT 
//


package auto.softserve.XMLEntities.fellow;

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
 *         &lt;element name="projectAimsAttainment">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="aimAttainment" type="{}attainment" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="projectOutcomesAttainment">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="outcomeAttainment" type="{}attainment" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="researchOutput">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="journalPublications" type="{}reference"/>
 *                   &lt;element name="bookChapterPublications" type="{}reference"/>
 *                   &lt;element name="scientificPublicationsArticles" type="{}reference"/>
 *                   &lt;element name="technicalAnyReports" type="{}reference"/>
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
    "projectAimsAttainment",
    "projectOutcomesAttainment",
    "researchOutput",
    "selfEvaluation"
})
@XmlRootElement(name = "ProgressReportContent")
public class ProgressReportContent {

    @XmlElement(required = true)
    protected ProgressReportContent.ProjectAimsAttainment projectAimsAttainment;
    @XmlElement(required = true)
    protected ProgressReportContent.ProjectOutcomesAttainment projectOutcomesAttainment;
    @XmlElement(required = true)
    protected ProgressReportContent.ResearchOutput researchOutput;
    @XmlElement(required = true)
    protected String selfEvaluation;

    /**
     * Gets the value of the projectAimsAttainment property.
     * 
     * @return
     *     possible object is
     *     {@link ProgressReportContent.ProjectAimsAttainment }
     *     
     */
    public ProgressReportContent.ProjectAimsAttainment getProjectAimsAttainment() {
        return projectAimsAttainment;
    }

    /**
     * Sets the value of the projectAimsAttainment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgressReportContent.ProjectAimsAttainment }
     *     
     */
    public void setProjectAimsAttainment(ProgressReportContent.ProjectAimsAttainment value) {
        this.projectAimsAttainment = value;
    }

    /**
     * Gets the value of the projectOutcomesAttainment property.
     * 
     * @return
     *     possible object is
     *     {@link ProgressReportContent.ProjectOutcomesAttainment }
     *     
     */
    public ProgressReportContent.ProjectOutcomesAttainment getProjectOutcomesAttainment() {
        return projectOutcomesAttainment;
    }

    /**
     * Sets the value of the projectOutcomesAttainment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgressReportContent.ProjectOutcomesAttainment }
     *     
     */
    public void setProjectOutcomesAttainment(ProgressReportContent.ProjectOutcomesAttainment value) {
        this.projectOutcomesAttainment = value;
    }

    /**
     * Gets the value of the researchOutput property.
     * 
     * @return
     *     possible object is
     *     {@link ProgressReportContent.ResearchOutput }
     *     
     */
    public ProgressReportContent.ResearchOutput getResearchOutput() {
        return researchOutput;
    }

    /**
     * Sets the value of the researchOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgressReportContent.ResearchOutput }
     *     
     */
    public void setResearchOutput(ProgressReportContent.ResearchOutput value) {
        this.researchOutput = value;
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
     *         &lt;element name="aimAttainment" type="{}attainment" maxOccurs="unbounded"/>
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
        "aimAttainment"
    })
    public static class ProjectAimsAttainment {

        @XmlElement(required = true)
        protected List<Attainment> aimAttainment;

        /**
         * Gets the value of the aimAttainment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the aimAttainment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAimAttainment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Attainment }
         * 
         * 
         */
        public List<Attainment> getAimAttainment() {
            if (aimAttainment == null) {
                aimAttainment = new ArrayList<Attainment>();
            }
            return this.aimAttainment;
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
     *         &lt;element name="outcomeAttainment" type="{}attainment" maxOccurs="unbounded"/>
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
        "outcomeAttainment"
    })
    public static class ProjectOutcomesAttainment {

        @XmlElement(required = true)
        protected List<Attainment> outcomeAttainment;

        /**
         * Gets the value of the outcomeAttainment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the outcomeAttainment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOutcomeAttainment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Attainment }
         * 
         * 
         */
        public List<Attainment> getOutcomeAttainment() {
            if (outcomeAttainment == null) {
                outcomeAttainment = new ArrayList<Attainment>();
            }
            return this.outcomeAttainment;
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
     *         &lt;element name="journalPublications" type="{}reference"/>
     *         &lt;element name="bookChapterPublications" type="{}reference"/>
     *         &lt;element name="scientificPublicationsArticles" type="{}reference"/>
     *         &lt;element name="technicalAnyReports" type="{}reference"/>
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
        "journalPublications",
        "bookChapterPublications",
        "scientificPublicationsArticles",
        "technicalAnyReports"
    })
    public static class ResearchOutput {

        @XmlElement(required = true)
        protected Reference journalPublications;
        @XmlElement(required = true)
        protected Reference bookChapterPublications;
        @XmlElement(required = true)
        protected Reference scientificPublicationsArticles;
        @XmlElement(required = true)
        protected Reference technicalAnyReports;

        /**
         * Gets the value of the journalPublications property.
         * 
         * @return
         *     possible object is
         *     {@link Reference }
         *     
         */
        public Reference getJournalPublications() {
            return journalPublications;
        }

        /**
         * Sets the value of the journalPublications property.
         * 
         * @param value
         *     allowed object is
         *     {@link Reference }
         *     
         */
        public void setJournalPublications(Reference value) {
            this.journalPublications = value;
        }

        /**
         * Gets the value of the bookChapterPublications property.
         * 
         * @return
         *     possible object is
         *     {@link Reference }
         *     
         */
        public Reference getBookChapterPublications() {
            return bookChapterPublications;
        }

        /**
         * Sets the value of the bookChapterPublications property.
         * 
         * @param value
         *     allowed object is
         *     {@link Reference }
         *     
         */
        public void setBookChapterPublications(Reference value) {
            this.bookChapterPublications = value;
        }

        /**
         * Gets the value of the scientificPublicationsArticles property.
         * 
         * @return
         *     possible object is
         *     {@link Reference }
         *     
         */
        public Reference getScientificPublicationsArticles() {
            return scientificPublicationsArticles;
        }

        /**
         * Sets the value of the scientificPublicationsArticles property.
         * 
         * @param value
         *     allowed object is
         *     {@link Reference }
         *     
         */
        public void setScientificPublicationsArticles(Reference value) {
            this.scientificPublicationsArticles = value;
        }

        /**
         * Gets the value of the technicalAnyReports property.
         * 
         * @return
         *     possible object is
         *     {@link Reference }
         *     
         */
        public Reference getTechnicalAnyReports() {
            return technicalAnyReports;
        }

        /**
         * Sets the value of the technicalAnyReports property.
         * 
         * @param value
         *     allowed object is
         *     {@link Reference }
         *     
         */
        public void setTechnicalAnyReports(Reference value) {
            this.technicalAnyReports = value;
        }

    }

}
