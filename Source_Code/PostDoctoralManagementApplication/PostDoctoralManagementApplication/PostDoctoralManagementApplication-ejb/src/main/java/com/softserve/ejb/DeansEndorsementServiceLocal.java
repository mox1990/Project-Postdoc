/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.ejb;

import com.softserve.DBDAO.exceptions.NonexistentEntityException;
import com.softserve.DBDAO.exceptions.RollbackFailureException;
import com.softserve.DBEntities.Application;
import com.softserve.DBEntities.Endorsement;
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
public interface DeansEndorsementServiceLocal {
    public List<Application> loadPendingApplications(Session session) throws AuthenticationException, Exception;
    public void denyApplication(Session session, Application application, String reason) throws AuthenticationException, NonexistentEntityException, RollbackFailureException, Exception;
    public void endorseApplication(Session session, Application application, Endorsement endorsementReport) throws AuthenticationException, RollbackFailureException, NonexistentEntityException, Exception;    
}
