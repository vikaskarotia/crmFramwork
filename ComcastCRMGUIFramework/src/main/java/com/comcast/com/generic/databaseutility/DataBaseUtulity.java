package com.comcast.com.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtulity {

	Connection connection = null;
	Statement statement = null;

	public void getConnectToDb(String url, String username, String password) throws SQLException {// default data base

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		connection = DriverManager.getConnection(url, username, password);

		System.out.println("connection succesful");
	}

	public ResultSet excuteQuery(String query) throws SQLException {

		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		return rs;
	}
	
	public void closeDbConnection() throws SQLException{
		connection.close();
	}

}

//getCoonection(url,un,pw)
// close connection
// execute select query
// execute non select query