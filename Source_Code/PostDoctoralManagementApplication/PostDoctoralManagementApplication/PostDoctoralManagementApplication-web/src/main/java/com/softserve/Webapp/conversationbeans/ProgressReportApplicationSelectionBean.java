/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.Webapp.conversationbeans;

import com.softserve.DBEntities.Application;
import com.softserve.Webapp.depenedentbeans.ApplicationFilterDependBean;
import com.softserve.Webapp.sessionbeans.ConversationManagerBean;
import com.softserve.Webapp.sessionbeans.NavigationManagerBean;
import com.softserve.Webapp.sessionbeans.SessionManagerBean;
import com.softserve.Webapp.util.ExceptionUtil;
import com.softserve.ejb.applicationservices.ProgressReportManagementServiceLocal;
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
@Named(value = "progressReportApplicationSelectionBean")
@ConversationScoped
public class ProgressReportApplicationSelectionBean implements Serializable {
    
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
    private ProgressReportManagementServiceLocal progressReportManagementServiceLocal;
    
    /**
     * Creates a new instance of ProgressReportApplicationSelectionRequestBean
     */
    public ProgressReportApplicationSelectionBean() {
    }
    
    @PostConstruct
    public void init()
    {
        conversationManagerBean.registerConversation(conversation);
        conversationManagerBean.startConversation(conversation);
        try
        {
            applicationFilterDependBean.init(progressReportManagementServiceLocal.allApplicationsWithPendingReportsForUser(sessionManagerBean.getSession()));
        }
        catch(Exception ex)
        {
            ExceptionUtil.logException(ProgressReportApplicationSelectionBean.class, ex);
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
        return navigationManagerBean.goToProgressReportManagementServiceReportCreationView();
    }
}
