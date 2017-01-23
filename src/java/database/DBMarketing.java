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
    
    public Header getHeaderFromPage(String page) {
        
        Header header = null;
        try {
            //ResultSet resultSet = accessDB.executeSQLStatement("SELECT * FROM \"Marketing\" WHERE namepage = '" + page + "';");
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT * FROM \"Marketing\" WHERE \"namepage\"='" + page + "';");
            
            
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = accessDB.toUtf8(resultSet.getString("namepage"));
                String title = accessDB.toUtf8(resultSet.getString("title"));
                String keywords = accessDB.toUtf8(resultSet.getString("keywords"));
                String description = accessDB.toUtf8(resultSet.getString("description"));
                String language = accessDB.toUtf8(resultSet.getString("language"));
                header = new Header(id, name, title,keywords,description,language);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return header;
    }
    /**
    *   Increase one visit on this page (first parameter)
    *
    */
    public void increaseVisitsFromPage(String page) {
        
        try {
            
            accessDB.executeSQLStatement("UPDATE \"Marketing\" SET visited = visited + 1 WHERE namepage='" + page + "';");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Header> getHeaders() {
        
        ArrayList<Header> headers = new ArrayList<Header>();
        
        try {
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT * FROM \"Marketing\";");
            
            while(resultSet.next()) {
                Header header;
                
                int id = resultSet.getInt("id");
                String name = accessDB.toUtf8(resultSet.getString("namePage"));
                String title = accessDB.toUtf8(resultSet.getString("title"));
                String keywords = accessDB.toUtf8(resultSet.getString("keywords"));
                String description = accessDB.toUtf8(resultSet.getString("description"));
                String language = accessDB.toUtf8(resultSet.getString("language"));
                int visits = resultSet.getInt("visited");
                
                header = new Header(id, name, title,keywords,description,language, visits);
                
                headers.add(header);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return headers;
        
    }
    
    public void updateMetaTag(String namePage, String metaTag, String valueTag) {
        try {
            accessDB.executeSQLStatement("UPDATE \"Marketing\" SET " + metaTag + "='" + valueTag + "' WHERE namepage='" + namePage +  "';");
                    } catch (SQLException ex) {
            Logger.getLogger(DBMarketing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
