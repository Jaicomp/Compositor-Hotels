/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marketing.Header;

/**
 *
 * @author jaimescript
 */
public class DBMarketing {
    
    private AccessDB accessDB;
    
    public DBMarketing() {
        accessDB = new AccessDB();
    }
    
    public Header getHeaderInfoFromPage(String namePage) {
        
        Header header = null;
        try {
            //ResultSet resultSet = accessDB.executeSQLStatement("SELECT * FROM \"Marketing\" WHERE namepage = '" + namePage + "';");
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT * FROM \"Marketing\" WHERE namepage='rooms.jsp';");
            
            if (resultSet.isFirst() ){
                int id = resultSet.getInt("id");
            }
            
//          String name = accessDB.toUtf8(resultSet.getString("namePage"));
//            String title = accessDB.toUtf8(resultSet.getString("title"));
//            String keywords = accessDB.toUtf8(resultSet.getString("keywords"));
//            String description = accessDB.toUtf8(resultSet.getString("description"));
//            String language = accessDB.toUtf8(resultSet.getString("language"));
//
//            header = new Header(id, name, title,keywords,description,language);
            header = new Header(1, "N", "T","K",namePage,"L");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return header;
    }
}
