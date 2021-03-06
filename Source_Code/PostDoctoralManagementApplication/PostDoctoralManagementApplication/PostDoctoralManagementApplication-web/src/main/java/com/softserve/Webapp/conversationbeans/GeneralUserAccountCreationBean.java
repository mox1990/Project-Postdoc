/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.Webapp.conversationbeans;

import com.softserve.persistence.DBEntities.Address;
import com.softserve.persistence.DBEntities.Department;
import com.softserve.persistence.DBEntities.EmployeeInformation;
import com.softserve.persistence.DBEntities.Faculty;
import com.softserve.persistence.DBEntities.Institution;
import com.softserve.persistence.DBEntities.Person;
import com.softserve.persistence.DBEntities.SecurityRole;
import com.softserve.Webapp.depenedentbeans.LocationFinderDependBean;
import com.softserve.Webapp.sessionbeans.ConversationManagerBean;
import com.softserve.Webapp.sessionbeans.NavigationManagerBean;
import com.softserve.Webapp.sessionbeans.SessionManagerBean;
import com.softserve.Webapp.util.ExceptionUtil;
import com.softserve.ejb.nonapplicationservices.LocationManagementServiceLocal;
import com.softserve.ejb.nonapplicationservices.UserAccountManagementServiceLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DualListModel;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Named(value = "generalUserAccountCreationBean")
@ConversationScoped
public class GeneralUserAccountCreationBean implements Serializable{

    @Inject
    private SessionManagerBean sessionManagerBean;
    @Inject 
    private NavigationManagerBean navigationManagerBean;
    @Inject
    private ConversationManagerBean conversationManagerBean;
    @Inject
    private LocationFinderDependBean locationFinderDependBean;
    
    @Inject
    private Conversation conversation;
    
    @EJB
    private UserAccountManagementServiceLocal userAccountManagementServiceLocal;
    
    private String password;
    private String reTypePassword;
    private Person person;
    private Address address;
    private EmployeeInformation employeeInformation;
    private Address upAddress;
    
    private boolean isSystemAdmin;
    
    private List<SecurityRole> sourceRoles;
    private List<SecurityRole> targetRoles;
    private DualListModel<SecurityRole> securityRoles;
    
    /**
     * Creates a new instance of UserAccountCreationRequestBean
     */
    public GeneralUserAccountCreationBean() {
    }
    
    @PostConstruct
    public void init()
    {
        conversationManagerBean.registerConversation(conversation);
        conversationManagerBean.startConversation(conversation);
        
        try
        {
            person = new Person();  
            person.setTitle("Mr.");
            address = new Address();
            employeeInformation = new EmployeeInformation();
            upAddress = new Address();
            employeeInformation.setDepartment(new Department((long)(0)));
            employeeInformation.getDepartment().setFaculty(new Faculty((long) 0));
            employeeInformation.getDepartment().getFaculty().setInstitution(new Institution((long)(0)));

            locationFinderDependBean.init(null);

            sourceRoles = com.softserve.auxiliary.constants.PersistenceConstants.getAllSecurityRoles();
            sourceRoles.remove(com.softserve.auxiliary.constants.PersistenceConstants.SECURITY_ROLE_SYSTEM_ADMINISTRATOR);

            targetRoles = new ArrayList<SecurityRole>();
            securityRoles = new DualListModel<SecurityRole>(sourceRoles, targetRoles);
        }
        catch(Exception ex)
        {
            ExceptionUtil.logException(GeneralUserAccountCreationBean.class, ex);
            ExceptionUtil.handleException(null, ex);
            navigationManagerBean.callFacesNavigator(navigationManagerBean.goToUserAccountManagementServicesHomeView());
        }
        
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
        
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmployeeInformation getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(EmployeeInformation employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

    public Address getUpAddress() {
        return upAddress;
    }

    public void setUpAddress(Address upAddress) {
        this.upAddress = upAddress;
    }

    public DualListModel<SecurityRole> getSecurityRoles() {
        return securityRoles;
    }

    public void setSecurityRoles(DualListModel<SecurityRole> securityRoles) 
    {        
        this.securityRoles = securityRoles;      
    }

    public void setIsSystemAdmin(boolean isSystemAdmin) {
        this.isSystemAdmin = isSystemAdmin;
    }

    public boolean isIsSystemAdmin() {
        return isSystemAdmin;
    }

    public String getReTypePassword() {
        return reTypePassword;
    }

    public void setReTypePassword(String reTypePassword) {
        this.reTypePassword = reTypePassword;
    }
            
    public LocationFinderDependBean getLocationFinderDependBean() {
        return locationFinderDependBean;
    }

    public void setLocationFinderDependBean(LocationFinderDependBean locationFinderDependBean) {
        this.locationFinderDependBean = locationFinderDependBean;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
                
    public String performGeneralUserAccountCreationRequest()
    {
        System.out.println("================================= creating");
        try 
        {
            if(!reTypePassword.equals(password))
            {
                throw new Exception("Passwords do not match");
            }
            
            person.setPassword(password);
            
            if(isSystemAdmin)
            {
                securityRoles.getTarget().addAll(securityRoles.getSource());
                
                
                securityRoles.getTarget().add(com.softserve.auxiliary.constants.PersistenceConstants.SECURITY_ROLE_SYSTEM_ADMINISTRATOR);
            }

            person.setSecurityRoleList(new ArrayList<SecurityRole>());
            person.getSecurityRoleList().addAll(securityRoles.getTarget());
            
            System.out.println(person.getSecurityRoleList().toString());
            
            person.setAccountStatus(com.softserve.auxiliary.constants.PersistenceConstants.ACCOUNT_STATUS_ACTIVE);
            person.setAddressLine1(address);
            
            
            if(person.getUpEmployee())
            {
                employeeInformation.setDepartment(locationFinderDependBean.getActualDepartmentEntity(employeeInformation.getDepartment().getDepartmentID()));
                person.setSystemID(employeeInformation.getEmployeeID());
                employeeInformation.setPhysicalAddress(upAddress);
                person.setEmployeeInformation(employeeInformation);
                userAccountManagementServiceLocal.createUserAccount(sessionManagerBean.getSystemLevelSessionForCurrentSession(), true, person);               
            }
            else
            {
                userAccountManagementServiceLocal.createUserAccount(sessionManagerBean.getSystemLevelSessionForCurrentSession(), false, person);            
            }
            System.out.println("================================= about to clear");
            sessionManagerBean.clearSessionStorage();
            conversationManagerBean.deregisterConversation(conversation);
            return navigationManagerBean.goToUserAccountManagementServicesHomeView();
        } 
        catch (Exception ex) 
        {
            System.out.println("================================= error");
            ExceptionUtil.logException(GeneralUserAccountCreationBean.class, ex);
            ExceptionUtil.handleException(null, ex);
            return "";
        }
    }
}
