/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.Webapp.conversationbeans;

import com.softserve.persistence.DBEntities.Application;
import com.softserve.persistence.DBEntities.FundingReport;
import com.softserve.persistence.DBEntities.Notification;
import com.softserve.persistence.DBEntities.Person;
import com.softserve.persistence.DBEntities.ResearchFellowInformation;
import com.softserve.Webapp.depenedentbeans.FundingReportCreationDependBean;
import com.softserve.Webapp.depenedentbeans.LocationFinderDependBean;
import com.softserve.Webapp.sessionbeans.ConversationManagerBean;
import com.softserve.Webapp.sessionbeans.NavigationManagerBean;
import com.softserve.Webapp.sessionbeans.SessionManagerBean;
import com.softserve.Webapp.util.ExceptionUtil;
import com.softserve.ejb.applicationservices.DRISApprovalServiceLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Named(value = "drisApproveFundingBean")
@ConversationScoped 
public class DRISApproveFundingBean implements Serializable{

    @Inject
    private SessionManagerBean sessionManagerBean;
    @Inject 
    private NavigationManagerBean navigationManagerBean;
    @Inject
    private FundingReportCreationDependBean fundingReportCreationDependBean;
    @Inject
    private LocationFinderDependBean locationFinderDependBean;
    @Inject
    private ConversationManagerBean conversationManagerBean;
    
    @Inject
    private Conversation conversation;
    
    @EJB
    private DRISApprovalServiceLocal dRISApprovalServiceLocal;
    
    private ResearchFellowInformation researchFellowInformation;
    private String applicantMessage;
    private Notification cscMessage;
    private Notification financeMessage;
    private Date startDate;
    private Date endDate;
    
    private int noOfYears;
    
    /**
     * Creates a new instance of DRISApproveFundingBean
     */
    public DRISApproveFundingBean() {
    }
    
    @PostConstruct
    public void init()
    {
        conversationManagerBean.registerConversation(conversation);
        conversationManagerBean.startConversation(conversation);
        System.out.println("Initialising");
        try
        {
            if(getSelectedApplication() == null)
            {
                throw new Exception("No application selected");
            }
            
            fundingReportCreationDependBean.init(null);
            applicantMessage = "";
            cscMessage = new Notification();
            financeMessage = new Notification();

            cscMessage.setReciever(new Person());
            financeMessage.setReciever(new Person());

            if(getSelectedApplication().getFellow().getResearchFellowInformation() != null)
            {
                researchFellowInformation = getSelectedApplication().getFellow().getResearchFellowInformation();
            }
            else
            {
                researchFellowInformation = new  ResearchFellowInformation();
            }

            locationFinderDependBean.init(researchFellowInformation.getDepartment());
        }
        catch(Exception ex)
        {
            ExceptionUtil.logException(DRISApproveFundingBean.class, ex);
            ExceptionUtil.handleException(null, ex);
            navigationManagerBean.callFacesNavigator(navigationManagerBean.goToDRISApprovalServiceApplicationSelectionView());
        }
    }            

    public FundingReportCreationDependBean getFundingReportCreationDependBean() {
        return fundingReportCreationDependBean;
    }

    public void setFundingReportCreationDependBean(FundingReportCreationDependBean fundingReportCreationDependBean) {
        this.fundingReportCreationDependBean = fundingReportCreationDependBean;
    }

    public Notification getCscMessage() {
        return cscMessage;
    }

    public void setCscMessage(Notification cscMessage) {
        this.cscMessage = cscMessage;
    }

    public Notification getFinanceMessage() {
        return financeMessage;
    }

    public void setFinanceMessage(Notification financeMessage) {
        this.financeMessage = financeMessage;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public ResearchFellowInformation getResearchFellowInformation() {
        return researchFellowInformation;
    }

    public void setResearchFellowInformation(ResearchFellowInformation researchFellowInformation) {
        this.researchFellowInformation = researchFellowInformation;
    }
                    
    public Application getSelectedApplication()
    {
        return sessionManagerBean.getObjectFromSessionStorage("APPLICATION", Application.class);
    }

    public LocationFinderDependBean getLocationFinderDependBean() {
        return locationFinderDependBean;
    }

    public void setLocationFinderDependBean(LocationFinderDependBean locationFinderDependBean) {
        this.locationFinderDependBean = locationFinderDependBean;
    }
            
    public void onYearSlideEnd()
    {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(startDate);
        gregorianCalendar.add(GregorianCalendar.YEAR, noOfYears);
        System.out.println("Number of years " + noOfYears);
        endDate = gregorianCalendar.getTime();
    }
    
    public String preformFundingApprovalRequest()
    {
        try
        {
            Application application = getSelectedApplication();
            application.setStartDate(startDate);
            onYearSlideEnd();
            application.setEndDate(endDate);
            researchFellowInformation.setDepartment(locationFinderDependBean.getActualDepartmentEntity(researchFellowInformation.getDepartment().getDepartmentID()));
            researchFellowInformation.setSystemAssignedID(application.getFellow().getSystemID());
            researchFellowInformation.setPerson(application.getFellow());
            
            dRISApprovalServiceLocal.approveFunding(sessionManagerBean.getSession(), application, researchFellowInformation, fundingReportCreationDependBean.getFundingReport(),applicantMessage,cscMessage,financeMessage);
            return navigationManagerBean.goToDRISApprovalServiceApplicationSelectionView();
        }
        catch(Exception ex)
        {
            ExceptionUtil.logException(DRISApproveFundingBean.class, ex);
            ExceptionUtil.handleException(null, ex);
            return "";
        }
    }
    
    
}
