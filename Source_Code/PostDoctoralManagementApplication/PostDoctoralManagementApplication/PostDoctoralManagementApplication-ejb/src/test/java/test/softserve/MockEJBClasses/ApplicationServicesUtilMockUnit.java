/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.softserve.MockEJBClasses;

import com.softserve.DBDAO.ApplicationJpaController;
import com.softserve.DBDAO.DeclineReportJpaController;
import com.softserve.ejb.AuditTrailService;
import com.softserve.ejb.NotificationService;
import com.softserve.ejb.UserGateway;
import com.softserve.system.ApplicationServicesUtil;
import com.softserve.system.DBEntitiesFactory;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author kgothatso
 */
public class ApplicationServicesUtilMockUnit extends ApplicationServicesUtil {
    private ApplicationJpaController aDAO;
    private DBEntitiesFactory dBEntities;
    private UserGateway uEJB;
    private NotificationService nEJB;
    private AuditTrailService aTEJB;
    private DeclineReportJpaController dRDAO;
    private GregorianCalendar gCal;

    public ApplicationServicesUtilMockUnit() {
        super(null);
    }

    public ApplicationServicesUtilMockUnit(EntityManager em) {
        super(em);
    }

    public void setaDAO(ApplicationJpaController aDAO) {
        this.aDAO = aDAO;
    }

    public void setdBEntities(DBEntitiesFactory dBEntities) {
        this.dBEntities = dBEntities;
    }

    public void setuEJB(UserGateway uEJB) {
        this.uEJB = uEJB;
    }

    public void setnEJB(NotificationService nEJB) {
        this.nEJB = nEJB;
    }

    public void setaTEJB(AuditTrailService aTEJB) {
        this.aTEJB = aTEJB;
    }

    public void setdRDAO(DeclineReportJpaController dRDAO) {
        this.dRDAO = dRDAO;
    }

    public void setgCal(GregorianCalendar gCal) {
        this.gCal = gCal;
    }
    
    protected ApplicationJpaController getApplicationDAO()
    {
        return aDAO;
    }
    
    /**
     *
     * @return
     */
    @Override
    protected DBEntitiesFactory getDBEntitiesFactory()
    {
        return dBEntities;
    }
    
    /**
     *
     * @return
     */
    protected UserGateway getUserGatewayServiceEJB()
    {
        return uEJB;
    }
    
    /**
     *
     * @return
     */
    protected NotificationService getNotificationServiceEJB()
    {
        return nEJB;
    }
    
    /**
     *
     * @return
     */
    protected AuditTrailService getAuditTrailServiceEJB()
    {
        return aTEJB;
    }
    
    protected DeclineReportJpaController getDeclineReportDAO()
    {
        return dRDAO;
    }
    
    @Override
    protected GregorianCalendar getGregorianCalendar()
    {
        return gCal;
    }
}
