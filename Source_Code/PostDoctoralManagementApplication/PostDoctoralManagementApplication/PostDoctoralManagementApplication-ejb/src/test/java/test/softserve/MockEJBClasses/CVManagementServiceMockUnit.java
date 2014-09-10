/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.softserve.MockEJBClasses;

import com.softserve.DBDAO.AcademicQualificationJpaController;
import com.softserve.DBDAO.CvJpaController;
import com.softserve.DBDAO.ExperienceJpaController;
import com.softserve.ejb.AuditTrailService;
import com.softserve.ejb.CVManagementService;
import com.softserve.ejb.UserGateway;
import com.softserve.system.DBEntitiesFactory;
import com.softserve.system.Session;

/**
 *
 * @author kgothatso
 */
public class CVManagementServiceMockUnit extends CVManagementService {
    private CvJpaController cVDAO;
    private UserGateway uEJB;
    private AuditTrailService aTEJB;
    private DBEntitiesFactory dBEntities;
    private AcademicQualificationJpaController aQDAO;
    private ExperienceJpaController eDAO;

    public void seteDAO(ExperienceJpaController eDAO) {
        this.eDAO = eDAO;
    }
    
    public void setaQDAO(AcademicQualificationJpaController aQDAO) {
        this.aQDAO = aQDAO;
    }
    
    public void setcVDAO(CvJpaController cVDAO) {
        this.cVDAO = cVDAO;
    }

    public void setuEJB(UserGateway uEJB) {
        this.uEJB = uEJB;
    }

    public void setaTEJB(AuditTrailService aTEJB) {
        this.aTEJB = aTEJB;
    }

    public void setdBEntities(DBEntitiesFactory dBEntities) {
        this.dBEntities = dBEntities;
    }
    
    protected ExperienceJpaController getExperienceDAO()
    {
        return eDAO;
    }
    
}
