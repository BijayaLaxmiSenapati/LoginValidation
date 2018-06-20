import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.utility.Utility;

public class JdbcBatch 
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement st=null;
		String insertQuery1="insert into Emp_Information.Students(stuNAME,stuMARK) values('Yugandhara',90)";
		String insertQuery2="insert into Emp_Information.Students(stuNAME,stuMARK) values('Swetalina',80)";
		String insertQuery3="insert into Emp_Information.Students(stuNAME,stuMARK) values('Simran',70)";
		String updateQuery1="update Emp_Information.Students set stuNAME='Shyam' where stuID=2";
		String deleteQuery1="delete from Emp_Information.Students where stuName='Simran'";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			st=con.createStatement();
			st.addBatch(insertQuery1);
			st.addBatch(insertQuery2);
			st.addBatch(insertQuery3);
			st.addBatch(updateQuery1);
			st.addBatch(deleteQuery1);
			st.executeBatch();
		}
		catch(Exception e)
		{
			System.out.println("Nopes");
			e.printStackTrace();
		}
		finally
		{
			if(st!=null)
			{
				try
				{
					st.close();
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
}
