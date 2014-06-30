/*
 * This file is licensed to the authors stated below
 * Any unauthrised changes are prohibited.
 * and open the template in the editor.
 */

package test.softserve.MockEJBClasses;

import com.softserve.DBDAO.*;
import com.softserve.DBDAO.exceptions.NonexistentEntityException;
import com.softserve.DBDAO.exceptions.PreexistingEntityException;
import com.softserve.DBDAO.exceptions.RollbackFailureException;
import com.softserve.DBEntities.Address;
import com.softserve.DBEntities.Person;
import com.softserve.DBEntities.UpEmployeeInformation;
import com.softserve.Exceptions.AutomaticSystemIDGenerationException;
import com.softserve.UserAccountManagementServices.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpSession;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */

public class UserAccountManagementServicesMockUnit extends UserAccountManagementServices {     
    
    private PersonJpaController pDAO = null;
    private AddressJpaController aDAO = null;
    private UpEmployeeInformationJpaController uDAO = null;

    public void setpDAO(PersonJpaController pDAO) {
        this.pDAO = pDAO;
    }

    public void setaDAO(AddressJpaController aDAO) {
        this.aDAO = aDAO;
    }

    public void setuDAO(UpEmployeeInformationJpaController uDAO) {
        this.uDAO = uDAO;
    }
    
    
    /**
     *This function creates an instance of the PersonJpaController. 
     * Note this function's secondary goal is to simplify the subclass mocking 
     * of the UserAccountManagementServices in the unit testing 
     * @return An instance of PersonJpaController
     */
    @Override
    protected PersonJpaController getPersonDAO()
    {
        return pDAO;
    }
    
    /**
     *This function creates an instance of the AddressJpaController. 
     * Note this function's secondary goal is to simplify the subclass mocking 
     * of the UserAccountManagementServices in the unit testing 
     * @return An instance of AddressJpaController
     */
    @Override
    protected AddressJpaController getAddressDAO()
    {
        return aDAO;
    }
    
    /**
     *This function creates an instance of the UpEmployeeInformationJpaController. 
     * Note this function's secondary goal is to simplify the subclass mocking 
     * of the UserAccountManagementServices in the unit testing 
     * @return An instance of UpEmployeeInformationJpaController
     */
    @Override
    protected UpEmployeeInformationJpaController getUPEmployeeInfoDAO()
    {
        return uDAO;
    }
    
    
    
    
}
