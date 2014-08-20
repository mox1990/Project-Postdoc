/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.DBDAO;

import com.softserve.DBDAO.exceptions.NonexistentEntityException;
import com.softserve.DBDAO.exceptions.PreexistingEntityException;
import com.softserve.DBDAO.exceptions.RollbackFailureException;
import com.softserve.DBEntities.FundingCost;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.softserve.DBEntities.FundingReport;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
public class FundingCostJpaController implements Serializable {

    public FundingCostJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FundingCost fundingCost) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            FundingReport fundingReport = fundingCost.getFundingReport();
            if (fundingReport != null) {
                fundingReport = em.getReference(fundingReport.getClass(), fundingReport.getReportID());
                fundingCost.setFundingReport(fundingReport);
            }
            em.persist(fundingCost);
            if (fundingReport != null) {
                fundingReport.getFundingCostList().add(fundingCost);
                fundingReport = em.merge(fundingReport);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findFundingCost(fundingCost.getCostID()) != null) {
                throw new PreexistingEntityException("FundingCost " + fundingCost + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FundingCost fundingCost) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            FundingCost persistentFundingCost = em.find(FundingCost.class, fundingCost.getCostID());
            FundingReport fundingReportOld = persistentFundingCost.getFundingReport();
            FundingReport fundingReportNew = fundingCost.getFundingReport();
            if (fundingReportNew != null) {
                fundingReportNew = em.getReference(fundingReportNew.getClass(), fundingReportNew.getReportID());
                fundingCost.setFundingReport(fundingReportNew);
            }
            fundingCost = em.merge(fundingCost);
            if (fundingReportOld != null && !fundingReportOld.equals(fundingReportNew)) {
                fundingReportOld.getFundingCostList().remove(fundingCost);
                fundingReportOld = em.merge(fundingReportOld);
            }
            if (fundingReportNew != null && !fundingReportNew.equals(fundingReportOld)) {
                fundingReportNew.getFundingCostList().add(fundingCost);
                fundingReportNew = em.merge(fundingReportNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = fundingCost.getCostID();
                if (findFundingCost(id) == null) {
                    throw new NonexistentEntityException("The fundingCost with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            FundingCost fundingCost;
            try {
                fundingCost = em.getReference(FundingCost.class, id);
                fundingCost.getCostID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fundingCost with id " + id + " no longer exists.", enfe);
            }
            FundingReport fundingReport = fundingCost.getFundingReport();
            if (fundingReport != null) {
                fundingReport.getFundingCostList().remove(fundingCost);
                fundingReport = em.merge(fundingReport);
            }
            em.remove(fundingCost);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FundingCost> findFundingCostEntities() {
        return findFundingCostEntities(true, -1, -1);
    }

    public List<FundingCost> findFundingCostEntities(int maxResults, int firstResult) {
        return findFundingCostEntities(false, maxResults, firstResult);
    }

    private List<FundingCost> findFundingCostEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FundingCost.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public FundingCost findFundingCost(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FundingCost.class, id);
        } finally {
            em.close();
        }
    }

    public int getFundingCostCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FundingCost> rt = cq.from(FundingCost.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
