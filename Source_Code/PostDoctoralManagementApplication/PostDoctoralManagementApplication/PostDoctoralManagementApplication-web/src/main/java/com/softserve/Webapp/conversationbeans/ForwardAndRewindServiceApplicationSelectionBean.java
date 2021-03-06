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
import com.softserve.ejb.applicationservices.ForwardAndRewindServicesLocal;
import com.softserve.auxiliary.util.ApplicationServicesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Named(value = "forwardAndRewindServiceApplicationSelectionBean")
@ConversationScoped
public class ForwardAndRewindServiceApplicationSelectionBean implements Serializable {
    
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
    private ForwardAndRewindServicesLocal forwardAndRewindServicesLocal;
    
    
    
    /**
     * Creates a new instance of ForwardAndRewindServiceRequestBean
     */
    public ForwardAndRewindServiceApplicationSelectionBean() {
    }
    @PostConstruct
    public void init()
    {
        conversationManagerBean.registerConversation(conversation);
        conversationManagerBean.startConversation(conversation);
        
        try
        {
            List<Application> applications = forwardAndRewindServicesLocal.loadMovableApplications(sessionManagerBean.getSession());
            System.out.println(applications.toString());
            applicationFilterDependBean.init(applications);
        }
        catch(Exception ex)
        {
            ExceptionUtil.logException(ForwardAndRewindServiceApplicationSelectionBean.class, ex);
            ExceptionUtil.handleException(null, ex);
            navigationManagerBean.callFacesNavigator(navigationManagerBean.goToApplicationServicesHomeView());
        }  
    }
    
    
    public ApplicationFilterDependBean getApplicationFilterDependBean() {
        return applicationFilterDependBean;
    }
}
