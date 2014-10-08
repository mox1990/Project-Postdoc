/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.softserve.MockEJBClasses;

import com.softserve.persistence.DBDAO.AuditLogJpaController;
import com.softserve.auxillary.factories.DAOFactory;
import com.softserve.auxillary.factories.DBEntitiesFactory;
import com.softserve.ejb.nonapplicationservices.AuditTrailService;
import com.softserve.auxillary.transactioncontrollers.TransactionController;
import javax.persistence.EntityManager;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
public class AuditTrailServiceMockUnit extends AuditTrailService {
    DAOFactory dAOFactory;
    TransactionController transactionController;
    EntityManager em;

    public void setdAOFactory(DAOFactory dAOFactory) {
        this.dAOFactory = dAOFactory;
    }
    
    public void setTransactionController(TransactionController transactionController) {
        this.transactionController = transactionController;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Override
    protected DAOFactory getDAOFactory(EntityManager em)
    {
        return dAOFactory;
    }
    
    @Override
    protected TransactionController getTransactionController()
    {
        return transactionController;
    }
    
    @Override
    protected EntityManager createEntityManager()
    {
        return em;
    }
}
