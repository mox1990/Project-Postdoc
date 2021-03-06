/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.softserve.EJBUnitTests;

import com.softserve.auxiliary.factories.DAOFactory;
import com.softserve.persistence.DBDAO.ApplicationJpaController;
import com.softserve.persistence.DBDAO.DeclineReportJpaController;
import com.softserve.persistence.DBEntities.AcademicQualification;
import com.softserve.persistence.DBEntities.Application;
import com.softserve.persistence.DBEntities.AuditLog;
import com.softserve.persistence.DBEntities.Cv;
import com.softserve.persistence.DBEntities.DeclineReport;
import com.softserve.persistence.DBEntities.Department;
import com.softserve.persistence.DBEntities.EligiblityReport;
import com.softserve.persistence.DBEntities.EmployeeInformation;
import com.softserve.persistence.DBEntities.Faculty;
import com.softserve.persistence.DBEntities.Notification;
import com.softserve.persistence.DBEntities.Person;
import com.softserve.persistence.DBEntities.SecurityRole;
import com.softserve.ejb.nonapplicationservices.AuditTrailService;
import com.softserve.ejb.nonapplicationservices.NotificationService;
import com.softserve.ejb.nonapplicationservices.UserGateway;
import com.softserve.auxiliary.util.ApplicationServicesUtil;
import com.softserve.auxiliary.factories.DBEntitiesFactory;
import com.softserve.auxiliary.requestresponseclasses.Session;
import com.softserve.persistence.DBDAO.ApplicationReviewRequestJpaController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import test.softserve.MockEJBClasses.ApplicationServicesUtilMockUnit;
import test.softserve.MockEJBClasses.CVManagementServiceMockUnit;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
public class ApplicationServicesUtilUnitTest {
    private ApplicationJpaController mockApplicationJpaController;
    private DBEntitiesFactory mockDBEntitiesFactory;
    private GregorianCalendar mockGregorianCalendar;
    private DAOFactory mockDAOFactory;
    private DeclineReportJpaController mockDeclineReportJpaController;
    private ApplicationReviewRequestJpaController mockApplicationReviewRequestJpaController;
    
    private ApplicationServicesUtilMockUnit instance;
    
    public ApplicationServicesUtilUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ApplicationServicesUtilMockUnit();
        
        mockApplicationJpaController = mock(ApplicationJpaController.class);
        mockDBEntitiesFactory = mock(DBEntitiesFactory.class);
        mockGregorianCalendar = mock(GregorianCalendar.class);
        mockDAOFactory = mock(DAOFactory.class);
        mockDeclineReportJpaController = mock(DeclineReportJpaController.class);
        mockApplicationReviewRequestJpaController = mock(ApplicationReviewRequestJpaController.class);
        
        instance.setdAOFactory(mockDAOFactory);
        instance.setdBEntities(mockDBEntitiesFactory);
        instance.setgCal(mockGregorianCalendar);
        
        when(mockDAOFactory.createApplicationDAO()).thenReturn(mockApplicationJpaController);
        when(mockDAOFactory.createDeclineReportDAO()).thenReturn(mockDeclineReportJpaController);
        when(mockDAOFactory.createApplicationReviewRequestDAO()).thenReturn(mockApplicationReviewRequestJpaController);
        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of loadPendingApplications method, of class ApplicationServicesUtil.
     */
    @Test
    public void testLoadPendingApplications() {
        String applicationStatusGroup = com.softserve.auxiliary.constants.PersistenceConstants.APPLICATION_STATUS_SUBMITTED;
        
        try
        {
            instance.loadPendingApplications(new Person("u12236731"), applicationStatusGroup, 0, Integer.MAX_VALUE);
           
            verify(mockDAOFactory).createApplicationDAO();
            verify(mockApplicationJpaController).findAllApplicationsWithStatusAndReferee(applicationStatusGroup, new Person("u12236731"), 0, Integer.MAX_VALUE);
            
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockDBEntitiesFactory);
            verifyNoMoreInteractions(mockGregorianCalendar);
            verifyNoMoreInteractions(mockDAOFactory);
            verifyNoMoreInteractions(mockDeclineReportJpaController);
            verifyNoMoreInteractions(mockApplicationReviewRequestJpaController);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            fail("An exception occured");
        }
    }  
    
    /**
     * Test of getTotalNumberOfPendingApplications method, of class ApplicationServicesUtil.
     */
    @Test
    public void testGetTotalNumberOfPendingApplicationsWithStatusAndReferre() {
        String applicationStatusGroup = com.softserve.auxiliary.constants.PersistenceConstants.APPLICATION_STATUS_SUBMITTED;
        
        try
        {
            instance.getTotalNumberOfPendingApplications(new Person("u12236731"), applicationStatusGroup);
           
            verify(mockDAOFactory).createApplicationDAO();
            verify(mockApplicationJpaController).countAllApplicationsWithStatusAndReferee(applicationStatusGroup, new Person("u12236731"));
            
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockDBEntitiesFactory);
            verifyNoMoreInteractions(mockGregorianCalendar);
            verifyNoMoreInteractions(mockDAOFactory);
            verifyNoMoreInteractions(mockDeclineReportJpaController);
            verifyNoMoreInteractions(mockApplicationReviewRequestJpaController);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            fail("An exception occured");
        }
    }
    
    @Test
    public void testGetTotalNumberOfPendingApplicationsWithStatusAndGrantholder() {
        String applicationStatusGroup = com.softserve.auxiliary.constants.PersistenceConstants.APPLICATION_STATUS_REFERRED;
        
        try
        {
            instance.getTotalNumberOfPendingApplications(new Person("u12236731"), applicationStatusGroup);
           
            verify(mockDAOFactory).createApplicationDAO();
            verify(mockApplicationJpaController).countAllApplicationsWithStatusAndGrantHolder(applicationStatusGroup, new Person("u12236731"));
            
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockDBEntitiesFactory);
            verifyNoMoreInteractions(mockGregorianCalendar);
            verifyNoMoreInteractions(mockDAOFactory);
            verifyNoMoreInteractions(mockDeclineReportJpaController);
            verifyNoMoreInteractions(mockApplicationReviewRequestJpaController);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            fail("An exception occured");
        }
    }
    
    @Test
    public void testGetTotalNumberOfPendingApplicationsWithStatusAndDepartment() {
        String applicationStatusGroup = com.softserve.auxiliary.constants.PersistenceConstants.APPLICATION_STATUS_FINALISED;
        
        Faculty mockFaculty = mock(Faculty.class);
        Department mockDepartment = mock(Department.class);
        when(mockDepartment.getFaculty()).thenReturn(mockFaculty);
        
        EmployeeInformation mockEmployeeInformation = mock(EmployeeInformation.class);
        when(mockEmployeeInformation.getDepartment()).thenReturn(mockDepartment);
        
        Person mockPerson = mock(Person.class);
        when(mockPerson.getEmployeeInformation()).thenReturn(mockEmployeeInformation);
        
        try
        {
            instance.getTotalNumberOfPendingApplications(mockPerson, applicationStatusGroup);
           
            //verify(mockApplicationJpaController).countAllApplicationsWithStatusAndDepartment(applicationStatusGroup, mockDepartment);
            //verifyNoMoreInteractions(mockApplicationJpaController);
        }
        catch (Exception ex)
        {
            fail("An exception occured");
        }
    }
    
    @Test
    public void testGetTotalNumberOfPendingApplicationsWithStatusAndFaculty() {
        String applicationStatusGroup = com.softserve.auxiliary.constants.PersistenceConstants.APPLICATION_STATUS_RECOMMENDED;        
        
        Faculty mockFaculty = mock(Faculty.class);
        Department mockDepartment = mock(Department.class);
        when(mockDepartment.getFaculty()).thenReturn(mockFaculty);
        
        EmployeeInformation mockEmployeeInformation = mock(EmployeeInformation.class);
        when(mockEmployeeInformation.getDepartment()).thenReturn(mockDepartment);
        
        Person mockPerson = mock(Person.class);
        when(mockPerson.getEmployeeInformation()).thenReturn(mockEmployeeInformation);
        
        when(mockApplicationJpaController.countAllApplicationsWithStatusAndReferee(applicationStatusGroup, mockPerson)).thenReturn((long)3);
        try
        {
            int result = instance.getTotalNumberOfPendingApplications(mockPerson, applicationStatusGroup);
           
            verify(mockDAOFactory).createApplicationDAO();
            verify(mockDAOFactory).createApplicationReviewRequestDAO();
            verify(mockApplicationReviewRequestJpaController).findAllApplicationsRequestForPersonAs(mockPerson, com.softserve.auxiliary.constants.PersistenceConstants.APPLICATION_REVIEW_TYPE_DEAN);
            verify(mockApplicationJpaController).findAllApplicationsWithStatusAndFaculty(applicationStatusGroup, mockFaculty,0, Integer.MAX_VALUE);
            
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockDBEntitiesFactory);
            verifyNoMoreInteractions(mockGregorianCalendar);
            verifyNoMoreInteractions(mockDAOFactory);
            verifyNoMoreInteractions(mockDeclineReportJpaController);
            verifyNoMoreInteractions(mockApplicationReviewRequestJpaController);
            
        }
        catch (Exception ex)
        {
            fail("An exception occured");
        }
    }
    
    @Test
    public void testGetTotalNumberOfPendingApplications() {
        String applicationStatusGroup = "WhatElseIsTHERE?";
        
        try
        {
            instance.getTotalNumberOfPendingApplications(new Person("u12236731"), applicationStatusGroup);
           
            verify(mockDAOFactory).createApplicationDAO();
            verify(mockApplicationJpaController).countAllApplicationsWithStatus(applicationStatusGroup);
            
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockDBEntitiesFactory);
            verifyNoMoreInteractions(mockGregorianCalendar);
            verifyNoMoreInteractions(mockDAOFactory);
            verifyNoMoreInteractions(mockDeclineReportJpaController);
            verifyNoMoreInteractions(mockApplicationReviewRequestJpaController);
        }
        catch (Exception ex)
        {
            fail("An exception occured");
        }
    }

    /**
     * Test of declineAppliction method, of class ApplicationServicesUtil.
     */
    @Test
    public void testDeclineAppliction() throws Exception {
        Faculty mockFaculty = mock(Faculty.class);
        Department mockDepartment = mock(Department.class);
        when(mockDepartment.getFaculty()).thenReturn(mockFaculty);
        
        EmployeeInformation mockEmployeeInformation = mock(EmployeeInformation.class);
        when(mockEmployeeInformation.getDepartment()).thenReturn(mockDepartment);
        
        Person mockPerson = mock(Person.class);
        when(mockPerson.getEmployeeInformation()).thenReturn(mockEmployeeInformation);
        
        Session mockSession = mock(Session.class);
        when(mockSession.getUser()).thenReturn(mockPerson);
        
        Application mockApplication = mock(Application.class);
        
        when(mockApplication.getFellow()).thenReturn(new Person("u12236731"));
        when(mockApplication.getGrantHolder()).thenReturn(mockPerson);
        when(mockApplication.getApplicationID()).thenReturn(Long.MAX_VALUE);
        when(mockApplication.getStatus()).thenReturn("Pending");
        
        String reason = "Prospective fellow does not meet the requirement";
        
        when(mockDBEntitiesFactory.createAduitLogEntitiy("Declined application " + Long.MAX_VALUE, new Person("u12236731"))).thenReturn(new AuditLog(Long.MAX_VALUE));
        when(mockDBEntitiesFactory.createDeclineReportEntity(mockApplication,mockSession.getUser(), reason, mockGregorianCalendar.getTime())).thenReturn(new DeclineReport(Long.MAX_VALUE));
        
        try
        {
            instance.declineAppliction(mockSession, mockApplication, reason);
            
            verify(mockDAOFactory).createApplicationDAO();
            verify(mockDAOFactory).createDeclineReportDAO();
            verify(mockDBEntitiesFactory).createDeclineReportEntity(mockApplication, mockSession.getUser() ,reason, mockGregorianCalendar.getTime());
            verify(mockApplicationJpaController).edit(mockApplication);
            verify(mockDeclineReportJpaController).create(new DeclineReport(Long.MAX_VALUE));
            
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockDBEntitiesFactory);
            verifyNoMoreInteractions(mockDAOFactory);
            verifyNoMoreInteractions(mockDeclineReportJpaController);
            verifyNoMoreInteractions(mockApplicationReviewRequestJpaController);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            fail("An exception occured");
        }
    }
    
    @Test
    public void testDeclineApplictionAlreadyDeclined() throws Exception {
        Session mockSession = mock(Session.class);
        when(mockSession.getUser()).thenReturn(new Person("u12236731"));
        
        Application mockApplication = mock(Application.class);
        
        when(mockApplication.getFellow()).thenReturn(new Person("u12236731"));
        when(mockApplication.getGrantHolder()).thenReturn(new Person("s25030403"));
        when(mockApplication.getApplicationID()).thenReturn(Long.MAX_VALUE);
        when(mockApplication.getStatus()).thenReturn(com.softserve.auxiliary.constants.PersistenceConstants.APPLICATION_STATUS_DECLINED);
        
        String reason = "Prospective fellow does not meet the requirement";
        
        when(mockDBEntitiesFactory.createAduitLogEntitiy("Declined application " + Long.MAX_VALUE, new Person("u12236731"))).thenReturn(new AuditLog(Long.MAX_VALUE));
        when(mockDBEntitiesFactory.createNotificationEntity(new Person("u12236731"), new Person("u12236731"), "Application declined", "The following application has been declined by " + mockSession.getUser().getCompleteName() + ". For the following reasons: " + reason)).thenReturn(new Notification(Long.MAX_VALUE));
        when(mockDBEntitiesFactory.createNotificationEntity(new Person("u12236731"), mockApplication.getGrantHolder(), "Application declined", "The following application has been declined by " + mockSession.getUser().getCompleteName() + ". For the following reasons: " + reason)).thenReturn(new Notification(Long.MIN_VALUE));
        when(mockDBEntitiesFactory.createDeclineReportEntity(mockApplication,mockSession.getUser(), reason, mockGregorianCalendar.getTime())).thenReturn(new DeclineReport(Long.MAX_VALUE));
        
        try
        {
            instance.declineAppliction(mockSession, mockApplication, reason);
            
            verify(mockDBEntitiesFactory).createDeclineReportEntity(mockApplication, mockSession.getUser() ,reason, mockGregorianCalendar.getTime());
            verify(mockDBEntitiesFactory).createAduitLogEntitiy("Declined application "+ Long.MAX_VALUE, new Person("u12236731"));
            verify(mockDBEntitiesFactory).createNotificationEntity(new Person("u12236731"), new Person("u12236731"), "Application declined", "The following application has been declined by " + mockSession.getUser().getCompleteName() + ". For the following reasons: " + reason);
            verify(mockDBEntitiesFactory).createNotificationEntity(new Person("u12236731"), mockApplication.getGrantHolder(), "Application declined", "The following application has been declined by " + mockSession.getUser().getCompleteName() + ". For the following reasons: " + reason);
            
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockApplicationJpaController);
            verifyNoMoreInteractions(mockDBEntitiesFactory);
            verifyNoMoreInteractions(mockGregorianCalendar);
            verifyNoMoreInteractions(mockDAOFactory);
            verifyNoMoreInteractions(mockDeclineReportJpaController);
            verifyNoMoreInteractions(mockApplicationReviewRequestJpaController);
        }
        catch (Exception ex)
        {
            if(!ex.getMessage().equals("Application has already been declined"))
            {
                fail("An exception occured");
            }
        }
    }
}
