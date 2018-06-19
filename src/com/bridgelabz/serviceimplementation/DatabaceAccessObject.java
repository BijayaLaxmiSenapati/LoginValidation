package com.bridgelabz.serviceimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.utility.Utility;

public class DatabaceAccessObject 
{
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	public void connection() 
	{
		try 
		{
			Class.forName(Utility.getProperty("DRIVER"));
			con=DriverManager.getConnection(Utility.getProperty("URL"),Utility.getProperty("USERNAME"),Utility.getProperty("PASSWORD"));
			stmt=con.createStatement();
		} 
		catch (ClassNotFoundException |SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void closeResources()
	{
		if(rs!=null)
		{
			try
			{
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try
			{
				stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
