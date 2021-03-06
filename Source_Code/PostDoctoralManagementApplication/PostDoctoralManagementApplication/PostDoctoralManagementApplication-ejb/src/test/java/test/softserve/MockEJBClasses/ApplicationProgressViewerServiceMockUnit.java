/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.softserve.MockEJBClasses;

import com.softserve.persistence.DBDAO.ApplicationJpaController;
import com.softserve.auxiliary.factories.DAOFactory;
import com.softserve.ejb.applicationservices.ApplicationProgressViewerService;
import com.softserve.ejb.nonapplicationservices.UserGateway;
import com.softserve.auxiliary.util.ApplicationServicesUtil;
import com.softserve.auxiliary.factories.DBEntitiesFactory;
import com.softserve.auxiliary.transactioncontrollers.TransactionController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
public class ApplicationProgressViewerServiceMockUnit extends ApplicationProgressViewerService {
    private ApplicationServicesUtil aEJB;
    private UserGateway uEJB;
    private DAOFactory dAOFactory;
    private EntityManager em;
    
    @Override    
    protected DAOFactory getDAOFactory(EntityManager em) {
        return dAOFactory;
    }    
    
    @Override
    protected ApplicationServicesUtil getApplicationServicesUTIL(EntityManager em) {
        return aEJB;
    }
    
    @Override
    protected UserGateway getUserGatewayServiceEJB() {
        return uEJB;
    }
    
    @Override
    protected EntityManager createEntityManager() {
        return em;
    }
    
    public void setaEJB(ApplicationServicesUtil aEJB) {
        this.aEJB = aEJB;
    }

    public void setuEJB(UserGateway uEJB) {
        this.uEJB = uEJB;
    }
    
    public void setdAOFactory(DAOFactory dAOFactory) {
        this.dAOFactory = dAOFactory;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
