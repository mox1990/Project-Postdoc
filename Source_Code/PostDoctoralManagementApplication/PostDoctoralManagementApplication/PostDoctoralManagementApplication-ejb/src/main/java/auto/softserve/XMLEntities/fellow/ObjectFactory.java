//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.15 at 09:34:30 AM CAT 
//


package auto.softserve.XMLEntities.fellow;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the auto.softserve.XMLEntities.fellow package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: auto.softserve.XMLEntities.fellow
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProgressReport }
     * 
     */
    public ProgressReport createProgressReport() {
        return new ProgressReport();
    }

    /**
     * Create an instance of {@link ProgressReport.ProjectAimsAttainment }
     * 
     */
    public ProgressReport.ProjectAimsAttainment createProgressReportProjectAimsAttainment() {
        return new ProgressReport.ProjectAimsAttainment();
    }

    /**
     * Create an instance of {@link ProgressReport.ProjectOutcomesAttainment }
     * 
     */
    public ProgressReport.ProjectOutcomesAttainment createProgressReportProjectOutcomesAttainment() {
        return new ProgressReport.ProjectOutcomesAttainment();
    }

    /**
     * Create an instance of {@link ProgressReport.ResearchOutput }
     * 
     */
    public ProgressReport.ResearchOutput createProgressReportResearchOutput() {
        return new ProgressReport.ResearchOutput();
    }

    /**
     * Create an instance of {@link Reference }
     * 
     */
    public Reference createReference() {
        return new Reference();
    }

    /**
     * Create an instance of {@link Attainment }
     * 
     */
    public Attainment createAttainment() {
        return new Attainment();
    }

}
