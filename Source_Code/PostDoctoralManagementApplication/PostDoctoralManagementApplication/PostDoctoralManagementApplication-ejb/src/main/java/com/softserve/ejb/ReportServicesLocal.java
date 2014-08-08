/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.softserve.ejb;

import com.itextpdf.text.DocumentException;
import com.softserve.DBEntities.Application;
import com.softserve.system.Session;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author K
 */
@Local
public interface ReportServicesLocal {
    public byte[] exportPersonsToPdf() throws JRException, ClassNotFoundException, SQLException, InterruptedException;
    public byte[] exportPersonsToExcel() throws JRException, ClassNotFoundException, SQLException, InterruptedException, IOException;
}
