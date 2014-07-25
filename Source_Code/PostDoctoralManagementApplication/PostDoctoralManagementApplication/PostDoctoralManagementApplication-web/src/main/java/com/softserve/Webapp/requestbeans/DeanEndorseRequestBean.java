/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.Webapp.requestbeans;

import auto.softserve.XMLEntities.HOD.RecommendationReportContent;
import com.softserve.DBEntities.Application;
import com.softserve.DBEntities.Endorsement;
import com.softserve.DBEntities.RecommendationReport;
import com.softserve.Webapp.sessionbeans.ConversationManagerBean;
import com.softserve.Webapp.sessionbeans.NavigationManagerBean;
import com.softserve.Webapp.sessionbeans.SessionManagerBean;
import com.softserve.Webapp.util.ExceptionUtil;
import com.softserve.ejb.DeansEndorsementServiceLocal;
import com.softserve.ejb.HODRecommendationServices;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Named(value = "deanEndorseRequestBean")
@RequestScoped
public class DeanEndorseRequestBean {
    
    @Inject
    private SessionManagerBean sessionManagerBean;
    @Inject 
    private NavigationManagerBean navigationManagerBean;
    
    @EJB
    private DeansEndorsementServiceLocal deansEndorsementServiceLocal;
    
    private UIComponent errorContainer; 
    
    private Endorsement endorsement = null;
    
    /**
     * Creates a new instance of HODRecommendBean
     */
    public DeanEndorseRequestBean() 
    {        
    }
    
    @PostConstruct
    public void init()
    {
        endorsement = new Endorsement();
    }
    
    public Application getSelectedApplication()
    {
        return sessionManagerBean.getObjectFromSessionStroage(0, Application.class);
    }

    public UIComponent getErrorContainer() {
        return errorContainer;
    }

    public void setErrorContainer(UIComponent errorContainer) {
        this.errorContainer = errorContainer;
    }

    public Endorsement getEndorsement() {
        return endorsement;
    }

    public void setEndorsement(Endorsement endorsement) {
        this.endorsement = endorsement;
    }
                
    public String preformEndorseRequest()
    {
        try
        {
            deansEndorsementServiceLocal.endorseApplication(sessionManagerBean.getSession(), getSelectedApplication(), endorsement);
            return navigationManagerBean.goToDeanApplicationSelectionView();
        }
        catch(Exception ex)
        {
            ExceptionUtil.handleException(errorContainer, ex);
            return "";
        }
    }
    
}