/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.ejb;

import com.softserve.ApplicationServices.ApplicationServices;
import com.softserve.DBDAO.ApplicationJpaController;
import com.softserve.DBDAO.RecommendationReportJpaController;
import com.softserve.DBDAO.exceptions.NonexistentEntityException;
import com.softserve.DBDAO.exceptions.RollbackFailureException;
import com.softserve.DBEntities.Application;
import com.softserve.DBEntities.AuditLog;
import com.softserve.DBEntities.Notification;
import com.softserve.DBEntities.RecommendationReport;
import com.softserve.system.DBEntitiesFactory;
import com.softserve.system.Session;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class HODApprovalServices implements HODApprovalServicesLocal {

    @PersistenceUnit(unitName = com.softserve.constants.PersistenceConstants.PERSISTENCE_UNIT_NAME)
    private EntityManagerFactory emf;
    
    protected ApplicationJpaController getApplicationDAO()
    {
        return new ApplicationJpaController(com.softserve.constants.PersistenceConstants.getUserTransaction(), emf);
    }
    
    protected RecommendationReportJpaController getRecommmendationReportDAO()
    {
        return new RecommendationReportJpaController(com.softserve.constants.PersistenceConstants.getUserTransaction(), emf);
    }
    
    protected DBEntitiesFactory getDBEntitiesFactory()
    {
        return new DBEntitiesFactory();
    }
    
    protected NotificationService getNotificationServiceEJB()
    {
        return new NotificationService();
    }
    
    protected AuditTrailService getAuditTrailServiceEJB()
    {
        return new AuditTrailService();
    }
    
    /**
     *This function loads all the applications that need to approved/declined by the 
     * specified HOD
     * @param session The session object used to authenticate the user
     * @return A list of all the applications that user can Approved/declined
     */
    @Override
    public List<Application> loadPendingApplications(Session session)
    {
        //AuthenticUser(session, list of privliges)
        
        ApplicationServices applicationServices = new ApplicationServices(emf);
        
        return applicationServices.loadPendingApplications(session.getUser(), com.softserve.constants.PersistenceConstants.APPLICATION_STATUS_FINALISED);
    }
    
    public void denyAppliction(Session session, Application application, String reason) throws NonexistentEntityException, RollbackFailureException, Exception
    {
        //AuthenticUser(session, list of privliges)
        
        ApplicationJpaController applicationJpaController = getApplicationDAO();
        DBEntitiesFactory dBEntitiesFactory = getDBEntitiesFactory();
        AuditTrailService auditTrailService = getAuditTrailServiceEJB();
        NotificationService notificationService = getNotificationServiceEJB();
        
        //Deny application
        application.setStatus(com.softserve.constants.PersistenceConstants.APPLICATION_STATUS_DECLINED);        
        applicationJpaController.edit(application);
        
        //Log action  
        AuditLog auditLog = dBEntitiesFactory.buildAduitLogEntitiy("Declined application " + application.getApplicationID(), session.getUser());
        auditTrailService.logAction(auditLog);
        
        //Send notification to grant holder and applicatantD
        Notification notification = dBEntitiesFactory.buildNotificationEntity(session.getUser(), application.getFellow(), "Application declined", "The following application has been declined by " + session.getUser().getCompleteName() + ". For the following reasons: " + reason);
        notificationService.sendNotification(notification, true);
        
        notification = dBEntitiesFactory.buildNotificationEntity(session.getUser(), application.getGrantHolderID(), "Application declined", "The following application has been declined by " + session.getUser().getCompleteName() + ". For the following reasons: " + reason);
        notificationService.sendNotification(notification, true);
    }
    
    public void ammendAppliction(Session session, Application application, String reason) throws NonexistentEntityException, RollbackFailureException, Exception
    {
        //AuthenticUser(session, list of privliges)
        
        ApplicationJpaController applicationJpaController = getApplicationDAO();
        DBEntitiesFactory dBEntitiesFactory = getDBEntitiesFactory();
        AuditTrailService auditTrailService = getAuditTrailServiceEJB();
        NotificationService notificationService = getNotificationServiceEJB();
        
        //Ammend application
        application.setStatus(com.softserve.constants.PersistenceConstants.APPLICATION_STATUS_REFEREED);        
        applicationJpaController.edit(application);
        
        //Log action        
        AuditLog auditLog = dBEntitiesFactory.buildAduitLogEntitiy("Ammendment request for application " + application.getApplicationID(), session.getUser());
        auditTrailService.logAction(auditLog);
        
        //Send notification to grant holder and applicatantD        
        Notification notification = dBEntitiesFactory.buildNotificationEntity(session.getUser(), application.getFellow(), "Application ammendment requested", "The following application requires ammendment as per request by " + session.getUser().getCompleteName() + ". For the following reasons: " + reason);
        notificationService.sendNotification(notification, true);
        
        notification = dBEntitiesFactory.buildNotificationEntity(session.getUser(), application.getGrantHolderID(), "Application ammendment requested", "The following application requires ammendment as per request by " + session.getUser().getCompleteName() + ". For the following reasons: " + reason);
        notificationService.sendNotification(notification, true);
    }
    
    public void approveApplication(Session session, Application application, RecommendationReport recommendationReport) throws NonexistentEntityException, RollbackFailureException, Exception
    {
        //AuthenticUser(session, list of privliges)
        
        ApplicationJpaController applicationJpaController = getApplicationDAO();
        RecommendationReportJpaController recommendationReportJpaController = getRecommmendationReportDAO();
        DBEntitiesFactory dBEntitiesFactory = getDBEntitiesFactory();
        AuditTrailService auditTrailService = getAuditTrailServiceEJB();
        NotificationService notificationService = getNotificationServiceEJB();
        
        recommendationReportJpaController.create(recommendationReport);
        
        application.setRecommendationReportID(recommendationReport);
        application.setStatus(com.softserve.constants.PersistenceConstants.APPLICATION_STATUS_RECOMMENDED);
        
        try
        {
            applicationJpaController.edit(application);
        }
        catch(Exception ex)
        {
            //If an error occurs during update of application the recommendation report must be removed as well
            recommendationReportJpaController.destroy(recommendationReport.getReportID());
            throw ex;
        }
        
        //Log action
        
        AuditLog auditLog = dBEntitiesFactory.buildAduitLogEntitiy("Application approved" + application.getApplicationID(), session.getUser());
        auditTrailService.logAction(auditLog);
        
        //Send notification to Deans office
        
        Notification notification = dBEntitiesFactory.buildNotificationEntity(session.getUser(), application.getFellow(), "Application approved", "The following application was approved by " + session.getUser().getCompleteName() + ". Please review for endorsement.");
        notificationService.sendNotification(notification, true);
    }
}
