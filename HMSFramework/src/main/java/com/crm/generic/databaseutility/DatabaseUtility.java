package com.crm.generic.databaseutility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	Connection connection;
	Statement statement;
public void connectToDatabase() throws SQLException
{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp10","admin","root");
	
}

public ResultSet executeSelectQuery(String query) throws SQLException
{
	statement
	 = connection.createStatement();
	ResultSet result = statement.executeQuery(query);
	return result;
}

public int executeNonSelectQuery(String query) throws SQLException
{
	int result = statement.executeUpdate(query);
	return result;
	
}

public void closeDB() throws SQLException
{
	connection.close();
}
}
