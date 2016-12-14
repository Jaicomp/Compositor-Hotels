/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jaimescript
 */
public class DBClient {
    
    private AccessDB accessDB;
    
    public DBClient() {
        accessDB = new AccessDB();
    }
    
    
    public boolean existClient(String username, String password) {
        boolean existClient = false;
        try {
            
            ResultSet resultSet = accessDB.executeSQLStatement("SELECT * FROM \"Client\" WHERE username='" + username + "' and password='" + password + "';");
            
            //Remember, the cursor is pointing before the first row
            existClient = resultSet.next();
            
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return existClient;
        
    }
    
        public void addNewClient(String username, String password, String firstname, String lastname, String email) {
        
        try {
            
            accessDB.executeSQLStatement("INSERT INTO \"Client\"(username, password, firstname, lastname, email) values ('" + username + "','" + password + "','" + firstname + "','" + lastname + "','" + email + "');");
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
