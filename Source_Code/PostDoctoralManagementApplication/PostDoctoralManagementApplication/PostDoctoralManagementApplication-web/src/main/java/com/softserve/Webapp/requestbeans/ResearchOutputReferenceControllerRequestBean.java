/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.Webapp.requestbeans;

import auto.softserve.XMLEntities.CV.Reference;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Named(value = "researchOutputReferenceControllerRequestBean")
@RequestScoped
public class ResearchOutputReferenceControllerRequestBean {

    /**
     * Creates a new instance of ResearchOutputReferenceControllerRequestBean
     */
    public ResearchOutputReferenceControllerRequestBean() {
    }
    
    public boolean doesReferenceHavePubliser(Reference reference)
    {
        System.out.print("DOES HAVe publisher =====");
        if(reference != null && reference.getStatus() != null)
        {
            return !reference.getStatus().equals(com.softserve.constants.PersistenceConstants.CV_REFERENCE_INPROGRESS);
        }
        else
        {
            return false;
        }
    }
    
    public boolean doesReferenceHavePublicationDate(Reference reference)
    {
        if(reference != null && reference.getStatus() != null)
        {
            return reference.getStatus().equals(com.softserve.constants.PersistenceConstants.CV_REFERENCE_PUBLISHED);
        }
        else
        {
            return false;
        }
    }
    
}
