/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.ejb;

import com.softserve.DBDAO.exceptions.NonexistentEntityException;
import com.softserve.DBDAO.exceptions.RollbackFailureException;
import com.softserve.DBEntities.Application;
import com.softserve.DBEntities.RecommendationReport;
import com.softserve.Exceptions.AuthenticationException;
import com.softserve.system.Session;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Local
public interface HODApprovalServicesLocal {
    public List<Application> loadPendingApplications(Session session, int StartIndex, int maxNumberOfRecords) throws AuthenticationException, Exception;
    public int countTotalPendingApplications(Session session) throws AuthenticationException, Exception;
    public void denyAppliction(Session session, Application application, String reason) throws AuthenticationException, NonexistentEntityException, RollbackFailureException, Exception;
    public void ammendAppliction(Session session, Application application, String reason) throws AuthenticationException, NonexistentEntityException, RollbackFailureException, Exception;
    public void approveApplication(Session session, Application application, RecommendationReport recommendationReport) throws AuthenticationException, NonexistentEntityException, RollbackFailureException, Exception;
}
