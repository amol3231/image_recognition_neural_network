import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
public class conn
{

    public ResultSet selectQuery(String query)
	{
	    ResultSet rs=null;	
		try
		{
		    
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/face","root","");
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery(query);
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
			return rs;
	}
	public  int selectUpdate(String query)
	{
		int x=0;
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/face","root","root");
			Statement stmt=con.createStatement();
			x=stmt.executeUpdate(query);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return x;
	}

        public Vector getAllId()
        {
            Vector v = new Vector();
            v.add("Select the ID");
            String s ="select * from record  order by rid ";
            	try
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/face","root","root");
			Statement stmt=con.createStatement();
		        ResultSet rs=stmt.executeQuery(s);
                        while(rs.next())
                        {
                            v.add(rs.getString(1));
                        }

		}catch(Exception e)
		{
			System.out.println("error in getAllId()");
                        e.printStackTrace();
		}

             return (v);
        }
	
 
}