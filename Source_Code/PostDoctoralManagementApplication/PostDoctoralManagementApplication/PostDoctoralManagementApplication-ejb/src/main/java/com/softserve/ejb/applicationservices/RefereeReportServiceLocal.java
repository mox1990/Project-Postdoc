/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.ejb.applicationservices;

import com.softserve.persistence.DBDAO.exceptions.RollbackFailureException;
import com.softserve.persistence.DBEntities.Application;
import com.softserve.persistence.DBEntities.RefereeReport;
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
public interface RefereeReportServiceLocal 
{
    public List<Application> loadPendingApplications(Session session, int StartIndex, int maxNumberOfRecords) throws AuthenticationException, Exception;
    public int countTotalPendingApplications(Session session) throws AuthenticationException, Exception;
    public void submitReferralReport(Session session, Application application, RefereeReport refereeReport) throws AuthenticationException, RollbackFailureException, Exception; 
}
