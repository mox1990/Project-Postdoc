/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.Webapp.conversationbeans;

import com.softserve.persistence.DBEntities.Application;
import com.softserve.Webapp.depenedentbeans.ApplicationFilterDependBean;
import com.softserve.Webapp.sessionbeans.ConversationManagerBean;
import com.softserve.Webapp.sessionbeans.NavigationManagerBean;
import com.softserve.Webapp.sessionbeans.SessionManagerBean;
import com.softserve.Webapp.util.ExceptionUtil;
import com.softserve.ejb.applicationservices.DeansEndorsementServiceLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Named(value = "deanApplicationSelectionBean")
@ConversationScoped
public class DeanApplicationSelectionBean implements Serializable {
    
    @Inject
    private SessionManagerBean sessionManagerBean;
    @Inject 
    private NavigationManagerBean navigationManagerBean;
    @Inject
    private ConversationManagerBean conversationManagerBean;
    @Inject
    private ApplicationFilterDependBean applicationFilterDependBean;
    @Inject
    private Conversation conversation;

    @EJB
    private DeansEndorsementServiceLocal deansEndorsementServiceLocal;
        
    /**
     * Creates a new instance of HODApplicationSelectionRequestBean
     */
    public DeanApplicationSelectionBean() {
    }
            
    @PostConstruct
    public void init()
    {
        conversationManagerBean.registerConversation(conversation);
        conversationManagerBean.startConversation(conversation);
        try
        {
            applicationFilterDependBean.init(deansEndorsementServiceLocal.loadPendingApplications(sessionManagerBean.getSession(), 0, Integer.MAX_VALUE));
        }
        catch(Exception ex)
        {
            ExceptionUtil.logException(DeanApplicationSelectionBean.class, ex);
            ExceptionUtil.handleException(null, ex);
            navigationManagerBean.callFacesNavigator(navigationManagerBean.goToApplicationServicesHomeView());
        }
    }

    public ApplicationFilterDependBean getApplicationFilterDependBean() {
        return applicationFilterDependBean;
    }
            
    public void selectApplication(Application application)
    {
        sessionManagerBean.addObjectToSessionStorage("APPLICATION",application);
    }
    
    public String viewApplication(Application application)
    {
        selectApplication(application);
        conversationManagerBean.deregisterConversation(conversation);
        return navigationManagerBean.goToDeanApplicationViewer();
    }
}
