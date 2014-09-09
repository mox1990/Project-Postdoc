/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.transactioncontrollers;

import com.softserve.DBDAO.DAOFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
public class TransactionController {
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;
    private UserTransaction userTransaction = null;

    public TransactionController(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    
    public EntityManager StartTransaction() throws Exception
    {
        if(userTransaction == null)
        {
            userTransaction = com.softserve.constants.PersistenceConstants.getUserTransaction();
            try
            {
                userTransaction.begin();
                entityManager = entityManagerFactory.createEntityManager();
                
            }
            catch(Exception ex)
            {
                userTransaction = null;
                throw new Exception("Transaction start failed due to " + ex.toString() + ". Database remains unchanged.", ex);
            }
        }
        
        return entityManager;
    }
    
    public void RollbackTransaction() throws Exception
    {
        if(userTransaction != null)
        {
            userTransaction.rollback();
        }
        else
        {
            throw new Exception("Transcation controller cannot commit a null user transaction");
        }
    }
    
    
    public void CommitTransaction() throws Exception
    {
        if(userTransaction != null)
        {            
            userTransaction.commit();
        }
        else
        {
            throw new Exception("Transcation controller cannot commit a null user transaction");
        }
    }
    
    public void CloseEntityManagerForTransaction() throws Exception
    {
        if(entityManager != null)
        {
            entityManager.close();
            entityManager = null;
        }
        else
        {
            throw new Exception("Transcation controller cannot close a null entity manager");
        }
    }
    
    public DAOFactory getDAOFactoryForTransaction() throws Exception
    {
        if(userTransaction != null && entityManager != null )
        {
            return new DAOFactory(entityManager);
        }
        else
        {
            throw new Exception("Transcation controller cannot find a vaild entity manager");
        }
    }
    
}
