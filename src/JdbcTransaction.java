import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JdbcTransaction
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement st=null;
		Statement st1=null;
		Statement st2=null;
		String updateQuery="update hotel.room set price=2000 where id=1";
		String insertQuery="insert into hotel.room values(2,'mankhurd',500)";
		String insertQuery1="insert into hotel.room values(2,'govandi',3000)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			con.setAutoCommit(false);
			st=con.createStatement();
			st.executeUpdate(updateQuery);
			st1=con.createStatement();
			st1.executeUpdate(insertQuery);
			st2=con.createStatement();
			st2.executeUpdate(insertQuery1);
			con.commit();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			try 
			{
				System.out.println("the whole process is rolled back");
				con.rollback();
				//System.out.println("Transaction is not successful");

			}
			catch (SQLException e1) 
			{
				System.out.println("Transaction is not successful");
				//e1.printStackTrace();
			}
			//e.printStackTrace();
		}
		finally
		{
			if(st2!=null)
			{
				try
				{
					st2.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(st1!=null)
			{
				try
				{
					st1.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
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
