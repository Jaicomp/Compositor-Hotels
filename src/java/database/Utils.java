/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jaimescript
 */
public class Utils {
    
    public String hola(
            HttpServletRequest request,
            HttpServletResponse response
        ) throws SQLException {
       
       return  (new AccessDB()).executeSQLStatement("") + "";
       
    }
    
}
