package common.db	;

import java.io.*	;
import java.sql.*	;	 

public class SQLExecuter
{
	private static final String 
		DB_URL = "jdbc:mysql://localhost:3306/gjdb";		
 	static
	{ 
		try
		{
	 		Class.forName
			("com.mysql.cj.jdbc.Driver"); 
 		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static Connection getDBConnection ()
		throws SQLException
	{ 
		return 
			DriverManager.getConnection(DB_URL,"root","root");
	} 

	public static int executeUpdateQuery( String query )
		throws SQLException 
	{
		Connection con = null ;
		try
		{
			con = getDBConnection() ;
			Statement stmt = con.createStatement( ) ;
			return stmt.executeUpdate( query ) ;
		}
		catch( SQLException e )
		{
			throw e ;
		}
		finally
		{
			try
			{ 
				if ( con != null ) con.close() ;
			}
			catch ( SQLException e )
			{
				throw e ;
			} 
		} 
	}
	public static ResultSet executeRSQuery( String query )
		throws SQLException 
	{
		Connection con = null ;
		try
		{
			con = getDBConnection() ;
			Statement stmt = con.createStatement( ) ;
			return stmt.executeQuery ( query ) ;
		}
		catch( SQLException e )
		{
			throw e ;
		}
		// Cannot close connection else
		// Caller will not get ResultSet
		// Caller has to close ResultSet
	}
}
