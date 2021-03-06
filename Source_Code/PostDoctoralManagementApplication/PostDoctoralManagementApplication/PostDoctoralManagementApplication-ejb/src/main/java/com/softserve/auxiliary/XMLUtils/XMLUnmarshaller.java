/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.auxiliary.XMLUtils;

import auto.softserve.XMLEntities.CV.ProgressReportContent;
import auto.softserve.XMLEntities.CV.*;
import auto.softserve.XMLEntities.HOD.*;
import auto.softserve.XMLEntities.PrePostConditional.Prepostconditionalmethods;
import auto.softserve.XMLEntities.application.*;
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
        if(applicationInformation == null || applicationInformation.equals(""))
        {
            return new ApplicationInformation();
        }
        
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.application");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (ApplicationInformation) unmarshaller.unmarshal(new StreamSource(new StringReader(applicationInformation)));        
    }
    
    public RecommendationReportContent unmarshalRecommendationReportContentString(String recommendationReportContent) throws JAXBException
    {
        if(recommendationReportContent == null || recommendationReportContent.equals(""))
        {
            return new RecommendationReportContent();
        }
        
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.HOD");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (RecommendationReportContent) unmarshaller.unmarshal(new StreamSource(new StringReader(recommendationReportContent)));        
    }
    
    public ReferalReport unmarshalReferalReportString(String referalReport) throws JAXBException
    {
        if(referalReport == null || referalReport.equals(""))
        {
            return new ReferalReport();
        }
        
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.referee");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (ReferalReport) unmarshaller.unmarshal(new StreamSource(new StringReader(referalReport)));        
    }
    
    public ProgressReportContent unmarshalProgressReportContentString(String progressReportContent) throws JAXBException
    {
        if(progressReportContent == null || progressReportContent.equals(""))
        {
            return new ProgressReportContent();
        }
        
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.CV");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (ProgressReportContent) unmarshaller.unmarshal(new StreamSource(new StringReader(progressReportContent)));        
    }
    
    public OtherContributions unmarshalOtherContributionsString(String otherContributions) throws JAXBException
    {
        if(otherContributions == null || otherContributions.equals(""))
        {
            return new OtherContributions();
        }
        
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.CV");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (OtherContributions) unmarshaller.unmarshal(new StreamSource(new StringReader(otherContributions)));        
    }
    
    public ResearchOutput unmarshalResearchOutputString(String researchOutput) throws JAXBException
    {
        if(researchOutput == null || researchOutput.equals(""))
        {
            return new ResearchOutput();
        }
        
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.CV");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (ResearchOutput) unmarshaller.unmarshal(new StreamSource(new StringReader(researchOutput)));        
    }
    
    public AdditionalInformation unmarshalAdditionalInformationString(String additionalInformation) throws JAXBException
    {
        if(additionalInformation == null || additionalInformation.equals(""))
        {
            return new AdditionalInformation();
        }
        
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.CV");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (AdditionalInformation) unmarshaller.unmarshal(new StreamSource(new StringReader(additionalInformation)));        
    }
    
    public Prepostconditionalmethods unmarshalPrepostconditionalmethodsString(String prepostconditionalmethods) throws JAXBException
    {
        if(prepostconditionalmethods == null || prepostconditionalmethods.equals(""))
        {
            return new Prepostconditionalmethods();
        }
        
        JAXBContext jaxbc = JAXBContext.newInstance("auto.softserve.XMLEntities.PrePostConditional");
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        return (Prepostconditionalmethods) unmarshaller.unmarshal(new StreamSource(new StringReader(prepostconditionalmethods)));        
    }
    
}
