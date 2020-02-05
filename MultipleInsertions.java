package data.java;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.*;
public class MultipleInsertions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner sc= null; 
				
				 
				
        		Connection connection=null;  
        		PreparedStatement preparedStatement = null;
        try 
        {	
        	int n=0;
        	sc= new Scanner(System.in);
        	if(sc!=null)
        	n=sc.nextInt();
        	Class.forName("org.postgresql.Driver");
        	 connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bhavya","postgres", "postgres");
        	 if(connection!=null)
        	 preparedStatement = connection.prepareStatement("insert into employee2 values(?,?,?,?)");
        	 	if(preparedStatement!=null && sc!=null)
        	 	{
        	 		for(int i=1;i<=n;i++)
        	 		{ 
        	 			System.out.println("Enter"+i+"details");
        	 			System.out.println("Enter the id");
        	 			int no=sc.nextInt();
        	 			System.out.println("Enter the name");
        	 			String str=sc.next();
        	 			System.out.println("Enter the date of birth");
        	 			String s=sc.next();
        	 			System.out.println("Enter the email id");
        	 			String str1=sc.next();
        	 			preparedStatement.setInt(1, no);
        	 			preparedStatement.setString(2, str);
        	 			preparedStatement.setString(3, s);
        	 			preparedStatement.setString(4, str1);
        	 		int res=preparedStatement.executeUpdate();
        	 					if(res==0)
        	 						System.out.println(i+"Student details not inserted");
        	 					else
        	 						System.out.println("Student details inserted");
        	 		}
        	 	}
        }
        catch (ClassNotFoundException cnf) 
	      {
	         cnf.printStackTrace();
	         System.err.println(cnf.getClass().getName()+": "+cnf.getMessage());
	         System.exit(0);
	      }
        catch (SQLException se) 
	      {
	         se.printStackTrace();
	         System.err.println(se.getClass().getName()+": "+se.getMessage());
	         System.exit(0);
	      }
        catch (Exception e) 
	      {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
        
        finally
        {
        	try
        	{
        		if(preparedStatement != null)
        			preparedStatement.close();
        	}
        	 catch (SQLException se) 
   	      {
   	         se.printStackTrace();
   	         System.err.println(se.getClass().getName()+": "+se.getMessage());
   	         System.exit(0);
   	      }
        	try
        	{
        		if(connection!= null)
        			connection.close();
        	}
        	 catch (SQLException se1) 
   	      {
   	         se1.printStackTrace();
   	         System.err.println(se1.getClass().getName()+": "+se1.getMessage());
   	         System.exit(0);
   	      }
        }



}
}