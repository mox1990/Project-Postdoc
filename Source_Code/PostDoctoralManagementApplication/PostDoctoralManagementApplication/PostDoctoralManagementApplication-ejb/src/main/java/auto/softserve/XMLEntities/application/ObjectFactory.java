//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.26 at 11:04:54 AM CAT 
//


package auto.softserve.XMLEntities.application;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the auto.softserve.XMLEntities.application package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: auto.softserve.XMLEntities.application
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ApplicationInformation }
     * 
     */
    public ApplicationInformation createApplicationInformation() {
        return new ApplicationInformation();
    }

    /**
     * Create an instance of {@link ApplicationInformation.ProjectAims }
     * 
     */
    public ApplicationInformation.ProjectAims createApplicationInformationProjectAims() {
        return new ApplicationInformation.ProjectAims();
    }

    /**
     * Create an instance of {@link ApplicationInformation.ExpectedOutcomes }
     * 
     */
    public ApplicationInformation.ExpectedOutcomes createApplicationInformationExpectedOutcomes() {
        return new ApplicationInformation.ExpectedOutcomes();
    }

    /**
     * Create an instance of {@link ApplicationInformation.TeamMembers }
     * 
     */
    public ApplicationInformation.TeamMembers createApplicationInformationTeamMembers() {
        return new ApplicationInformation.TeamMembers();
    }

    /**
     * Create an instance of {@link Member }
     * 
     */
    public Member createMember() {
        return new Member();
    }

}
