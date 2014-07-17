/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.XMLUtils;

import auto.softserve.XMLEntities.CV.*;
import auto.softserve.XMLEntities.HOD.*;
import auto.softserve.XMLEntities.application.*;
import auto.softserve.XMLEntities.fellow.*;
import auto.softserve.XMLEntities.referee.*;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
public class XMLUnmarshaller {

    public XMLUnmarshaller() {
    }
    
    public ApplicationInformation unmarshalApplicationInformationString(String applicationInformation) throws JAXBException
    {
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.application.ApplicationInformation");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (ApplicationInformation) unmarshaller.unmarshal(new StreamSource(new StringReader(applicationInformation)));        
    }
    
    public RecommendationReportContent unmarshalRecommendationReportContentString(String recommendationReportContent) throws JAXBException
    {
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.HOD.RecommendationReport");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (RecommendationReportContent) unmarshaller.unmarshal(new StreamSource(new StringReader(recommendationReportContent)));        
    }
    
    public ReferalReport unmarshalReferalReportString(String referalReport) throws JAXBException
    {
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.referee.ReferalReport");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (ReferalReport) unmarshaller.unmarshal(new StreamSource(new StringReader(referalReport)));        
    }
    
    public ProgressReportContent unmarshalProgressReportContentString(String progressReportContent) throws JAXBException
    {
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.fellow.ProgressReport");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (ProgressReportContent) unmarshaller.unmarshal(new StreamSource(new StringReader(progressReportContent)));        
    }
    
    public OtherContributions unmarshalOtherContributionsString(String otherContributions) throws JAXBException
    {
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.CV.OtherContributions");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (OtherContributions) unmarshaller.unmarshal(new StreamSource(new StringReader(otherContributions)));        
    }
    
    public ResearchOutput unmarshalResearchOutputString(String researchOutput) throws JAXBException
    {
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.CV.ResearchOutput");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (ResearchOutput) unmarshaller.unmarshal(new StreamSource(new StringReader(researchOutput)));        
    }
    
    public AdditionalInformation unmarshalAdditionalInformationString(String additionalInformation) throws JAXBException
    {
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.CV.AdditionalInformation");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (AdditionalInformation) unmarshaller.unmarshal(new StreamSource(new StringReader(additionalInformation)));        
    }
    
}