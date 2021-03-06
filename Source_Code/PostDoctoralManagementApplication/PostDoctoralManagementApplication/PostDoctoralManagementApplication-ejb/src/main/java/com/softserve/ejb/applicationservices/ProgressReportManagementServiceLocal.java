/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.ejb.applicationservices;

import com.softserve.persistence.DBEntities.Application;
import com.softserve.persistence.DBEntities.ProgressReport;
import com.softserve.auxiliary.Exceptions.AuthenticationException;
import com.softserve.auxiliary.requestresponseclasses.Session;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Local
public interface ProgressReportManagementServiceLocal {
    public void createProgressReport(Session session, Application application, ProgressReport progressReport) throws Exception;
    public void updateProgressReport(Session session, ProgressReport progressReport) throws Exception;
    public List<Application> allApplicationsWithPendingReportsForUser(Session session) throws Exception;
    public boolean doesApplicationHaveFinalProgressReport(Session session, Application application) throws Exception;
    public int getNumberOfProgressReportsRequiredByApplication(Session session, Application application) throws Exception;
}
