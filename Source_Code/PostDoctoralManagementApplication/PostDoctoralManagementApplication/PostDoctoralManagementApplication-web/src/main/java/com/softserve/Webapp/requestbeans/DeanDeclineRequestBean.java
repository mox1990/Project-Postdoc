/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.Webapp.requestbeans;

import com.softserve.persistence.DBEntities.Application;
import com.softserve.Webapp.sessionbeans.ConversationManagerBean;
import com.softserve.Webapp.sessionbeans.NavigationManagerBean;
import com.softserve.Webapp.sessionbeans.SessionManagerBean;
import com.softserve.Webapp.util.ExceptionUtil;
import com.softserve.ejb.applicationservices.DeansEndorsementServiceLocal;
import com.softserve.ejb.applicationservices.HODRecommendationServices;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Named(value = "deanDeclineRequestBean")
@RequestScoped
public class DeanDeclineRequestBean {
    
    @Inject
    private SessionManagerBean sessionManagerBean;
    @Inject 
    private NavigationManagerBean navigationManagerBean;
    
    @EJB
    private DeansEndorsementServiceLocal deansEndorsementServiceLocal;
        
    private String reason = "";
    
    /**
     * Creates a new instance of HODRecommendBean
     */
    public DeanDeclineRequestBean() {
    }
    
    public Application getSelectedApplication()
    {
        return sessionManagerBean.getObjectFromSessionStorage("APPLICATION", Application.class);
    }
            
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String preformDeclineRequest()
    {
        try
        {
            deansEndorsementServiceLocal.declineApplication(sessionManagerBean.getSession(), getSelectedApplication(), reason);
            return navigationManagerBean.goToDeanApplicationSelectionView();
        }
        catch(Exception ex)
        {
            ExceptionUtil.logException(DeanDeclineRequestBean.class, ex);
            ExceptionUtil.handleException(null, ex);
            return "";
        }
    }
    
}
