/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal.database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author pgn
 */
public class DatabaseConnector
{
    
    private SQLServerDataSource dataSource;
    
    public DatabaseConnector() throws IOException
    {
        Properties props = new Properties();
        props.load(new FileReader("DBSettings.txt"));
        dataSource = new SQLServerDataSource();
        dataSource.setDatabaseName(props.getProperty("database"));
        System.out.println(dataSource.getDatabaseName());
        dataSource.setUser(props.getProperty("user"));
         System.out.println(dataSource.getUser());
        dataSource.setPassword(props.getProperty("password"));  
        System.out.println(props.getProperty("password"));
        dataSource.setServerName(props.getProperty("server"));
        System.out.println(props.getProperty("server"));
    }
    
    public Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }
    
}
