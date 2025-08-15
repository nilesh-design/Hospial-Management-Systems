package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connections 
{
	Connection connection;
	Statement statement;
	
	public Connections()
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_management_system", "root", "1997Nilesh@2003");
			statement = connection.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
