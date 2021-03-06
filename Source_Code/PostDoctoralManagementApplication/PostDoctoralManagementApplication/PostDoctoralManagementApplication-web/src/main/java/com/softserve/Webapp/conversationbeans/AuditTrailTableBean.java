/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.Webapp.conversationbeans;

import com.softserve.persistence.DBEntities.AuditLog;
import com.softserve.Webapp.sessionbeans.ConversationManagerBean;
import com.softserve.Webapp.sessionbeans.NavigationManagerBean;
import com.softserve.Webapp.sessionbeans.SessionManagerBean;
import com.softserve.Webapp.util.ExceptionUtil;
import com.softserve.ejb.nonapplicationservices.AuditTrailServiceLocal;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
@Named(value = "auditTrailTableBean")
@ConversationScoped
public class AuditTrailTableBean implements Serializable {
    
    @Inject
    private SessionManagerBean sessionManagerBean;
    @Inject 
    private NavigationManagerBean navigationManagerBean;
    @Inject
    private ConversationManagerBean conversationManagerBean;
    
    @Inject
    private Conversation conversation;
    
    @EJB
    private AuditTrailServiceLocal auditTrailServiceLocal; 
    
    private List<AuditLog> entries;
    private List<AuditLog> filteredEntries;
    private AuditLog selectedEntry;
    
    /**
     * Creates a new instance of auditTrailTableBean
     */
    public AuditTrailTableBean() {
    }
    
    @PostConstruct
    public void init()
    {
        conversationManagerBean.registerConversation(conversation);
        conversationManagerBean.startConversation(conversation);
        try
        {
            entries = auditTrailServiceLocal.loadAllAuditLogEntries(sessionManagerBean.getSession());
            filteredEntries = new ArrayList<AuditLog>();
            filteredEntries.addAll(entries);
        }
        catch(Exception ex)
        {
            ExceptionUtil.logException(DRISApplicationFundingEditBean.class, ex);
            ExceptionUtil.handleException(null, ex);
            navigationManagerBean.callFacesNavigator(navigationManagerBean.goToWelcomeView());
        }
        
        
        
        
        
    }

    public List<AuditLog> getEntries() {
        return entries;
    }

    public void setEntries(List<AuditLog> entries) {
        this.entries = entries;
    }

    public List<AuditLog> getFilteredEntries() {
        return filteredEntries;
    }

    public void setFilteredEntries(List<AuditLog> filteredEntries) {
        this.filteredEntries = filteredEntries;
    }

    public void setSelectedEntry(AuditLog selectedEntry) {
        this.selectedEntry = selectedEntry;
    }

    public AuditLog getSelectedEntry() {
        return selectedEntry;
    }
    
    
    
}
