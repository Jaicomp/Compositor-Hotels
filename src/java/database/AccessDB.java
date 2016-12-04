/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

/**
 *
 * @author jaimescript
 */
public class AccessDB {
    private Connection connection;
    private String host;
    private String port;
    private String db;
    private String user;
    private String pass;
    Statement stmt = null;
    
    public AccessDB() {
        host = DBProperties.host;
        port = DBProperties.port;
        db = DBProperties.db;
        user = DBProperties.user;
        pass = DBProperties.pass;
        connection = null;
    }
    
    private void connectDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager
                    .getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db, user, pass);
            
        } catch (Exception e) {
            e.printStackTrace();
            
            
        }
        System.out.println("Opened database successfully");
        
        
    }
    
    
    public ResultSet executeSQLStatement(String sqlStatement) throws SQLException {
        ResultSet resultSet = null;
        try{
            
        connectDatabase();
        stmt = connection.createStatement();
        resultSet = stmt.executeQuery(sqlStatement);
        
        
        }  catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            disconnectDatabase();
        }
        
        return resultSet;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    
    
    private void disconnectDatabase() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String toUtf8(String s) {
        String res = "no-UTF8";
        byte[] b;
        try {
            b = s.getBytes("UTF-8");
            res = new String(b);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AccessDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    
    
    
}
