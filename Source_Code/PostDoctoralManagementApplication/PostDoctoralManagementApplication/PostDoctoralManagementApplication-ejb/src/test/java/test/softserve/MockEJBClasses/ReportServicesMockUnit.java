/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.softserve.MockEJBClasses;

import com.softserve.DBDAO.ApplicationJpaController;
import com.softserve.DBDAO.AuditLogJpaController;
import com.softserve.DBDAO.PersonJpaController;
import com.softserve.ejb.ReportServices;
import com.softserve.ejb.UserGateway;
import com.softserve.ejb.UserGatewayLocal;

/**
 *
 * @author kgothatso
 */
public class ReportServicesMockUnit extends ReportServices {
    UserGateway uEJB;

    public UserGateway getuEJB() {
        return uEJB;
    }

    public void setuEJB(UserGateway uEJB) {
        this.uEJB = uEJB;
    }
    
    @Override
    protected UserGatewayLocal getUserGatewayServiceEJB()
    {
        return uEJB;
    }
}
